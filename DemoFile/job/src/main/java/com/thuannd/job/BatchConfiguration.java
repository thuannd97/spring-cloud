package com.thuannd.job;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @JobScope
    public FlatFileItemReader<Article> reader(@Value("#{jobParameters['INPUT_FILE']}") final String fileName) {
        FlatFileItemReader<Article> item = new FlatFileItemReader<>();
        item.setStrict(false);
        if(FileController.fileToImport != null){
            item.setResource(new ClassPathResource(fileName));
        }
        item.setName("articleItemReader");
        item.setLineMapper(new DefaultLineMapper<Article>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"title", "content"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Article>() {
                    {
                        setTargetType(Article.class);
                    }
                });
            }
        });
        return item;
    }

    @Bean
    public ArticleItemProcessor processor(){
        return new ArticleItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Article> writer(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Article>()
        .itemSqlParameterSourceProvider(
            new BeanPropertyItemSqlParameterSourceProvider<>()
        ).sql("INSERT INTO article (title, content) VALUES(:title, :content)")
        .dataSource(dataSource)
        .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
            return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end().build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Article> writer){
            return stepBuilderFactory.get("step1")
            .<Article, Article> chunk(1000)
            .reader(reader(FileController.fileToImport))
            .processor(processor())
            .writer(writer)
            .build();
    }

}
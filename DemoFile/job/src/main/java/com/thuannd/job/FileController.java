package com.thuannd.job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

    final String UPLOAD_DIR = "/home/hopeeee/working/spring-cloud/DemoFile/job/src/main/resources/";

    static String fileToImport = null;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @PostMapping("/file/single-file")
    public void uploadSingleFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOAD_DIR + multipartFile.getOriginalFilename());
            fileToImport = multipartFile.getOriginalFilename();
            Files.write(path, bytes);
            System.out.println("uploaded success!!!");
        }
    }

    @PostMapping("/file/multiple-file")
    public void uploadMultipleFile(@RequestParam("files") MultipartFile[] files) throws IOException {
        for(int i = 0; i < files.length; i++){
            if(!files[i].isEmpty()){
                byte[] bytes = files[i].getBytes();
                Path path = Paths.get(UPLOAD_DIR + files[i].getOriginalFilename());
                Files.write(path, bytes);
                System.out.println("uploaded success!!!");
            }
        }
    }

    @PostMapping("/file/sh-file")
    public void uploadShFile(@RequestParam("shFile") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
            try{
                Runtime.getRuntime().exec(new String[]{"bash", path.toString()});
                handle();
            }catch(Exception ex){
                System.out.println("cannot exec command!!!");
                ex.printStackTrace();
            }
            System.out.println("end exec--------------");
        }
    }

    public void handle() throws Exception {
        jobLauncher.run(job, createInitialJobParameterMap());
    }

    private JobParameters createInitialJobParameterMap() {
        Map<String, JobParameter> m = new HashMap<>();
        m.put("time", new JobParameter(System.currentTimeMillis()));
        if(FileController.fileToImport != null){
            m.put("INPUT_FILE", new JobParameter(FileController.fileToImport));
        }
        JobParameters p = new JobParameters(m);
        return p;
    }

}
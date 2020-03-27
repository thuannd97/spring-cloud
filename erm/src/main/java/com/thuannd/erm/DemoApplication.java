package com.thuannd.erm;

import com.thuannd.erm.services.impl.UserDetailServiceImpl;
import com.thuannd.erm.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/dang-nhap").permitAll()
		.antMatchers("/quan-tri/**").hasAnyRole(Constants.ADMIN).anyRequest()
		.authenticated().and().formLogin().loginPage("/dang-nhap")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/", true).failureUrl("/dang-nhap?e")
		.permitAll().and().logout().logoutUrl("/dang-xuat")
		.permitAll().and().exceptionHandling().accessDeniedPage("/dang-nhap?e");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/client/js/**", "/client/css/**", "/client/fonts/**", "/client/images/**",
		"/user/css/**", "/user/js/**", "/user/fonts/**", "/user/images/**", "/user/plugins/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(encoder());
	}

	public PasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

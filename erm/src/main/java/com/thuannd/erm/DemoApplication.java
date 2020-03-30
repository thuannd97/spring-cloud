package com.thuannd.erm;

import com.thuannd.erm.services.impl.UserDetailServiceImpl;
import com.thuannd.erm.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebSecurity
public class DemoApplication extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/erm/trang-chu").permitAll()
		.antMatchers("/erm/dang-nhap").permitAll()
		.requestMatchers(PathRequest.toStaticResources().at(StaticResourceLocation.CSS, 
						StaticResourceLocation.JAVA_SCRIPT))
				.permitAll()
		.antMatchers("/quan-tri/**").hasAnyRole(Constants.ADMIN).anyRequest()
		.authenticated().and().formLogin().loginPage("/erm/dang-nhap")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/erm/quan-tri", true).failureUrl("/erm/dang-nhap?e")
		.permitAll().and().logout().logoutUrl("/erm/dang-xuat")
		.permitAll().and().exceptionHandling().accessDeniedPage("/erm/dang-nhap?e");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/admin/css/**", "/admin/js/**", "/admin/fonts/**", 
		"/admin/images/**", "/client/css/**", "/client/js/**", 
		"/client/fonts/**", "/client/images/**", 
		"/admin/plugins/**");
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

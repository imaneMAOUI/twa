package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 DataSource dataSource;
	 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/store/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
				.antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/session/login")
				.permitAll()
				.defaultSuccessUrl("/store/products")
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/session/logout"))
				.logoutSuccessUrl("/session/login");
	}
	
	@Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource)
	   .usersByUsernameQuery(
			   "select username,password, enabled from users where username=?")
			  .authoritiesByUsernameQuery(
			   "select username, role from authorities where username=?");
	  ;
	 } 
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
	
	
}

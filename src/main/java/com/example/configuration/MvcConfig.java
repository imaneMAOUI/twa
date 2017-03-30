package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MvcConfig {
	  @Bean(name = "dataSource")
	  public DriverManagerDataSource dataSource() {
	      DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	      driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      driverManagerDataSource.setUrl("jdbc:mysql://localhost/projet_taw");
	      driverManagerDataSource.setUsername("root");
	      driverManagerDataSource.setPassword("");
	      return driverManagerDataSource;
	  }
}

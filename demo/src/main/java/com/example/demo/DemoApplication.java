package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.controller","com.example.demo.dao","com.example.demo.vo"})
@EntityScan(basePackages = {"com.example.demo.models","com.example.demo.repository"})
@EnableJpaRepositories("com.example.demo.repository")
public class DemoApplication {

	public static void main(String[] args) {
		// StdResponse testing = new StdResponse().setMessage("My fail");
		// System.out.println(testing.getMessage());
		SpringApplication.run(DemoApplication.class, args);
	}

}

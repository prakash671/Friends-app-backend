package com.employee.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan(basePackages = {"com.employee.management.controller"})
public class EmployeeMangApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMangApplication.class, args);
	}

}

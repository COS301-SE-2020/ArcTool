package com.arcTool.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.arcTool.*"})
@EntityScan(basePackages = {"com.arcTool.*"})
//@EnableJpaRepositories(basePackages = {"com.arcTool.*"})
public class arcToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(arcToolApplication.class);
	}

}

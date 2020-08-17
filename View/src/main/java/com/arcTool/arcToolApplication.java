package com.arcTool;

// package com.arcTool.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"com.arcTool.*"})
@EntityScan(basePackages = {"com.arcTool.*"})
@EnableJpaRepositories(basePackages = {"com.arcTool.*"})
public class arcToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(arcToolApplication.class);
	}

}
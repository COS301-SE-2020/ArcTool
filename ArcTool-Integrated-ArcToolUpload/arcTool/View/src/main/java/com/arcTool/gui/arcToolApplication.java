package com.arcTool.gui;
import com.arcTool.Controller.UserController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"com.arcTool.*"})
@EntityScan(basePackages = {"com.arcTool.*"})
@EnableJpaRepositories(basePackages = {"com.arcTool.*"})
@Configuration
@EnableAutoConfiguration
@ComponentScan({"gui","Controller"})
public class arcToolApplication {

	public static void main(String[] args) {
//		new File(UserController.uploadDirectory).mkdir();
		SpringApplication.run(arcToolApplication.class);
	}

}

package com.bookcatlog.bookcatlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class BookcatlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatlogApplication.class, args);
	}

}


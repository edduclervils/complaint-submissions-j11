package com.revature.complaintsubmissionsj11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:prod.properties")
public class ComplaintSubmissionsJ11Application {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintSubmissionsJ11Application.class, args);
	}

}

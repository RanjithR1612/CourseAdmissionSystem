package com.company.courseadmissionsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourseAdmissionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseAdmissionSystemApplication.class, args);
	}

}

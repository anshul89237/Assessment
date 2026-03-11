package com.lpu.SMSAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SmsAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsAssessmentApplication.class, args);
	}

}

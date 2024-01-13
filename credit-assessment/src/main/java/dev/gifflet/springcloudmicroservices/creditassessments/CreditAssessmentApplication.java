package dev.gifflet.springcloudmicroservices.creditassessments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAssessmentApplication.class, args);
	}

}

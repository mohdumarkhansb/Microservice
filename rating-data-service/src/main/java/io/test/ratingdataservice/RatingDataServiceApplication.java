package io.test.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RatingDataServiceApplication {

    @Bean
    RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
    
	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
		System.out.println("Rating Data Service");
	}

}

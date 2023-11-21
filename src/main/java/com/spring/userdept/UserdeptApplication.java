package com.spring.userdept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class UserdeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdeptApplication.class, args);
	}

}

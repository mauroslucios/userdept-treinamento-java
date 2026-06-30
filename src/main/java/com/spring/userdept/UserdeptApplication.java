package com.spring.userdept;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@OpenAPIDefinition(
		servers = {
				@Server(url = "https://mauroslucios.com", description = "Servidor de Produção"),
				@Server(url = "http://localhost:8080", description = "Ambiente Local de Desenvolvimento")
		}
)
public class UserdeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserdeptApplication.class, args);
	}

}

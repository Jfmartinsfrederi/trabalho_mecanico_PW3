package com.example.trabalho_mecanico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode =
		EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class TrabalhoMecanicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoMecanicoApplication.class, args);
	}

}

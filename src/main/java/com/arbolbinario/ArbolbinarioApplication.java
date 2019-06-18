package com.arbolbinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ArbolbinarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArbolbinarioApplication.class, args);
	}

}

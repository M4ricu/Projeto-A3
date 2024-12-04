package com.m4ricu.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.m4ricu.single", "com." })
@EntityScan(basePackages = { "com.m4ricu.single.model" }) // Pacote das entidades
@EnableJpaRepositories(basePackages = { "com.m4ricu.single.repository" }) // Pacote dos repositórios
public class SingleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleApplication.class, args);
	}

}

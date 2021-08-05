package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(String...strings) throws Exception{
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				log.info("// TODO Auto-generated method stub :: commandLineRunner test");
				
			}
			
		};
		
	}

}
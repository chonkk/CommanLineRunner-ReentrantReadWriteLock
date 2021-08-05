package com.example.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.example.demo"})
@Getter@Setter
public class Demo2Application {
	
	@Autowired
	CiLock lock;

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(String...strings) throws Exception{
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

				log.info("commandLineRunner test start!!");
			
				log.info("{}", lock);
				log.info("{}", lock.readLock());
				log.info("{}", lock);
				
				log.info("{}",lock.writeLock());

				log.info("{}", lock);
				
				
			}
			
		};
		
	}
}

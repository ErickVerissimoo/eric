package com.everyoneblogsspring.everyonesblogs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.SpringProperties;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@ServletComponentScan
public class EveryonesblogsApplication {


	public static void main(String[] args) {
		SpringApplication.run(EveryonesblogsApplication.class, args);
	}
	@Bean
public CommandLineRunner olateste() {
return args ->{ 
System.out.println("Spring version: " + SpringVersion.getVersion());
};
}
}

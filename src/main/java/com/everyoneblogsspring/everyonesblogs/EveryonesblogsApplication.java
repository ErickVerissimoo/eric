package com.everyoneblogsspring.everyonesblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EveryonesblogsApplication {


	public static void main(String[] args) {
		SpringApplication.run(EveryonesblogsApplication.class, args);
	}

}

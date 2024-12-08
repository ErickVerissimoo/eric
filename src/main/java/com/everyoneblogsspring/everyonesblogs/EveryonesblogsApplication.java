package com.everyoneblogsspring.everyonesblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.everyoneblogsspring.everyonesblogs.listener")
public class EveryonesblogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveryonesblogsApplication.class, args);
	}

}

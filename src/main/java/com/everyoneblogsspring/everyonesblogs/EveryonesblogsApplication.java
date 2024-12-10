package com.everyoneblogsspring.everyonesblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

@SpringBootApplication(scanBasePackages  = {"com.everyoneblogsspring.everyonesblogs.utils"})
public class EveryonesblogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveryonesblogsApplication.class, args);
	}

}

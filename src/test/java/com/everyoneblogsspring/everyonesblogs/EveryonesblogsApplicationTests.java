package com.everyoneblogsspring.everyonesblogs;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;
@SpringBootTest
@ComponentScan(basePackageClasses = UserMapper.class)
public class EveryonesblogsApplicationTests {
	@Autowired private UserMapper mapper;
	
	
	@Test
	void contextLoads() {

		UserDTO dto = UserDTO.builder().email("erickverissimodasilva144@gmail.com").password("erick123").build();
	User user = mapper.toUser(dto);
	System.out.println(user.getEmail());
	}

}

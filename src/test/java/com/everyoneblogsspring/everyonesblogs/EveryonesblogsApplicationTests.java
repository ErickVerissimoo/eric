package com.everyoneblogsspring.everyonesblogs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.everyoneblogsspring.everyonesblogs.dto.userDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
@SpringBootTest

public class EveryonesblogsApplicationTests {

	@Test
	void contextLoads() {
	userDTO dto = userDTO.builder().email("erickverissimodasilva144@gmail.com").password("erick2312").username("erickadads").build();
	var e = dto.toEntity(User.class);
	System.out.println(e.getPassword());
	}

}

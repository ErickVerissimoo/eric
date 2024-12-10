package com.everyoneblogsspring.everyonesblogs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;
@SpringBootTest

public class EveryonesblogsApplicationTests {
	@Autowired
	 private UserMapper mapper;
	
	
	@Test
	void contextLoads() {

		UserDTO dto = UserDTO.builder().email("erickverissimodasilva144@gmail.com").password("erick123").build();
	User user = mapper.toUser(dto);
	System.out.println(user.getEmail());
	}

}

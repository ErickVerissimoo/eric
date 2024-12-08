package com.everyoneblogsspring.everyonesblogs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.everyoneblogsspring.everyonesblogs.dto.userDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EveryonesblogsApplicationTests {
	@Autowired
	private userRepository repository;
	@Test
	void contextLoads() {
		userDTO dto = userDTO.builder().email("erickverissimodasilva144@gmail").password("erick323432").username("erickasdsad").build();
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		repository.saveAndFlush(user);
		User founded = repository.findById(user.getId()).orElse(null);
		assertThat(founded).isNotNull();
		System.out.println("Teste finalizado");
	}

}

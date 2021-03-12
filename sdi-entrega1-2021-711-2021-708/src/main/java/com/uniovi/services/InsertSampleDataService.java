package com.uniovi.services;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
	
	@Autowired
	private UsersService usersService;

	@PostConstruct
	public void init() {
		User user1 = new User("pedro@email.es", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setRole("ROLE_USER");
		User user2 = new User("lucas@email.es", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setRole("ROLE_USER");
		User user3 = new User("maria@email.es", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setRole("ROLE_USER");
		User user4 = new User("almonte@email.es", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setRole("ROLE_USER");
		User user5 = new User("valdes@email.es", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setRole("ROLE_USER");
		User user6 = new User("admin@email.es", "Edward", "Núñez");
		user6.setPassword("123456");
		user6.setRole("ROLE_ADMIN");
		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);
	}
}
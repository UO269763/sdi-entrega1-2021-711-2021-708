package com.uniovi.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Oferta;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {

	@Autowired
	private UsersService usersService;

	@Autowired
	private OfertaService ofertasService;

	@PostConstruct
	public void init() {
		User user1 = new User("pedro@email.es", "Pedro", "Díaz");
		user1.setPassword("123456");
		user1.setRole("ROLE_USER");
		Oferta oferta1 = new Oferta(user1, "Camiseta azul", "Talla L", 20);
		Oferta oferta2 = new Oferta(user1, "Sudadera azul", "Talla M", 10);
		Oferta oferta3 = new Oferta(user1, "Pantalon azul", "Talla XL", 120);

		User user2 = new User("lucas@email.es", "Lucas", "Núñez");
		user2.setPassword("123456");
		user2.setRole("ROLE_USER");
		Oferta oferta4 = new Oferta(user1, "Zapatos nike", "Talla L", 20);
		Oferta oferta5 = new Oferta(user1, "Sudadera nike", "Talla M", 10);
		Oferta oferta6 = new Oferta(user1, "Pantalon nike", "Talla XL", 120);

		User user3 = new User("maria@email.es", "María", "Rodríguez");
		user3.setPassword("123456");
		user3.setRole("ROLE_USER");
		Oferta oferta7 = new Oferta(user1, "Zapatos adidas", "Talla L", 20);
		Oferta oferta8 = new Oferta(user1, "Sudadera adidas", "Talla M", 10);
		Oferta oferta9 = new Oferta(user1, "Pantalon adidas", "Talla XL", 120);

		User user4 = new User("almonte@email.es", "Marta", "Almonte");
		user4.setPassword("123456");
		user4.setRole("ROLE_USER");
		Oferta oferta10 = new Oferta(user1, "Calcetines", "Seminuevos", 2);
		Oferta oferta11 = new Oferta(user1, "Chandal completo", "Talla M", 60);
		Oferta oferta12 = new Oferta(user1, "Chubasquero", "Talla XL", 120);

		User user5 = new User("valdes@email.es", "Pelayo", "Valdes");
		user5.setPassword("123456");
		user5.setRole("ROLE_USER");
		Oferta oferta13 = new Oferta(user1, "Zapatos", "Seminuevos", 2);
		Oferta oferta14 = new Oferta(user1, "Sudadera", "Talla M", 60);
		Oferta oferta15 = new Oferta(user1, "Pantalon", "Talla XL", 120);

		User user6 = new User("admin@email.es", "Edward", "Núñez");
		user6.setPassword("123456");
		user6.setRole("ROLE_ADMIN");

		// Añadir usuarios al service
		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);

		// Añadir ofertas al service
		ofertasService.addOferta(oferta1, user1);
		ofertasService.addOferta(oferta2, user1);
		ofertasService.addOferta(oferta3, user1);

		ofertasService.addOferta(oferta4, user2);
		ofertasService.addOferta(oferta5, user2);
		ofertasService.addOferta(oferta6, user2);

		ofertasService.addOferta(oferta7, user3);
		ofertasService.addOferta(oferta8, user3);
		ofertasService.addOferta(oferta9, user4);

		ofertasService.addOferta(oferta10, user4);
		ofertasService.addOferta(oferta11, user4);
		ofertasService.addOferta(oferta12, user4);

		ofertasService.addOferta(oferta13, user5);
		ofertasService.addOferta(oferta14, user5);
		ofertasService.addOferta(oferta15, user5);

//		// Añadir ofertas compradas
//		Set<Oferta> user1Compras = new HashSet<Oferta>() {
//		{
//			add(oferta4);
//			add(oferta5);
//		}
//	};
//		user1.setOfertasCompradas(user1Compras);
//		ofertasService.comprarOferta(oferta4.getId(), user1);
//		ofertasService.comprarOferta(oferta5.getId(), user1);
//		
//		ofertasService.comprarOferta(oferta7.getId(), user2);
//		ofertasService.comprarOferta(oferta8.getId(), user2);
//
//		ofertasService.comprarOferta(oferta10.getId(), user3);
//		ofertasService.comprarOferta(oferta11.getId(), user3);
//
//		ofertasService.comprarOferta(oferta13.getId(), user4);
//		ofertasService.comprarOferta(oferta14.getId(), user4);
//
//		ofertasService.comprarOferta(oferta1.getId(), user5);
//		ofertasService.comprarOferta(oferta2.getId(), user5);

		
	}

}
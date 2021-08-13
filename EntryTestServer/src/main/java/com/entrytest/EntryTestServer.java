package com.entrytest;

import com.entrytest.service.*;


import com.entrytest.model.Role;
import com.entrytest.model.User;
import com.entrytest.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EntryTestServer implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EntryTestServer.class, args);
}

		@Override
		public void run (String...args) throws Exception {
			System.out.println("Helo Spring booyt");
//		User user=new User();
//		user.setFistName("Manesh");
//		user.setLastName("Kumar");
//		user.setAddress("GNS");
//		user.setEmail("rkumar@mail.com");
//		user.setPhoneNo("0335");
//		user.setGender("male");
//		user.setProfile("manesh.png");
//
//		Role role=new Role();
//		role.setRollId(1);
//		role.setRollName("ADMIN");
//
//		Set<UserRole> userRoleset=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleset.add(userRole);
//
//		User user1=this.userService.createUser(user,userRoleset);

		}

}
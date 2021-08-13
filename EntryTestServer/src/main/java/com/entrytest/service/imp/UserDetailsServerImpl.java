package com.entrytest.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entrytest.model.User;
import com.entrytest.repositry.UserRepositry;

@Service
public class UserDetailsServerImpl implements UserDetailsService {
	@Autowired
	private UserRepositry userRepositry;
	// reposity always bring data fromm database
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
	User user=this.userRepositry.findByFistName(username);
		if(user==null) {
			System.out.println("user Not Found");
			throw new UsernameNotFoundException("No user Found");
	    }
		return user;
	}
}

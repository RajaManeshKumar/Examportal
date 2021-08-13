package com.entrytest.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrytest.model.User;


public interface UserRepositry extends JpaRepository<User,Integer> {
        public User findByFistName(String username);
}




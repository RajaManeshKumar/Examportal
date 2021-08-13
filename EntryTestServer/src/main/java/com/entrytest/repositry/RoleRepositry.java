package com.entrytest.repositry;

import com.entrytest.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositry extends JpaRepository<Role,Integer> {
}

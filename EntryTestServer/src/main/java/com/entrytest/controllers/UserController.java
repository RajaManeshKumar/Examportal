package com.entrytest.controllers;
import com.entrytest.service.UserService;

import com.entrytest.model.Role;
import com.entrytest.model.User;
import com.entrytest.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoleSet = new HashSet<>();
        Role role = new Role();
        role.setRollId(12);
        role.setRollName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleSet.add(userRole);
        System.out.println(user.getFistName());
        return this.userService.createUser(user, userRoleSet);
    }
    // getname by fistname
    @GetMapping("/{username}")
    public User getFistName(@PathVariable("username") String name){
        return this.userService.getFistName(name);
    }
    // delete user by user id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
         this.userService.deleteUser(id);
    }

}
package com.entrytest.service;


import com.entrytest.model.User;
import com.entrytest.model.UserRole;

import java.util.Set;

public interface UserService  {
    // creating user
    public User createUser(User user, Set<UserRole> userRoles);

    //getting user by username
    public User getFistName(String fistName);

    public void deleteUser(int id);
}

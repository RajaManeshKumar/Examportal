package com.entrytest.service.imp;

import com.entrytest.service.UserService;

import com.entrytest.model.User;
import com.entrytest.model.UserRole;
import com.entrytest.repositry.RoleRepositry;
import com.entrytest.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepositry userRepositry;
    @Autowired
    private RoleRepositry roleRepositry;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        // we have to check the username is already not presnst
        User local=this.userRepositry.findByFistName(user.getFistName());
        if(local!=null){
            System.out.println("User Laready Exist");
        }
        else{
            for(UserRole ur:userRoles){
                 roleRepositry.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
           local= this.userRepositry.save(user);
            // user create
        }
        return local;
    }

    // getting name by fistname
    @Override
    public User getFistName(String fistName) {
        return this.userRepositry.findByFistName(fistName);
    }

    // delete user
    @Override
    public void deleteUser(int id) {
        this.userRepositry.deleteById(id);
    }




}

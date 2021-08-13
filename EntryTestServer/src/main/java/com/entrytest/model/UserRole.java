package com.entrytest.model;

import javax.persistence.*;

@Entity
@Table(name = "userrole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public UserRole() {
    }

    @ManyToOne
    private Role role;

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package com.exam.services;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    //method for creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by ID
    public void deleteUser(Long id);

}

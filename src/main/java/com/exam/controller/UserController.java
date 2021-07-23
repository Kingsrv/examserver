package com.exam.controller;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception {

        Set<UserRole> roleSet = new HashSet<>();
        user.setProfile("default.png");

        //encoding the password using Bcryptpasssword encoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = new Role();
        role.setRoleId(45L);
        role.setRole("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roleSet.add(userRole);

        return this.userService.createUser(user,roleSet);
    }

    //view user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //Delete user by ID
    @DeleteMapping("/{userId}")
    public void  deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //write update user API

}

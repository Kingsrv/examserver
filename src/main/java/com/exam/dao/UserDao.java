package com.exam.dao;

import com.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    public User findByUsername(String username);
}

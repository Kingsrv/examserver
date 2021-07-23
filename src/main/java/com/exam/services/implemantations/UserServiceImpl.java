package com.exam.services.implemantations;

import com.exam.dao.RoleDao;
import com.exam.dao.UserDao;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.helper.UserFoundException;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userDao.findByUsername(user.getUsername());
        //check if the user is already present
        if(local!=null){
            System.out.println("user already present.");
            throw new UserFoundException();
        }else{
            //create user
             for(UserRole ur:userRoles){
                 roleDao.save(ur.getRole());
             }
             user.getUserRoles().addAll(userRoles);
             local=this.userDao.save(user);
        }
        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userDao.findByUsername(username);
    }

    //deleting user by user id
    @Override
    public void deleteUser(Long id) {
        this.userDao.deleteById(id);
    }

}

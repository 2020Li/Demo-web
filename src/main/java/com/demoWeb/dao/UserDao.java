package com.demoWeb.dao;

import com.demoWeb.entity.UsersEntity;
import org.hibernate.Session;

import java.util.List;

public interface UserDao {
    Session getSession();
    List<UsersEntity> getAllUsers();
    UsersEntity getuUserById(int id);
    void addUser(UsersEntity usersEntity);

    UsersEntity getuUserByemail(String email);


    UsersEntity getUserByName(String userName);
}

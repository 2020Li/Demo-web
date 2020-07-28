package com.demoWeb.service;

import com.demoWeb.entity.UsersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UsersEntity> getAllUsers();
    UsersEntity getUserById(int id);
    void addUser(UsersEntity usersEntity);

    UsersEntity getUserByemail(String email);

    UsersEntity getUserByName(String userName);
}

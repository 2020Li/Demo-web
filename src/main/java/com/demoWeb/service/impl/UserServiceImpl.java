package com.demoWeb.service.impl;

import com.demoWeb.dao.UserDao;
import com.demoWeb.entity.UsersEntity;
import com.demoWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
//@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> list=userDao.getAllUsers();
        return list;
    }

    @Override
    public UsersEntity getUserById(int id) {
        return userDao.getuUserById(id);
    }

    @Override
    public void addUser(UsersEntity usersEntity) {
        userDao.addUser(usersEntity);
    }

    @Override
    public UsersEntity getUserByemail(String email) {
        return userDao.getuUserByemail(email);
    }

    @Override
    public UsersEntity getUserByName(String userName) {

        return userDao.getUserByName(userName);
    }

}

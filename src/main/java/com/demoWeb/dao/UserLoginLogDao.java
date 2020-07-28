package com.demoWeb.dao;

import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;
import org.hibernate.Session;

import java.util.List;

public interface UserLoginLogDao {
    Session getSession();
    List<UserloginlogEntity> getUserById(String userId);
    void addUserLoginLog(UserloginlogEntity userloginlogEntity);
}

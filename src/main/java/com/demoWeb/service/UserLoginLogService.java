package com.demoWeb.service;

import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;

import java.util.List;

public interface UserLoginLogService {

    List<UserloginlogEntity> getUserById(String userId);

    void addUserLoginLog(UserloginlogEntity userloginlogEntity);
}

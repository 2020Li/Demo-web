package com.demoWeb.service.impl;

import com.demoWeb.dao.UserLoginLogDao;
import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;
import com.demoWeb.service.UserLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {
    @Resource
    private UserLoginLogDao userLoginLogDao;

    @Override
    public List<UserloginlogEntity> getUserById(String userId) {
        return userLoginLogDao.getUserById(userId);
    }

    @Override
    public void addUserLoginLog(UserloginlogEntity userloginlogEntity) {
        userLoginLogDao.addUserLoginLog(userloginlogEntity);
    }
}

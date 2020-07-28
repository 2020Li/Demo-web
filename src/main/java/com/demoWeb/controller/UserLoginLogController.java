package com.demoWeb.controller;

import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;
import com.demoWeb.service.UserLoginLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userLoginLog")
public class UserLoginLogController{
    @Resource
    private UserLoginLogService userLoginLogService;
    //用户登录日志展示
    @RequestMapping(value="/userLogin",method= RequestMethod.POST)
    @ResponseBody
    public List userLogin(String userId){
        System.out.println("进入log控制层");
        if (userId != null){
            List<UserloginlogEntity> userLoginLog=userLoginLogService.getUserById(userId);
            if (userLoginLog != null){
                System.out.println(userLoginLog);
                return userLoginLog;
            }else {
                return null;
            }
        }
        return null;
    }

}


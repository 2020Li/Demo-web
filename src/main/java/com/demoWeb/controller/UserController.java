package com.demoWeb.controller;

import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;
import com.demoWeb.service.UserLoginLogService;
import com.demoWeb.service.UserService;
import com.demoWeb.test.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserLoginLogService userLoginLogService;
    @RequestMapping("/register")
    public String register(){
        /* request.setAttribute("usersList",userService.getAllUsers());*/
        return "register";
    }
    @RequestMapping("/login")
    public String login(){
        /* request.setAttribute("usersList",userService.getAllUsers());*/
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        /* request.setAttribute("usersList",userService.getAllUsers());*/
        return "index";
    }

    @RequestMapping("/getAllUsers")
    public String getAllUsers(){
       /* request.setAttribute("usersList",userService.getAllUsers());*/
        UsersEntity user=userService.getUserById(1);
        System.out.println("查出来的数据是"+user);
        System.out.println("姓名："+user.getUserName()+"电话："+user.getCellphone());
        return "index";
    }

    @RequestMapping(value="/addUser",method= RequestMethod.POST)
    @ResponseBody
    public String addUser(HttpServletRequest request,UsersEntity user){
      /*  Map map =  request.getParameterMap();
        System.out.println(map);
        UsersEntity user=new UsersEntity();*/
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setCellphone(request.getParameter("cellphone"));
        user.setEmail(request.getParameter("email"));
        user.setCreateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
        System.out.println("进入控制层");
        System.out.println(user);
        UsersEntity usersEntity=userService.getUserByName(user.getUserName());
        UsersEntity userByEmaiil=userService.getUserByemail(user.getEmail());

        //System.out.println(usersEntity+"++++++++++");
        if (usersEntity == null){
            if (userByEmaiil == null){
           // System.out.println(user.getPassword());
            String salt=Util.getCharAndNumr(4);
           // System.out.println(salt);
            String md5pwd=Util.getMd5(user.getPassword()+salt);
            user.setPassword(md5pwd);
            user.setSalt(salt);
            //System.out.println(user.getPassword());
            userService.addUser(user);
            return "login";
            }else {
                return "exist";
            }
        }else {
            return "";
        }
    }
    @RequestMapping(value="/userLogin",method= RequestMethod.POST)
    @ResponseBody
    public String userLogin(HttpServletRequest request, HttpServletResponse response){
        String email=request.getParameter("email");
        String password=request.getParameter("pwd");
        //System.out.println(email+"+++++++++++++++++++++++");
       if (email != null && password != null){
           UserloginlogEntity userloginlogEntity=new UserloginlogEntity();
           UsersEntity user=userService.getUserByemail(email);
           if (user != null){
              // System.out.println(user);
               String md5pwd= Util.getMd5(password+user.getSalt());
               String pwd=user.getPassword();
               System.out.println(md5pwd+"+"+pwd);
               if (md5pwd.equals(pwd)){
                    userloginlogEntity.setUserId(user.getUserId());
                    System.out.println(new Date(new java.util.Date().getTime()));
                    userloginlogEntity.setLoginTime(new java.sql.Timestamp(new java.util.Date().getTime()));
                    userLoginLogService.addUserLoginLog(userloginlogEntity);
                    return String.valueOf(user.getUserId());
               }else {
                   return "lose";
               }
           }else {
               return "lose";
           }
       }else {
           return "null";
       }
    }
}

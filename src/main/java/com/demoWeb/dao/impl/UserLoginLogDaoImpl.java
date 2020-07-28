package com.demoWeb.dao.impl;

import com.demoWeb.dao.UserLoginLogDao;
import com.demoWeb.entity.UserloginlogEntity;
import com.demoWeb.entity.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserLoginLogDaoImpl implements UserLoginLogDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Session getSession() {return sessionFactory.getCurrentSession();}

    @Override
    public List<UserloginlogEntity> getUserById(String userId) {
        System.out.println("查询日志");
        int id=Integer.parseInt(userId);
        String hql = "select loginId,userId,loginIp,loginTime from UserloginlogEntity where userId=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger(0,id);
        return query.list();

    }

    @Override
    public void addUserLoginLog(UserloginlogEntity userloginlogEntity) {
        System.out.println("进入登录日志dao层");
        Transaction transaction=getSession().beginTransaction();
        getSession().save(userloginlogEntity);
        transaction.commit();
        getSession().flush();
        getSession().close();
    }

}

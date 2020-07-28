package com.demoWeb.dao.impl;

import com.demoWeb.dao.UserDao;
import com.demoWeb.entity.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
//@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<UsersEntity> getAllUsers(){
        String hql="from users";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public UsersEntity getuUserById(int id) {
        return ((UsersEntity)getSession().get(UsersEntity.class,id));
    }

    @Override
    public void addUser(UsersEntity usersEntity) {
        System.out.println("进入dao层");
        Transaction transaction=getSession().beginTransaction();
        getSession().save(usersEntity);
        transaction.commit();
        getSession().flush();
        getSession().close();
    }
    @Override
    public UsersEntity getuUserByemail(String email) {
        String hql = "from UsersEntity as u where u.email=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, email);
        ArrayList list= (ArrayList) query.list();
        if(null!=list && list.size() !=0){
            return ((UsersEntity)list.get(0));
        }
        return null;
    }

    @Override
    public UsersEntity getUserByName(String userName) {
        String hql = "from UsersEntity as u where u.userName=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        ArrayList list= (ArrayList) query.list();
        if(null!=list && list.size() !=0){
            return ((UsersEntity)list.get(0));
        }
        return null;
    }

   /* @Override
    public UsersEntity getUserByNameAndPwd(String userName, String password) {
        String hql = "from UsersEntity as u where u.userName=? and u.password=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, userName);
        query.setString(1, password);
        ArrayList list= (ArrayList) query.list();
        if(null!=list && list.size() !=0){
            return ((UsersEntity)list.get(0));
        }
        return null;
    }*/
}

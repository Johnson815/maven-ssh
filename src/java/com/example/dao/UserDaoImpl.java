package com.example.dao;

import com.example.model.UserInfoEntity;
import com.example.utils.UuidUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Iterator;

@Repository("userDao")
@Transactional()
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public UserInfoEntity info(Long id) {
        Session session = sessionFactory.getCurrentSession();
        UserInfoEntity user = session.get(UserInfoEntity.class, id);
        return user;
    }

    @Override
    public boolean login(UserInfoEntity user) {
        Iterator<UserInfoEntity> it;
        String hsql = "FROM UserInfoEntity u where u.name=? and u.pwd=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getName());
        query.setString(1, user.getPwd());
        it = query.iterate();
        if (it.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(UserInfoEntity user) {
        Session session = sessionFactory.getCurrentSession();
        Iterator<UserInfoEntity> it;
        String hsql = "FROM UserInfoEntity u where u.name=? ";
        Query query = session.createQuery(hsql);
        query.setString(0, user.getName());
        it = query.iterate();
        if (it.hasNext()) {
            return false;
        } else {
            user.setNo(UuidUtils.generateCode("u"));
            user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            user.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
            session.save(user);
            return true;
        }
    }
}

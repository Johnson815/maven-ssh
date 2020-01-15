package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.UserInfoEntity;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserInfoEntity info(Long id) {
        return null;
    }

    @Override
    public boolean login(UserInfoEntity user) {
        return userDao.login(user);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public boolean register(UserInfoEntity user) {
        return userDao.register(user);
    }
}

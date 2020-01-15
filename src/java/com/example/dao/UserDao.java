package com.example.dao;

import com.example.model.UserInfoEntity;

public interface UserDao {

    UserInfoEntity info(Long id);

    boolean login(UserInfoEntity user);

    boolean register(UserInfoEntity user);
}

package com.example.service;

import com.example.model.UserInfoEntity;

public interface UserService {

    UserInfoEntity info(Long id);

    boolean login(UserInfoEntity user);

    boolean register(UserInfoEntity user);
}

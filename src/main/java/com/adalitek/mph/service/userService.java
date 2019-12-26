package com.adalitek.mph.service;

import com.adalitek.mph.model.user;

public interface userService {

    public user findUserByEmail(String email) ;
    public user saveUser(user user);
}

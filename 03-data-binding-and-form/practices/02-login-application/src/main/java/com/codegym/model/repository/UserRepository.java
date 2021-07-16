package com.codegym.model.repository;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;

public interface UserRepository {
    public User checkLogin(Login login);
}

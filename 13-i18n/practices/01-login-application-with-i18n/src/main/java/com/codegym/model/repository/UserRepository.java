package com.codegym.model.repository;

import com.codegym.model.entity.Login;
import com.codegym.model.entity.User;

public interface UserRepository {
    public User checkLogin(Login login);
}

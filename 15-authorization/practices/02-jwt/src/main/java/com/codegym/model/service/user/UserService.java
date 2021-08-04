package com.codegym.model.service.user;

import com.codegym.model.entity.User;
import com.codegym.model.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends GeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}

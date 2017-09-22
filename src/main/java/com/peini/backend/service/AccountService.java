package com.peini.backend.service;

import com.peini.backend.entity.User;

import java.util.List;

public interface AccountService {
    User save(User user);
    User getUserByEmail(String email);
    User getUserByUserName(String userName);
    List<User> getAllUsers();
}

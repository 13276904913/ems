package com.hbc.ems.service;

import com.hbc.ems.entity.User;

public interface UserService {
    boolean login(String username, String password);

    void add(User user);
}

package com.hbc.ems.service.impl;

import com.hbc.ems.dao.UserMapper;
import com.hbc.ems.entity.User;
import com.hbc.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return false;
        } else {
            User user = userMapper.selectByUsername(username);
            if (user == null) {
                return false;
            } else {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public void add(User user) {
        if (user == null) {
            return;
        }
        userMapper.insert(user);
    }
}

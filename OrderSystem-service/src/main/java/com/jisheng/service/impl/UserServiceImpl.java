package com.jisheng.service.impl;


import com.jisheng.dao.UserDAO;
import com.jisheng.po.User;
import com.jisheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    public UserServiceImpl() {
    }

    @Override
    public boolean addUser(User user) {
        return userDAO.add(user);
    }

    @Override
    public boolean checkLoginInfo(User user) {
        String passWord = userDAO.checkLoginInfo(user).getPassword();
        if (user.getPassword().equals(passWord)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUserPassword(User user, String password) {
        if (checkLoginInfo(user)) {
            return userDAO.updateUserPassword(user, password);
        } else {
            return false;
        }
    }

    @Override
    public User getUserInfo(User user) {
        return userDAO.getUser(user);
    }

    @Override
    public boolean usernameIsExist(User user) {
        User serUser = userDAO.getUser(user);
        if (serUser != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeUser(User user) {
        return userDAO.remove(user);
    }

}

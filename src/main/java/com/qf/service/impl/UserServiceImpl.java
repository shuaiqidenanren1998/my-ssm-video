package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByEmaAndPwd(User user) {
        return userDao.findByEmaAndPwd(user);
    }

    @Override
    public User findByEma(String ema) {
        return userDao.findByEma(ema);
    }

    @Override
    public boolean insertUser(User user) {

        return userDao.insertUser(user);
    }

    @Override
    public User validateEmail(User user) {
        return userDao.validateEmail(user);
    }
}

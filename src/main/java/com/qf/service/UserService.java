package com.qf.service;

import com.qf.pojo.User;

public interface UserService {

    public User findByEmaAndPwd (User user);
    public User findByEma (String ema);
    public boolean insertUser(User user);
    public User validateEmail(User user);

}

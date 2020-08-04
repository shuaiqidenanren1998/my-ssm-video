package com.qf.dao;

import com.qf.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public User findByEmaAndPwd (User user);
    public User findByEma (String ema);
    public boolean insertUser(User user);
    public User validateEmail(User user);

}

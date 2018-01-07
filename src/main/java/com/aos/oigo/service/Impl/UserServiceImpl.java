package com.aos.oigo.service.Impl;

import com.aos.oigo.dao.TestDao;
import com.aos.oigo.dao.UserDao;
import com.aos.oigo.pojo.User;
import com.aos.oigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    TestDao testDao;

    @Override
    public List<User> getUserList() {
        //return userDao.getUserList();
        return testDao.getAllUser();
    }
}

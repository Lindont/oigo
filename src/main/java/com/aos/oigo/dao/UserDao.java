package com.aos.oigo.dao;

import com.aos.oigo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserList();
}

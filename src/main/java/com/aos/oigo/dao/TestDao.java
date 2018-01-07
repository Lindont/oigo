package com.aos.oigo.dao;

import com.aos.oigo.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-07
 */
@Repository
public interface TestDao {
    @Select("SELECT * FROM USER")
    List<User> getAllUser();
}

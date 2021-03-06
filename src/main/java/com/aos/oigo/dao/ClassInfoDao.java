package com.aos.oigo.dao;

import com.aos.oigo.pojo.ClassInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-19
 */
@Repository
public interface ClassInfoDao {
    List<ClassInfo> selectClassInfo();
}

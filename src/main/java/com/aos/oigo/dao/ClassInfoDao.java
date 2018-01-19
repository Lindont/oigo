package com.aos.oigo.dao;

import com.aos.oigo.pojo.ClassInfo;
import org.springframework.stereotype.Repository;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-19
 */
@Repository
public interface ClassInfoDao {
    ClassInfo selectClassInfo(int classId);
}

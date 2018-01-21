package com.aos.oigo.service.Impl;

import com.aos.oigo.dao.ClassInfoDao;
import com.aos.oigo.pojo.ClassInfo;
import com.aos.oigo.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    ClassInfoDao classInfoDao;

    @Override
    public List<ClassInfo> selectClassInfo() {
        return classInfoDao.selectClassInfo();
    }
}

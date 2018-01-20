package com.aos.oigo.service.Impl;

import com.aos.oigo.dao.OrderInfoDao;
import com.aos.oigo.pojo.Order;
import com.aos.oigo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoDao orderInfoDao;


    @Override
    public List<Order> selectOrderInfo() {
        return orderInfoDao.selectOrderInfo();
    }
}

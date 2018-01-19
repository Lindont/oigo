package com.aos.oigo.dao;

import com.aos.oigo.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Repository
public interface OrderInfoDao {
    List<Order> selectOrderInfo();
}

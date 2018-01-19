package com.aos.oigo.controller.order;

import com.aos.oigo.pojo.Order;
import com.aos.oigo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-20
 */
@Controller
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    @RequestMapping("/orderinfo")
    public void getOrderInfo() {
        List<Order> order = orderInfoService.selectOrderInfo();
        System.out.println(order);
    }
}

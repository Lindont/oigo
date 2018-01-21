package com.aos.oigo.controller.order;

import com.aos.oigo.pojo.Order;
import com.aos.oigo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getOrderInfo() {

        List<Order> orders = orderInfoService.selectOrderInfo();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order");
        mv.addObject("orders", orders);
        return mv;
    }


    @RequestMapping("/getorderajax")
    @ResponseBody
    public List<Order> getorderajax() {
        List<Order> orders = orderInfoService.selectOrderInfo();
        return orders;
    }


    @RequestMapping("/formorder")
    public String formOrder(Order order) {
        System.out.println(order.getCustomerId());
        System.out.println(order.getOrderCode());
        System.out.println(order.getCreatetime());
        return "index";
    }
}

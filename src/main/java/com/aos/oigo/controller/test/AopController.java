package com.aos.oigo.controller.test;

import com.aos.oigo.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-10
 */
@Controller
public class AopController {
    @Autowired
    AopService aopService;

    @RequestMapping("/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        aopService.add(a, b);
        return "index";
    }
}

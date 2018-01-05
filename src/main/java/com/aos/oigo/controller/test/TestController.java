package com.aos.oigo.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-05
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String test() {
        return "黄浩新很帅";
    }
}

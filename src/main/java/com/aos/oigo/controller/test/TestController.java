package com.aos.oigo.controller.test;

import com.aos.oigo.pojo.AjaxBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @RequestMapping("/ajaxtest")
    @ResponseBody
    public String ajaxtest(@RequestBody Map<String,Object> data) {
        System.out.println(data.get("account"));
        System.out.println(data.get("password"));
        System.out.println("aaaaaa");
        return "1";
    }

    @RequestMapping("/ajaxtest2")
    @ResponseBody
    public String ajaxtest2(@RequestBody AjaxBean bean) {
        System.out.println(bean.getAccount());
        System.out.println(bean.getPassword());
        System.out.println("aaaaaa");
        return "1";
    }
}

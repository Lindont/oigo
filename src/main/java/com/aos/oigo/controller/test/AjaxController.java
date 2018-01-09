package com.aos.oigo.controller.test;

import com.aos.oigo.pojo.AjaxBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-09
 */
@Controller
public class AjaxController {
    @RequestMapping("/ajaxtest1")
    @ResponseBody
    public Map ajaxtest1(@RequestBody Map<String, Object> data) {
        System.out.println(data.get("account"));
        System.out.println(data.get("password"));
        Map map = new HashMap();
        map.put("account", data.get("account"));
        map.put("password", data.get("password"));
        return map;
    }

    @RequestMapping("/ajaxtest2")
    @ResponseBody
    public AjaxBean ajaxtest2(@RequestBody AjaxBean bean) {
        System.out.println(bean.getAccount());
        System.out.println(bean.getPassword());
        return bean;
    }

    @RequestMapping("/ajaxtest3")
    @ResponseBody
    public String ajaxtest3(@RequestParam("account") String account, @RequestParam("password") String password) {
        System.out.println(account);
        System.out.println(password);
        return "1";
    }

    @RequestMapping("/pvtest/{name}/{id}")
    public String pvtest(@PathVariable String name,@PathVariable Integer id) {
        System.out.println(name);
        System.out.println(id);
        return "index";
    }
}

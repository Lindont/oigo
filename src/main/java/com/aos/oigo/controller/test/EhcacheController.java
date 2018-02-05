package com.aos.oigo.controller.test;

import com.aos.oigo.ehcache.EhCacheTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-05
 */
@Controller
public class EhcacheController {
    @Autowired
    private EhCacheTestService ehCacheTestService;

    @RequestMapping("/ehcache")
    public String getCache() throws InterruptedException {
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        return "index";
    }
}

package com.aos.oigo.controller.test;

import com.aos.oigo.redis.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-02-04
 */
@Controller
public class RedisController {
    @Autowired
    RedisClientTemplate redisTemplate;

    @RequestMapping(value = "/getredis/{key}", method = RequestMethod.GET)
    @ResponseBody
    public String getRedis(@PathVariable String key) {
        String str = redisTemplate.get(key);
        System.out.println(str);
        return str;
    }


    @RequestMapping(value = "/setredis", method = RequestMethod.POST)
    @ResponseBody
    public String setRedis(@RequestParam("rekey") String key, @RequestParam("reval") String val) {
        String str = redisTemplate.set(key, val);
        return str;
    }
}

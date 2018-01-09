package com.aos.oigo.controller.test;

import com.aos.oigo.pojo.FormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-09
 */
@Controller
public class FormController {
    @RequestMapping("/formtest1")
    public ModelAndView formtest1(FormBean fb) {
        ModelAndView mv = new ModelAndView();
        System.out.println(fb.getAccount());
        System.out.println(fb.getPassword());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/formtest2")
    public ModelAndView formtest2(@RequestParam("account") String account, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        System.out.println(account);
        System.out.println(password);
        mv.setViewName("index");
        return mv;
    }
}

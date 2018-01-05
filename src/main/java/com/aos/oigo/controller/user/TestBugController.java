package com.aos.oigo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class TestBugController {
    @RequestMapping("testbug")
    public ModelAndView testBug(@RequestParam(required = false) String username,
                                @RequestParam(required = false) String password) throws IOException {

        if (1 == 1) {
            return null;
        }
        System.out.println("哈哈哈");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("str", "abc");
        modelAndView.setViewName("showSession");
        return modelAndView;
    }
}

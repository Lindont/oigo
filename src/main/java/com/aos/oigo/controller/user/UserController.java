package com.aos.oigo.controller.user;

import com.aos.oigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-07
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping("/getUser")
    public String getUserList(Model model) {
        model.addAttribute("allUser",userService.getUserList());
        return "user";
    }
}

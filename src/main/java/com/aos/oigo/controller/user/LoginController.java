package com.aos.oigo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class LoginController
{
    @RequestMapping("setsession")
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpSession session)
    {
        session.setAttribute("username", username);
        System.out.println(password);
    }

}

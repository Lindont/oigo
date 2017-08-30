package com.aos.oigo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class GetSessionAttr
{
    @RequestMapping("getsession")
    public String getSession(HttpSession session, Model model)
    {
        Object str = session.getAttribute("username");
        model.addAttribute("str",str.toString());
        return "showSession";
    }
}

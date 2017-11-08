package com.aos.oigo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-11-08
 */
@Controller
public class GetContextPath {
    @RequestMapping("contextpath")
    public void getContextPath(HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(contextPath);
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getPathInfo());
    }
}

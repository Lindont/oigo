package com.aos.oigo.controller.user;

import com.aos.oigo.common.context.SessionContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class LoginController {
    @RequestMapping("setsession")
    public void login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      HttpSession session) {
        session.setAttribute("username", username);
        System.out.println(password);
    }

    /**
     * 踢出登录
     *
     * @param userId
     * @return
     */
    @RequestMapping("/kickout")
    @ResponseBody
    public String kickout(Long userId) {
        if (null == userId) {
            return "0";
        }
        SessionContextHolder holder = SessionContextHolder.getInstance();
        HttpSession session = holder.getSession(userId);
        if (session != null) {
            session.invalidate();
            holder.removeSession(userId);
        }
        return "0";
    }

}

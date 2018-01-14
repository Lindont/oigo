package com.aos.oigo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId,
                            @RequestHeader("User-Agent") String userAgent,
                            @RequestHeader("Accept") String[] accepts) {
        System.out.println(userAgent);
        for (String accept : accepts) {
            System.out.println(accept);
        }
        System.out.println("SessionID: " + sessionId);
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}

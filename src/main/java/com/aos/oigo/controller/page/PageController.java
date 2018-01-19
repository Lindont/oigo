package com.aos.oigo.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/")
    public String showIndex(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId,
                            @RequestHeader("User-Agent") String userAgent,
                            @RequestHeader("Accept") String[] accepts) {

        LOGGER.info(userAgent);
        for (String accept : accepts) {
            LOGGER.info(accept);
        }
        LOGGER.info("SessionID: " + sessionId);
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}

package com.aos.oigo.common.context;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : HuangHaoXin
 * @Description : 使用此方法所有类都能取到当前请求的 request, response 对象
 * @Date : Create in 2018-02-08
 */

/**
 *  使用此方法获取 request, response 需要先在 web.xml 配置下面的 Listener
 *   <listener>
 *       <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
 *   </listener>
*/

public class HttpContextHolder {
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }
}

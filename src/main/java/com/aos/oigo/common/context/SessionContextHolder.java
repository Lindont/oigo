package com.aos.oigo.common.context;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 使用单例模式获取用户信息
 */
public class SessionContextHolder {

    //单例
    private static SessionContextHolder instance;

    //容器
    private final HashMap context;

    //构造
    private SessionContextHolder() {
        context = new HashMap();
    }

    //工厂
    public static SessionContextHolder getInstance() {
        if (instance == null) {
            instance = new SessionContextHolder();
        }
        return instance;
    }

    /**
     * 添加session
     *
     * @param userId
     * @param session
     */
    public synchronized void addSession(Long userId, HttpSession session) {
        if (session == null) {
            return;
        }
        context.put(userId, session);
    }

    /**
     * 删除session
     *
     * @param userId
     */
    public synchronized void removeSession(Long userId) {
        if (userId == null) {
            return;
        }
        context.remove(userId);
    }

    /**
     * 获取session
     *
     * @param userId
     * @return
     */
    public synchronized HttpSession getSession(Long userId) {
        if (userId == null) {
            return null;
        }
        return (HttpSession) context.get(userId);
    }

}
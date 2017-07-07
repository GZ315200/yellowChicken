package org.igeek.interceptor;

import org.igeek.common.Const;
import org.igeek.pojo.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by Gyges on 2017/7/6.
 * 登录拦截
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
//        非登录界面拦截
        if (!url.contains("login")) {
            logger.info("###########进入拦截器################");
            HttpSession session = request.getSession();
            Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
            if (Objects.isNull(organization)) {
                response.sendRedirect(request.getContextPath() + "/login.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

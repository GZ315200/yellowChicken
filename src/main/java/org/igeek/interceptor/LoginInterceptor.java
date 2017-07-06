package org.igeek.interceptor;

import org.igeek.common.Const;
import org.igeek.pojo.Organization;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (url.indexOf("login") > 0) {
            return true;
        }
        HttpSession session = request.getSession();
        Organization organization = (Organization) session.getAttribute(Const.CURRENT_USER);
        if (Objects.nonNull(organization)){
            return true;
        }
        request.getRequestDispatcher(request.getContextPath()+"/login.html").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

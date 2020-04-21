package com.artisan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现 Handlerlnterceptor接口,覆盖其对应的方法即完成了拦截器的开发
 *
 * @author yangshangwei
 *
 */

public class MyInterceptor3 implements HandlerInterceptor {

    /**
     * preHandle在执行Controller之前执行
     * 返回true：继续执行处理器逻辑，包含Controller的功能
     * 返回false：中断请求
     *
     * 处理器执行前方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("MyInterceptor333-处理器执行前方法preHandle，返回true则不拦截后续的处理");
        return true;
    }

    /**
     * postHandle在请求执行完之后 渲染ModelAndView返回之前执行
     *
     * 处理器处理后方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("MyInterceptor333-处理器处理后方法postHandle");
    }

    /**
     * afterCompletion在整个请求执行完毕后执行,无论是否发生异常都会执行
     *
     * 处理器完成后方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("MyInterceptor333-处理器完成后方法afterCompletion");

    }

}


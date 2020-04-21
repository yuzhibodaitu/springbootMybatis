package com.artisan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Step1 @WebFilter注解开发过滤器
 * Step2 启动类增加@ServletComponentScan注解
 * 访问 http://localhost:9091/artisan/interceptor/test?name=artisan
 */
@WebFilter(filterName = "HttpFilter2", urlPatterns = "/*")
public class HttpFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("HttpFilter2  init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("HttpFilter2  doFilter begin");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("HttpFilter2 name:" + request.getParameter("name"));

        // 将请求转发给过滤器链上下一个对象。这里的下一个指的是下一个filter，如果没有filter那就是请求的资源。
        chain.doFilter(request, response);
        System.out.println("HttpFilter2  doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("HttpFilter2  destroy");
        Filter.super.destroy();
    }
}


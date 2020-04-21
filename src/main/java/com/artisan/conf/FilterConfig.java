package com.artisan.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.artisan.filter.HttpFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<HttpFilter> httpFilter(){
        FilterRegistrationBean<HttpFilter> filterRegistrationBean = new FilterRegistrationBean<HttpFilter>();
        // 设置filter
        filterRegistrationBean.setFilter(new HttpFilter());
        // 拦截规则
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}


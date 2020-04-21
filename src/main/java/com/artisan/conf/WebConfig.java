package com.artisan.conf;

import com.artisan.interceptor.MyInterceptor2;
import com.artisan.interceptor.MyInterceptor3;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.artisan.interceptor.MyInterceptor;

/**
 * 实现 WebMvcConfigurer 接 口， 最后覆盖其addInterceptors方法进行注册拦截器
 * @author yangshangwei
 *
 */

// 标注为配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  注册拦截器到 Spring MVC 机制， 然后 它会返 回 一个拦截器注册
//        InterceptorRegistration regist =  registry.addInterceptor(new MyInterceptor());
//
//        // 指定拦截匹配模式，限制拦截器拦截请求
//        regist.addPathPatterns("/artisan/interceptor/*");
//        // 不拦截的路径
//        regist.excludePathPatterns("/artisan/interceptor/exclude/*");

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/artisan/interceptor/*").excludePathPatterns("/artisan/interceptor/exclude/*");
        // 加入多个interceptor 判断拦击顺序
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/artisan/interceptor/*").excludePathPatterns("/artisan/interceptor/exclude/*");;
        registry.addInterceptor(new MyInterceptor3()).addPathPatterns("/artisan/interceptor/*").excludePathPatterns("/artisan/interceptor/exclude/*");;
    }

}


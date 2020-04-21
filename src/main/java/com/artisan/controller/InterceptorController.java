package com.artisan.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/artisan")
public class InterceptorController {

    @GetMapping("/interceptor/test")
    public String testInterceptor() {
        System.out.println("执行处理器逻辑testInterceptor....");
        return "请观察控制台中拦截器的日志输出";
    }


    @GetMapping("/interceptor/exclude/test")
    public String testExcludeInterceptor() {
        System.out.println("执行处理器逻辑testExcludeInterceptor....");
        return "exclude排除，不会被拦截器拦截";
    }
}


package com.garry.springinterceptor.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author guyu06
 * @date 2023/1/3 14:36
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private FirstInterceptor firstInterceptor;
    @Autowired
    private SecondInterceptor secondInterceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor).addPathPatterns("/interceptor/**");
        registry.addInterceptor(secondInterceptor).addPathPatterns("/interceptor/**");
    }
}

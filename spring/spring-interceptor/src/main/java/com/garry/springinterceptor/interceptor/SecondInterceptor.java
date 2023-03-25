package com.garry.springinterceptor.interceptor;

import com.garry.springinterceptor.interceptor.annotation.ValidationAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guyu06
 * @date 2023/1/3 14:24
 */
@Slf4j
@Component
public class SecondInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final ValidationAnnotation validationAnnotation = ((HandlerMethod)handler).getMethod().getAnnotation((ValidationAnnotation.class));
        if (validationAnnotation == null) {
            return true;
        }
        var hello = request.getAttribute("hello");
        return "world".equals(hello);
    }

}

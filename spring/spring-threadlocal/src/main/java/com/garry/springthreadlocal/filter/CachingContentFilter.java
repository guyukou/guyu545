package com.garry.springthreadlocal.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(0)
@Component
public class CachingContentFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, httpServletResponse);
//        filterChain.doFilter(new RepeatableReadServletRequest(httpServletRequest), httpServletResponse);
    }
}


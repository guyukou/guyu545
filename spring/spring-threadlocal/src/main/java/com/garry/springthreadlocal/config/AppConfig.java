package com.garry.springthreadlocal.config;

import com.garry.springthreadlocal.filter.TenantFilter;
import com.garry.springthreadlocal.tenant.TenantStore;
import com.google.common.collect.Lists;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @author guyu06
 * @date 2022/9/20 5:27 PM
 */
@Configuration
public class AppConfig {

    @Bean
    public TenantFilter tenantFilter() {
        return new TenantFilter();
    }

    @Bean
    public FilterRegistrationBean<TenantFilter> tenantFilterRegistration() {
        FilterRegistrationBean<TenantFilter> result = new FilterRegistrationBean<>();
        result.setFilter(this.tenantFilter());
        result.setUrlPatterns(Lists.newArrayList("/demo/*"));
        result.setName("Tenant Store Filter");
        result.setOrder(1);
        return result;
    }

    @Bean(destroyMethod = "destroy")
    public ThreadLocalTargetSource threadLocalTenantStore() {
        ThreadLocalTargetSource result = new ThreadLocalTargetSource();
        result.setTargetBeanName("tenantStore");
        return result;
    }

    @Primary
    @Bean(name = "proxiedThreadLocalTargetSource")
    public ProxyFactoryBean proxiedThreadLocalTargetSource(ThreadLocalTargetSource threadLocalTargetSource) {
        ProxyFactoryBean result = new ProxyFactoryBean();
        result.setTargetSource(threadLocalTargetSource);
        return result;
    }

    @Bean(name = "tenantStore")
    @Scope(scopeName = "prototype")
    public TenantStore tenantStore() {
        return new TenantStore();
    }
}
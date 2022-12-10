package com.garry.springthreadlocal.filter;

import com.garry.springthreadlocal.tenant.TenantStore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author guyu06
 * @date 2022/9/20 5:30 PM
 */
public class TenantFilter implements Filter {
    private static final String TENANT_HEADER_NAME = "X-TENANT-ID";
    @Autowired
    private TenantStore tenantStore;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        // LOGGER.info("Thread had tenant data: {} from an old request", this.tenantStore.getTenantId());

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String tenantId = request.getHeader(TENANT_HEADER_NAME);
        try {
            this.tenantStore.setTenantId(tenantId);
            chain.doFilter(servletRequest, servletResponse);
        } finally {
            // Otherwise when a previously used container thread is used, it will have the old tenant id set and
            // if for some reason this filter is skipped, tenantStore will hold an unreliable value
            this.tenantStore.clear();
        }
    }
}

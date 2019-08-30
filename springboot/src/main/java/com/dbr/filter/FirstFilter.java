package com.dbr.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * springboot
 * 2019/8/30 16:16
 * SpringBoot整合 Filter
 * <filter>
 * 	<filter-name>FirstFilter</filter-name>
 * 	<filter-class>com.bjsxt.filter.FirstFilter</filter-class> *</filter>
 * <filter-mapping>
 * 	<filter-name>FirstFilter</filter-name>
 * 	<url-pattern>/first</url-pattern>
 * </filter-mapping>
 * @author zhaozheng
 * @since
 **/
//常用filter过滤
//@WebFilter(filterName = "FirstFilter",urlPatterns = {"*.jsp","*.do"})
@WebFilter(filterName = "FirstFilter",urlPatterns = "/firstFilter")
public class FirstFilter implements Filter {
    private Logger logger= LoggerFactory.getLogger(FirstFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.error("进入filter");
        filterChain.doFilter(servletRequest,servletResponse);
        logger.error("离开filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

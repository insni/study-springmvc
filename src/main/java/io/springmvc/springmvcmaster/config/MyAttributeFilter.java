package io.springmvc.springmvcmaster.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/example")
public class MyAttributeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("myAttribute","This is a request attribute");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

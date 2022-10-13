package org.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[LOG] - Filter was initialized.");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("[LOG] - Custom filter intercepts web request at " + LocalDateTime.now());

        req.setAttribute("was-filtered", true);
        chain.doFilter(req, res);
    }
}

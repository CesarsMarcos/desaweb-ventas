/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.utp.sistema.ventas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cesar
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/pages/*"})
public class SessionFilter implements Filter {

    private HttpServletRequest req;

    private static final String[] loginRequiredURLs = {
        "/cliente", "/venta"
    };

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        String loginURI = req.getContextPath() + "/";
        boolean isUser = (session != null && session.getAttribute("role") != null && session.getAttribute("role").equals(2));
        boolean isLoggedIn = (session != null && session.getAttribute("username") != null && session.getAttribute("menu") != null);
        boolean isLoginRequest = req.getRequestURI().equals(loginURI);
        boolean isLoginPage = req.getRequestURI().endsWith("/");

        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            req.getRequestDispatcher("/login").forward(request, response);
        } else if (isLoggedIn && isUser && (!isLoginRequired())) {
            res.sendRedirect(req.getContextPath() + "/page-403");
        } else if (!isLoggedIn) {
            res.sendRedirect(req.getContextPath() + "/login");
        } else {
            isLoginRequired();
            chain.doFilter(request, response);
        }

    }

    private boolean isLoginRequired() {
        String requestURL = req.getRequestURL().toString();

        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }

        return false;
    }

    public void destroy() {
        //close any resources here
    }
}

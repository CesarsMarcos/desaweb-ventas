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

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession();

        if (session == null || session.getAttribute("username") == null) {

            System.out.println("No hay session");
            res.sendRedirect(req.getContextPath() + "/page-login.jsp");
            //request.getRequestDispatcher("./page-login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        //close any resources here
    }
}

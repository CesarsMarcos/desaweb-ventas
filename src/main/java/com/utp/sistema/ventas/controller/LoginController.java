/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Menu;
import com.utp.sistema.ventas.model.Usuario;
import com.utp.sistema.ventas.model.dao.impl.LoginDaoImp;
import com.utp.sistema.ventas.model.dao.impl.MenuDaoimpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    LoginDaoImp loginDao = new LoginDaoImp();
    MenuDaoimpl menuDao = new MenuDaoimpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/page-login.jsp")
                .forward(request, response);
        //processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario = loginDao.validateLogin(username, password);

        if (username == null || password == null || usuario == null) {
            request.setAttribute("message", "El nombre de usuario o la contraseña son incorrectos");
            request.getRequestDispatcher("page-login.jsp").forward(request, response);
        } else {

            List<Menu> menus = menuDao.findMenuByUserName(username);

            session.setAttribute("username", usuario.getNombres());
            session.setAttribute("role", usuario.getIdRol());
            session.setAttribute("menu", menus);
            request.getRequestDispatcher("/pages/home?menu=principal").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

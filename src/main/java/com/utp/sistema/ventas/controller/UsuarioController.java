/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Usuario;
import com.utp.sistema.ventas.model.dao.impl.RolDaoImp;
import com.utp.sistema.ventas.model.dao.impl.UsuarioDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDaoImp usuarioDao = new UsuarioDaoImp();
        RolDaoImp rolDao = new RolDaoImp();
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("usuarios", usuarioDao.findAll());
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);
                break;
            case "guardar":
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                Integer idRol = Integer.parseInt(request.getParameter("rol"));
                String tipDocumento = request.getParameter("tipDocumento");
                String numDocumento = request.getParameter("numDocumento");
                String password = request.getParameter("password");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                String direccion = request.getParameter("direccion");

                Usuario usuario = new Usuario();
                usuario.setNombres(nombres);
                usuario.setApellidos(apellidos);
                usuario.setTipo_documento(tipDocumento);
                usuario.setNum_documento(numDocumento);
                usuario.setIdRol(idRol);
                usuario.setPassword(password);
                usuario.setDireccion(direccion);
                usuario.setTelefono(telefono);
                usuario.setEmail(email);

                usuarioDao.insert(usuario);

                request.setAttribute("usuarios", usuarioDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);

                break;
                
               case "eliminar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                usuarioDao.delete(id);

                request.setAttribute("usuarios", usuarioDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);

                break;   
                
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

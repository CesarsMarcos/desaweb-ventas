/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Rol;
import com.utp.sistema.ventas.model.dao.impl.RolDaoImp;
import java.io.IOException;
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
@WebServlet(name = "RolController", urlPatterns = {"/RolController"})
public class RolController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RolDaoImp rolDao = new RolDaoImp();
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "listar":
                List<Rol> lista = rolDao.findAll();
                request.setAttribute("roles", lista);
                request.getRequestDispatcher("page-rol.jsp").forward(request, response);
                break;
            case "guardar":
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                Rol rol = new Rol();
                rol.setNombre(nombre);
                rol.setDescripcion(descripcion);
                
                rolDao.insert(rol);
                
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("page-rol.jsp").forward(request, response);
                
                break;
             case "eliminar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                rolDao.delete(id);

                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("page-rol.jsp").forward(request, response);

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

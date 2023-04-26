/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Categoria;
import com.utp.sistema.ventas.model.dao.impl.CategoriaDaoImp;
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
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CategoriaDaoImp categoriaDao = new CategoriaDaoImp();

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                List<Categoria> lista = categoriaDao.findAll();
                request.setAttribute("categorias", lista);
                request.getRequestDispatcher("page-categoria.jsp").forward(request, response);
                break;
            case "guardar":
                String descripcion = request.getParameter("descripcion");
                Categoria categoria = new Categoria();
                categoria.setDescripcion(descripcion);

                categoriaDao.insert(categoria);

                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("page-categoria.jsp").forward(request, response);

                break;
             case "eliminar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                categoriaDao.delete(id);

                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("page-categoria.jsp").forward(request, response);

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

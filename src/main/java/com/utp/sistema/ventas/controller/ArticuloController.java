/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Articulo;
import com.utp.sistema.ventas.model.dao.impl.ArticuloDaoImp;
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
@WebServlet(name = "ArticuloController", urlPatterns = {"/ArticuloController"})
public class ArticuloController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticuloDaoImp articuloDao = new ArticuloDaoImp();
        CategoriaDaoImp categoriaDao = new CategoriaDaoImp();

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("page-articulo.jsp").forward(request, response);
                break;
            case "guardar":
                String descripcion = request.getParameter("descripcion");
                Integer idCategoria = Integer.parseInt(request.getParameter("categoria"));
                Integer stock = Integer.parseInt(request.getParameter("stock"));
                Double precio = Double.parseDouble(request.getParameter("precioVenta"));

                Articulo articulo = new Articulo();
                articulo.setDescripcion(descripcion);
                articulo.setIdCategoria(idCategoria);
                articulo.setStock(stock);
                articulo.setPrecio_venta(precio);
                articuloDao.insert(articulo);

                request.setAttribute("articulos", articuloDao.findAll());
                request.getRequestDispatcher("page-articulo.jsp").forward(request, response);
                break;
            case "eliminar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                articuloDao.delete(id);

                request.setAttribute("articulos", articuloDao.findAll());
                request.getRequestDispatcher("page-articulo.jsp").forward(request, response);

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Articulo;
import com.utp.sistema.ventas.model.dao.impl.ArticuloDaoImp;
import com.utp.sistema.ventas.model.dao.impl.CategoriaDaoImp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Cesar
 */
@WebServlet(name = "ArticuloController", urlPatterns = {"/pages/articulo"})
public class ArticuloController extends HttpServlet {

    ArticuloDaoImp articuloDao = new ArticuloDaoImp();
    CategoriaDaoImp categoriaDao = new CategoriaDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id;
        String descripcion;
        Integer idCategoria, stock;
        Double precio;
        Articulo articulo = new Articulo();
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;
            case "guardar":
                descripcion = request.getParameter("descripcion");
                idCategoria = Integer.parseInt(request.getParameter("categoria"));
                stock = Integer.parseInt(request.getParameter("stock"));
                precio = Double.parseDouble(request.getParameter("precioVenta"));

                articulo.setDescripcion(descripcion);
                articulo.setIdCategoria(idCategoria);
                articulo.setStock(stock);
                articulo.setPrecio_venta(precio);
                articuloDao.insert(articulo);

                request.setAttribute("categorias", categoriaDao.findAll());
                request.setAttribute("articulos", articuloDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;

            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                descripcion = request.getParameter("descripcion");
                idCategoria = Integer.parseInt(request.getParameter("categoria"));
                stock = Integer.parseInt(request.getParameter("stock"));
                precio = Double.parseDouble(request.getParameter("precioVenta"));

                articulo.setIdArticulo(id);
                articulo.setDescripcion(descripcion);
                articulo.setIdCategoria(idCategoria);
                articulo.setStock(stock);
                articulo.setPrecio_venta(precio);
                articuloDao.update(articulo);

                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;

            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("categorias", categoriaDao.findAll());
                request.setAttribute("articulo", articuloDao.find(id));
                request.setAttribute("articulos", articuloDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);

                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                articuloDao.delete(id);
                request.setAttribute("articulos", articuloDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

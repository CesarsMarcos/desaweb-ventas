/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Articulo;
import com.utp.sistema.ventas.model.dao.impl.ArticuloDaoImp;
import com.utp.sistema.ventas.model.dao.impl.CategoriaDaoImp;
import com.utp.sistema.ventas.model.util.Constantes;
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
@WebServlet(name = "ArticuloController", urlPatterns = {"/pages/articulos"})
public class ArticuloController extends HttpServlet {

    ArticuloDaoImp articuloDao = new ArticuloDaoImp();
    CategoriaDaoImp categoriaDao = new CategoriaDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id;
        String descripcion, stock, precio, idCategoria;
        String accion = request.getParameter("accion");
        int idCategoriaInt, stockInt;
        double precioDouble;

        Articulo articulo = new Articulo();

        String validaciones = "";
        String mensaje = null;

        switch (accion) {
            case "listar":
                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);

                break;
            case "guardar":
                descripcion = request.getParameter("descripcion");
                idCategoria = request.getParameter("categoria");
                stock = request.getParameter("stock");
                precio = request.getParameter("precioVenta");
                idCategoriaInt = (idCategoria.equals("") || idCategoria == null ? 0 : Integer.valueOf(idCategoria));
                stockInt = (stock.equals("") || stock == null ? 0 : Integer.valueOf(stock));
                precioDouble = (precio.equals("") || precio == null ? 0 : Double.valueOf(precio));

                if (descripcion.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo descripcion esta vacio";
                }
                if (stockInt == 0) {
                    validaciones += "<br />Ingresa el stock";
                }

                if (precioDouble == 0) {
                    validaciones += "<br />Ingresa el precio";
                }

                if (idCategoriaInt == 0) {
                    validaciones += "<br />Debes seleccionar una categoria";
                }

                articulo.setDescripcion(descripcion);
                articulo.setIdCategoria(idCategoriaInt);
                articulo.setStock(stockInt);
                articulo.setPrecio_venta(precioDouble);

                if (validaciones.equals("")) {
                    mensaje = articuloDao.insert(articulo);

                }
                request.setAttribute("categorias", categoriaDao.findAll());
                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("articulo", articulo);
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;

            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));

                descripcion = request.getParameter("descripcion");
                idCategoria = request.getParameter("categoria");
                stock = request.getParameter("stock");
                precio = request.getParameter("precioVenta");
                idCategoriaInt = (idCategoria.equals("") || idCategoria == null ? 0 : Integer.valueOf(idCategoria));
                stockInt = (stock.equals("") || stock == null ? 0 : Integer.valueOf(stock));
                precioDouble = (precio.equals("") || precio == null ? 0 : Double.valueOf(precio));

                if (validaciones.equals("")) {
                    articulo.setIdArticulo(id);
                    articulo.setDescripcion(descripcion);
                    articulo.setIdCategoria(idCategoriaInt);
                    articulo.setStock(stockInt);
                    articulo.setPrecio_venta(precioDouble);
                    mensaje = articuloDao.update(articulo);
                }

                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.setAttribute("mensaje", mensaje);
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
                request.setAttribute("mensaje", Constantes.MENSAJE_BORRADO);
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                break;
            /*default:
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);
                request.setAttribute("articulos", articuloDao.findAll());
                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-articulo.jsp").forward(request, response);*/

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

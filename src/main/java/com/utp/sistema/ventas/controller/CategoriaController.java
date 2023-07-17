/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Categoria;
import com.utp.sistema.ventas.model.dao.impl.CategoriaDaoImp;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "CategoriaController", urlPatterns = {"/pages/categorias"})
public class CategoriaController extends HttpServlet {

    CategoriaDaoImp categoriaDao = new CategoriaDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = 0;
        String descripcion;
        Categoria categoria;
        String mensaje = null;
        String validaciones = "";
        List<Categoria> categorias = new ArrayList<>();
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                categorias = categoriaDao.findAll();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);
                break;
            case "guardar":
                descripcion = request.getParameter("descripcion");

                if (descripcion.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo descripcion esta vacio";
                }
                if (validaciones.equals("")) {
                    categoria = new Categoria();
                    categoria.setDescripcion(descripcion);
                    mensaje = categoriaDao.insert(categoria);
                }
                request.setAttribute("categorias", categoriaDao.findAll());
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);
                break;
            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                descripcion = request.getParameter("descripcion");

                if (descripcion.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo descripcion esta vacio";
                }

                if (validaciones.equals("")) {
                    categoria = new Categoria();
                    categoria.setDescripcion(descripcion);
                    categoria.setIdCategoria(id);
                    mensaje = categoriaDao.update(categoria);
                }

                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);

                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                categoriaDao.delete(id);

                request.setAttribute("categorias", categoriaDao.findAll());
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);
                break;

            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaDao.find(id);
                categorias = categoriaDao.findAll();
                request.setAttribute("categoria", categoria);
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);
                break;
            /*default:
                categorias = categoriaDao.findAll();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/page-categoria.jsp").forward(request, response);*/
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

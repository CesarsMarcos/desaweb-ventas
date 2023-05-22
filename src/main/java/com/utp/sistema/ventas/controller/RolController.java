/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Rol;
import com.utp.sistema.ventas.model.dao.impl.RolDaoImp;
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
@WebServlet(name = "RolController", urlPatterns = {"/pages/rol"})
public class RolController extends HttpServlet {

    RolDaoImp rolDao = new RolDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id;
        String nombre;
        String descripcion;

        List<Rol> lista = new ArrayList<>();
        Rol rol = new Rol();
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);
                break;
            case "guardar":
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                rol.setNombre(nombre);
                rol.setDescripcion(descripcion);

                rolDao.insert(rol);

                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);

                break;
            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");
                rol.setIdRol(id);
                rol.setNombre(nombre);
                rol.setDescripcion(descripcion);
                rolDao.update(rol);

                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);

                break;
            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("rol", rolDao.find(id));
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);

                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                rolDao.delete(id);

                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);

                break;
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

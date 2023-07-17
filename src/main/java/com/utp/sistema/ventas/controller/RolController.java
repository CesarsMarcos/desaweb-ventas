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
@WebServlet(name = "RolController", urlPatterns = {"/pages/roles"})
public class RolController extends HttpServlet {

    RolDaoImp rolDao = new RolDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        Integer id;
        String nombre;
        String descripcion;
        List<Rol> lista = new ArrayList<>();
        Rol rol = new Rol();

        String mensaje = null;
        String validaciones = "";

        switch (accion) {
            case "listar":
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);
                break;
            case "guardar":
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");

                if (nombre.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo Nombre esta vacio";
                }
                if (descripcion.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo Descripcion esta vacio";
                }
                if (validaciones.equals("")) {

                    rol.setNombre(nombre);
                    rol.setDescripcion(descripcion);

                    mensaje = rolDao.insert(rol);
                }

                request.setAttribute("roles", rolDao.findAll());
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);

                break;
            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                nombre = request.getParameter("nombre");
                descripcion = request.getParameter("descripcion");

                if (nombre.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo Nombre esta vacio";
                }
                if (descripcion.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo Descripcion esta vacio";
                }
                if (validaciones.equals("")) {
                    rol.setIdRol(id);
                    rol.setNombre(nombre);
                    rol.setDescripcion(descripcion);
                    mensaje = rolDao.update(rol);
                }

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
            /*default:
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("/page-rol.jsp").forward(request, response);*/
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

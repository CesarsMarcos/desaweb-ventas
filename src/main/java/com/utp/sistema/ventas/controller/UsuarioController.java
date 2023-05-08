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
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario"})
public class UsuarioController extends HttpServlet {

    UsuarioDaoImp usuarioDao = new UsuarioDaoImp();
    RolDaoImp rolDao = new RolDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        Integer id;
        String nombres;
        String apellidos;
        Integer idRol;
        String tipDocumento;
        String numDocumento;
        String password;
        String telefono;
        String email;
        String direccion;

        switch (accion) {
            case "listar":
                request.setAttribute("usuarios", usuarioDao.findAll());
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);
                break;
            case "guardar":
                nombres = request.getParameter("nombres");
                apellidos = request.getParameter("apellidos");
                idRol = Integer.parseInt(request.getParameter("rol"));
                tipDocumento = request.getParameter("tipDocumento");
                numDocumento = request.getParameter("numDocumento");
                password = request.getParameter("password");
                telefono = request.getParameter("telefono");
                email = request.getParameter("email");
                direccion = request.getParameter("direccion");

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
                request.getRequestDispatcher("usuario").forward(request, response);

                break;

            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                nombres = request.getParameter("nombres");
                apellidos = request.getParameter("apellidos");
                idRol = Integer.parseInt(request.getParameter("rol"));
                tipDocumento = request.getParameter("tipDocumento");
                numDocumento = request.getParameter("numDocumento");
                password = request.getParameter("password");
                telefono = request.getParameter("telefono");
                email = request.getParameter("email");
                direccion = request.getParameter("direccion");

                usuario = new Usuario();
                usuario.setIdUsuario(id);
                usuario.setNombres(nombres);
                usuario.setApellidos(apellidos);
                usuario.setTipo_documento(tipDocumento);
                usuario.setNum_documento(numDocumento);
                usuario.setIdRol(idRol);
                usuario.setPassword(password);
                usuario.setDireccion(direccion);
                usuario.setTelefono(telefono);
                usuario.setEmail(email);

                usuarioDao.update(usuario);

                request.setAttribute("usuarios", usuarioDao.findAll());
                request.setAttribute("roles", rolDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);

                break;

            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("roles", rolDao.findAll());
                request.setAttribute("usuario", usuarioDao.find(id));
                request.setAttribute("usuarios", usuarioDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);

                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                usuarioDao.delete(id);

                request.setAttribute("usuarios", usuarioDao.findAll());
                request.getRequestDispatcher("page-usuario.jsp").forward(request, response);
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

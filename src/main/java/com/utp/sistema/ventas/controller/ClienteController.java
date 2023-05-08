/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Cliente;
import com.utp.sistema.ventas.model.dao.impl.ClienteDaoImp;
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
@WebServlet(name = "ClienteController", urlPatterns = {"/cliente"})
public class ClienteController extends HttpServlet {

    ClienteDaoImp clienteDao = new ClienteDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id;
        String nombres;
        String apellidos;
        String tipCliente;
        String tipDocumento;
        String numDocumento;
        String telefono;
        String email;
        String direccion;

        Cliente cliente = new Cliente();

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);
                break;
            case "guardar":
                nombres = request.getParameter("nombres");
                apellidos = request.getParameter("apellidos");
                tipCliente = request.getParameter("tipCliente");
                tipDocumento = request.getParameter("tipDocumento");
                numDocumento = request.getParameter("numDocumento");
                telefono = request.getParameter("telefono");
                email = request.getParameter("email");
                direccion = request.getParameter("direccion");

                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setTipo_documento(tipDocumento);
                cliente.setNum_documento(numDocumento);
                cliente.setTipo_cliente(tipCliente);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setEmail(email);

                clienteDao.insert(cliente);

                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);

                break;

            case "modificar":
                id = Integer.parseInt(request.getParameter("id"));
                nombres = request.getParameter("nombres");
                apellidos = request.getParameter("apellidos");
                tipCliente = request.getParameter("tipCliente");
                tipDocumento = request.getParameter("tipDocumento");
                numDocumento = request.getParameter("numDocumento");
                telefono = request.getParameter("telefono");
                email = request.getParameter("email");
                direccion = request.getParameter("direccion");

                cliente.setIdCliente(id);
                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setTipo_documento(tipDocumento);
                cliente.setNum_documento(numDocumento);
                cliente.setTipo_cliente(tipCliente);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setEmail(email);

                clienteDao.update(cliente);

                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);

                break;

            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("cliente", clienteDao.find(id));
                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);

                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                clienteDao.delete(id);

                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);

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

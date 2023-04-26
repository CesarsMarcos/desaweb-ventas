/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Cliente;
import com.utp.sistema.ventas.model.dao.impl.ClienteDaoImp;
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
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDaoImp clienteDao = new ClienteDaoImp();

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                List<Cliente> lista = clienteDao.findAll();
                request.setAttribute("clientes", lista);
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);
                break;
              case "guardar":
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String tipCliente  = request.getParameter("tipCliente");
                String tipDocumento = request.getParameter("tipDocumento");
                String numDocumento = request.getParameter("numDocumento");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                String direccion = request.getParameter("direccion");

                Cliente cliente = new Cliente();
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
            case "eliminar":
                Integer id = Integer.parseInt(request.getParameter("id"));
                clienteDao.delete(id);

                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("page-cliente.jsp").forward(request, response);

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

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
@WebServlet(name = "ClienteController", urlPatterns = {"/pages/clientes"})
public class ClienteController extends HttpServlet {

    ClienteDaoImp clienteDao = new ClienteDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
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

        String mensaje = null;
        String validaciones = "";

        switch (accion) {
            case "listar":
                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);
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

                if (nombres.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo nombres esta vacio";
                }

                if (apellidos.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo apellidos esta vacio";
                }
                if (tipCliente.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>Debes seleccionar el Tipo de Cliente";
                }

                if (tipDocumento.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>Debes seleccionar un Tipo de Documento";
                }

                if (numDocumento.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo Número de Documento esta vacio";
                }

                if (telefono.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo password esta vacio";
                }

                if (email.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo email esta vacio";
                }

                if (direccion.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo direccion esta vacio";
                }

                if (validaciones.equals("")) {
                    cliente.setNombres(nombres);
                    cliente.setApellidos(apellidos);
                    cliente.setTipo_documento(tipDocumento);
                    cliente.setNum_documento(numDocumento);
                    cliente.setTipo_cliente(tipCliente);
                    cliente.setDireccion(direccion);
                    cliente.setTelefono(telefono);
                    cliente.setEmail(email);
                    mensaje = clienteDao.insert(cliente);
                }

                request.setAttribute("clientes", clienteDao.findAll());
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);

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

                if (nombres.replaceAll(" ", "").equals("")) {
                    validaciones += "El campo nombres esta vacio";
                }

                if (apellidos.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo apellidos esta vacio";
                }
                if (tipCliente.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>Debes seleccionar el Tipo de Cliente";
                }

                if (tipDocumento.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>Debes seleccionar un Tipo de Documento";
                }

                if (numDocumento.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo Número de Documento esta vacio";
                }

                if (telefono.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo password esta vacio";
                }

                if (email.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo email esta vacio";
                }

                if (direccion.replaceAll(" ", "").equals("")) {
                    validaciones += "<br/>El campo direccion esta vacio";
                }

                if (validaciones.equals("")) {
                    cliente.setIdCliente(id);
                    cliente.setNombres(nombres);
                    cliente.setApellidos(apellidos);
                    cliente.setTipo_documento(tipDocumento);
                    cliente.setNum_documento(numDocumento);
                    cliente.setTipo_cliente(tipCliente);
                    cliente.setDireccion(direccion);
                    cliente.setTelefono(telefono);
                    cliente.setEmail(email);
                    mensaje = clienteDao.update(cliente);
                }
                request.setAttribute("clientes", clienteDao.findAll());
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);

                break;

            case "obtener":
                id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("cliente", clienteDao.find(id));
                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);

                break;

            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                clienteDao.delete(id);

                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);
                break;
            /*default:
                request.setAttribute("clientes", clienteDao.findAll());
                request.getRequestDispatcher("/page-cliente.jsp").forward(request, response);*/
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

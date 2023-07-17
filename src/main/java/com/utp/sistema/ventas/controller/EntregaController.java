/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Entrega;
import com.utp.sistema.ventas.model.dao.impl.EntregaDaoImpl;
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
@WebServlet(name = "EntregaController", urlPatterns = {"/pages/entregas"})
public class EntregaController extends HttpServlet {

    EntregaDaoImpl entregaDao = new EntregaDaoImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idEntrega, idVenta, estado;

        Entrega entrega = new Entrega();

         String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                request.setAttribute("pendientes", entregaDao.findAllEntregaPending());
                request.getRequestDispatcher("/page-entrega.jsp").forward(request, response);
                break;

            case "entregados":
                request.setAttribute("entregados", entregaDao.findAllEntregaPending());
                request.getRequestDispatcher("/page-entrega.jsp").forward(request, response);
                break;
            case "guardar":
                idEntrega = Integer.parseInt(request.getParameter("idEntrega"));
                idVenta = Integer.parseInt(request.getParameter("idVenta"));
                estado = 1;

                entrega.setIdVenta(idVenta);
                entrega.setIdEntrega(idEntrega);
                entrega.setEstado(estado);
                entregaDao.insert(entrega);

                request.setAttribute("entregas", entregaDao.findAll());
                request.getRequestDispatcher("/page-entrega.jsp").forward(request, response);

                break;

            case "modificarEstado":
                idEntrega = Integer.parseInt(request.getParameter("idEntrega"));
                

                entrega.setIdEntrega(idEntrega);
                entrega.setEstado(1);

                entregaDao.update(entrega);

                request.setAttribute("entregas", entregaDao.findAllEntregaPending());
                request.getRequestDispatcher("/page-entrega.jsp").forward(request, response);
                break;
            /*default:
                request.setAttribute("pendientes", entregaDao.findAllEntregaPending());
                request.getRequestDispatcher("/page-entrega.jsp").forward(request, response);*/
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
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.Entrega;
import com.utp.sistema.ventas.model.dao.impl.EntregaDaoImpl;
import com.utp.sistema.ventas.model.dao.impl.VentaDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "PrograEntrega", urlPatterns = {"/pages/programacion"})
public class Programacion extends HttpServlet {

    EntregaDaoImpl entregaDao = new EntregaDaoImpl();
    VentaDaoImp ventaDao = new VentaDaoImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idEntrega;
        String accion = request.getParameter("accion");
        Entrega entrega = new Entrega();
        String validaciones = "";
        String mensaje = null;

        String idVenta, fecha;
        int idVentaInt;

        switch (accion) {
            case "listar":
                request.setAttribute("programadas", entregaDao.findAll());
                request.setAttribute("ventas", ventaDao.findAll());
                request.getRequestDispatcher("/page-programacion.jsp").forward(request, response);

                break;
            case "guardar":
                idVenta = request.getParameter("venta");
                fecha = request.getParameter("fecha");

                idVentaInt = (idVenta.equals("") || idVenta == null ? 0 : Integer.valueOf(idVenta));

                if (idVentaInt == 0) {
                    validaciones += "Selecciona una venta";
                }

                if (fecha.replaceAll(" ", "").equals("")) {
                    validaciones += "<br />El campo fecha de entrega no debe esta vacio";
                }

                if (validaciones.equals("")) {
                    entrega.setIdVenta(idVentaInt);
                    entrega.setFecha(fecha);
                    entrega.setEstado(1);
                    mensaje = entregaDao.insert(entrega);

                }

                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.setAttribute("programadas", entregaDao.findAll());
                request.getRequestDispatcher("/page-programacion.jsp").forward(request, response);
                break;

            case "modificar-estado":
                idVentaInt = Integer.parseInt(request.getParameter("idVentaInt"));
                idEntrega = Integer.parseInt(request.getParameter("idEntrega"));

                entrega.setIdEntrega(idEntrega);
                entrega.setEstado(0);

                entregaDao.update(entrega);
                ventaDao.updateEstadoVenta(idVentaInt);

                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.setAttribute("programadas", entregaDao.findAll());
                request.getRequestDispatcher("/page-programacion.jsp").forward(request, response);
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

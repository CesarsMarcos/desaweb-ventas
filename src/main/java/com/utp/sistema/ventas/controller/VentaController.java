/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.*;
import com.utp.sistema.ventas.model.dao.impl.*;
import com.utp.sistema.ventas.model.dto.VentaDTO;
import com.utp.sistema.ventas.model.util.Util;

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
@WebServlet(name = "VentaController", urlPatterns = {"/venta"})
public class VentaController extends HttpServlet {

    ClienteDaoImp clienteDao = new ClienteDaoImp();
    ArticuloDaoImp productoDao = new ArticuloDaoImp();
    VentaDaoImp ventaDao = new VentaDaoImp();
    Util util = new Util();
    VentaDTO venta = new VentaDTO();
    List<VentaDTO> ventas = new ArrayList<>();
    Articulo articulo = new Articulo();
    Cliente cliente = new Cliente();

    String descripcion, numSerie;
    int item, cantidad;
    double precio, subTotalItem, total, subTotal, igv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "BuscarCliente":
                Integer idCli = Integer.parseInt(request.getParameter("idCli"));
                cliente = clienteDao.find(idCli);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("page-detalle-venta.jsp").forward(request, response);
                break;

            case "BuscarProducto":
                Integer idProd = Integer.parseInt(request.getParameter("idProd"));
                articulo = productoDao.find(idProd);
                request.setAttribute("articulo", articulo);
                /* request.setAttribute("ventas", ventas);
                request.setAttribute("subTotal", subTotalFinal);
                request.setAttribute("igv", igv);
                request.setAttribute("total", total);*/
                request.getRequestDispatcher("page-detalle-venta.jsp").forward(request, response);
                break;

            case "AgregarLista":

                total = 0.0;
                item = item + 1;
                descripcion = articulo.getDescripcion();
                precio = articulo.getPrecio_venta();
                cantidad = Integer.parseInt(request.getParameter("cantidad"));
                subTotalItem = precio * cantidad;

                venta = new VentaDTO();
                venta.setId(item);
                venta.setDescripcion(descripcion);
                venta.setCantidad(cantidad);
                venta.setPrecioVenta(precio);
                venta.setSubTotal(subTotalItem);

                ventas.add(venta);

                for (int i = 0; i < ventas.size(); i++) {
                    subTotal = subTotal + ventas.get(i).getPrecioVenta();
                    igv = (subTotal + ventas.get(i).getPrecioVenta()) * 0.18;
                    total = subTotal + igv;
                }

                request.setAttribute("articulo", articulo);
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("igv", igv);
                request.setAttribute("total", total);
                request.setAttribute("ventas", ventas);
                request.getRequestDispatcher("page-detalle-venta.jsp").forward(request, response);
                break;
            default:
                //throw new AssertionError();
                numSerie = util.generateNumComprobante();
                request.setAttribute("numSerie", numSerie);
                request.getRequestDispatcher("page-detalle-venta.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("page-detalle-venta.jsp").forward(request, response);

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

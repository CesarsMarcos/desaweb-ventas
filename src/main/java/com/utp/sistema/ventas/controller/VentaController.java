/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.*;
import com.utp.sistema.ventas.model.dao.impl.*;
import com.utp.sistema.ventas.model.dto.ProductoParaVenderDTO;
import com.utp.sistema.ventas.model.util.Util;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cesar
 */
@WebServlet(name = "VentaController", urlPatterns = {"/pages/ventas"})
public class VentaController extends HttpServlet {

    ClienteDaoImp clienteDao = new ClienteDaoImp();
    ArticuloDaoImp productoDao = new ArticuloDaoImp();
    VentaDaoImp ventaDao = new VentaDaoImp();
    DetalleVentaDaoImp detalleDao = new DetalleVentaDaoImp();

    Venta venta = new Venta();
    Articulo articulo = new Articulo();
    Cliente cliente = new Cliente();
    Util util = new Util();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        ArrayList<ProductoParaVenderDTO> carrito;
        float total = 0, subTotal = 0, igv = 0;

        Integer idCliente, idProducto;

        String mensaje = null;
        String validaciones = "";

        if (accion == null) {
            carrito = this.obtenerCarrito(request);
            for (ProductoParaVenderDTO p : carrito) {
                subTotal += p.getTotal();
                igv += p.getTotal() * 0.18;
                total += subTotal + igv;
            }

            request.setAttribute("total", total);
            request.setAttribute("subTotal", subTotal);
            request.setAttribute("igv", igv);
            request.setAttribute("producto", new Articulo());
            request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
        } else {
            switch (accion) {
                case "BuscarProducto":
                    idProducto = (request.getParameter("idProducto") == null || request.getParameter("idProducto") == "") ? 0 : Integer.valueOf(request.getParameter("idProducto"));

                    if (idProducto == 0) {
                        validaciones += "<br />Ingresa el código de producto";
                    }

                    if (validaciones.equals("")) {
                        articulo = productoDao.find(idProducto);
                        if (articulo == null) {
                            mensaje = "Producto ingresado con código " + articulo.getIdArticulo() + " no existe, ingreso un código valido";
                        }
                        if (articulo.sinExistencia()) {
                            mensaje = "El producto está agotado";
                        }
                    }

                    carrito = this.obtenerCarrito(request);
                    for (ProductoParaVenderDTO p : carrito) {
                        subTotal += 0;
                        igv += 0;
                        total += p.getTotal();
                    }

                    request.setAttribute("total", total);
                    request.setAttribute("subTotal", subTotal);
                    request.setAttribute("igv", igv);
                    request.setAttribute("articulo", articulo);
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("validaciones", validaciones);
                    request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                    break;
                case "AgregarACarrito":
                    carrito = this.obtenerCarrito(request);

                    idProducto = (request.getParameter("idProducto") == null || request.getParameter("idProducto") == "") ? 0 : Integer.valueOf(request.getParameter("idProducto"));

                    if (idProducto == 0) {
                        validaciones += "<br />Ingresa el código de producto";
                    }

                    boolean encontrado = false;

                    if (validaciones.equals("")) {
                        for (ProductoParaVenderDTO productoParaVenderActual : carrito) {
                            if (productoParaVenderActual.getIdArticulo().equals(articulo.getIdArticulo())) {
                                productoParaVenderActual.aumentarCantidad();
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            carrito.add(new ProductoParaVenderDTO(1f, articulo.getIdArticulo(),
                                    articulo.getIdCategoria(),
                                    articulo.getDescripcion(),
                                    articulo.getPrecioVenta(),
                                    articulo.getStock(),
                                    articulo.getEstado()));
                        }

                        guardarCarrito(carrito, request);
                        carrito = this.obtenerCarrito(request);
                        for (ProductoParaVenderDTO p : carrito) {
                            subTotal += p.getTotal();
                            igv += p.getTotal() * 0.18;
                            total += subTotal + igv;
                        }
                    }

                    request.setAttribute("total", total);
                    request.setAttribute("subTotal", subTotal);
                    request.setAttribute("igv", igv);
                    request.setAttribute("validaciones", validaciones);
                    request.getRequestDispatcher("/page-venta.jsp").forward(request, response);

                    break;
                case "BuscarCliente":
                    idCliente = (request.getParameter("idCli") == null || request.getParameter("idCli") == "") ? 0 : Integer.valueOf(request.getParameter("idCli"));

                    if (idCliente == 0) {
                        validaciones += "<br />Ingresa el código de cliente";
                    }

                    if (validaciones.equals("")) {
                        cliente = clienteDao.find(idCliente);
                        if (cliente == null) {
                            mensaje = "Cliente con código " + idCliente + " no existe";
                        }
                    }

                    carrito = this.obtenerCarrito(request);
                    for (ProductoParaVenderDTO p : carrito) {
                        subTotal += p.getTotal();
                        igv += p.getTotal() * 0.18;
                        total += subTotal + igv;
                    }

                    request.setAttribute("cliente", cliente);
                    request.setAttribute("articulo", articulo);

                    request.setAttribute("subTotal", subTotal);
                    request.setAttribute("igv", igv);
                    request.setAttribute("total", total);

                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("validaciones", validaciones);
                    request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                    break;
                case "cancelar":
                    this.limpiarCarrito(request);

                    subTotal = 0.0f;
                    igv = 0.0f;
                    total = 0.0f;

                    request.setAttribute("total", total);
                    request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                    break;

                case "guardar":
                    carrito = this.obtenerCarrito(request);
                    idCliente = (request.getParameter("idCli") == null || request.getParameter("idCli") == "") ? 0 : Integer.valueOf(request.getParameter("idCli"));

                    if (idCliente == 0) {
                        validaciones += "Debes seleccionar un usuario";
                    }
                    if (carrito == null || carrito.size() <= 0) {
                        //return;
                        validaciones += "<br/>Debes agregar productos para continuar";
                    }

                    if (validaciones.equals("")) {

                        venta.setRuc("000000");
                        venta.setTipo_comprobante("tipo_comprobante");
                        venta.setNum_comprobante(util.generateNumComprobante());
                        venta.setIdCliente(cliente.getIdCliente());
                        venta.setImpuesto(Double.parseDouble(request.getParameter("igv")));
                        venta.setDescuento(0);
                        venta.setTotal(Double.parseDouble(request.getParameter("total")));
                        venta.setEstado(0);
                        venta.setIdUsuario(1);
                        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String s = formatter.format(new Date());

                        venta.setFecha_hora(s);
                        ventaDao.insert(venta);

                        int idVenta = ventaDao.getLastIdVenta();

                        for (ProductoParaVenderDTO productoParaVender : carrito) {

                            Articulo a = productoDao.find(productoParaVender.getIdArticulo());

                            if (a == null) {
                                continue;
                            }

                            a.restarExistencia(productoParaVender.getCantidad());
                            productoDao.update(a);

                            DetalleVenta detalle = new DetalleVenta(idVenta, productoParaVender.getIdArticulo(), productoParaVender.getCantidad(), productoParaVender.getPrecioVenta());
                            detalleDao.insert(detalle);

                        }
                        this.limpiarCarrito(request);
                        mensaje = "Venta registrada con éxito";

                    }

                    request.setAttribute("validaciones", validaciones);
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                    break;
                default:

            }
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

    private ArrayList<ProductoParaVenderDTO> obtenerCarrito(HttpServletRequest request) {
        ArrayList<ProductoParaVenderDTO> carrito = (ArrayList<ProductoParaVenderDTO>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }

    private void guardarCarrito(ArrayList<ProductoParaVenderDTO> carrito, HttpServletRequest request) {
        request.getSession().setAttribute("carrito", carrito);
    }

    private void limpiarCarrito(HttpServletRequest request) {
        this.guardarCarrito(new ArrayList<>(), request);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

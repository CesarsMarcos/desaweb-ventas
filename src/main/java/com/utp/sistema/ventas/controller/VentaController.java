/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.utp.sistema.ventas.controller;

import com.utp.sistema.ventas.model.*;
import com.utp.sistema.ventas.model.dao.impl.*;
import com.utp.sistema.ventas.model.dto.ProductoParaVenderDTO;
import com.utp.sistema.ventas.model.dto.VentaDTO;
import com.utp.sistema.ventas.model.util.Util;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "VentaController", urlPatterns = {"/pages/ventas"})
public class VentaController extends HttpServlet {

    ClienteDaoImp clienteDao = new ClienteDaoImp();
    ArticuloDaoImp productoDao = new ArticuloDaoImp();
    VentaDaoImp ventaDao = new VentaDaoImp();

    List<VentaDTO> ventas = new ArrayList<>();

    VentaDTO ventaDTO = new VentaDTO();
    Venta venta = new Venta();
    DetalleVenta detalleV = new DetalleVenta();
    DetalleVentaDaoImp detalleDao = new DetalleVentaDaoImp();
    Articulo articulo = new Articulo();
    Cliente cliente = new Cliente();

    Util util = new Util();

    String descripcion, numSerie;
    int item, cantidad;
    double precio, subTotalItem, total, subTotal, igv;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idCli, idProd;
        int idCliInt, idProdInt;
        String accion = request.getParameter("accion");
        String mensaje = null;
        String validaciones = "";

        switch (accion) {
            case "BuscarCliente":
                idCli = request.getParameter("idCli");
                idCliInt = (idCli.equals("") || idCli == null ? 0 : Integer.valueOf(idCli));

                if (idCliInt == 0) {
                    validaciones += "<br />Ingresa el código de cliente";
                }

                if (validaciones.equals("")) {
                    cliente = clienteDao.find(idCliInt);
                    if (cliente == null) {
                        mensaje = "Cliente con código " + idCli + " no existe";
                    }
                }

                request.setAttribute("cliente", cliente);
                request.setAttribute("articulo", articulo);
                request.setAttribute("articulo", articulo);
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("igv", igv);
                request.setAttribute("total", total);
                request.setAttribute("ventas", ventas);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                break;

            case "BuscarProducto":
                idProd = request.getParameter("idProducto");
                idProdInt = (idProd.equals("") || idProd == null ? 0 : Integer.valueOf(idProd));

                if (idProdInt == 0) {
                    validaciones += "<br />Ingresa el código de producto";
                }

                if (validaciones.equals("")) {
                    articulo = productoDao.find(idProdInt);
                    if (articulo.getIdArticulo() == 0 || articulo == null) {
                        mensaje = "Producto ingresado con código " + idProd + " no existe, ingreso un código valido";
                    }
                }

                request.setAttribute("articulo", articulo);
                request.setAttribute("articulo", articulo);
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("igv", igv);
                request.setAttribute("total", total);
                request.setAttribute("ventas", ventas);
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("validaciones", validaciones);
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                break;

            case "AgregarLista":
                total = 0.0;
                item = item + 1;
                descripcion = articulo.getDescripcion();
                precio = articulo.getPrecio_venta();
                cantidad = Integer.parseInt(request.getParameter("cantidad"));
                subTotalItem = precio * cantidad;

                ventaDTO = new VentaDTO();
                ventaDTO.setId(item);
                ventaDTO.setDescripcion(descripcion);
                ventaDTO.setCantidad(cantidad);
                ventaDTO.setPrecioVenta(precio);
                ventaDTO.setSubTotal(subTotalItem);
                ventaDTO.setIdProd(articulo.getIdArticulo());

                ventas.add(ventaDTO);

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
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                break;
            case "cancelar":
                ventas = new ArrayList<>();
                ventaDTO = new VentaDTO();

                subTotal = 0.0;
                igv = 0.0;
                total = 0.0;

                request.setAttribute("articulo", articulo);
                request.setAttribute("subTotal", subTotal);
                request.setAttribute("igv", igv);
                request.setAttribute("total", total);
                request.setAttribute("ventas", ventas);
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                break;

            case "guardar":
                venta.setRuc("000000");
                venta.setTipo_comprobante("tipo_comprobante");
                venta.setNum_comprobante(util.generateNumComprobante());
                venta.setIdCliente(cliente.getIdCliente());
                venta.setImpuesto(igv);
                venta.setDescuento(0);
                venta.setTotal(total);
                venta.setEstado(0);
                venta.setIdUsuario(1);

                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = formatter.format(new Date());

                venta.setFecha_hora(s);
                ventaDao.insert(venta);

                int idV = ventaDao.getLastIdVenta();

                for (int i = 0; i < ventas.size(); i++) {
                    detalleV = new DetalleVenta();
                    detalleV.setIdVenta(idV);
                    detalleV.setIdArticulo(ventas.get(i).getIdProd());
                    detalleV.setCantidad(ventas.get(i).getCantidad());
                    detalleV.setPrecio(ventas.get(i).getPrecioVenta());
                    detalleDao.insert(detalleV);
                }

                request.setAttribute("mensaje", "Venta registrada con exito");
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
                break;
            default:
                //throw new AssertionError();
                ventaDTO = new VentaDTO();
                // numSerie = util.generateNumComprobante();
                //request.setAttribute("numSerie", numSerie);

                float total = 0;
                ArrayList<ProductoParaVenderDTO> carrito = this.obtenerCarrito(request);
                for (ProductoParaVenderDTO p : carrito) {
                    total += p.getTotal();
                }
                request.setAttribute("total", 5000);
                request.setAttribute("mensaje", "Venta registrada con exito");
                request.getRequestDispatcher("/page-venta.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("/page-venta.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private ArrayList<ProductoParaVenderDTO> obtenerCarrito(HttpServletRequest request) {
        ArrayList<ProductoParaVenderDTO> carrito = (ArrayList<ProductoParaVenderDTO>) request.getSession().getAttribute("carrtito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }

    private void guardarCarrito(ArrayList<ProductoParaVenderDTO> carrito, HttpServletRequest request) {
        request.getSession().setAttribute("carrito", carrito);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : page-detalle-venta
    Created on : 17 abr. 2023, 21:50:52
    Author     : Cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Detalle de Venta</title>
    </head>
    <body class="d-flex h-100">
        <div class="cover-container d-flex w-100 h-100  mx-auto flex-column">
            <%@include file="navbar.jsp" %>
            <main class="px-3 mt-5">
                <div class="container">
                    <div class="panel panel-primary ">
                        <div class="panel-body ">
                            <form action="ventas" method="post">
                                <div class="row">
                                    <h5 class="mt-4">Registro de Nueva Venta</h5>
                                    <hr>
                                    <div class="col-sm-8">

                                        <div class="row g-3">
                                            <div class="col-sm-2 text-center">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" name="idProducto" placeholder="id de producto" value="${articulo.getIdArticulo()}" >    
                                                    <button type="submit" name="accion" value="BuscarProducto"  class="btn btn-outline-success"  ><i class="fa fa-search"></i></button>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <input type="text" class="form-control"  readonly="" placeholder="Descripción" value="${articulo.getDescripcion()}" >
                                            </div>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" readonly  placeholder="Precio" value="${articulo.getPrecioVenta()}" >
                                            </div>
                                            <div class="col-sm-3">
                                                <button type="submit" name="accion" value="AgregarACarrito" class="btn btn-success"><i class="fa fa-cart-plus" ></i></button>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="col-md-12">
                                            <div class="table-responsive">
                                                <table class="table align-middle">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Descripción</th>
                                                            <th scope="col">Precio Venta</th>
                                                            <th scope="col">Cantidad</th>
                                                            <th scope="col">Total</th>
                                                            <th scope="col"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${sessionScope.carrito}" var="venta" >
                                                            <tr>
                                                                <td>${venta.getDescripcion()}</td>
                                                                <td>${venta.getPrecioVenta()}</td>
                                                                <td>${venta.getCantidad()}</td>
                                                                <td>${venta.getTotal()}</td>
                                                                <td>
                                                                    <a href="" type="button"
                                                                       class="btn btn-danger btn-sm  btn-xs"><i
                                                                            class="ion ion-md-trash"></i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="card border-success mb-3" >
                                            <div class="card-header  border-success text-center bg-success"> <h3 class="d-inline fw-bold">S/ ${total == null  ? 0.0 : total} </h3></div>
                                            <div class="card-body">
                                                <div class="row g-3 center">
                                                    <div class="col-sm-12">
                                                        <label class="form-label fw-bold">Documento</label>
                                                        <select class="form-control"   name="tipDocumento">
                                                            <option value="">--Selecciona--</option>
                                                            <option value="BOLETA" >BOLETA</option>
                                                        </select>
                                                    </div>
                                                    <!--<div class="col-sm-6">
                                                        <label  class="form-label fw-bold">Nro. Comprobante</label>
                                                        <input type="text" class="form-control" name="numSerie" value="${numSerie}"  placeholder="00001">
                                                    </div>-->
                                                    <div class="col-sm-6" >
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" placeholder="DOI de cliente"  name="idCli" value="${cliente.getIdCliente()}">
                                                            <button class="btn btn-outline-success" type="submit"  name="accion"  value="BuscarCliente"><i class="fa fa-search"></i></button>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <input type="text" class="form-control"  placeholder="Nombres" value="${cliente.getNombres()} ${cliente.getApellidos()}">
                                                    </div>
                                                    <hr>
                                                    <div class="col-sm-6 ">
                                                        <p class="d-inline">SUB TOTAL</p>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <p class="d-inline">S/ ${subTotal  == null  ? 0.0 : subTotal}</p>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <p class="d-inline">IGV</p>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <p class="d-inline">S/ ${igv  == null  ? 0.0 : igv}</p>
                                                    </div>

                                                    <div class="col-sm">
                                                        <p class="d-inline">TOTAL</p>
                                                    </div>
                                                    <div class="col-sm">
                                                        <p class="d-inline">S/ ${total == null  ? 0.0 : total}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>                           
                                </div>
                                <div class="col-12">
                                    <button type="submit"  name="accion" value="guardar" class="btn btn-success"><i class="fa fa-floppy-o" aria-hidden="true"></i> Registrar Venta </button>
                                    <button type="submit" class="btn btn-danger" name="accion" value="cancelar"><i class="fa fa-times" aria-hidden="true"></i> Cancelar </button>
                                </div>

                                <c:if test="${not empty validaciones}">          
                                    <div class="alert alert-danger mt-1">
                                        ${validaciones}
                                    </div>
                                </c:if>                  
                                <c:if test="${not empty mensaje}">                
                                    <div class="alert alert-success mt-1">
                                        ${mensaje}
                                    </div>
                                </c:if>                      
                            </form>
                        </div>
                    </div>


                </div>
            </main>

            <%@include file="footer.jsp" %>
        </div>

    </body>

</html>

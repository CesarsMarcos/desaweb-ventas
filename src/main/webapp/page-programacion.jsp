<%-- 
    Document   : page-usuarios
    Created on : 17 abr. 2023, 21:49:24
    Author     : Cesar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Clientes</title>
    </head>
    <body class="d-flex h-100">
        <div class="cover-container d-flex w-100 h-100  mx-auto flex-column">
            <%@include file="navbar.jsp" %>
            <main class="px-3 mt-5">
                <div class="container">
                    <div class="panel panel-primary mt-3">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col col-sm-5">
                                    <h5 class="mt-4">Registro de Entregas</h5>
                                    <hr>
                                    <form method="post" action="programacion?accion=guardar" class="row g-2">

                                        <div class="col-6">
                                            <label for="nombres">Venta </label>
                                            <select class="form-control"   name="venta">
                                                <option value="">--Selecciona--</option>
                                                <c:forEach items="${ventas}" var="vp" >
                                                    <option value="${vp.getIdVenta()}">${vp.getNum_comprobante()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Fecha de Entrega </label>
                                            <input type="date" name="fecha" id="fecha" class="form-control" >
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <input type="submit" name="accion" value="Registrar" class="btn btn-primary" >

                                            </div>
                                        </div>
                                        <div>${requestScope.validaciones}</div>    
                                        <c:if test="${not empty mensaje}">                
                                            <div class="alert alert-success">
                                                ${mensaje}
                                            </div>
                                        </c:if>   
                                    </form>
                                </div>
                                <div class="col col-sm-7">
                                    <h5 class="mt-4">Entregas programadas</h5>
                                    <hr>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Entrega</th>
                                                <th scope="col">Venta</th>
                                                <th scope="col">fecha</th>
                                                <th scope="col">Estado</th>
                                                <th scope="col">Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${programadas}" var="pro" >
                                                <tr>
                                                    <td>${pro.getIdEntrega()}</td>
                                                    <td>${pro.getIdVenta()}</td>
                                                    <td>${pro.getFecha()} </td>
                                                    <td>${pro.getEstado()== 0 ? '<span class="badge bg-success">entregado</span>': '<span class="badge bg-warning">pendiente</span>' }   </td>
                                                    <td>
                                                        <a href="programacion?accion=modificar-estado&idEntrega=${pro.getIdEntrega()}&idVentaInt=${pro.getIdVenta()}" type="button" class="btn btn-success btn-sm  btn-xs"><i class="ion ion-md-bus"></i></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <%@include file="footer.jsp" %>
        </div>

    </body>

</html>


<%-- 
    Document   : page-entrega
    Created on : 29 may. 2023, 20:56:11
    Author     : Cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Entregas Pendientes</title>
    </head>
    <body class="d-flex h-100">
        <div class="cover-container d-flex w-100 h-100  mx-auto flex-column">
            <%@include file="navbar.jsp" %>
            <main class="px-3 mt-5">
                <div class="container">
                    <div class="panel panel-primary mt-3">
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-4">
                                    <h5 class="mt-4">Listado de Entregas</h5>
                                    <hr>
                                    <div class="list-group" id="list-tab" role="tablist">
                                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#listar" href="entregas?accion=listar" role="tab" aria-controls="list-home">Pendientes</a>
                                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#entregados" href="entregas?accion=entregados" role="tab" aria-controls="list-profile">Entregados</a>
                                    </div>
                                </div>
                                <div class="col-8">
                                    <div class="tab-content" id="nav-tabContent">
                                        <div class="tab-pane fade show active" id="listar" role="tabpanel" aria-labelledby="list-home-list">
                                            <h5 class="mt-4">Pendientes</h5>
                                            <hr>
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Id</th>
                                                        <th scope="col">Id Venta </th>
                                                        <th scope="col">Cliente</th>
                                                        <th scope="col">Estado</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${pendientes}" var="e" >
                                                        <tr>
                                                            <td>${e.idEntrega}</td>
                                                            <td>${e.idVenta}</td>
                                                            <td>${e.Cliente}  </td>
                                                            <td>${e.Estado == 0 ? '<span class="badge bg-warning">Pendiente</span>' : '<span class="badge bg-primary">Entregado</span>'} </td>
                                                            <td>
                                                                <a href="entregas?accion=modificar-estado&idEntrega=${e.idEntrega}" type="button" class="btn btn-success btn-sm  btn-xs"><i class="ion ion-md-bus"></i></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="tab-pane fade" id="entregados" role="tabpanel" aria-labelledby="list-profile-list">
                                            <div class="col col-sm-12">
                                                <h5 class="mt-4">Entregadas</h5>
                                                <hr>
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Id</th>
                                                            <th scope="col">Id Venta </th>
                                                            <th scope="col">Cliente</th>
                                                            <th scope="col">Estado</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${entregas}" var="e" >
                                                            <tr>
                                                                <td>${e.idEntrega}</td>
                                                                <td>${e.idVenta}</td>
                                                                <td>${e.Cliente}  </td>
                                                                <td>${e.Estado == 0 ? '<span class="badge bg-warning">Pendiente</span>' : '<span class="badge bg-primary">Entregado</span>'} </td>
                                                                <td>
                                                                    <a href="entregas?accion=modificar-estado&idEntrega=${e.idEntrega}" type="button" class="btn btn-success btn-sm  btn-xs"><i class="ion ion-md-bus"></i></a>
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

                        </div>
                    </div>
                </div>
            </main>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

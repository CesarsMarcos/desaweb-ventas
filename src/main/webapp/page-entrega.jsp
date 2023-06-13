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
        <title>Entregas</title>
    </head>
    <body class="d-flex h-100">
        <div class="cover-container d-flex w-100 h-100  mx-auto flex-column">
            <%@include file="navbar.jsp" %>
            <main class="px-3 mt-5">
                <div class="container">
                    <div class="panel panel-primary mt-3">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col col-sm-12">
                                    <h5 class="mt-4">Entregas</h5>
                                    <hr>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Rol</th>
                                                <th scope="col">Nombres</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${entregas}" var="e" >
                                                <tr>
                                                    <td>${e.getIdEntrega()}</td>
                                                    <td>${e.getIdVenta()}</td>
                                                    <td>${e.getEstado()}  </td>
                                                    <td>
                                                        <a href="usuarios?accion=obtener&id=${e.getIdVenta()}" type="button"
                                                           class="btn btn-info btn-sm  btn-xs"><i
                                                                class="ion ion-md-create"></i></a>
                                                        <a href="usuarios?accion=eliminar&id=${e.getIdVenta()}" type="button"
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
                    </div>
                </div>
            </main>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>

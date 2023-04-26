<%-- 
    Document   : page-rol
    Created on : 17 abr. 2023, 21:50:26
    Author     : Cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Roles</title>
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
                                    <h5 class="mt-4">Registro de Rol</h5>
                                    <form method="post" action="RolController?accion=guardar" class="row g-2">
                                        <div class="col-md-6">
                                            <label for="nombres">Nombre </label>
                                            <input type="text" name="nombre" id="nombre" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Descripción</label>
                                            <input type="text" name="descripcion" id="descripcion" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="submit" name="accion" value="Registrar" class="btn btn-primary" >
                                                <a class="btn btn-primary" href="index.php">Regresar al inicio</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col col-sm-7">
                                    <h5 class="mt-4">Roles</h5>
                                    <hr>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Descripción</th>
                                                <th scope="col">Estado</th>
                                                <th scope="col">Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${roles}" var="r" >
                                                <tr>
                                                    <td>${r.getIdRol()}</td>
                                                    <td>${r.getNombre()}</td>
                                                    <td>${r.getDescripcion()}</td>
                                                    <td>${r.getEstado()== 0 ? '<span class="badge text-bg-success">activo</span>': '<span class="badge text-bg-danger">inactivo</span>' }   </td>
                                                    <td>
                                                        <a href="RolController?accion=modificar&id=${r.getIdRol()}" type="button"
                                                           class="btn btn-info btn-sm enLinea btn-xs"><i
                                                                class="ion ion-md-create"></i></a>
                                                        <a href="RolController?accion=eliminar&id=${r.getIdRol()}" type="button"
                                                           class="btn btn-danger btn-sm enLinea btn-xs"><i
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

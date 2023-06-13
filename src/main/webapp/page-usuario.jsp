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
        <title>Usuarios</title>
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
                                    <h5 class="mt-4">Registro de Usuarios</h5>
                                    <hr>
                                    <form method="post"  ${usuario.getIdUsuario() == null ? 'action="usuarios?accion=guardar"' : 'action="usuarios?accion=modificar"'} class="row g-2">
                                        <div class="col-md-12">
                                            <input type="hidden" class="form-control" name="id" value="${usuario.getIdUsuario()}">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Nombres</label>
                                            <input type="text" class="form-control"  placeholder="Nombres" name="nombres" value="${usuario.getNombres()}">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Apellidos</label>
                                            <input type="text" class="form-control"  placeholder="Apellidos" name="apellidos" value="${usuario.getApellidos()}">
                                        </div>
                                        <div class="col-6">
                                            <label for="nombres">Tipo de Documento </label>
                                            <select class="form-control"   name="tipDocumento">
                                                <option value="">--Selecciona--</option>
                                                <option value="DNI" ${usuario.getTipo_documento() == 'DNI' ? 'selected' : ''}>DNI</option>
                                                <option value="RUC" ${usuario.getTipo_documento() == 'RUC' ? 'selected' : ''}>RUC</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Nro. Documento </label>
                                            <input type="text" name="numDocumento" id="numDocumento" class="form-control" value="${usuario.getNum_documento()}">
                                        </div>
                                        <div class="col-6">
                                            <label for="nombres">Rol </label>
                                            <select class="form-control"   name="rol">
                                                <option value="">--Selecciona--</option>
                                                <c:forEach items="${roles}" var="r" >
                                                    <option value="${r.getIdRol()}" ${usuario.getIdRol() == r.getIdRol() ? 'selected' : ''}>${r.getNombre()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="col-6">
                                            <label for="nombres">Password</label>
                                            <input type="password" name="password" id="password" class="form-control" >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Telefono</label>
                                            <input type="text" name="telefono" id="telefono" class="form-control" value="${usuario.getTelefono()}">
                                        </div>

                                        <div class="col-6">
                                            <label for="nombres">Email</label>
                                            <input type="email" name="email" id="email" class="form-control" value="${usuario.getEmail()}">
                                        </div>
                                        <div class="col-12">
                                            <label for="nombres">Dirección</label>
                                            <input type="text" name="direccion" id="direccion" class="form-control" value="${usuario.getDireccion()}">
                                        </div>

                                        <div class="col-12">
                                            <div class="form-group">
                                                ${usuario.getIdUsuario() == null ? '<button type="submit" class="btn btn-primary">Registrar</button>' : '<button type="submit" class="btn btn-primary">Modificar</button>'}
                                                ${usuario.getIdUsuario() == null ? '' : '<a class="btn btn-primary" href="../pages/usuario?accion=listar">Cancelar</a>'} 
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col col-sm-7">
                                    <h5 class="mt-4">Usuarios</h5>
                                    <hr>
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Rol</th>
                                                <th scope="col">Nombres</th>
                                                <th scope="col">Tipo Doc.</th>
                                                <th scope="col">Num Documento</th>
                                                <th scope="col">Telefóno</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${usuarios}" var="u" >
                                                <tr>
                                                    <td>${u.getIdUsuario()}</td>
                                                    <td>${u.getIdRol()}</td>
                                                    <td>${u.getNombres()} ${u.getApellidos()} </td>
                                                    <td>${u.getTipo_documento()}</td>
                                                    <td>${u.getNum_documento()}</td>
                                                    <td>${u.getTelefono()}</td>
                                                    <td>${u.getEmail()}</td>
                                                    <td>
                                                        <a href="usuarios?accion=obtener&id=${u.getIdUsuario()}" type="button"
                                                           class="btn btn-info btn-sm  btn-xs"><i
                                                                class="ion ion-md-create"></i></a>
                                                        <a href="usuarios?accion=eliminar&id=${u.getIdUsuario()}" type="button"
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


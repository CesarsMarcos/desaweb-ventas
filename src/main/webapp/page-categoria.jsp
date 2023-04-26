<%-- 
    Document   : page-categoria
    Created on : 17 abr. 2023, 21:50:09
    Author     : Cesar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Categoría</title>
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
                                    <h5 class="mt-4">Registro de Categoría</h5>
                                    <hr>
                                    <form method="post" action="CategoriaController?accion=guardar" class="row g-1">
                                        <div class="col-md-12">
                                            <label for="nombres">Descripción</label>
                                            <input type="text" class="form-control"  placeholder="Descripción" name="descripcion" >
                                        </div>

                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input type="submit" name="accion" value="Registrar" class="btn btn-primary" >
                                                <a class="btn btn-primary" href="index.html">Regresar al inicio</a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col col-sm-7">
                                    <h5 class="mt-4">Categorias</h5>
                                    <hr>
                                    <div class="table-responsive">
                                        <table class="table align-middle">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Descripción</th>
                                                     <th scope="col">Estado</th>
                                                    <th scope="col">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${categorias}" var="cate" >
                                                    <tr>
                                                        <td>${cate.getIdCategoria()}</td>
                                                        <td>${cate.getDescripcion()}</td>
                                                        <td>${cate.getEstado()== 0 ? '<span class="badge text-bg-success">activo</span>': '<span class="badge text-bg-danger">inactivo</span>' }   </td>
                                                        <td>
                                                            <a href="CategoriaController?accion=modificar&id=${cate.getIdCategoria()}" type="button"
                                                               class="btn btn-info btn-sm  btn-xs"><i
                                                                    class="ion ion-md-create"></i></a>
                                                            <a href="CategoriaController?accion=eliminar&id=${cate.getIdCategoria()}" type="button"
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
                </div>

            </main>
            <%@include file="footer.jsp" %>
        </div>

    </body>

</html>

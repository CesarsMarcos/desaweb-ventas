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
        <title>Articulo</title>
    </head>
    <body class="d-flex h-100">
        <div class="cover-container d-flex w-100 h-100 mx-auto flex-column">
            <%@include file="navbar.jsp" %>
            <main class="px-3 mt-5">
                <div class="container">
                    <div class="panel panel-primary mt-3">
                        <div class="panel-body">

                            <div class="row">
                                <div class="col col-sm-5">
                                    <h5 class="mt-4">Registro de Articulos</h5>
                                    <hr>
                                    <form method="post" ${articulo.getIdArticulo() == null ? 'action="articulos?accion=guardar"' : 'action="articulos?accion=modificar"'}  class="row g-2">
                                        <div class="col-md-12">
                                            <input type="hidden" name="id" class="form-control" value="${articulo.getIdArticulo()}" >
                                        </div>
                                        <div class="col-md-12">
                                            <label for="nombres">Descripción</label>
                                            <input type="text" name="descripcion" class="form-control" value="${articulo.getDescripcion()}" >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Categoría </label>
                                            <select class="form-control" name="categoria">
                                                <option value="">--Selecciona--</option>
                                                <c:forEach items="${categorias}" var="cate" >
                                                    <option value="${cate.getIdCategoria()}" ${articulo.getIdCategoria()== cate.getIdCategoria()  ? 'selected' : ''} >${cate.getDescripcion()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="col-md-6">
                                            <label for="nombres">Stock</label>
                                            <input type="text" name="stock" class="form-control" value="${articulo.getStock()}" >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Precio Venta</label>
                                            <input type="text" name="precioVenta"  class="form-control" value="${articulo.getPrecio_venta()}">
                                        </div>

                                        <div class="col-md-12">
                                            <div class="form-group">
                                                ${articulo.getIdArticulo() == null ? '<button type="submit" class="btn btn-primary">Registrar</button>' : '<button type="submit" class="btn btn-primary">Modificar</button>'}
                                                ${articulo.getIdArticulo() == null ? '' : '<a class="btn btn-primary" href="../pages/articulo?accion=listar">Cancelar</a>'} 
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-md-7">
                                    <h5 class="mt-4">Articulos</h5>
                                    <hr>
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Categoría</th>
                                                    <th scope="col">Descripción</th>
                                                    <th scope="col">Precio Venta</th>
                                                    <th scope="col">Stock</th>
                                                    <th scope="col">Estado</th>
                                                    <th scope="col">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${articulos}" var="a" >
                                                    <tr>
                                                        <td>${a.getIdArticulo()}</td>
                                                        <td>${a.getIdCategoria()}</td>
                                                        <td>${a.getDescripcion()}</td>
                                                        <td>${a.getPrecio_venta()}</td>
                                                        <td>${a.getStock()}</td>
                                                        <td>${a.getEstado()== 0 ? '<span class="badge text-bg-success">activo</span>': '<span class="badge text-bg-danger">inactivo</span>' }   </td>
                                                        <td>
                                                            <a href="articulos?accion=obtener&id=${a.getIdArticulo()}" 
                                                               class="btn btn-info btn-sm  btn-xs"><i
                                                                    class="ion ion-md-create"></i></a>
                                                            <a href="articulos?accion=eliminar&id=${a.getIdArticulo()}"
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

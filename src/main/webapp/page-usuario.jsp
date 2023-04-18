<%-- 
    Document   : page-usuarios
    Created on : 17 abr. 2023, 21:49:24
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <%@include file="head.jsp" %>
          <title>Usuarios</title>
    </head>
    <body>
      <div class="container">
        <div class="panel panel-primary mt-3">
            <div class="panel-body">
                <div class="row">
                    <div class="col col-sm-5">
                        <h2 class="mt-4">Registro de Articulo</h2>
                        <hr>
                        <form method="post" action="">
                            <div class="row">
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Categría </label>
                                        <select class="form-control">
                                            <option>categoria 1</option>
                                            <option>categoria 2</option>
                                            <option>categoria 3</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Código </label>
                                        <input type="text" name="codigo" id="codigo" class="form-control">
                                    </div>
                                </div>
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Nombre</label>
                                        <input type="text" name="nombre" id="nombre" class="form-control">
                                    </div>
                                </div>
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Descripción</label>
                                        <input type="text" name="descripcion" id="descripcion" class="form-control">
                                    </div>
                                </div>
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Stock</label>
                                        <input type="text" name="stock" id="stock" class="form-control">
                                    </div>
                                </div>
                                <div class="col col-12">
                                    <div class="form-group">
                                        <label for="nombres">Precio Venta</label>
                                        <input type="text" name="precioVenta" id="precioVenta" class="form-control">
                                    </div>
                                </div>

                            </div>
                            <div class="row mt-3">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">Registrar</button>
                                    <a class="btn btn-primary" href="index.html">Regresar al inicio</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col col-sm-7">
                        <h2 class="mt-4">Articulos</h2>
                        <hr>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Categoría</th>
                                    <th scope="col">Código</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Precio Venta</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <tr>
                                    <td>1</td>
                                    <td>Categoria</td>
                                    <td>AR-0001</td>
                                    <td>Articulo 1</td>
                                    <td>20</td>
                                    <td>20.99</td>
                                    <td>Descripción</td>
                                    <td>
                                        <a href="" type="button"
                                            class="btn btn-info btn-sm enLinea btn-xs"><i
                                                class="ion ion-md-create"></i>Editar</a>
                                        <a href="" type="button"
                                            class="btn btn-danger btn-sm enLinea btn-xs"><i
                                                class="ion ion-md-trash"></i>Eliminar</a>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

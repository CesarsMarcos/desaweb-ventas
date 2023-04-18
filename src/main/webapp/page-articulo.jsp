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
        <title>Articulo</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container mt-5">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col col-sm-5">
                            <h2 class="mt-4">Registro de Usuario</h2>
                            <hr>
                            <form method="post" action="">
                                <div class="row">
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Tipo de Cliente </label>
                                            <select class="form-control">
                                                <option>tipo 1</option>
                                                <option>tipo 2</option>
                                                <option>tipo 3</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Nombres</label>
                                            <input type="text" name="nombres" id="nombre" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Apellidos</label>
                                            <input type="text" name="apellidos" id="apellidos" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Tipo de Documento </label>
                                            <select class="form-control">
                                                <option>documento 1</option>
                                                <option>documento 2</option>
                                                <option>documento 3</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Nro. Documento </label>
                                            <input type="text" name="numDocumento" id="numDocumento" class="form-control">
                                        </div>
                                    </div>

                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Dirección</label>
                                            <input type="text" name="direccion" id="direccion" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Teleféno</label>
                                            <input type="text" name="telefono" id="telefono" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col col-12">
                                        <div class="form-group">
                                            <label for="nombres">Email</label>
                                            <input type="text" name="email" id="email" class="form-control">
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
                            <h2 class="mt-4">Usuarios</h2>
                            <hr>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Tipo Cliente</th>
                                        <th scope="col">Nombres</th>
                                        <th scope="col">Tipo Doc.</th>
                                        <th scope="col">Num Documento</th>
                                        <th scope="col">Telefóno</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>tipo</td>
                                        <td>AR-0001</td>
                                        <td>Arturo Dávila</td>
                                        <td>12345678</td>
                                        <td>12345678</td>
                                        <td>email</td>
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

<%-- 
    Document   : page-usuarios
    Created on : 17 abr. 2023, 21:49:24
    Author     : Cesar
--%>

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
                                    <form method="post" action="" class="row g-2">
                                        <div class="col-md-4">
                                            <label for="nombres">Nombres</label>
                                            <input type="text" class="form-control"  placeholder="Nombres">
                                        </div>
                                        <div class="col-4">
                                            <label for="nombres">Apellidos</label>
                                            <input type="text" class="form-control"  placeholder="Apellidos">
                                        </div>

                                        <div class="col-md-4">
                                            <label for="nombres">Tipo de Cliente </label>
                                            <select class="form-control">
                                                <option>tipo 1</option>
                                                <option>tipo 2</option>
                                                <option>tipo 3</option>
                                            </select>
                                        </div>
                                        <div class="col-6">
                                            <label for="nombres">Tipo de Documento </label>
                                            <select class="form-control">
                                                <option>documento 1</option>
                                                <option>documento 2</option>
                                                <option>documento 3</option>
                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Nro. Documento </label>
                                            <input type="text" name="numDocumento" id="numDocumento" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="nombres">Teleféno</label>
                                            <input type="text" name="telefono" id="telefono" class="form-control">
                                        </div>

                                        <div class="col-6">
                                            <label for="nombres">Email</label>
                                            <input type="text" name="email" id="email" class="form-control">
                                        </div>
                                        <div class="col-12">
                                            <label for="nombres">Dirección</label>
                                            <input type="text" name="direccion" id="direccion" class="form-control">
                                        </div>
                                         <div class="col-12">
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary">Registrar</button>
                                                <a class="btn btn-primary" href="index.html">Regresar al inicio</a>
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
                                                            class="ion ion-md-create"></i></a>
                                                    <a href="" type="button"
                                                       class="btn btn-danger btn-sm enLinea btn-xs"><i
                                                            class="ion ion-md-trash"></i></a>
                                                </td>
                                            </tr>

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


<%-- 
    Document   : page-detalle-venta
    Created on : 17 abr. 2023, 21:50:52
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Detalle de Venta</title>

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
                                    <form class="row g-2">
                                        <div class="col-12">
                                            <h5> Cliente</h5>      
                                        </div>
                                        <hr>
                                        <div class="col-md-6">
                                            <div class="input-group mb-3">
                                                <input type="text" class="form-control" placeholder="id de cliente">
                                                <button class="btn btn-outline-success" type="button" id="button-addon2">Buscar</button>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Nombre">
                                        </div>

                                        <div class="col-6">
                                            <input type="text" class="form-control"  placeholder="Nombre">
                                        </div>
                                        <div class="col-6">
                                            <input type="text" class="form-control"  placeholder="DNI">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Apellidos">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Teléfono">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Dirección">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Email">
                                        </div>
                                        <div class="col-12">
                                            <h5> Producto</h5>      
                                        </div>
                                        <hr>
                                        <div class="col-md-6">
                                            <div class="input-group mb-3">
                                                <input type="text" class="form-control" placeholder="id de producto">
                                                <button class="btn btn-outline-success" type="button" id="button-addon2">Buscar</button>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control"  placeholder="Descripción">
                                        </div>

                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary">Agregar</button>
                                        </div>
                                    </form>  
                                </div>
                                <div class="col col-sm-7">
                                    <h5 class="">Categorias</h5>
                                    <hr>
                                    <div class="table-responsive">
                                        <table class="table align-middle">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Cetegoría</th>
                                                    <th scope="col">Descripción</th>
                                                    <th scope="col">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <tr>
                                                    <td>1</td>
                                                    <td>Calientes</td>
                                                    <td>Calientes</td>
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
                </div>
            </main>
            <%@include file="footer.jsp" %>
        </div>

    </body>

</html>

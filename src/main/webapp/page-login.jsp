<%-- 
    Document   : page-login
    Created on : 17 abr. 2023, 22:33:56
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <div class="container login">

            <div class="col-sm-6 col-md-12">
                <div class="card border-info text-center">
                    <div class="card-header">Sistema de Ventas </div>
                    <div class="card-body">
                        <form (novalidate class="form-signin mt-3">
                            <img src="images/123282.png" alt="" class="figure-img img-fluid rounded" style="width: 150px">
                            <input formControlName="username" type="text" class="form-control mb-2"
                                   placeholder="username" name="username" autofocus>
                            <input  formControlName="password" type="password" class="form-control mb-2"
                                   placeholder="password" name="password">
                            <div class="form-group">
                                <a href="HomeController?menu=principal" class="btn btn-primary btn-block" type="submit">
                                    Login <i class="fa fa-sign-in" aria-hidden="true"></i>
                                </a>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>

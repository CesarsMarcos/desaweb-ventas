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
        <div class="container">
            <div class="card border-info text-center login">
                <div class="card-header"></div>
                <div class="card-body">
                    <img src="#" class="logo-brand" alt="logo" width="" />
                    <h4 class="text-center"></h4>
                    <form id="login-form" class="form-signin" action="#" method="POST">
                        <div class="form-group">
                            <label class="sr-only" for="itUsuario">Username</label>
                            <div class="input-group mb-2">
                                <input type="text" name="usuario" class="form-control has-error" id="usuario" placeholder="Username">
                            </div>
                            <span class="help-block" id="error"></span>
                        </div>
                        <div class="form-group">
                            <div class="input-group mb-2">
                                <input type="password" name="clave" class="form-control" id="clave" placeholder="Password">
                            </div>
                            <span class="help-block" id="error"></span>
                        </div>
                        <button type="submit" name="submit" class="btn btn-block btn-outline btn-primary" id="btnLogin">
                            Ingresar <i class="fa fa-sign-in"></i>
                        </button>
                        <a class="btn btn-block btn-outline btn-primary" href="#">
                            <i class="ion ion-md-arrow-round-back"></i> Regresar al inicio</a>
                    </form>
                </div>
                <div class="footer my-2">Copyright &copy; 2023 &mdash; </div>
            </div>
        </div>
    </body>
</html>

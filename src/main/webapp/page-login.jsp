<%-- 
    Document   : page-login
    Created on : 17 abr. 2023, 22:33:56
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <div class="container login">
            <div class="col-sm-6 col-md-12">
                <div class="card border-info text-center">
                    <div class="card-header">Sistema de Ventas </div>
                    <div class="card-body">
                        <form action="login" method="post">
                            <img src="${pageContext.request.contextPath}/images/123282.png" alt="" class="figure-img img-fluid rounded" style="width: 150px">
                            <input type="text" class="form-control mb-2"
                                   placeholder="username" name="username" autofocus>
                            <input   type="password" class="form-control mb-2"
                                     placeholder="password" name="password">
                            <div class="form-group">
                                <button  class="btn btn-primary btn-block" type="submit">Login</button>
                            </div>
                            <span style="color: red">${message}</span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

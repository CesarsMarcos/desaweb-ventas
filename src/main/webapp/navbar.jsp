<%-- 
    Document   : head
    Created on : 17 abr. 2023, 21:53:12
    Author     : Cesar
--%>


<%@page import="com.utp.sistema.ventas.model.Menu"%>
<%@page import="java.util.List"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-blue">
    <div class="container-fluid">
        <a class="navbar-brand" href="home?menu=principal">SV</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">


                <%
                    List<Menu> menus = (List) request.getSession().getAttribute("menu");
                    if (menus != null) {
                        for (Menu m : menus) {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/pages<%= m.getRuta()%>?accion=listar"><%= m.getMenu()%></a>
                </li>

                <%
                        }
                    }%>
                <!-- 
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/articulo?accion=listar">Articulos</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/categoria?accion=listar">Categorías</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/usuario?accion=listar">Usuarios</a>
               </li> 
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/rol?accion=listar">Roles</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/cliente?accion=listar">Clientes</a>
               </li>
               <li class="nav-item">
                   <a class="nav-link" href="${pageContext.request.contextPath}/pages/venta">Ventas</a>
               </li>
                -->

            </ul>
            <form class="d-flex" role="search">

                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%= session.getAttribute("username")%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar sessión</a></li>

                        </ul>
                    </li>
                </ul>     

            </form>
        </div>

    </div>
</nav>

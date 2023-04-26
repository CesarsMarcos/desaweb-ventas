<%-- 
    Document   : head
    Created on : 17 abr. 2023, 21:53:12
    Author     : Cesar
--%>


<nav class="navbar navbar-expand-lg bg-body-tertiary bg-blue">
    <div class="container-fluid">
        <a class="navbar-brand" href="HomeController?menu=principal">SV</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="ArticuloController?accion=listar">Articulos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="CategoriaController?accion=listar">Categoría</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="UsuarioController?accion=listar">Usuarios</a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link" href="RolController?accion=listar">Roles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ClienteController?accion=listar">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="VentaController?accion=listar">Ventas</a>
                </li>

            </ul>
            <form class="d-flex" role="search">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Perfil
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Perfil</a></li>
                            <li><a class="dropdown-item" href="page-login.jsp">Cerrar sessión</a></li>

                        </ul>
                    </li>
                </ul>
            </form>
        </div>

    </div>
</nav>

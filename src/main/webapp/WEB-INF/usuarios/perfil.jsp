<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Perfil - Animal adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">

    </head>
    <body>
        <!-- Barra de navegación superior -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main class="row">
            <!--Seccion Principal-->
            <section class="col-md-12 col-sm-12 col-xs-12">
                <article class="col-md-offset-2 col-md-4 col-sm-6 col-xs-12">
                    <div class="thumbnail zoom">
                        <img class="img-responsive photo-animal" src="<c:url value='/img/usuarios/${usuarios.dni}.png'/>" alt="Foto de ${usuarios.nombre}"/>
                        <footer class="color">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4 class="centered">${usuarios.nombre} ${usuarios.apellidos}</h4>
                                    <p class="centered">
                                        <a href="<c:url value='#'/>">
                                            <i class="rrss fa fa-facebook fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="<c:url value='#'/>">
                                            <i class="rrss fa fa-twitter fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="<c:url value='#'/>">
                                            <i class="rrss fa fa-linkedin fa-3x" aria-hidden="true"></i>
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </footer>
                        <nav aria-label="...">
                            <ul class="pager">
                                <li><a href='<c:url value='/usuarios/editar'/>'>Editar información</a></li>
                            </ul>
                        </nav>
                    </div>
                </article>
            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

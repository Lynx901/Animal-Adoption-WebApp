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
                <div class="row">
                    <div class="col-md-offset-1 col-md-4 col-sm-6 col-xs-12">
                        <img class="img-responsive photo-animal" src="<c:url value='/img/usuarios/${usuario.dni}.png'/>" alt="Foto de ${usuario.nombre}"/>
                    </div>

                    <div class="col-md-7 color">
                        <h4 class="centered">${usuario.nombre} ${usuario.apellidos}</h4>
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

                        <c:if test="${empty mascotas}">
                            <p class="centered">NO TIENE NINGUNA MASCOTA</p>
                        </c:if>
                        <c:if test="${not empty mascotas}">
                            <section class="col-md-12 col-sm-12 col-xs-12">
                                <h4 class="centered">Mascotas disponibles</h4>
                                <div class="row">
                                    <c:forEach var="m" items="${mascotas}">
                                        <c:set var="qry" value="?id=${m.id}"/>
                                        <article class="col-md-4 col-sm-6 col-xs-12">
                                            <div class="thumbnail zoom">
                                                <a href="<c:url value='/inicio/animales/ficha${qry}'/>">
                                                    <c:catch var="e">
                                                        <img class="img-responsive photo-animal" src="<c:url value='/img/animales/${m.id}.png'/>" alt="Foto del animal"/>
                                                    </c:catch>
                                                    <c:if test="${!empty e}">
                                                        <img class="img-responsive photo-animal" src="<c:url value='/img/${a.raza}-placeholder.jpg'/>" alt="Foto del animal"/>
                                                    </c:if>                                                    
                                                    <footer class="color">
                                                        <div class="row">
                                                            <img class="col-md-2 col-sm-1 col-xs-1 usr-ph img-circle" src="<c:url value='/img/usuarios/${m.duenio}.png'/>" alt="Foto de ${m.duenio}"/>
                                                            <div class="col-md-8">
                                                                <h4>${m.nombre}</h4>
                                                                <h5>${m.raza}, ${m.edad} años</h5>
                                                            </div>
                                                        </div>
                                                    </footer>
                                                </a>
                                            </div>
                                        </article>
                                    </c:forEach>
                                </div>

                            </section>
                        </c:if>

                        <a class="btn btn-primary btn-centered-total" href='<c:url value='/inicio/usuarios/editar'/>'>Editar información</a>
                    </div>

                </div>
            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

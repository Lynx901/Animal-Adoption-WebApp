
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Inicio - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    </head>
    <body>
        <!-- Barra de navegación superior -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main class="row">
            <!-- Panel de navegación lateral -->
            <%@include file="/WEB-INF/jspf/navigation.jspf" %>
            <c:if test="${empty animales}">
                NO HAY ANIMALES DISPONIBLES
            </c:if>
            <c:if test="${not empty animales}">
                <section class="col-md-10 col-sm-10 col-xs-12">

                    <div class="row">
                        <c:forEach var="a" items="${animales}">
                            <article class="col-md-4 col-sm-6 col-xs-12">
                                <div class="thumbnail zoom">
                                    <a href="<c:url value='/ficha.jsp?nombre=${a.nombre}&especie=${a.especie}&raza=${a.raza}&edad=${a.edad}&sexo=${a.sexo}'/>">
                                        <img class="img-responsive photo-animal" src="<c:url value='/img/${a.especie}-placeholder.jpg'/>" alt="Foto del animal"/>
                                        <footer class="color">
                                            <div class="row">
                                                <img class="col-md-2 col-sm-1 col-xs-1 usr-ph img-circle" src="<c:url value='/img/usuarios/${a.duenio}.png'/>" alt="Foto de ${a.duenio}"/>
                                                <div class="col-md-9">
                                                    <h4>${a.nombre}</h4>
                                                    <p>XX Km</p>
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
            <nav aria-label="...">
                <ul class="pager">
                    <li><a href='<c:url value='/animales/crear'/>'>Añadir un animal nuevo</a></li>
                </ul>
            </nav>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>



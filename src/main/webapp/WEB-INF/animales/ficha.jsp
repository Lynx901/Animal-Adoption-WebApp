<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Ficha - Animal adoption</title>
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
            <section class="col-md-10">
                <div class="col-md-5 thumbnail">
                    <c:catch var="e">
                        <img class="img-responsive photo-animal" src="<c:url value='/img/animales/${animal.id}.png'/>" alt="Foto del animal"/>
                    </c:catch>
                    <c:if test="${!empty e}">
                        <img class="img-responsive photo-animal" src="<c:url value='/img/${animal.raza}-placeholder.jpg'/>" alt="Foto del animal"/>
                    </c:if>                
                </div>
                <aside class="col-md-offset-1 col-md-6 color">
                    <h2>${param.nombre}</h2>
                    <div class="row">
                        <img class="col-md-2 usr-ph img-circle" src="<c:url value='/img/usuarios/${animal.duenio}.png'/>" alt="Foto del usuario"/>
                        <div class="col-md-9">
                            <h4>${animal.nombre}</h4>
                            <p>XX Km</p>
                        </div>
                    </div>
                    <div class="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d6030.418742494061!2d-111.34563870463673!3d26.01036670629853!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses-419!2smx!4v1471908546569" width="600" height="200" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
                    <h4>Información del animal</h4>
                    <div class="row">
                        <div class="col-sm-6 col-md-offset-3 col-md-3">
                            <p>Raza: </p>
                        </div>
                        <div class="col-sm-6 col-md-offset-1 col-md-3">
                            <p>${animal.raza} (<a href="<c:url value='/inicio/animales/listado?raza=${animal.raza}'/>">+</a>)</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-md-offset-3 col-md-3">
                            <p>Edad: </p>
                        </div>
                        <div class="col-sm-6 col-md-offset-1 col-md-3">
                            <p>${animal.edad} años</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-md-offset-3 col-md-3">
                            <p>Estado de salud: </p>
                        </div>
                        <div class="col-sm-6 col-md-offset-1 col-md-3">
                            <p>${animal.estado} </p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-md-offset-3 col-md-3">
                            <p>Sexo: </p>
                        </div>
                        <div class="col-sm-6 col-md-offset-1 col-md-3">
                            <p><c:if test="${animal.sexo}"> Macho </c:if> 
                                <c:if test="${not animal.sexo}"> Hembra </c:if> 
                                </p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-offset-3 col-md-3">
                                <p>Vacunas y Chip: </p>
                            </div>
                            <div class="col-sm-6 col-md-offset-1 col-md-4">
                                <p><c:if test="${animal.chip}">Tiene chip</c:if> </p>
                            <p><c:if test="${animal.vacunas}">Tiene las vacunas</c:if> </p>
                            </div>
                        </div> 

                        <p>${animal.descripcion}</p>

                </aside>
            </section>
        </main>
        <aside class="row botones">

            <c:if test="${usuario.dni eq animal.duenio}">
                <a class="btn btn-primary btn-centered" href='<c:url value='/inicio/animales/editar?id=${animal.id}'/>'>Editar</a>
                <a class="btn btn-danger btn-centered" onclick="alert('Se ha eliminado correctamente')" href='<c:url value='/inicio/animales/borrar?id=${animal.id}'/>'>Eliminar</a> 
            </c:if>
        </aside>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

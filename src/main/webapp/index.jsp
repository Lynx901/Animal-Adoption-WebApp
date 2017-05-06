<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/select.css'/>">

    </head>
    <body>
        <!-- Cabecera -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <div class="row">
            <h1> Selecciona el método de acceso a la aplicación web </h1>
            <br>
            <section class="col-md-offset-1 col-sm-offset-1 col-md-5 col-sm-5 servlet zoom">
                <a href="<c:url value='/animales'/>"><h2>Servlet</h2></a>
            </section>
            <section class="col-md-5 col-sm-5 spring zoom">
                <a href="<c:url value='/inicio/animales/listado'/>"><h2>Spring MVC</h2></a>
            </section>
        </div>
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
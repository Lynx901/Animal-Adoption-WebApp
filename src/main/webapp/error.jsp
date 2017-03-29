<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
    </head>
    <body>
        <!-- Barra de navegación superior -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>
            <img src="<c:url value='/img/404.png'/>"> alt="Error 404. Página no encontrada." class="img-responsive center-block" />
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
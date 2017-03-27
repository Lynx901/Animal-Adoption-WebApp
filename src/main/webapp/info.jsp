<%@page contentType="text/html" pageEncoding ="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¿Quiénes Somos? - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
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
                        <img class="img-responsive photo-animal" src="img/dani.jpg" alt="Foto de Daniel Moya Leiva"/>
                        <footer class="color">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4 class="centered">Daniel Moya Leiva</h4>
                                    <p class="centered">
                                        <a href="#">
                                            <i class="rrss fa fa-facebook fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="#">
                                            <i class="rrss fa fa-twitter fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="#">
                                            <i class="rrss fa fa-linkedin fa-3x" aria-hidden="true"></i>
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </footer>
                    </div>
                </article>
                <article class="col-md-4 col-sm-6 col-xs-12">
                    <div class="thumbnail zoom">
                        <img class="img-responsive photo-animal" src="img/juanfra.jpg" alt="Foto de Juan Francisco Abán Fontecha"/>
                        <footer class="color">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4 class="centered">Juan Francisco Abán Fontecha</h4>
                                    <p class="centered">
                                        <a href="#">
                                            <i class="rrss fa fa-facebook fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="#">
                                            <i class="rrss fa fa-twitter fa-3x" aria-hidden="true"></i>
                                        </a>
                                        <a href="#">
                                            <i class="rrss fa fa-linkedin fa-3x" aria-hidden="true"></i>
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </footer>
                    </div>
                </article>
            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

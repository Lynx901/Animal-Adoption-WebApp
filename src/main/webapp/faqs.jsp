<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preguntas Frecuentes - Animal Adoption</title>
        <!-- Bootstrap Links -->
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/faqs.css'/>">
    </head>
    <body>
        <!-- Barra de navegación superior -->
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main class="row">
            <!--Seccion Principal-->
            <section class="col-md-10 col-sm-10 col-xs-12 faq-section">
                <h1>Preguntas Frecuentes - FAQS </h1>
                
                <button class="accordion">¿Cuantos animales puedo adoptar? </button>
                <div class="panel">
                    <p>Dado que necesitamos garantizar el bienestar de los animales,
                        existe un máximo de 4 animales por usuario, aunque se comprobará
                        si existe relación entre usuarios para evitar que se adopten 
                        demasiados animales por una misma familia</p>
                </div>

                <button class="accordion">¿Necesito estar registrado para adoptar?</button>
                <div class="panel">
                    <p>Sin duda es un requisito imprescindible ya que hacemos un 
                        seguimiento de los animales para que estén bien cuidados</p>
                </div>

                <button class="accordion">¿Puedo dar en adopción a mis animales?</button>
                <div class="panel">
                    <p>Si los animales pueden ser donados por usuarios particulares 
                        a los centros de adopción, siempre que tengan espacio para ello</p>
                </div>
            </section>
        </main>
        <script>
            var acc = document.getElementsByClassName("accordion");
            var i;

            for (i = 0; i < acc.length; i++) {
                acc[i].onclick = function () {
                    this.classList.toggle("active");
                    var panel = this.nextElementSibling;
                    if (panel.style.display === "block") {
                        panel.style.display = "none";
                    } else {
                        panel.style.display = "block";
                    }
                }
            }
        </script>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>

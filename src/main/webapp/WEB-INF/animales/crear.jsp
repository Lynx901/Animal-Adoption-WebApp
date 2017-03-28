
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Alta Animales - Animal Adoption</title>
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
            <section class="col-md-offset-1 col-md-5">
                <h2>Dar de alta a un animal</h2>
                <form method="POST">
                    <label >Especie: <input name="especie" value="${animales.especie}" class='form-control'></label>
                    <span class='label label-warning'>${errEspecie}</span><br/>
                    <label >Nombre: <input name="nombre" value="${animales.nombre}" class='form-control'></label><br/>
                    <label>Estado:<input name="estado" value="${animales.estado}" class='form-control'></label>
                    <span class='label label-warning'>${errEstado}</span><br/>
                    <label>Edad:<input name="edad" value="${animales.edad}" class='form-control'></label>
                    <span class='label label-warning'>${errEdad}</span><br/>
                    <label>Sexo:<input name="sexo" value="${animales.sexo}" class='form-control'></label>
                    <span class='label label-warning'>${errSexo}</span><br/>
                    <label >Chip:<input name="socio" type="checkbox" value="1" ${animales.chip?"checked":""} class='form-control'></label><br>
                    <label >Vacuna:<input name="socio" type="checkbox" value="1" ${animales.vacunas?"checked":""} class='form-control'></label><br>
                    <label >DNI del Dueño: <input name="dnidueno" value="${animales.dnidueno}" class='form-control'></label><br/>
                    <input name="enviar" type="submit" value='Enviar' class='btn btn-primary'>
                    <input name="enviar" type="reset" value='Restaurar' class='btn btn-default'>
                </form> 
            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>



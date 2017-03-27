<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Contacto - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/register.css'/>">
    </head>
    <body>
        <!-- Cabecera minimizada -->
        <%@include file="WEB-INF/jspf/header_min.jspf" %>
        <section class="main-login main-center">
            <c:if test="${not empty param.Enviar}">
                <p> Gracias. Su consulta queda almacenada y será tramitada lo antes posible </p>
            </c:if>
            <c:if test="${empty param.Enviar}">

                <form class="form-horizontal" method="post" action=mailto:info@animaladoption.com>

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Nombre</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Introduzca su nombre" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Motivo" class="col-sm-2 control-label">Motivo</label>
                        <div class="col-sm-10">
                            <select name="Motivo" class="form-control">
                                <option value="Consulta General">Consulta</option>
                                <option value="Informe un problema">Informar de un problema</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="email" class="form-control" name="email" id="email"  placeholder="Introduzca su Email" required />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mensaje" class="col-sm-2 control-label">Mensaje</label>
                        <div class="col-sm-10">
                            <div class="input-group">
                                <textarea rows="5" cols="100" class="form-control" id="Mensaje" name="Mensaje" placeholder="Introduzca su mensaje" required ></textarea>
                            </div>
                        </div>
                    </div>


                    <div class="form-group ">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Enviar">Contacto</button>
                    </div>
                    <div class="login-register">
                        <a href="<c:url value='/animales'/>">Inicio</a>
                    </div>
                </form>
            </c:if>

        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
    </body>
</html>
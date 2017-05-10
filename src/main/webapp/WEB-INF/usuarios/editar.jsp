<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/register.css'/>">
    </head>
    <body>
        <!-- Cabecera minimizada -->
        <%@include file="/WEB-INF/jspf/header_min.jspf" %>
        <section class="main-login main-center">
            <form:form id="formUsuarios" class="form-horizontal" method="POST" modelAttribute="usuario" name="editUsuarios" validate="true">

                <div class="form-group">
                    <form:label path="dni" class="col-sm-4 control-label">DNI</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="dni" name="dni" id="dni"/>
                                <p id="errDNI" class="text-danger" hidden >
                                    El DNI debe ser de la forma 12345678 (sin letra).
                                </p>
                                <form:errors cssClass="error" path="dni"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="nombre" class="col-sm-4 control-label">Nombre</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="nombre" name="nombre" id="nombre"/>
                                <p id="errNombre" class="text-danger" hidden >
                                    El nombre tiene que tener más de 2 letras.
                                </p>
                                <form:errors cssClass="error" path="nombre"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="apellidos" class="col-sm-4 control-label">Apellidos</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="apellidos" name="apellidos" id="apellidos"/>
                                <p id="errApellidos" class="text-danger" hidden >
                                    Al menos pon un apellido (con algunas letras).
                                </p>
                                <form:errors cssClass="error" path="apellidos"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="direccion" class="col-sm-4 control-label">Dirección</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="direccion" name="direccion" id="direccion"/>
                                <p id="errDireccion" class="text-danger" hidden >
                                    Debe ser una dirección válida.
                                </p>
                                <form:errors cssClass="error" path="direccion"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="email" class="col-sm-4 control-label">Email</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="email" name="email" id="email"/>
                                <p id="errEmail" class="text-danger" hidden >
                                    Debe ser un email válido.
                                </p>
                                <form:errors cssClass="error" path="email"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <input type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Registrarse">
                    <div id="mensaje"></div>
                </div>
            </form:form>
        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
        <script src="<c:url value='/js/animalesController.js'/>"></script>
    </body>
</html>

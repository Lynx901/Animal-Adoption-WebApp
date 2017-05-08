<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Registro - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/register.css'/>">
    </head>
    <body>
        <!-- Cabecera minimizada -->
        <%@include file="/WEB-INF/jspf/header_min.jspf" %>
        <section class="main-login main-center">
            <c:if test="${empty param.Enviar}">
                <form:form class="form-horizontal" method="POST" modelAttribute="usuario">

                    <div class="form-group">
                        <form:label path="dni" class="col-sm-4 control-label">DNI</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="dni" />
                                <form:errors cssClass="error" path="dni"/><br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="nombre" class="col-sm-4 control-label">Nombre</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="nombre"/>
                                <form:errors cssClass="error" path="nombre"/><br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="apellidos" class="col-sm-4 control-label">Apellidos</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="apellidos"/>
                                <form:errors cssClass="error" path="apellidos"/><br>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="direccion" class="col-sm-4 control-label">Dirección</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="direccion"/>
                                <form:errors cssClass="error" path="direccion"/><br>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="email" class="col-sm-4 control-label">Email</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="email"/>
                                <form:errors cssClass="error" path="email"/><br>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="usuario" class="col-sm-4 control-label">Usuario</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="usuario"/>
                                <form:errors cssClass="error" path="usuario"/><br>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="pass" class="col-sm-4 control-label">Contraseña</form:label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <form:input class="form-control" path="pass"/>
                                <form:errors cssClass="error" path="pass"/><br>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <input type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Registrarse" >
                    </div>
                    <div class="login-register">
                        <a href="<c:url value='/login.jsp'/>">Iniciar sesión</a>
                    </div>
                </form:form>
        </c:if>
        <c:if test="${not empty param.Enviar}">
             <p> Gracias ${param.name} en breves recibira un correo electronico a ${param.email} para confirmar su registro </p>
                <div class="login-register">
                    <a href="<c:url value='/animales'/>">Inicio</a>
                </div>
        </c:if>
        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
    </body>
</html>

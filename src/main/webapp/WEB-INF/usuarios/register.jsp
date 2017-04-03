<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <c:if test="${not empty param.Enviar}">
                <p> Gracias ${param.name} en breves recibira un correo electronico a ${param.email} para confirmar su registro </p>
                <div class="login-register">
                    <a href="<c:url value='/animales'/>">Inicio</a>
                </div>
            </c:if>
            <c:if test="${empty param.Enviar}">
                <form class="form-horizontal" method="POST">

                    <div class="form-group">
                        <label for="dni" class="col-sm-4 control-label">DNI</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="dni" id="dni"  placeholder="Ingrese su DNI" required/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre" class="col-sm-4 control-label">Nombre</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="nombre" id="nombre"  placeholder="Ingrese su nombre" required/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="apellidos" class="col-sm-4 control-label">Apellidos</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="apellidos" id="apellidos"  placeholder="Ingrese sus apellidos" required/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="direccion" class="col-sm-4 control-label">Dirección</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="direccion" id="direccion"  placeholder="Ingrese dónde vive" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-4 control-label">Email</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="email" class="form-control" name="email" id="email"  placeholder="Ingrese su Email" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="usuario" class="col-sm-4 control-label">Usuario</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="usuario" id="usuario"  placeholder="Ingrese su nombre de Usuario" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pass" class="col-sm-4 control-label">Contraseña</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="pass" id="pass"  placeholder="Ingrese su contraseña" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm" class="col-sm-4 control-label">Confirmar Contraseña</label>
                        <div class="col-sm-8">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirme su contraseña" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Enviar" >Registrarse</button>
                    </div>
                    <div class="login-register">
                        <a href="<c:url value='/usuarios/login'/>">Iniciar sesión</a>
                    </div>
                </form>
            </c:if>
        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
    </body>
</html>

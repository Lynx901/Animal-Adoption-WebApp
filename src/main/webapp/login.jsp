<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Animal Adoption</title>
        <!-- Enlaces a Bootstrap -->
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>
        <!-- Website CSS style -->
        <link rel="stylesheet" href="<c:url value='/css/register.css'/>">

    </head>
    <body>
        <!-- Cabecera minimizada -->
        <%@include file="/WEB-INF/jspf/header_min.jspf" %>
        <section class="main-login main-center">

            <form class="form-horizontal" action="j_security_check" method="post">

                <div class="form-group">
                    <label for="j_username" class="col-sm-4 control-label">Usuario</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="j_username" id="j_username"  placeholder="Ingrese su Email" required />
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label for="j_password" class="col-sm-4 control-label">Contraseña</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="j_password" id="j_password"  placeholder="Ingrese su contraseña" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Enviar">Iniciar sesión</button>
                </div>
                <div class="login-register">
                    <a href="<c:url value='/usuarios/registro'/>">Registrarse</a>
                </div>
            </form>

        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
    </body>
</html>

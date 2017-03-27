<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Animal Adoption</title>
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
                <c:redirect url="animales?usuario=${param.email}"/>
            </c:if>
            <c:if test="${empty param.Enviar}">

            <form class="form-horizontal" method="post">

                <div class="form-group">
                    <label for="email" class="col-sm-4 control-label">Email</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <input type="email" class="form-control" name="email" id="email"  placeholder="Ingrese su Email" required />
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Contraseña</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <input type="password" class="form-control" name="password" id="password"  placeholder="Ingrese su contraseña" required/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="Enviar" value="Enviar">Iniciar sesión</button>
                </div>
                <div class="login-register">
                    <a href="register.jsp">Registrarse</a>
                </div>
            </form>
            </c:if>

        </section>
        <!-- Pie de página minimizado -->
        <%@include file="/WEB-INF/jspf/footer_min.jspf" %>
    </body>
</html>


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
            <section class="col-md-offset-1 col-sm-offset-1 col-md-7 col-sm-7">

                <form method="POST" class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Dar de alta a un animal</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nombre">Nombre</label>  
                            <div class="col-md-6">
                                <input id="nombre" name="nombre" type="text" placeholder="Toby, Garfield, etc." class="form-control input-md" required="">
                                <span class="help-block">Debe ser el nombre real del animal</span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="edad">Edad</label>  
                            <div class="col-md-6">
                                <input id="edad" name="edad" type="text" placeholder="3, 4, 5..." class="form-control input-md" required="">
                                <span class="help-block">Debe ser un número mayor que 0</span>  
                            </div>
                        </div>
                        
                         <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="sexo">Sexo</label>
                            <div class="col-md-4"> 
                                <label class="radio-inline" for="sexo-0">
                                    <input type="radio" name="sexo" id="sexo-0" value="true" checked="checked">
                                    Macho
                                </label> 
                                <label class="radio-inline" for="sexo-1">
                                    <input type="radio" name="sexo" id="sexo-1" value="false">
                                    Hembra
                                </label>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="especie">Especie</label>
                            <div class="col-md-6">
                                <select id="especie" name="especie" class="form-control">
                                    <option value="perro">perro</option>
                                    <option value="gato">gato</option>
                                </select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="raza">Raza</label>
                            <div class="col-md-6">
                                <select id="raza" name="raza" class="form-control">
                                    <option value="Siamés">Siamés</option>
                                    <option value="Persa">Persa</option>
                                    <option value="Bengala">Bengala</option>
                                    <option value="Mestizo">Mestizo</option>
                                    <option value="Husky">Husky</option>
                                    <option value="Labrador">Labrador</option>
                                    <option value="Pastor Alemán">Pastor Alemán</option>
                                </select>
                            </div>
                        </div>
                        
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="estado">Estado de salud</label>  
                            <div class="col-md-6">
                                <input id="estado" name="estado" type="text" placeholder="Perfecto" class="form-control input-md" required="">
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="chip">¿Tiene chip?</label>
                            <div class="col-md-4"> 
                                <label class="radio-inline" for="chip-0">
                                    <input type="radio" name="chip" id="chip-0" value="true" checked="checked">
                                    Sí
                                </label> 
                                <label class="radio-inline" for="chip-1">
                                    <input type="radio" name="chip" id="chip-1" value="false">
                                    No
                                </label>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="vacunas">¿Está vacunado?</label>
                            <div class="col-md-4"> 
                                <label class="radio-inline" for="vacunas-0">
                                    <input type="radio" name="vacunas" id="vacunas-0" value="true" checked="checked">
                                    Sí
                                </label> 
                                <label class="radio-inline" for="vacunas-1">
                                    <input type="radio" name="vacunas" id="vacunas-1" value="false">
                                    No
                                </label>
                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="description">¡Cuéntanos algo de él!</label>
                            <div class="col-md-4">                     
                                <textarea class="form-control col-md-6" id="description" name="description">Es muy activo, le gusta...</textarea>
                            </div>
                        </div>
                        <div class="form-group ">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="enviar" value="Enviar" >Enviar datos</button>
                        </div>
                    </fieldset>
                </form>

            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>



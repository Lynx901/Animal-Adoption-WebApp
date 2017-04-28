<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

                <form:form method="POST" class="form-horizontal" modelAtribute="animal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Dar de alta a un animal</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="nombre">Nombre</form:label>  
                            <div class="col-md-6">
                                <form:input path="nombre" class="form-control input-md"/>
                                <span class="help-block">Debe ser el nombre real del animal</span> 
                                <form:errors cssClass="error" path="nombre"/><br>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="edad">Edad</form:label>  
                            <div class="col-md-6">
                                <form:input path="edad" class="form-control input-md"/>
                                <span class="help-block">Debe ser un número mayor que 0</span> 
                                <form:errors cssClass="error" path="edad"/><br>
                            </div>
                        </div>
                        
                         <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="sexo">Sexo</form:label>
                            <div class="col-md-4"> 
                                <form:label class="radio-inline" path="sexo-0">
                                    <form:input path="sexo" type="radio" name="sexo" id="sexo-0" value="true" checked="checked" />
                                    Macho
                                </form:label> 
                                <form:label class="radio-inline" path="sexo-1">
                                    <form:input path="sexo" type="radio" name="sexo" id="sexo-1" value="false" />
                                    Hembra
                                </form:label>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="especie">Especie</form:label>
                            <div class="col-md-6">
                                <form:select path="especie" id="especie" name="especie" class="form-control">
                                    <form:option value="perro">perro</form:option>
                                    <form:option value="gato">gato</form:option>
                                </form:select>
                            </div>
                        </div>

                        <!-- Select Basic -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="raza">Raza</form:label>
                            <div class="col-md-6">
                                <form:select path="raza" id="raza" name="raza" class="form-control">
                                    <form:option value="siamés">Siamés</form:option>
                                    <form:option value="persa">Persa</form:option>
                                    <form:option value="bengala">Bengala</form:option>
                                    <form:option value="mestizo">Mestizo</form:option>
                                    <form:option value="husky">Husky</form:option>
                                    <form:option value="labrador">Labrador</form:option>
                                    <form:option value="pastorAlemán">Pastor Alemán</form:option>
                                </form:select>
                            </div>
                        </div>
                        
                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="estado">Estado de salud</form:label>  
                            <div class="col-md-6">
                                <form:input path="estado" id="estado" name="estado" type="text" placeholder="Perfecto" class="form-control input-md" required="">
                                <form:errors cssClass="error" path="estado"/><br>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="chip">¿Tiene chip?</form:label>
                            <div class="col-md-4"> 
                                <form:label class="radio-inline" path="chip-0">
                                    <form:input path="chip-0" type="radio" name="chip" id="chip-0" value="true" checked="checked">
                                    Sí
                                </form:label> 
                                <form:label class="radio-inline" path="chip-1">
                                    <form:input path="chip-1" type="radio" name="chip" id="chip-1" value="false">
                                    No
                                </form:label>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="vacunas">¿Está vacunado?</label>
                            <div class="col-md-4"> 
                                <form:label class="radio-inline" path="vacunas-0">
                                    <form:input path="vacunas-0" type="radio" name="vacunas" id="vacunas-0" value="true" checked="checked">
                                    Sí
                                </form:label> 
                                <form:label class="radio-inline" path="vacunas-1">
                                    <form:input path="vacunas-1" type="radio" name="vacunas" id="vacunas-1" value="false">
                                    No
                                </form:label>
                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="description">¡Cuéntanos algo de él!</form:label>
                            <div class="col-md-4">                     
                                <form:textarea path="description" class="form-control col-md-6" id="description" name="description">Es muy activo, le gusta...</form:textarea>
                                <form:errors cssClass="error" path="description"/><br>
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" class="btn btn-primary btn-lg btn-block login-button" name="enviar" value="Enviar" >Enviar datos</form:button>
                        </div>
                    </fieldset>
                </form:form>

            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>



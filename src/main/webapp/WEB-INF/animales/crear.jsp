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
                <form:form id='formAnimales' method="POST" class="form-horizontal" modelAttribute="animal" enctype="multipart/form-data">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Dar de alta a un animal</legend>
                        
                        <!-- File upload-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Sube una foto de tu mascota</label> 
                            <div class="col-md-6">
                                <form:input name="multipartFile" path="multipartFile" type="file" />
                                <p id="errMultipartFile" class="text-danger" hidden >
                                    Debes subir una foto.
                                </p>
                                <form:errors path="multipartFile"/><br/>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="nombre">Nombre</form:label>  
                            <div class="col-md-6">
                                <form:input name="nombre" path="nombre" class="form-control input-md"/>
                                <span class="help-block">Debe ser el nombre real del animal</span> 
                                <p id="errNombre" class="text-danger" hidden >
                                    El nombre debe tener al menos 2 letras.
                                </p>
                                <form:errors cssClass="alert alert-danger" path="nombre"/>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="edad">Edad</form:label>  
                            <div class="col-md-6">
                                <form:input name="edad" path="edad" class="form-control input-md"/>
                                <p id="errEdad" class="text-danger" hidden >
                                    La edad debe ser mayor de 0 y menor de 100
                                </p>
                                <span class="help-block">Debe ser un número mayor que 0</span> 
                                
                            </div>
                        </div>
                        
                         <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 right-align" path="sexo">Sexo</form:label>
                            <div class="col-md-4"> 
                                <div class="row">
                                    <div class="col-md-6"> 
                                        <form:radiobutton path="sexo" value="true"/> Macho
                                    </div>
                                    <div class="col-md-6"> 
                                        <form:radiobutton path="sexo" value="false"/> Hembra
                                    </div>
                                </div>
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
                                    <form:option value="Siamés">Siamés</form:option>
                                    <form:option value="Persa">Persa</form:option>
                                    <form:option value="Bengala">Bengala</form:option>
                                    <form:option value="Mestizo">Mestizo</form:option>
                                    <form:option value="Husky">Husky</form:option>
                                    <form:option value="Labrador">Labrador</form:option>
                                    <form:option value="Pastor Alemán">Pastor Alemán</form:option>
                                </form:select>
                            </div>
                        </div>
                        
                        <!-- Text input-->
                        <div class="form-group">
                            <form:label class="col-md-4 control-label" path="estado">Estado de salud</form:label>  
                            <div class="col-md-6">
                                <form:input path="estado" id="estado" name="estado" type="text" placeholder="Perfecto" class="form-control input-md" required="" />
                                <span class="help-block">Describe en qué estado se encuentra el animal</span> 
                                <p id="errEstado" class="text-danger" hidden >
                                    El estado no puede estar vacío, Pon algo como "genial", "pachucho", "sano"...
                                </p>
                                <form:errors cssClass="alert alert-danger" path="estado"/>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 right-align" path="chip">¿Tiene chip?</form:label>
                            <div class="col-md-4"> 
                                <div class="row">
                                    <div class="col-md-4"> 
                                        <form:radiobutton path="chip" value="true"/> Sí
                                    </div>
                                    <div class="col-md-4"> 
                                        <form:radiobutton path="chip" value="false"/> No
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <form:label class="col-md-4 right-align" path="vacunas">¿Está vacunado?</form:label>
                            <div class="col-md-4"> 
                                <div class="row">
                                    <div class="col-md-4"> 
                                        <form:radiobutton path="vacunas" value="true"/> Sí
                                    </div>
                                    <div class="col-md-4"> 
                                        <form:radiobutton path="vacunas" value="false"/> No
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Textarea -->
                        <div class="form-group">
                            <form:label class="col-md-4  right-align" path="descripcion">¡Cuéntanos algo de él!</form:label>
                            <div class="col-md-4"> 
                                <form:textarea name="descripcion" path="descripcion" rows="5" cols="30" />
                                <p id="errDescripcion" class="text-danger" hidden >
                                    Tienes que decirnos algo sobre tu mascota.
                                </p>
                                <form:errors cssClass="alert alert-danger" path="descripcion"/><br>
                            </div>
                        </div>
                        <div class="form-group ">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button" name="enviar" value="Enviar" >Enviar datos</button>
                        </div>
                    </fieldset>
                </form:form>

            </section>
        </main>
        <!-- Pie de página general -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
        <script src="<c:url value='/js/animalesController.js'/>"></script>
    </body>
</html>



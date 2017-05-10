/*jslint browser: true*/
/*global $, jQuery*/

$(function () {
    UsuarioSpringController.init​();
});

$(function () {
    //Configure events on page load
    clienteCtrl.init(viewModel);
});
        var UsuarioSpringController ​= {
        config​:{
        lista: "#listaUsuarios",
                formulario: "form [name=registroUsuarios]",
                ibNombre: "[name=dni]"
        },
                init: function() {
                var self = this;
                        $(this.config​.lista).hide();
                        $(this.config​.formulario).on('submit', function(event){
                self.validarDatos(event);
                });
                        $(this.config​.ibNombre).focus();
                },
                validarDatos: function(event){
                //use this for access UsuarioSpringController
                var valido = true;
                        var dni = document.getElementById("dni").value;
                        var nombre = document.getElementById("nombre").value;
                        var email = document.getElementById("email").value;
                        var usuario = document.getElementById("usuario").value;
                        var contrasena = document.getElementById("contrasena").value;
                        if (dni == null){
                alert("Tiene que escribir su dni");
                        valido = false;
                }

                if (nombre == null){
                alert("Tiene que escribir su nombre");
                        valido = false;
                }

                if (email == null){
                alert("Tiene que escribir su correo electronico");
                        valido = false;
                }

                if (usuario == null){
                alert("Tiene que escribir su usuario");
                        valido = false;
                }

                if (contrasena == null){
                alert("Tiene que escribir su contrasena");
                        valido = false;
                }

                return valido;
                },
                funcionalidad2:function(){

                },
        }
}



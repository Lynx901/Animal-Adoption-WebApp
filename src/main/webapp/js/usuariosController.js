/*jslint browser: true*/
/*global $, jQuery*/


$(function () {
    usuariosCtrl.init(viewModel);
});

var viewModel = {
    usuario: {}
};

//Clientes Controller
var usuariosCtrl = {
    config: {
        frmEdit: '#formUsuarios'
    },
    model: {},
    init: function (model) {
        this.model = model;

        var self = this;
        
        $(this.config.frmEdit).submit(function () {
            self.formSubmit();
        });
        
        $(this.config.frmEdit).submit(function (event) {
            if (self.validarDatos(event) === false) {
                event.preventDefault();  //stop submit 
            } else {
                alert("Enhorabuena, te has registrado correctamente");
            }
        });
    },
   
    validarDatos: function () {
        //Form Client-side validation
        //Shows validation errors next to form fields
        var result = true;
        
        usuario = this.formSubmit();
        
        if(usuario.dni < 10000000 || usuario.dni > 99999999) {
            $('#errDNI').show();
            result = false;
        } else {
            $('#errDNI').hide();
        }
        
        if(usuario.nombre.length < 2 || usuario.nombre.length > 50) {
            $('#errNombre').show();
            result = false;
        } else {
            $('#errNombre').hide();
        }
        
        if(usuario.apellidos.length < 2 || usuario.apellidos.length > 50) {
            $('#errApellidos').show();
            result = false;
        } else {
            $('#errApellidos').hide();
        }
        
        if(usuario.direccion.length < 2 || usuario.direccion.length > 50) {
            $('#errDireccion').show();
            result = false;
        } else {
            $('#errDireccion').hide();
        }
        
        if(usuario.email.length < 2 || usuario.email.length > 50) {
            $('#errEmail').show();
            result = false;
        } else {
            $('#errEmail').hide();
        }
        
        if(usuario.usuario.length < 2 || usuario.usuario.length > 50) {
            $('#errUsuario').show();
            result = false;
        } else {
            $('#errUsuario').hide();
        }


        return result;
    },
    
    formSubmit: function() {
        var usuario = this.model.usuario;
        usuario = {};
        
        usuario.nombre = $('[name=nombre').val();
        usuario.dni = $('[name=dni').val();
        usuario.apellidos = $('[name=apellidos').val();
        usuario.direccion = $('[name=direccion').val();
        usuario.email = $('[name=email').val();
        usuario.usuario = $('[name=usuario').val();
        
        $(this.config.errMsgs).empty();
        
        return usuario;
    }
}; //End animalesCtrl


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
        
        $(this.config.frmEdit).submit(function (event) {
            event.preventDefault();
            event.preventDefault(); //Avoid default form submit
            self.formSubmit();
        });
         
        if(self.validarDatos(event) === false) {
            event.preventDefault();
        }
    },
    
    formSubmit: function() {
        var usuario = this.model.usuario;
        var self;
        usuario = {};
        
        usuario.nombre = $('[name=nombre').val();
        usuario.dni = $('[name=dni').val();
        usuario.apellidos = $('[name=apellidos').val();
        usuario.direccion = $('[name=direccion').val();
        usuario.email = $('[name=email').val();
        usuario.usuario = $('[name=usuario').val();
        
        $(this.config.errMsgs).empty();
        
        //Form Client-side validation
        if (this.validarDatos(usuario)) {
            self = this;
            var RESTMethod = 'POST';
            var RESTUrl = this.config.srvUrl;
            
            $.ajax({
                url: RESTUrl,                
                type: RESTMethod,
                dataType: 'json',                //expected data type
                contentType: 'application/JSON',
                data: JSON.stringify(usuario)               
                })
                .done(function (json) {
                    console.log(json);
                })
                .fail(function (jqxhr) {
                    console.log(jqxhr);
                });
        }

    },
   
    validarDatos: function (usuario) {
        //Form Client-side validation
        //Shows validation errors next to form fields
        var result = true;
        
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
    }
}; //End animalesCtrl


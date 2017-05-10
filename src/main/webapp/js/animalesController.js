/*jslint browser: true*/
/*global $, jQuery*/


$(function () {
    animalesCtrl.init(viewModel);
});

var viewModel = {
    animal: {}
};

//Clientes Controller
var animalesCtrl = {
    config: {
        frmEdit: '#formAnimales'
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
        var animal = this.model.animal;
        var self;
        animal = {};
        
        animal.nombre = $('[name=nombre').val();
        animal.edad = $('[name=edad').val();
        animal.estado = $('[name=estado').val();
        animal.descripcion = $('[name=descripcion').val();
        
        $(this.config.errMsgs).empty();
        
        //Form Client-side validation
        if (this.validarDatos(animal)) {
            self = this;
            var RESTMethod = 'POST';
            var RESTUrl = this.config.srvUrl;
            
            $.ajax({
                url: RESTUrl,                
                type: RESTMethod,
                dataType: 'json',                //expected data type
                contentType: 'application/JSON',
                data: JSON.stringify(animal)               
                })
                .done(function (json) {
                    console.log(json);
                })
                .fail(function (jqxhr) {
                    console.log(jqxhr);
                });
        }

    },
   
    validarDatos: function (animal) {
        //Form Client-side validation
        //Shows validation errors next to form fields
        var result = true;
        
        if(animal.nombre.length < 2 || animal.nombre.length > 50) {
            $('#errNombre').show();
            result = false;
        } else {
            $('#errNombre').hide();
        }
        
        if(animal.edad < 0 || animal.edad > 100) {
            $('#errEdad').show();
            result = false;
        } else {
            $('#errEdad').hide();
        }
        
        if(animal.estado.length < 2) {
            $('#errEstado').show();
            result = false;
        } else {
            $('#errEstado').hide();
        }
        
        if(animal.descripcion.length < 2) {
            $('#errDescripcion').show();
            result = false;
        } else {
            $('#errDescripcion').hide();
        }

        return result;
    }
}; //End animalesCtrl


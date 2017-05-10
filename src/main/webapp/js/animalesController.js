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
            if (self.validarDatos(event) === false) {
                event.preventDefault();  //stop submit 
            } else {
                alert("Enhorabuena, tu mascota se ha subido correctamente");
            }
        });
        
    },
   
    validarDatos: function () {
        //Form Client-side validation
        //Shows validation errors next to form fields
        animal = this.formSubmit();
        
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
    },
        
    formSubmit: function() {
        var animal = this.model.animal;
        animal = {};
        
        animal.nombre = $('[name=nombre').val();
        animal.edad = $('[name=edad').val();
        animal.estado = $('[name=estado').val();
        animal.descripcion = $('[name=descripcion').val();
        
        $(this.config.errMsgs).empty();
        return animal;
    }
}; //End animalesCtrl


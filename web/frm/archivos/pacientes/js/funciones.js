/*function buscarCedula() {
    var datosFormulario = $("#formPrograma").serialize();
    
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarCedula.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
           // $("#mensajes").html("Enviando datos al servidor ...");
        },
        success: function (json) {
            if (json.ci_paciente === 0) {
                $("#mensajes").html("Ya existe el nro de cedula");
                $("#ci_paciente").focus();
                $("#ci_paciente").val("");
                siguienteCampo("#nombre_paciente", "#botonAgregar", true);
            } else {
                $("#ci_paciente").val(json.ci_paciente);
                $("#nombre_paciente").focus();
            }
        },
        error: function (e) {
           $("#mensajes").html("No se pudo recuperar los datos de CI");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {

            }
        }
    });
}
*/

function agregarPaciente() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_paciente").focus();
            $("#id_paciente").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            $("#id_paciente").focus();
        }
    });
}

function modificarPaciente() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/modificar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_paciente").focus();
            $("#id_paciente").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {

        }
    });
}

function eliminarPaciente() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#id_paciente").focus();
            $("#id_paciente").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {

            }
        }
    });
}

function buscarIdPaciente() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_paciente").val(json.id_paciente);
            $("#ci_paciente").val(json.ci_paciente);
            $("#nombre_paciente").val(json.nombre_paciente);
            $("#apellido_paciente").val(json.apellido_paciente);            
            $("#fechanac_paciente").val(json.fechanac_paciente);            
            $("#altura_paciente").val(json.altura_paciente);
            $("#peso_paciente").val(json.peso_paciente);            
            $("#direccion_paciente").val(json.direccion_paciente);            
            $("#telefono_paciente").val(json.telefono_paciente);
            $("#celular_paciente").val(json.celular_paciente);
            $("#email_paciente").val(json.email_paciente);            
            $("#profesion_paciente").val(json.profesion_paciente);
            $("#lugar_trabajo").val(json.lugar_trabajo);
            $("#seguro_paciente").val(json.seguro_paciente);
            
            $("#id_sexo").val(json.id_sexo);
            $("#nombre_sexo").val(json.nombre_sexo);
            // console.log(json.nuevo);
            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disabled', false);
                $("#botonModificar").prop('disabled', true);
                $("#botonEliminar").prop('disabled', true);
                siguienteCampo("#nombre_paciente", "#botonAgregar", true);
            } else {
                $("#botonAgregar").prop('disabled', true);
                $("#botonModificar").prop('disabled', false);
                $("#botonEliminar").prop('disabled', true);
                siguienteCampo("#nombre_paciente", "#botonModificar", true);
            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {}
        }
    });
}

function buscarNombrePaciente() {
    var datosFormulario = $("#formBuscar").serialize();

    $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombre.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function () {
                var id = $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_paciente").val(id);
                $("#nombre_paciente").focus();
                buscarIdPaciente();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {

            }
        }
    });
}

//sexos

function buscarIdSexo() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdSexo.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_sexo").val(json.id_sexo);
            $("#nombre_sexo").val(json.nombre_sexo);
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {}
        }
    });
}

function buscarNombreSexo() {
    var datosFormulario = $("#formBuscar").serialize();

    $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombreSexo.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function () {
                var id = $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_sexo").val(id);
                $("#nombre_sexo").focus();
                buscarIdSexo();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {

            }
        }
    });
}


function limpiarFormulario() {
    $("#id_paciente").val("");
    $("#nombre_paciente").val("");
    $("#apellido_paciente").val("");
    $("#ci_paciente").val("");
    $("#fechanac_paciente").val("");
    
    $("#altura_paciente").val("");
    $("#peso_paciente").val("");
    $("#direccion_paciente").val("");
    $("#telefono_paciente").val("");
    $("#celular_paciente").val("");
    $("#email_paciente").val("");
    
    $("#profesion_paciente").val("");
    $("#lugar_trabajo").val("");
    $("#seguro_paciente").val("");
    
    $("#id_sexo").val("");
    $("#nombre_sexo").val("");
     
  }



function validarFormulario() {
    var valor = true;
    if ($("#ci_paciente").val().trim() == 0) {
        valor = false;
        $("#mensajes").html("Nro de CI no puede estar vacio");
        $("#ci_paciente").focus();
    } else if ($("#ci_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Nro de CI no puede estar vacio");
        $("#ci_paciente").focus();
    } else if ($("#nombre_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Nombre del paciente no puede estar vacio");
        $("#nombre_paciente").focus();
    } else if ($("#apellido_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Apellido del paciente no puede estar vacio");
        $("#apellido_paciente").focus();
    } else if ($("#fechanac_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Ingrese la fecha");
        $("#fechanac_paciente").focus();
    } else if ($("#nombre_sexo").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Elija el sexo del paciente");
        $("#id_sexo").focus();
    }  else if ($("#altura_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Elija la altura del paciente");
        $("#altura_paciente").focus();
    } else if ($("#peso_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Elija el peso del paciente");
        $("#peso_paciente").focus();
    } else if ($("#peso_paciente").val().trim() == 0) {
        valor = false;
        $("#mensajes").html("Elija el peso del paciente");
        $("#peso_paciente").focus();
    } else if ($("#direccion_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique la direccion del paciente");
        $("#direccion_paciente").focus();
    }  else if ($("#telefono_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique el telefono del paciente");
        $("#telefono_paciente").focus();
    } else if ($("#celular_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique el nro de celular del paciente");
        $("#celular_paciente").focus();
    } else if ($("#email_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique el email del paciente");
        $("#email_paciente").focus();
    }  else if ($("#profesion_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique la profesion del paciente");
        $("#profesion_paciente").focus();
    }  else if ($("#lugar_trabajo").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique el lugar de trabajo del paciente");
        $("#lugar_trabajo").focus();
    }  else if ($("#seguro_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Indique el seguro medico del paciente");
        $("#seguro_paciente").focus();
    } 
    
    
    return valor;
}

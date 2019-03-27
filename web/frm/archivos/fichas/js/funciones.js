function buscarIdFicha() {
    var datosFormulario = $("#formPrograma").serialize();
   // alert(datosFormulario);
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
            $("#id_ficha").val(json.id_ficha);
            $("#nombre_ficha").val(json.nombre_ficha);
            $("#fecha_ficha").val(json.fecha_ficha);            
            $("#id_doctor").val(json.id_doctor);
            $("#nombre_doctor").val(json.nombre_doctor);            
            $("#id_paciente").val(json.id_paciente);
            $("#nombre_paciente").val(json.nombre_paciente);  
            $("#apellido_paciente").val(json.apellido_paciente); 
            $("#nombre_sexo").val(json.nombre_sexo); 
            $("#presion_alta").val(json.presion_alta);
            $("#presion_baja").val(json.presion_baja);            
            $("#alergias_paciente").val(json.alergias_paciente);
            $("#vacunas_paciente").val(json.vacunas_paciente);
            
            /*Si es femenino*/
            $("#tiene_embarazo").val(json.tiene_embarazo);
            $("#tiempo_gestacion").val(json.tiempo_gestacion);
            $("#esta_amamantando").val(json.esta_amamantando);
            $("#medico_tratante").val(json.medico_tratante);
            $("#medico_tratante_nro").val(json.medico_tratante_nro);
            /* ********* */
            
            $("#alteraciones_sistem").val(json.alteraciones_sistem);
            $("#hab_nocivos").val(json.hab_nocivos);
            $("#medicacion_actual").val(json.medicacion_actual);
            
            $("#contenidoDetalle").html(json.contenido_detalle);
            
           /* if (json.nombre_ficha === "PENDIENTE") {
               $("#botonFacturar").prop('disabled', false);
           } else {
                $("#botonFacturar").prop('disabled', true);
           }*/
            quitarcamposfemeninos();
            if (json.nuevo === "true") {
               $("#botonAgregar").prop('disabled', false);
               $("#botonModificar").prop('disabled', true);
               $("#botonEliminar").prop('disabled', true);
               siguienteCampo("#nombre_ficha", "#botonAgregar", true);
               $("#detalle").prop('hidden', true);
           } else {
               $("#botonAgregar").prop('disabled', true);
               $("#botonModificar").prop('disabled', false);
               $("#botonEliminar").prop('disabled', false);
               siguienteCampo("#nombre_ficha", "#botonModificar", true);
               $("#detalle").prop('hidden', false);
           }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo traer los datos..");
        },
        complete: function (objeto, exito, error){
           if (exito === "success"){
           }
        }
    });
}

function quitarcamposfemeninos() {
    //  alert("HOLA");
    var sexo = $("#nombre_sexo").val();
   // alert(" SEXO " + sexo)
    if (sexo === "MASCULINO") {
        $("#esfemenino").hide();
       // alert("SI");
    } else
        if (sexo === "FEMENINO") {
        $("#esfemenino").show();
       // alert("SI");
    }
};
                                
                                
                                
function buscarNombreFicha() {
    var datosFormulario = $("#formBuscar").serialize();
    //alert(datosFormulario);
    $.ajax({
       type: 'POST',
       url: 'jsp/buscarNombre.jsp',
       data: datosFormulario,
       dataType: 'json',
       beforeSend: function (objeto) {
           $("#mensajes").html("Enviando datos al Servidor ...");
           $("#contenidoBusqueda").css("display", "none");
       },
       success: function (json){
           $("#mensajes").html(json.mensaje);
           $("#contenidoBusqueda").html(json.contenido);
           $("#contenidoBusqueda").fadeIn("slow");
           $("tbody tr").on("click", function(){
              var id = $(this).find("td:first").html();
              $("#panelBuscar").html("");
              $("#id_ficha").val(id);
              $("#nombre_ficha").focus();
              buscarIdFicha();
              $("#buscar").fadeOut("slow");
              $("#panelPrograma").fadeIn("slow");
          });
       },
       error: function(e) {
           $("#mensajes").html("No se pudo modificar los datos.");
       },
       complete: function(objeto, exito, error) {
           if (exito === "success"){
               
           }
       }
    });
}
function agregarFicha(){
    var datosFormulario = $("#formPrograma").serialize();
  // alert(datosFormulario)
    $.ajax({
        type: 'POST',
        url: "jsp/agregar.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servidor ...");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);
          //  limpiarFormulario();
            $("#botonAgregar").prop('disabled', true);
            $("#detalleficha").prop('hidden', false);
            $("#id_ficha").val(json.id_ficha);
            buscarIdFicha();
            //$("#id_ficha").focus();
            //$("#id_ficha").select();
        },
        error: function (e){
            $("#mensajes").html("No se pudo agregar los datos.");
        },
        complete: function (objeto, exito, error){
            if (exito === "success"){
        }
    }
    });
}
function modificarFicha() {
        var datosFormulario = $("#formPrograma").serialize();
       // alert(datosFormulario);
        $.ajax({
            
            type: 'POST',
            url: "jsp/modificar.jsp",
            data: datosFormulario,
            dataType: 'json',
            beforeSend: function (objeto) {
                $("#mensajes").html("Enviando datos al Servidor ...");
            },
            success: function (json) {
                $("#mensajes").html(json.mensaje);
               // limpiarFormulario();
                $("#id_ficha").focus();
                $("#id_ficha").select();
                buscarIdFicha();
            },
            error: function (e) {
                $("#mensajes").html("No se pudo modificar los datos.");
            },
            complete: function (objeto, exito, error) {
                
            }
        });
    }
function eliminarFicha() {
        var datosFormulario = $("#formPrograma").serialize();
        $.ajax ({
            type: 'POST',
            url: "jsp/eliminar.jsp",
            data: datosFormulario,
            dataType: 'json',
            beforeSend: function (objeto) {
                $("#mensajes").html("Enviando datos al Servidor ...");
            },
            success: function (json) {
                $("#mensajes").html(json.mensaje);                
                    eliminarDetalleFicha();
                    limpiarFormulario();              
                $("#id_ficha").focus();
                $("#id_ficha").select();
                alert("Si desea eliminar la ficha, primero debe eliminar los tratamientos");
            },
            error: function (e) {
                $("#mensaje").html("No se pudo modificar los datos.");
                 
            },
            complete: function (objeto, exito, error) {
                if (exito === "success") {
                }
            }
        });
    }
    
function crearFacturas(){
    var datosFormulario = $("#formPrograma").serialize();
  // alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: "jsp/facturar.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servidor ...");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);
            limpiarFormulario();
            $("#botonAgregar").prop('disabled', true);
            $("#detalleficha").prop('hidden', false);
            $("#id_ficha").val(json.id_ficha);
            buscarIdFicha();
            //$("#id_ficha").focus();
            //$("#id_ficha").select();
        },
        error: function (e){
            $("#mensajes").html("No se pudo agregar los datos.");
        },
        complete: function (objeto, exito, error){
            if (exito === "success"){
        }
    }
    });
}
  
/*DOCTORES*/
function buscarIdDoctor() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdDoctor.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_doctor").val(json.id_doctor);
            $("#nombre_doctor").val(json.nombre_doctor);
            
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error){
           if (exito === "success"){
           }
        }
    });
}
function buscarNombreDoctor() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
       type: 'POST',
       url: 'jsp/buscarNombreDoctor.jsp',
       data: datosFormulario,
       dataType: 'json',
       beforeSend: function (objeto) {
           $("#mensajes").html("Enviando datos al Servidor ...");
           $("#contenidoBusqueda").css("display", "none");
       },
       success: function (json){
           $("#mensajes").html(json.mensaje);
           $("#contenidoBusqueda").html(json.contenido);
           $("#contenidoBusqueda").fadeIn("slow");
           $("tbody tr").on("click", function(){
              var id = $(this).find("td:first").html();
              $("#panelBuscar").html("");
              $("#id_doctor").val(id);
              $("#nombre_doctor").focus();
              buscarIdDoctor();
              $("#buscar").fadeOut("slow");
              $("#panelPrograma").fadeIn("slow");
          });
       },
       error: function(e) {
           $("#mensajes").html("No se pudo modificar los datos.");
       },
       complete: function(objeto, exito, error) {
           if (exito === "success"){
               
           }
       }
    });
}

//PACIENTES
function buscarIdPaciente() {
    var datosFormulario = $("#formPrograma").serialize();

    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdPaciente.jsp',
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
            $("#nombre_gruposang").val(json.nombre_gruposang);//GRUPO DE SANGRE
            $("#direccion_paciente").val(json.direccion_paciente);            
            $("#telefono_paciente").val(json.telefono_paciente);
            $("#celular_paciente").val(json.celular_paciente);
            $("#email_paciente").val(json.email_paciente);            
            $("#profesion_paciente").val(json.profesion_paciente);
            $("#lugar_trabajo").val(json.lugar_trabajo);
            $("#seguro_paciente").val(json.seguro_paciente);
            
            $("#id_sexo").val(json.id_sexo);
            $("#nombre_sexo").val(json.nombre_sexo);
            $("#id_gruposang").val(json.id_gruposang);
            $("#nombre_gruposang").val(json.nombre_gruposang);
            quitarcamposfemeninos();
            // console.log(json.nuevo);
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
        url: 'jsp/buscarNombrePaciente.jsp',
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

/*SERVICIOS*/
function buscarIdServicio() {
    var datosFormulario = $("#formLinea").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdServicio.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_servicio").val(json.id_servicio);
            $("#nombre_servicio").val(json.nombre_servicio);
            $("#descripcion_servicio").val(json.descripcion_servicio);
            $("#precio_servicio").val(json.precio_servicio);
            $("#observacion_servicio").val(json.observacion_servicio);
            
       
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error){
           if (exito === "success"){
           }
        }
    });
}
function buscarNombreServicio() {
    var datosFormulario = $("#formBuscar").serialize();
  
    $.ajax({
       type: 'POST',
       url: 'jsp/buscarNombreServicio.jsp',
       data: datosFormulario,
       dataType: 'json',
       beforeSend: function (objeto) {
           $("#mensajes").html("Enviando datos al Servidor ...");
           $("#contenidoBusqueda").css("display", "none");
       },
       success: function (json){
           $("#mensajes").html(json.mensaje);
           $("#contenidoBusqueda").html(json.contenido);
           $("#contenidoBusqueda").fadeIn("slow");
           $("tbody tr").on("click", function(){
              var id = $(this).find("td:first").html();
              $("#panelBuscar").html("");
              $("#id_servicio").val(id);
              $("#nombre_servicio").focus();
              buscarIdServicio();
              $("#buscar").fadeOut("slow");
              $("#panelLinea").fadeIn("slow");
          });
       },
       error: function(e) {
           $("#mensajes").html("No se pudo modificar los datos.");
       },
       complete: function(objeto, exito, error) {
           if (exito === "success"){
               
           }
       }
    });
}

function agregarLinea() {
    $("#id_detalleficha").val("0");
    $("#id_servicio").val("0");
    $("#nombre_servicio").val("");
    $("#estado_detalleficha").val("");
    $("#obs_detalleficha").val("");
    $("#medicacion_detalleficha").val("");
    $("#fecha_detalleficha").val("");
    $("#panelLinea").fadeIn("slow");
    $("#panelPrograma").fadeOut("slow");
    
    $("#botonAgregarLinea").prop('disabled', false);
    $("#botonModificarLinea").prop('disabled', true);
    $("#botonEliminarLinea").prop('disabled', true);
    siguienteCampo("#id_servicio", "#botonAgregarLinea", true);
}
function editarLinea(id) {
    $("#id_detalleficha").val(id);
    //alert("linea" + id); 
    $("#id_servicio").val(0);
    $("#nombre_servicio").val("");
    $("#estado_detalleficha").val("");// QUITAR
    /*
     * Se agregan campos con el id
     * 
     **/
    
    $("#panelLinea").fadeIn("slow");
    $("#panelPrograma").fadeOut("slow");
    
    $("#id_servicio").focus();
    $("#id_servicio").select();
    $("#botonAgregarLinea").prop('disabled', true);
    $("#botonModificarLinea").prop('disabled', false);
    $("#botonEliminarLinea").prop('disabled', false);
    buscarIdDetalleFicha();
    //siguienteCampo("#nombre_servicio", "#botonModificarLinea", true); //ver
}

//DETALLESfunction buscarIdDetalleFicha() 
function agregarDetalleFicha() {
    var datosFormulario = $("#formLinea").serialize();
    var id_ficha = $("#id_ficha").val();
    datosFormulario += "&id_ficha=" + id_ficha;
    //alert (datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/agregarDetalleFicha.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#panelLinea").fadeOut("slow");
            $("#panelPrograma").fadeIn("slow");
            buscarIdFicha();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo agregar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
//BUSCARDETALLE
function buscarIdDetalleFicha() {
    var datosFormulario = $("#formLinea").serialize();
    //alert("BUSCAR ID DETALLE FICHA: " + datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdDetalleFicha.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            //$("#hora_detalleficha").val(json.hora_detalleficha);
            //pruba linea
            $("#id_detalleficha").val(json.id_detalleficha);
            //alert("ID df: " + json.id_detalleficha);
            $("#id_servicio").val(json.id_servicio);
           // alert("ID de servicio: "+json.id_servicio);
            $("#nombre_servicio").val(json.nombre_servicio);
            //alert("Nombre del servicio: "+json.nombre_servicio);
            $("#estado_detalleficha").val(json.estado_detalleficha);
            $("#obs_detalleficha").val(json.obs_detalleficha);
            $("#medicacion_detalleficha").val(json.medicacion_detalleficha);
            $("#fecha_detalleficha").val(json.fecha_detalleficha);
            
        },
        error: function (e) {
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function modificarDetalleFicha() {
    var datosFormulario = $("#formLinea").serialize();
    var id_ficha = $("#id_ficha").val();
    datosFormulario += "&id_ficha=" + id_ficha;
   // alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/modificarDetalleFicha.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#panelLinea").fadeOut("slow");
            $("#panelPrograma").fadeIn("slow");
            buscarIdFicha();
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
function eliminarDetalleFicha() {
    var datosFormulario = $("#formLinea").serialize();
    var id_ficha = $("#id_ficha").val();
    datosFormulario += "&id_ficha=" + id_ficha;
    $.ajax({
        type: 'POST',
        url: 'jsp/eliminarDetalleFicha.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json)
        {
            $("#mensajes").html(json.mensaje);
            $("#panelLinea").fadeOut("slow");
            $("#panelPrograma").fadeIn("slow");
            buscarIdFicha();
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


function limpiarFormulario(){
        $("#id_ficha").val("0");
        $("#nombre_ficha").val("");
       // $("#fecha_ficha").val("dd//mm/aaa");
        $("#id_paciente").val("");
        $("#nombre_paciente").val("");
        $("#id_doctor").val("");
        $("#nombre_doctor").val("");
       // $("#presion_alta").val("");
       
       $("#tiene_embarazo").val("");
       $("#tiempo_gestacion").val("");
       $("#esta_amamantando").val("");
       $("#medico_tratante").val("");
       $("#medico_tratante_nro").val("");
       
        $("#nombre_doctor").val("");
        $("#alergias_paciente").val("");
        $("#vacunas_paciente").val("");
       
        $("#alteraciones_sistem").val("");
        $("#hab_nocivos").val("");
        $("#medicacion_actual").val("");
        
        $("#nombre_sexo").val("");
       
    }
    
 
  function validarFormulario() {
      var valor = true;
    /*if ($("#id_doctor").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Seleccione un doctor");
        $("#id_doctor").focus();
    } else if ($("#id_doctor").val().trim() == 0) {
        valor = false;
        $("#mensajes").html("Seleccione un doctor");
        $("#id_doctor").focus();
    } else
    */ if ($("#nombre_doctor").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Doctor no puede estar vacio");
        $("#id_doctor").focus();
        /*Paciente*/
    }
    /*else if ($("#id_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Seleccione un paciente");
        $("#id_paciente").focus();
    } 
      */
    /*else if ($("#id_paciente").val().trim() == 0) {
        valor = false;
        $("#mensajes").html("Seleccione un paciente");
        $("#id_paciente").focus();
    } */ 
    else if ($("#nombre_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Paciente no puede estar vacio");
        $("#id_paciente").focus();
    } else if ($("#nombre_ficha").val().trim() === "") {
        valor = false;
        $("#mensajes").html("Especifique el motivo de la consulta");
        $("#nombre_ficha").focus();
    } else if ($("#presion_alta_select").val() === "elegirpa") {
        $("#mensajes").html("El campo de presion ALTA no puede estar vacio");
        valor = false;
        $("#presion_alta").focus();
    } else if ($("#presion_baja_select").val() === "elegirpb") {
        $("#mensajes").html("El campo de presion BAJA no puede estar vacio");
        valor = false;
        $("#presion_alta").focus();
    }
      else if ($("#alergias_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("El campo de alergias no puede estar vacio");
        $("#alergias_paciente").focus();
    } else if ($("#vacunas_paciente").val().trim() === "") {
        valor = false;
        $("#mensajes").html("El campo de vacunas no puede estar vacio");
        $("#vacunas_paciente").focus();
    }
    return valor;
}
    

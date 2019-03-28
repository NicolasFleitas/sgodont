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
            $("#presion_alta_select").val(json.presion_alta);
            $("#presion_baja_select").val(json.presion_baja);
            
            /*TIENE TUVO*/
             $("#fiebre_reumatica_select").val(json.fiebre_reumatica);
             $("#desmayos_select").val(json.desmayos);
             $("#marcapasos_cardiacos_select").val(json.marcapasos_cardiacos);
             $("#trat_radio_quimio_select").val(json.trat_radio_quimio);
             $("#tienetuvo_especificar").val(json.tienetuvo_especificar);      
             
             $("#ataques_cardiacos_select").val(json.ataques_cardiacos);
             $("#sangrado_excesivo_select").val(json.sangrado_excesivo);
             $("#moretones_inst_select").val(json.moretones_inst);
             $("#asma_rinitis_select").val(json.asma_rinitis);
             $("#farmaco_especificar").val(json.farmaco_especificar);
             
            /* ------ */
            
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
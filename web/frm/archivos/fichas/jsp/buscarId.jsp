<%@page import="modelos.Servicios"%>
<%@page import="java.util.Date"%>
<%@page import="modelos.Pacientes"%>
<%@page import="controladores.FichasControlador"%>
<%@page import="controladores.DetalleFichasControlador"%>
<%@page import="modelos.Doctores"%>
<%@page import="utiles.Utiles"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="modelos.Fichas"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
    String tipo = "error";
    String mensaje = "Datos no encontrados";
    String nuevo = "true";
    
    Fichas ficha = new Fichas();
    ficha.setId_ficha(id_ficha);

    FichasControlador.buscarId(ficha);    
    if (ficha.getId_ficha() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    } 
    String contenido_detalle = DetalleFichasControlador.buscarIdFicha(id_ficha);

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("id_ficha", ficha.getId_ficha());
    obj.put("nombre_ficha", ficha.getNombre_ficha());
    obj.put("fecha_ficha", String.valueOf(ficha.getFecha_ficha()));
    obj.put("id_doctor", ficha.getDoctor().getId_doctor());
    obj.put("nombre_doctor", ficha.getDoctor().getNombre_doctor());
    obj.put("id_paciente", ficha.getPaciente().getId_paciente());
    obj.put("nombre_paciente", ficha.getPaciente().getNombre_paciente());
    obj.put("apellido_paciente", ficha.getPaciente().getApellido_paciente());
    obj.put("nombre_sexo", ficha.getPaciente().getSexo().getNombre_sexo());
    /*TieneTuvo*/
    obj.put("presion_alta", ficha.getPresion_alta());
    obj.put("presion_baja", ficha.getPresion_baja());
    obj.put("fiebre_reumatica", ficha.getFiebre_reumatica());
    obj.put("desmayos", ficha.getDesmayos());
    obj.put("marcapasos_cardiacos", ficha.getMarcapasos_cardiacos());
    obj.put("trat_radio_quimio", ficha.getTrat_radio_quimio());
    obj.put("tienetuvo_especificar", ficha.getTienetuvo_especificar());
    
    obj.put("ataques_cardiacos", ficha.getAtaques_cardiacos());
    obj.put("sangrado_excesivo", ficha.getSangrado_excesivo());
    obj.put("moretones_inst", ficha.getMoretones_inst());
    obj.put("asma_rinitis", ficha.getAsma_rinitis());
    obj.put("farmaco_especificar", ficha.getFarmaco_especificar());
    /*FinTieneTuvo*/
    obj.put("alergias_paciente", ficha.getAlergias_paciente());
    obj.put("vacunas_paciente", ficha.getVacunas_paciente());
    obj.put("alteraciones_sistem", ficha.getAlteraciones_sistem());
    obj.put("hab_nocivos", ficha.getHab_nocivos());
    obj.put("medicacion_actual", ficha.getMedicacion_actual());
    obj.put("tiene_embarazo", ficha.getTiene_embarazo());
    obj.put("tiempo_gestacion", ficha.getTiempo_gestacion());
    obj.put("esta_amamantando", ficha.getEsta_amamantando());
    obj.put("medico_tratante", ficha.getMedico_tratante());
    obj.put("medico_tratante_nro", ficha.getMedico_tratante_nro());
    obj.put("contenido_detalle", contenido_detalle);
    out.print(obj);
    out.flush();
%>
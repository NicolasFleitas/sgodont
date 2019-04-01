<%@page import="modelos.Pacientes"%>
<%@page import="modelos.Doctores"%>
<%@page import="utiles.Utiles"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="controladores.FichasControlador"%>
<%@page import="modelos.Fichas"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
    int id_doctor = Integer.parseInt(request.getParameter("id_doctor"));
    int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
    String nombre_ficha = request.getParameter("nombre_ficha");
    String sfecha_ficha = request.getParameter("fecha_ficha");
    java.sql.Date fecha_ficha = Utiles.stringToSqlDate(sfecha_ficha);
    String alergias_paciente = request.getParameter("alergias_paciente");
    String vacunas_paciente = request.getParameter("vacunas_paciente");
    String alteraciones_sistem = request.getParameter("alteraciones_sistem");
    String hab_nocivos = request.getParameter("hab_nocivos");
    String medicacion_actual = request.getParameter("medicacion_actual");
    String tiene_embarazo = request.getParameter("tiene_embarazo_select");
    String tiempo_gestacion = request.getParameter("tiempo_gestacion");
    String esta_amamantando = request.getParameter("esta_amamantando_select");
    String medico_tratante = request.getParameter("medico_tratante");
    String medico_tratante_nro = request.getParameter("medico_tratante_nro");
    
     /*TieneTuvo*/
    String presion_alta = request.getParameter("presion_alta_select");
    String presion_baja = request.getParameter("presion_baja_select");    
    String fiebre_reumatica = request.getParameter("fiebre_reumatica_select");
    String desmayos = request.getParameter("desmayos_select");
    String marcapasos_cardiacos = request.getParameter("marcapasos_cardiacos_select");
    String trat_radio_quimio = request.getParameter("trat_radio_quimio_select");
    String tienetuvo_especificar = request.getParameter("tienetuvo_especificar");
    
    String ataques_cardiacos  = request.getParameter("ataques_cardiacos_select");
    String sangrado_excesivo  = request.getParameter("sangrado_excesivo_select");
    String moretones_inst  = request.getParameter("moretones_inst_select");
    String asma_rinitis  = request.getParameter("asma_rinitis_select");
    String farmaco_especificar = request.getParameter("farmaco_especificar");
    /*Fin TieneTuvo*/
  
    Doctores doctor = new Doctores();
    doctor.setId_doctor(id_doctor);
    Pacientes paciente = new Pacientes();
    paciente.setId_paciente(id_paciente);
   
    String tipo ="error";
    String mensaje ="Datos no agregados.";
    
    Fichas ficha = new Fichas();
    ficha.setId_ficha(id_ficha);
    ficha.setNombre_ficha(nombre_ficha);
    ficha.setFecha_ficha(fecha_ficha);    
    ficha.setDoctor(doctor);
    ficha.setPaciente(paciente);
    ficha.setPresion_alta(presion_alta);
    ficha.setPresion_baja(presion_baja);
    ficha.setAlergias_paciente(alergias_paciente);
    ficha.setVacunas_paciente(vacunas_paciente);  
    ficha.setAlteraciones_sistem(alteraciones_sistem);
    ficha.setHab_nocivos(hab_nocivos);
    ficha.setMedicacion_actual(medicacion_actual);
    ficha.setTiene_embarazo(tiene_embarazo);
    ficha.setTiempo_gestacion(tiempo_gestacion);
    ficha.setEsta_amamantando(esta_amamantando);
    ficha.setMedico_tratante(medico_tratante);
    ficha.setMedico_tratante_nro(medico_tratante_nro);
     /*TieneTuvo*/
    ficha.setPresion_alta(presion_alta);
    ficha.setPresion_baja(presion_baja);
    ficha.setFiebre_reumatica(fiebre_reumatica);
    ficha.setDesmayos(desmayos);
    ficha.setMarcapasos_cardiacos(marcapasos_cardiacos);
    ficha.setTrat_radio_quimio(trat_radio_quimio);
    ficha.setTienetuvo_especificar(tienetuvo_especificar);
    
    ficha.setAtaques_cardiacos(ataques_cardiacos);
    ficha.setSangrado_excesivo(sangrado_excesivo);
    ficha.setMoretones_inst(moretones_inst);
    ficha.setAsma_rinitis(asma_rinitis);
    ficha.setFarmaco_especificar(farmaco_especificar);
    /*FinTieneTuvo*/
    
   if (FichasControlador.modificar(ficha)){
       tipo = "success";
       mensaje = "Datos agregados";
   }
   
  JSONObject obj = new JSONObject();
  obj.put("tipo", tipo);
  obj.put("mensaje", mensaje);
  out.print(obj);
  out.flush();
    
    %>
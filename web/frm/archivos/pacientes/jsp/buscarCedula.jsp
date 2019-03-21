<%@page import="org.json.simple.JSONObject"%>
<%@page import="modelos.Pacientes"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="controladores.PacientesControlador"%>
<%

    int ci_paciente = Integer.parseInt(request.getParameter("ci_paciente"));

    String tipo = "error";
 
    Pacientes paciente = new Pacientes();
    paciente.setCi_paciente(ci_paciente);
    PacientesControlador.buscarCedula(paciente);


    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("ci_paciente", paciente.getCi_paciente());
    System.out.println(paciente.getCi_paciente());
    out.print(obj);
    out.flush();
%>
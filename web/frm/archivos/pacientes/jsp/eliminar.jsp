
<%@page import="controladores.PacientesControlador"%>
<%@page import="modelos.Pacientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
    
    
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    Pacientes paciente = new Pacientes();
    paciente.setId_paciente(id_paciente);
    
    if (PacientesControlador.eliminar(paciente)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>

<%@page import="utiles.Utiles"%>
<%@page import="modelos.Sexos"%>
<%@page import="controladores.PacientesControlador"%>
<%@page import="modelos.Pacientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
    int ci_paciente = Integer.parseInt(request.getParameter("ci_paciente"));
    String nombre_paciente = request.getParameter("nombre_paciente");
    String apellido_paciente = request.getParameter("apellido_paciente");
    String sfechanac_paciente = request.getParameter("fechanac_paciente");
    java.sql.Date fechanac_paciente = Utiles.stringToSqlDate(sfechanac_paciente);
    String altura_paciente = request.getParameter("fechanac_paciente");
    int peso_paciente = Integer.parseInt(request.getParameter("peso_paciente"));
    String direccion_paciente = request.getParameter("direccion_paciente");
    String telefono_paciente = request.getParameter("telefono_paciente");
    String celular_paciente = request.getParameter("celular_paciente");
    String email_paciente = request.getParameter("email_paciente");
    String profesion_paciente = request.getParameter("profesion_paciente");
    String lugar_trabajo = request.getParameter("lugar_traabajo");
    String seguro_medico = request.getParameter("seguro_medico");

    String tipo = "error";
    String mensaje = "Datos no modificados.";

    Pacientes paciente = new Pacientes();
    paciente.setId_paciente(id_paciente);
    paciente.setCi_paciente(ci_paciente);
    paciente.setNombre_paciente(nombre_paciente);
    paciente.setApellido_paciente(apellido_paciente);
    paciente.setFechanac_paciente(fechanac_paciente);
    paciente.setAltura_paciente(altura_paciente);
    paciente.setPeso_paciente(peso_paciente);
    paciente.setDireccion_paciente(direccion_paciente);
    paciente.setTelefono_paciente(telefono_paciente);
    paciente.setCelular_paciente(celular_paciente);
    paciente.setEmail_paciente(email_paciente);
    paciente.setProfesion_paciente(profesion_paciente);
    paciente.setLugar_trabajo(lugar_trabajo);
    paciente.setSeguro_paciente(seguro_medico);

    if (PacientesControlador.modificar(paciente)) {
        tipo = "success";
        mensaje = "Datos modificados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>

<%@page import="controladores.DetalleFichasControlador"%>
<%@page import="modelos.DetalleFichas"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_detalleficha = Integer.parseInt(request.getParameter("id_detalleficha"));

    String tipo = "error";
    String mensaje = "Datos no agregados.";

     DetalleFichas detalleficha = new DetalleFichas();
     detalleficha.setId_detalleficha(id_detalleficha);

    if (DetalleFichasControlador.eliminar(detalleficha)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>
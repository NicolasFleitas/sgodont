
<%@page import="controladores.GrupoSanguineosControlador"%>
<%@page import="modelos.GrupoSanguineos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_gruposang = Integer.parseInt(request.getParameter("id_gruposang"));
    
    
    String tipo = "error";
    String mensaje = "Datos no eliminados.";
    
    GrupoSanguineos gruposang = new GrupoSanguineos();
    gruposang.setId_gruposang(id_gruposang);
    
    if (GrupoSanguineosControlador.eliminar(gruposang)) {
        tipo = "success";
        mensaje = "Datos eliminados.";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>
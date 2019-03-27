<%@page import="controladores.GrupoSanguineosControlador"%>
<%@page import="modelos.GrupoSanguineos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_gruposang = Integer.parseInt(request.getParameter("id_gruposang"));
    String nombre_gruposang = request.getParameter("nombre_gruposang");

    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    GrupoSanguineos gruposang = new GrupoSanguineos();
    gruposang.setId_gruposang(id_gruposang);
    gruposang.setNombre_gruposang(nombre_gruposang);

    if (GrupoSanguineosControlador.agregar(gruposang)) {
        tipo = "success";
        mensaje = "Datos agregados.";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>


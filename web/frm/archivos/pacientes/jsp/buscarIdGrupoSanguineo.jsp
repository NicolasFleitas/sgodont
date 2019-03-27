
<%@page import="controladores.GrupoSanguineosControlador"%>
<%@page import="modelos.GrupoSanguineos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_gruposang = Integer.parseInt(request.getParameter("id_gruposang"));
    
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    GrupoSanguineos gruposang = new GrupoSanguineos();
    gruposang.setId_gruposang(id_gruposang);
    
   GrupoSanguineosControlador.buscarId(gruposang);
    if (gruposang.getId_gruposang()!=0){
        tipo = "success";
        mensaje = "Datos encontrados.";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("id_gruposang", gruposang.getId_gruposang());
    obj.put("nombre_gruposang", gruposang.getNombre_gruposang());
    out.print(obj);
    out.flush();
%>

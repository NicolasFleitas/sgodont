
<%@page import="java.sql.Date"%>
<%@page import="modelos.Servicios"%>
<%@page import="modelos.Fichas"%>
<%@page import="modelos.Pacientes"%>
<%@page import="modelos.DetalleFichas"%>
<%@page import="controladores.DetalleFichasControlador"%>
<%@page import="modelos.Doctores"%>
<%@page import="utiles.Utiles"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_detalleficha = Integer.parseInt(request.getParameter("id_detalleficha"));
    //System.out.println("VALOR DE ID_DETALLEFICHA: "+id_detalleficha);
    String tipo = "error";
    String mensaje = "Datos no encontrados";
    String nuevo = "true";
    
    DetalleFichas detalleficha = new DetalleFichas();
    detalleficha.setId_detalleficha(id_detalleficha);

    DetalleFichasControlador.buscarId(detalleficha);
    if (detalleficha != null) {
            tipo = "success";
            mensaje = "Datos encontrados.";
            nuevo = "false";
        } /*else {
            detalleficha.setId_detalleficha(0);
            
            Servicios servicio = new Servicios();
            servicio.setId_servicio(0);
            servicio.setNombre_servicio("");
            
            detalleficha.setServicio(servicio);
            detalleficha.setEstado_detalleficha("");
            
            Fichas ficha = new Fichas();
            ficha.setId_ficha(0);
            
            detalleficha.setFicha(ficha);
            detalleficha.setServicio(servicio);
            
            detalleficha.setObs_detalleficha("");
            detalleficha.setMedicacion_detalleficha("");
           // detalleficha.setFecha_detalleficha(null);
        }*/


    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
  
    obj.put("id_detalleficha", detalleficha.getId_detalleficha());
    obj.put("hora_detalleficha",detalleficha.getEstado_detalleficha());
    obj.put("id_ficha", String.valueOf(detalleficha.getFicha().getId_ficha()));
    obj.put("id_servicio", String.valueOf(detalleficha.getServicio().getId_servicio()));
    obj.put("nombre_servicio", detalleficha.getServicio().getNombre_servicio());
    obj.put("estado_detalleficha", detalleficha.getEstado_detalleficha());
    obj.put("obs_detalleficha", detalleficha.getObs_detalleficha());
    obj.put("medicacion_detalleficha", detalleficha.getMedicacion_detalleficha());
    obj.put("fecha_detalleficha", String.valueOf(detalleficha.getFecha_detalleficha()));
    
    out.print(obj);
    out.flush();
%>
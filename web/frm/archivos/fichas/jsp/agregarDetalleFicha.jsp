<%@page import="modelos.Servicios"%>
<%@page import="controladores.DetalleFichasControlador"%>
<%@page import="utiles.Utiles"%>
<%@page import="modelos.DetalleFichas"%>
<%@page import="modelos.Pacientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="modelos.Fichas"%>
<%@page import="java.sql.ResultSet"%>
<%
    //int id_detalleficha = Integer.parseInt(request.getParameter("id_detalleficha"));
    int id_ficha = Integer.parseInt(request.getParameter("id_ficha"));
    int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));
    String p_dentaria = request.getParameter("p_dentaria");
    String tec_anestesia = request.getParameter("tec_anestesia");
    String estado_detalleficha = request.getParameter("estado_detalleficha");

    String obs_detalleficha = request.getParameter("obs_detalleficha");
    String medicacion_detalleficha = request.getParameter("medicacion_detalleficha");
    String sfecha_detalleficha = request.getParameter("fecha_detalleficha");
    java.sql.Date fecha_detalleficha = Utiles.stringToSqlDate(sfecha_detalleficha);

    Servicios servicio = new Servicios();
    servicio.setId_servicio(id_servicio);

    Fichas ficha = new Fichas();
    ficha.setId_ficha(id_ficha);

    String tipo = "error";
    String mensaje = "Datos no agregados.";

    DetalleFichas detalleficha = new DetalleFichas();
    detalleficha.setP_dentaria(p_dentaria);
    detalleficha.setTec_anestesia(tec_anestesia);
    detalleficha.setEstado_detalleficha(estado_detalleficha);
    detalleficha.setObs_detalleficha(obs_detalleficha);
    detalleficha.setMedicacion_detalleficha(medicacion_detalleficha);
    detalleficha.setFecha_detalleficha(fecha_detalleficha);

    detalleficha.setFicha(ficha);
    detalleficha.setServicio(servicio);

    if (DetalleFichasControlador.agregar(detalleficha)) {
        tipo = "success";
        mensaje = "Datos agregados";
    }

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();

%>
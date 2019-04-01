package controladores;

//import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DecimalFormat;
import modelos.Fichas;
import modelos.DetalleFichas;
import modelos.Servicios;
import utiles.Conexion;

public class DetalleFichasControlador {

    public static boolean agregar(DetalleFichas detalleficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into detallefichas "
                    + "(id_ficha,estado_detalleficha,id_servicio,"
                    + "obs_detalleficha,medicacion_detalleficha,fecha_detalleficha) "
                    + "values (?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                ps.setInt(1, detalleficha.getFicha().getId_ficha());
                ps.setString(2, detalleficha.getEstado_detalleficha());
                ps.setInt(3, detalleficha.getServicio().getId_servicio());
                ps.setString(4, detalleficha.getObs_detalleficha());
                ps.setString(5, detalleficha.getMedicacion_detalleficha());
                ps.setDate(6, detalleficha.getFecha_detalleficha());
                ps.setString(7, detalleficha.getP_dentaria());
                ps.setString(8, detalleficha.getTec_anestesia());
                ps.executeUpdate();
                ps.close();
                Conexion.getConn().setAutoCommit(false);

                valor = true;
            } catch (SQLException ex) {
                System.out.println("AGREGARDETALLEFICHA--> " + ex.getLocalizedMessage());
                try {
                    Conexion.getConn().rollback();
                } catch (SQLException ex1) {
                    System.out.println("AGREGARDETALLEFICHA--> " + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static DetalleFichas buscarId(DetalleFichas detalleficha) {
        if (Conexion.conectar()) {
            /*String sql = "select * from detallefichas df "
                    + "left join servicios s"
                    + " on df.id_servicio=s.id_servicio"
                    + " where df.id_detalleficha=" + detalleficha.getId_detalleficha();*/

            String sql = "select * from detallefichas df, servicios s , fichas f "
                    + " where "
                    + "df.id_servicio = s.id_servicio"
                    + " and "
                    + "df.id_ficha = f.id_ficha"
                    + " and "
                    + "df.id_detalleficha=" + detalleficha.getId_detalleficha();

            System.out.println("DetalleFichasControlador.BuscarId:--> " + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    detalleficha.setId_detalleficha(rs.getInt("id_detalleficha"));
                    detalleficha.setEstado_detalleficha(rs.getString("estado_detalleficha"));

                    Fichas ficha = new Fichas();
                    ficha.setId_ficha(rs.getInt("id_ficha"));

                    Servicios servicio = new Servicios();
                    servicio.setId_servicio(rs.getInt("id_servicio"));
                    servicio.setNombre_servicio(rs.getString("nombre_servicio"));

                    detalleficha.setFicha(ficha);
                    detalleficha.setServicio(servicio);
                    detalleficha.setP_dentaria(rs.getString("p_dentaria"));
                    detalleficha.setTec_anestesia(rs.getString("tec_anestesia"));
                    detalleficha.setObs_detalleficha(rs.getString("obs_detalleficha"));
                    detalleficha.setMedicacion_detalleficha(rs.getString("medicacion_detalleficha"));
                    detalleficha.setFecha_detalleficha(rs.getDate("fecha_detalleficha"));
                    /*System.out.println("****CON DETALLEFICHA**********");
                    System.out.println("ID_detalleficha : " + detalleficha.getId_detalleficha());
                    System.out.println(" ESTADO: " + detalleficha.getEstado_detalleficha());
                    System.out.println("SERVICIO: " + detalleficha.getServicio().getNombre_servicio());
                    System.out.println("FECHA DF: " + detalleficha.getFecha_detalleficha());
                    System.out.println("**************");
*/
                } else {
                    detalleficha.setId_detalleficha(0);

                    Servicios servicio = new Servicios();
                    servicio.setId_servicio(0);
                    servicio.setNombre_servicio("");

                    detalleficha.setServicio(servicio);
                    detalleficha.setEstado_detalleficha("");
                    detalleficha.setP_dentaria("");
                    detalleficha.setTec_anestesia("");

                    Fichas ficha = new Fichas();
                    ficha.setId_ficha(0);

                    detalleficha.setFicha(ficha);
                    detalleficha.setServicio(servicio);

                    detalleficha.setObs_detalleficha("");
                    detalleficha.setMedicacion_detalleficha("");
                    
                    java.sql.Date hoy_detalle = new java.sql.Date(new java.util.Date().getTime());                    
                    System.out.println("Fecha actual detalle : " + hoy_detalle);
                    detalleficha.setFecha_detalleficha(hoy_detalle);
                }
            } catch (SQLException ex) {
                //System.out.println("BUSCAR ID DETALLEFICHA--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return detalleficha;
    }

    public static String buscarIdFicha(int id) {
        String valor = "";
        if (Conexion.conectar()) {
            try {
               
               String sql = "select * from detallefichas df, servicios s, fichas f"
                        + " where "
                        + "df.id_ficha = f.id_ficha"
                        + " and "
                        + "df.id_servicio = s.id_servicio"
                        + " and "
                        + "df.id_ficha=" + id 
                        + " order by id_detalleficha";
               
                System.out.println("DetallesFichasControlador.buscarIdFicha--> " + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    //DecimalFormat df = new DecimalFormat( "#,###.00" );
                    String tabla = "";
                    //BigDecimal total = BigDecimal.ZERO;
                    while (rs.next()) {
                        // BigDecimal estado = rs.getBigDecimal("estado_detallepedido");
                        //total = total.add(estado);
                        //System.out.println("total"+total);
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_detalleficha") + "</td>"
                                + "<td>" + rs.getString("id_servicio") + "</td>"
                                
                                + "<td>" + rs.getString("nombre_servicio") + "</td>"
                                + "<td>" + rs.getString("tec_anestesia") + "</td>"
                                + "<td>" + rs.getString("estado_detalleficha") + "</td>"
                                + "<td>" + rs.getDate("fecha_detalleficha") + "</td>"
                                //+ "<td class='centrado'>" + df.format(estado) + "</td>"
                                + "<td class='centrado'>"
                                + "<button onclick='editarLinea(" + rs.getString("id_detalleficha") + ")'"
                                + " type='button' class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-pencil'>"
                                + "</span></button></td>"                             
                                + "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td  colspan=6>No existen registros ...</td></tr>";
                    } else {
                        //tabla += "<tr><td colspan=3>TOTAL</td><td class='centrado'>"+df.format(total)+"</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return valor;
    }

    // public static String


    public static boolean modificar(DetalleFichas detalleficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update detallefichas set "
                    + "id_ficha="+ detalleficha.getFicha().getId_ficha()+", "
                    + "estado_detalleficha='" + detalleficha.getEstado_detalleficha() +"',"
                    + "id_servicio='"+ detalleficha.getServicio().getId_servicio() +"',"
                    + "obs_detalleficha='"+ detalleficha.getObs_detalleficha() +"',"
                    + "medicacion_detalleficha='"+ detalleficha.getMedicacion_detalleficha() +"',"
                    + "fecha_detalleficha='"+ detalleficha.getFecha_detalleficha() +"',"                   
                    + "p_dentaria='"+ detalleficha.getP_dentaria() +"',"     
                    + "tec_anestesia='"+ detalleficha.getTec_anestesia()+"'" 
                    + " where "
                    + "id_detalleficha= " + detalleficha.getId_detalleficha();
            System.out.println("*****");
            System.out.println("MODIFICAR DETALLE " + sql);
            System.out.println("*****");
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        return valor;

    }

    public static boolean eliminar(DetalleFichas detalleficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from detallefichas where id_detalleficha=?";
            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                ps.setInt(1, detalleficha.getId_detalleficha());
                ps.executeUpdate();
                ps.close();
                Conexion.getConn().setAutoCommit(false);
                valor = true;
            } catch (SQLException ex) {
                System.out.println("ELIMINAR---->" + ex.getLocalizedMessage());
                try {
                    Conexion.getConn().rollback();
                } catch (SQLException ex1) {
                    System.out.println("ELIMINAR--->" + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static boolean eliminarServicioFicha(Fichas ficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from detallefichas where id_ficha=?";
            try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                ps.setInt(1, ficha.getId_ficha());
                ps.executeUpdate();
                ps.close();
                Conexion.getConn().commit();
                System.out.println("ELIMINAR SERVICIO FICHA--->" + ficha.getId_ficha());
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--->" + ex.getLocalizedMessage());
                try {
                    Conexion.getConn().rollback();
                } catch (SQLException ex1) {
                    System.out.println("--->" + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }

}

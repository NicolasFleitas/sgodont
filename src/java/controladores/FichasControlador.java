package controladores;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Fichas;
import utiles.Conexion;
import utiles.Utiles;
import modelos.Doctores;
import modelos.Pacientes;
import modelos.Sexos;

public class FichasControlador {

    public static boolean agregar(Fichas ficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into fichas(nombre_ficha, fecha_ficha, id_doctor, id_paciente,"
                    + "presion_alta,presion_baja,alergias_paciente,vacunas_paciente,"
                    + "alteraciones_sistem,hab_nocivos,medicacion_actual,"
                    + "tiene_embarazo,tiempo_gestacion,esta_amamantando,"
                    + "medico_tratante,medico_tratante_nro,"
                    + "fiebre_reumatica,desmayos,marcapasos_cardiacos,"
                    + "trat_radio_quimio,tienetuvo_especificar)"
                    + " values('" + ficha.getNombre_ficha() + "','"
                    + ficha.getFecha_ficha() + "','"
                    + ficha.getDoctor().getId_doctor() + "','"
                    + ficha.getPaciente().getId_paciente() + "','"
                    + ficha.getPresion_alta() + "','"
                    + ficha.getPresion_baja() + "','"
                    + ficha.getAlergias_paciente() + "','"
                    + ficha.getVacunas_paciente() + "','"
                    + ficha.getAlteraciones_sistem() + "','"
                    + ficha.getHab_nocivos() + "','"
                    + ficha.getMedicacion_actual() + "','"
                    
                    + ficha.getTiene_embarazo() + "','"
                    + ficha.getTiempo_gestacion() + "','"
                    + ficha.getEsta_amamantando() + "','"
                    + ficha.getMedico_tratante() + "','"
                    + ficha.getMedico_tratante_nro()+ "','"
                    
                    + ficha.getFiebre_reumatica() + "','"
                    + ficha.getDesmayos() + "','"
                    + ficha.getMarcapasos_cardiacos()+ "','"
                    + ficha.getTrat_radio_quimio()+ "','"
                    + ficha.getTienetuvo_especificar()+ "')";
                    
            
            System.out.println("SQL AGREGAR: "+ sql);

            try {
                Conexion.getSt().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset = Conexion.getSt().getGeneratedKeys();
                if (keyset.next()) {
                    int id_ficha = keyset.getInt(1);
                    ficha.setId_ficha(id_ficha);
                    Conexion.getConn().setAutoCommit(false);
                }
                valor = true;
            } catch (SQLException ex) {
                System.out.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static boolean facturar(Fichas ficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "select * from fichas f, doctores d, pacientes p, detallefichas df, servicios s  where f.id_doctor = d.id_doctor and f.id_paciente = p.id_paciente  and df.id_ficha = f.id_ficha and s.id_servicio = df.id_servicio and f.id_ficha =" + ficha.getId_ficha() + "";
            System.out.println("FACTURAR---->" + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) { //Si encuentra el id traerá todos los datos

                    String sql1 = "insert into facturas(id_paciente, fecha_factura)"
                            + " values('" + ficha.getPaciente().getId_paciente() + "','"
                        
                            + ficha.getFecha_ficha() + ")";
                    System.out.println("INSERT-->" + sql1);
                    try {
                        Conexion.getSt().executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
                        ResultSet keyset = Conexion.getSt().getGeneratedKeys();
                        if (keyset.next()) {
                            int id_factura = keyset.getInt(1);
                            ficha.setId_ficha(id_factura);
                            Conexion.getConn().setAutoCommit(false);
                            
                            
                            
                            
                        }
                        valor = true;
                    } catch (SQLException ex) {
                        System.out.println("Error:" + ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }

        }
        return valor;
    }

    public static Fichas buscarId(Fichas ficha) {
        if (Conexion.conectar()) {
            String sql = "select * from fichas f, doctores d, pacientes p, sexos s"
                    + " where "
                    + "f.id_doctor = d.id_doctor"
                    + " and "
                    + "f.id_paciente = p.id_paciente"
                    + " and "
                    + "p.id_sexo = s.id_sexo"
                    + " and "
                    + "id_ficha =" + ficha.getId_ficha() + "";
            System.out.println("ControladorFichasbuscarId-->" + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) { //Si encuentra el id traerá todos los datos
                    Doctores doctor = new Doctores();
                    Pacientes paciente = new Pacientes();

                    ficha.setId_ficha(rs.getInt("id_ficha"));
                    ficha.setNombre_ficha(rs.getString("nombre_ficha"));
                    ficha.setFecha_ficha(rs.getDate("fecha_ficha"));

                    doctor.setId_doctor(rs.getInt("id_doctor"));
                    doctor.setNombre_doctor(rs.getString("nombre_doctor"));

                    paciente.setId_paciente(rs.getInt("id_paciente"));
                    paciente.setNombre_paciente(rs.getString("nombre_paciente"));  
                    paciente.setApellido_paciente(rs.getString("apellido_paciente"));  
                    Sexos sexo = new Sexos();
                    sexo.setNombre_sexo(rs.getString("nombre_sexo"));
                    paciente.setSexo(sexo);

                    ficha.setDoctor(doctor);
                    ficha.setPaciente(paciente);
                    
                    ficha.setPresion_alta(rs.getString("presion_alta"));
                    ficha.setPresion_baja(rs.getString("presion_baja"));
                    ficha.setFiebre_reumatica(rs.getString("fiebre_reumatica"));
                    ficha.setDesmayos(rs.getString("desmayos"));
                    ficha.setMarcapasos_cardiacos(rs.getString("marcapasos_cardiacos"));
                    ficha.setTrat_radio_quimio(rs.getString("trat_radio_quimio"));
                    ficha.setTienetuvo_especificar(rs.getString("tienetuvo_especificar"));
                    ficha.setAlergias_paciente(rs.getString("alergias_paciente"));
                    ficha.setVacunas_paciente(rs.getString("vacunas_paciente"));
                    ficha.setAlteraciones_sistem(rs.getString("alteraciones_sistem"));
                    ficha.setHab_nocivos(rs.getString("hab_nocivos"));
                    ficha.setMedicacion_actual(rs.getString("medicacion_actual"));
                    
                    ficha.setTiene_embarazo(rs.getString("tiene_embarazo"));
                    ficha.setTiempo_gestacion(rs.getString("tiempo_gestacion"));
                    ficha.setEsta_amamantando(rs.getString("esta_amamantando"));
                    ficha.setMedico_tratante(rs.getString("medico_tratante"));
                    ficha.setMedico_tratante_nro(rs.getString("medico_tratante_nro"));
                    
                    
                } else {
                    Doctores doctor = new Doctores();
                    Pacientes paciente = new Pacientes();
                    paciente.setId_paciente(0);
                    paciente.setNombre_paciente("");
                    paciente.setApellido_paciente("");
                    Sexos sexo = new Sexos();
                    sexo.setNombre_sexo("");
                    paciente.setSexo(sexo);
                    
                    
                    //Date fecha = new Date();
                    java.sql.Date hoy = new java.sql.Date(new java.util.Date().getTime());                    
                    System.out.println("FECHA HOY : " + hoy);
                    ficha.setId_ficha(0);
                    ficha.setNombre_ficha("");
                    ficha.setFecha_ficha(hoy);
                    
                    paciente.setId_paciente(0);
                    paciente.setNombre_paciente("");
                    paciente.setSexo(sexo);
                    ficha.setDoctor(doctor);
                    ficha.setPaciente(paciente);
                    
                    ficha.setPresion_alta("");
                    ficha.setPresion_baja("");
                    ficha.setFiebre_reumatica("");
                    ficha.setDesmayos("");
                    ficha.setMarcapasos_cardiacos("");
                    ficha.setTrat_radio_quimio("");
                    ficha.setTienetuvo_especificar("");
                    
                    ficha.setAlergias_paciente("");
                    ficha.setVacunas_paciente("");
                    ficha.setAlteraciones_sistem("");
                    ficha.setHab_nocivos("");
                    ficha.setMedicacion_actual("");
                    
                    ficha.setTiene_embarazo("");
                    ficha.setTiempo_gestacion("");
                    ficha.setEsta_amamantando("");
                    ficha.setMedico_tratante("");
                    ficha.setMedico_tratante_nro("");
                    
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return ficha;
    }

    public static String buscarNombre(String nombre, int pagina) {

        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {

            try {
                System.out.println(nombre);
                String sql = "select * from fichas f, pacientes p where f.id_paciente = p.id_paciente and   upper(nombre_paciente) like '%"
                        + nombre.toUpperCase() + "%'"
                        + "order by ci_paciente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;

                System.out.println("BUSCARNOMBRE--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_ficha") + "</td>"
                                + "<td>" + rs.getString("ci_paciente") + "</td>"
                                + "<td>" + rs.getString("fecha_ficha") + "</td>"
                                + "<td>" + rs.getString("nombre_paciente") + "</td>"
                                + "<td>" + rs.getString("apellido_paciente") + "</td>"
                                //+ "<td>" + rs.getString("observacion_ficha") + "</td>"

                                + "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2> No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error: " + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static boolean modificar(Fichas ficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update fichas set "
                    + "nombre_ficha='" + ficha.getNombre_ficha() + "',"
                    + "fecha_ficha='" + ficha.getFecha_ficha() + "',"
                    + "id_doctor='" + ficha.getDoctor().getId_doctor() + "',"
                    + "id_paciente='" + ficha.getPaciente().getId_paciente() + "',"
                    + "presion_alta='" + ficha.getPresion_alta() + "',"
                    + "presion_baja='" + ficha.getPresion_baja()+ "',"
                    + "fiebre_reumatica='" + ficha.getFiebre_reumatica() + "',"
                    + "desmayos='" + ficha.getDesmayos()+ "',"
                    + "marcapasos_cardiacos='" + ficha.getMarcapasos_cardiacos()+ "',"
                    + "trat_radio_quimio='" + ficha.getTrat_radio_quimio()+ "',"
                    + "tienetuvo_especificar='" + ficha.getTienetuvo_especificar()+ "',"
                    + "alergias_paciente='" + ficha.getAlergias_paciente() + "',"
                    + "vacunas_paciente='" + ficha.getVacunas_paciente() + "'," 
                    + "alteraciones_sistem='" + ficha.getAlteraciones_sistem()+ "',"
                    + "hab_nocivos='" + ficha.getHab_nocivos()+ "',"
                    + "medicacion_actual='" + ficha.getMedicacion_actual() + "'," 
                    + "tiene_embarazo='" + ficha.getTiene_embarazo()+ "'," 
                    + "tiempo_gestacion='" + ficha.getTiempo_gestacion() + "',"
                    + "esta_amamantando='" + ficha.getEsta_amamantando() + "',"
                    + "medico_tratante='" + ficha.getMedico_tratante() + "',"
                    + "medico_tratante_nro='" + ficha.getMedico_tratante_nro()+ "'" 
                    + " where "
                    + "id_ficha=" + ficha.getId_ficha();
            System.out.println("MODIFICAR FICHA-->"+ sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        return valor;
    }

    public static boolean eliminar(Fichas ficha) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from fichas where id_ficha=" + ficha.getId_ficha();
            System.out.println("ELIMINAR FICHA SQL->" + sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.out.println("Error:" + ex);
            }
        }
        return valor;
    }
}

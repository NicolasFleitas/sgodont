
package controladores;
import modelos.Pacientes;
import modelos.Sexos;
import utiles.Conexion;
import utiles.Utiles;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;


public class PacientesControlador {
    
    
    
     public static Pacientes buscarCedula(Pacientes paciente) {
        if (Conexion.conectar()) {
            String sql = "select * from pacientes where ci_paciente='" + paciente.getCi_paciente()+ "'";
            System.out.println(sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    paciente.setCi_paciente(0);
                } else {
                    paciente.setCi_paciente(paciente.getCi_paciente());
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        return paciente;
    }
    
    public static boolean agregar(Pacientes paciente){
        boolean valor = false;
        if (Conexion.conectar()){
            String sql = "insert into "
                    + "pacientes (ci_paciente,nombre_paciente,apellido_paciente,"
                    + "fechanac_paciente,altura_paciente,peso_paciente,"
                    + "direccion_paciente,telefono_paciente,celular_paciente,"
                    + "email_paciente,profesion_paciente,lugar_trabajo,seguro_paciente) " 
                    + "values ('" + paciente.getCi_paciente()+ "','"
                    + paciente.getNombre_paciente()+ "','"
                    + paciente.getApellido_paciente()+ "','"
                    + paciente.getFechanac_paciente()+ "','"                    
                    + paciente.getAltura_paciente()+ "','"
                    + paciente.getPeso_paciente()+ "','"
                    + paciente.getDireccion_paciente() + "','" 
                    + paciente.getTelefono_paciente()+ "','" 
                    + paciente.getCelular_paciente()+ "','"
                    + paciente.getEmail_paciente()+ "','" 
                    + paciente.getProfesion_paciente()+ "','" 
                    + paciente.getLugar_trabajo()+ "','" 
                    + paciente.getSeguro_paciente()+ "')";
                  System.out.println("sql"+ sql);  
            try {
                Conexion.getSt().executeUpdate(sql);
                
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(PacientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        return valor;        
    }
    
    public static boolean modificar(Pacientes paciente){
        boolean valor = false;
        if (Conexion.conectar()){ 
            String sql = "update pacientes set ci_paciente='" + paciente.getCi_paciente()+ "',"
                    + "nombre_paciente='" + paciente.getNombre_paciente()+ "',"
                    + "apellido_paciente='" + paciente.getApellido_paciente() + "',"
                    + "fechanac_paciente='" + paciente.getFechanac_paciente()+ "',"
                    + "altura_paciente='" + paciente.getAltura_paciente()+ "',"                    
                    + "peso_paciente='" + paciente.getPeso_paciente()+ "',"
                    + "direccion_paciente='" + paciente.getDireccion_paciente()+ "',"
                    + "telefono_paciente='" + paciente.getTelefono_paciente() +"',"
                    + "celular_paciente='" + paciente.getCelular_paciente() + "',"
                    + "email_paciente='" + paciente.getEmail_paciente()+ "',"
                    + "profesion_paciente='" + paciente.getProfesion_paciente()+ "',"
                    + "lugar_trabajo='" + paciente.getLugar_trabajo() + "',"
                    + "seguro_paciente='" + paciente.getSeguro_paciente()+ "'"
                    + " where id_paciente=" + paciente.getId_paciente();
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(PacientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        
        return valor;
        
    }
    
    public static boolean eliminar(Pacientes paciente){
        boolean valor = false;
        if (Conexion.conectar()){
            String sql = "delete from pacientes where id_paciente=" + paciente.getId_paciente();
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(PacientesControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        
        return valor;
        
    }
    
    public static Pacientes buscarId(Pacientes paciente) {
        if (Conexion.conectar()){
            String sql = "select * from pacientes"
                    + " where "
                    + "id_paciente ='"+paciente.getId_paciente()+"'";
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()){
                    paciente.setId_paciente(rs.getInt("id_paciente"));
                    paciente.setCi_paciente(rs.getInt("ci_paciente"));
                    paciente.setNombre_paciente(rs.getString("nombre_paciente"));
                    paciente.setApellido_paciente(rs.getString("apellido_paciente"));
                    paciente.setFechanac_paciente(rs.getDate("fechanac_paciente"));  
                    
                    paciente.setAltura_paciente(rs.getString("altura_paciente"));
                    paciente.setPeso_paciente(rs.getInt("peso_paciente"));
                    
                    paciente.setDireccion_paciente(rs.getString("direccion_paciente"));
                    paciente.setTelefono_paciente(rs.getString("telefono_paciente"));  
                    paciente.setCelular_paciente(rs.getString("celular_paciente"));
                    paciente.setEmail_paciente(rs.getString("email_paciente"));
                    paciente.setProfesion_paciente(rs.getString("profesion_paciente"));
                    
                    paciente.setLugar_trabajo(rs.getString("lugar_trabajo"));
                    paciente.setSeguro_paciente(rs.getString("seguro_paciente"));    
                    
                    /*Sexos sexo = new Sexos();
                    sexo.setId_sexo(rs.getInt("id_sexo"));
                    sexo.setNombre_sexo(rs.getString("nombre_sexo"));
                    */
                  //  paciente.setSexo(sexo);
                } 
                
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        return paciente;
    }
    public static String buscarNombre(String nombre, int pagina) {
      
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            
            try {
                  System.out.println(nombre);
                String sql = "select * from pacientes where  upper(nombre_paciente) like '%" +
                        nombre.toUpperCase() + "%'"
                        + "order by id_paciente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
              
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_paciente") + "</td>"
                                + "<td>" + rs.getString("ci_paciente") + "</td>"
                                + "<td>" + rs.getString("nombre_paciente") + "</td>"
                                + "<td>" + rs.getString("apellido_paciente") + "</td>"
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
    
    
    // 
    
}

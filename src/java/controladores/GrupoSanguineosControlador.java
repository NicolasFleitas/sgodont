
package controladores;

import modelos.GrupoSanguineos;
import utiles.Conexion;
import utiles.Utiles;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;


public class GrupoSanguineosControlador {
    
    
     public static boolean agregar(GrupoSanguineos gruposang){
        boolean valor = false;
        if (Conexion.conectar()){
            String sql = "insert into gruposanguineos (nombre_gruposang)" 
                    + "values ('" + gruposang.getNombre_gruposang() + "')";
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(GrupoSanguineosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        
        return valor;
        
    }
     
     public static boolean modificar(GrupoSanguineos gruposang){
        boolean valor = false;
        if (Conexion.conectar()){ 
            String sql = "update gruposanguineos set nombre_gruposang='" + gruposang.getNombre_gruposang() + "'"
                    + " where id_gruposang=" + gruposang.getId_gruposang();
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(GrupoSanguineosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        
        return valor;
        
    }
    
    public static boolean eliminar(GrupoSanguineos gruposang){
        boolean valor = false;
        if (Conexion.conectar()){
            String sql = "delete from gruposanguineos where id_gruposang=" + gruposang.getId_gruposang();
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                
                valor = true;
                
            } catch (SQLException ex) {
                Logger.getLogger(GrupoSanguineosControlador.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
        
        return valor;
        
    }
    public static GrupoSanguineos buscarId(GrupoSanguineos gruposang) {
        if (Conexion.conectar()){
            String sql = "select * from gruposanguineos where id_gruposang ='"+gruposang.getId_gruposang()+"'";
            
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()){
                    gruposang.setId_gruposang(rs.getInt("id_gruposang"));
                    gruposang.setNombre_gruposang(rs.getString("nombre_gruposang"));
                } else {
                    gruposang.setId_gruposang(0);
                    gruposang.setNombre_gruposang("");
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
        }
        return gruposang;
    }
    
    public static String buscarNombre(String nombre, int pagina) {
      
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            
            try {
                  System.out.println(nombre);
                String sql = "select * from gruposanguineos where upper(nombre_gruposang) like '%" +
                        nombre.toUpperCase() + "%'"
                        + "order by id_gruposang offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
              
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_gruposang") + "</td>"
                                + "<td>" + rs.getString("nombre_gruposang") + "</td>"
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
    
    
    
    
    
}

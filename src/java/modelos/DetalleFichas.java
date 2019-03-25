
package modelos;

import java.sql.Date;

public class DetalleFichas {
    int id_detalleficha;
    Servicios servicio;
    Fichas ficha;
    String estado_detalleficha;
    String obs_detalleficha;
    String medicacion_detalleficha;
    Date fecha_detalleficha;
    

    public DetalleFichas() {
    }

    public DetalleFichas(int id_detalleficha, Servicios servicio, Fichas ficha, String estado_detalleficha, String obs_detalleficha, String medicacion_detalleficha, Date fecha_detalleficha) {
        this.id_detalleficha = id_detalleficha;
        this.servicio = servicio;
        this.ficha = ficha;
        this.estado_detalleficha = estado_detalleficha;
        this.obs_detalleficha = obs_detalleficha;
        this.medicacion_detalleficha = medicacion_detalleficha;
        this.fecha_detalleficha = fecha_detalleficha;
    }

    public String getObs_detalleficha() {
        return obs_detalleficha;
    }

    public void setObs_detalleficha(String obs_detalleficha) {
        this.obs_detalleficha = obs_detalleficha;
    }

    public String getMedicacion_detalleficha() {
        return medicacion_detalleficha;
    }

    public void setMedicacion_detalleficha(String medicacion_detalleficha) {
        this.medicacion_detalleficha = medicacion_detalleficha;
    }

    public Date getFecha_detalleficha() {
        return fecha_detalleficha;
    }

    public void setFecha_detalleficha(Date fecha_detalleficha) {
        this.fecha_detalleficha = fecha_detalleficha;
    }

  
    public int getId_detalleficha() {
        return id_detalleficha;
    }

    public void setId_detalleficha(int id_detalleficha) {
        this.id_detalleficha = id_detalleficha;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public Fichas getFicha() {
        return ficha;
    }

    public void setFicha(Fichas ficha) {
        this.ficha = ficha;
    }

    public String getEstado_detalleficha() {
        return estado_detalleficha;
    }

    public void setEstado_detalleficha(String estado_detalleficha) {
        this.estado_detalleficha = estado_detalleficha;
    }

    
   

    
    

   
    
    
    
}

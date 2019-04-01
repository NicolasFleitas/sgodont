
package modelos;

import java.sql.Date;

public class DetalleFichas {
    int id_detalleficha;
    private Servicios servicio;
    private Fichas ficha;
    private String estado_detalleficha;
    private String obs_detalleficha;
    private String medicacion_detalleficha;
    private Date fecha_detalleficha;
    private String p_dentaria;
    private String tec_anestesia;
    
    

    public DetalleFichas() {
    }

    public DetalleFichas(int id_detalleficha, Servicios servicio, Fichas ficha, String estado_detalleficha, String obs_detalleficha, String medicacion_detalleficha, Date fecha_detalleficha, String p_dentaria, String tec_anestesia) {
        this.id_detalleficha = id_detalleficha;
        this.servicio = servicio;
        this.ficha = ficha;
        this.estado_detalleficha = estado_detalleficha;
        this.obs_detalleficha = obs_detalleficha;
        this.medicacion_detalleficha = medicacion_detalleficha;
        this.fecha_detalleficha = fecha_detalleficha;
        this.p_dentaria = p_dentaria;
        this.tec_anestesia = tec_anestesia;
    }

    public String getTec_anestesia() {
        return tec_anestesia;
    }

    public void setTec_anestesia(String tec_anestesia) {
        this.tec_anestesia = tec_anestesia;
    }


    public String getP_dentaria() {
        return p_dentaria;
    }

    public void setP_dentaria(String p_dentaria) {
        this.p_dentaria = p_dentaria;
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

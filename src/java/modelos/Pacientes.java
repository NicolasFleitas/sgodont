
package modelos;
import java.sql.Date;

public class Pacientes {
    private int id_paciente;
    private int ci_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private Date fechanac_paciente;
    private String altura_paciente;
    private int peso_paciente;
    private String direccion_paciente;
    private String telefono_paciente;
    private String celular_paciente;
    private String email_paciente;
    private String profesion_paciente;
    private String lugar_trabajo;
    private String seguro_paciente;
    private Sexos sexo;
    private GrupoSanguineos gruposang;
    
    public Pacientes() {
        
    }  

    public Pacientes(int id_paciente, int ci_paciente, String nombre_paciente, String apellido_paciente, Date fechanac_paciente, String altura_paciente, int peso_paciente, String direccion_paciente, String telefono_paciente, String celular_paciente, String email_paciente, String profesion_paciente, String lugar_trabajo, String seguro_paciente, Sexos sexo, GrupoSanguineos gruposang) {
        this.id_paciente = id_paciente;
        this.ci_paciente = ci_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.fechanac_paciente = fechanac_paciente;
        this.altura_paciente = altura_paciente;
        this.peso_paciente = peso_paciente;
        this.direccion_paciente = direccion_paciente;
        this.telefono_paciente = telefono_paciente;
        this.celular_paciente = celular_paciente;
        this.email_paciente = email_paciente;
        this.profesion_paciente = profesion_paciente;
        this.lugar_trabajo = lugar_trabajo;
        this.seguro_paciente = seguro_paciente;
        this.sexo = sexo;
        this.gruposang = gruposang;
    }   

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getCi_paciente() {
        return ci_paciente;
    }

    public void setCi_paciente(int ci_paciente) {
        this.ci_paciente = ci_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public Date getFechanac_paciente() {
        return fechanac_paciente;
    }

    public void setFechanac_paciente(Date fechanac_paciente) {
        this.fechanac_paciente = fechanac_paciente;
    }

    public String getAltura_paciente() {
        return altura_paciente;
    }

    public void setAltura_paciente(String altura_paciente) {
        this.altura_paciente = altura_paciente;
    }

    public int getPeso_paciente() {
        return peso_paciente;
    }

    public void setPeso_paciente(int peso_paciente) {
        this.peso_paciente = peso_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getCelular_paciente() {
        return celular_paciente;
    }

    public void setCelular_paciente(String celular_paciente) {
        this.celular_paciente = celular_paciente;
    }
    
    

    public String getEmail_paciente() {
        return email_paciente;
    }

    public void setEmail_paciente(String email_paciente) {
        this.email_paciente = email_paciente;
    }

    public String getProfesion_paciente() {
        return profesion_paciente;
    }

    public void setProfesion_paciente(String profesion_paciente) {
        this.profesion_paciente = profesion_paciente;
    }

    public String getLugar_trabajo() {
        return lugar_trabajo;
    }

    public void setLugar_trabajo(String lugar_trabajo) {
        this.lugar_trabajo = lugar_trabajo;
    }

    public String getSeguro_paciente() {
        return seguro_paciente;
    }

    public void setSeguro_paciente(String seguro_paciente) {
        this.seguro_paciente = seguro_paciente;
    }

    public Sexos getSexo() {
        return sexo;
    }

    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }

    public GrupoSanguineos getGruposang() {
        return gruposang;
    }

    public void setGruposang(GrupoSanguineos gruposang) {
        this.gruposang = gruposang;
    }
    
     
}

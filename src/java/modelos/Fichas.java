package modelos;
import java.sql.Date;

public class Fichas {
    private int id_ficha;
    private Doctores doctor;
    private Pacientes paciente;
    private String nombre_ficha;
    private Date fecha_ficha;
    private String presion_alta;
    private String presion_baja;
    private String alergias_paciente;
    private String vacunas_paciente;
    private String alteraciones_sistem;
    private String hab_nocivos;
    private String medicacion_actual;

    public Fichas() {
    }

    public Fichas(int id_ficha, Doctores doctor, Pacientes paciente, String nombre_ficha, Date fecha_ficha, String presion_alta, String presion_baja, String alergias_paciente, String vacunas_paciente, String alteraciones_sistem, String hab_nocivos, String medicacion_actual) {
        this.id_ficha = id_ficha;
        this.doctor = doctor;
        this.paciente = paciente;
        this.nombre_ficha = nombre_ficha;
        this.fecha_ficha = fecha_ficha;
        this.presion_alta = presion_alta;
        this.presion_baja = presion_baja;
        this.alergias_paciente = alergias_paciente;
        this.vacunas_paciente = vacunas_paciente;
        this.alteraciones_sistem = alteraciones_sistem;
        this.hab_nocivos = hab_nocivos;
        this.medicacion_actual = medicacion_actual;
    }

    public String getAlteraciones_sistem() {
        return alteraciones_sistem;
    }

    public void setAlteraciones_sistem(String alteraciones_sistem) {
        this.alteraciones_sistem = alteraciones_sistem;
    }

    public String getMedicacion_actual() {
        return medicacion_actual;
    }

    public void setMedicacion_actual(String medicacion_actual) {
        this.medicacion_actual = medicacion_actual;
    }
    
    public String getHab_nocivos() {
        return hab_nocivos;
    }

    public void setHab_nocivos(String hab_nocivos) {
        this.hab_nocivos = hab_nocivos;
    }

    public String getPresion_baja() {
        return presion_baja;
    }

    public void setPresion_baja(String presion_baja) {
        this.presion_baja = presion_baja;
    }

   

    public String getPresion_alta() {
        return presion_alta;
    }

    public void setPresion_alta(String presion_alta) {
        this.presion_alta = presion_alta;
    }

    public String getAlergias_paciente() {
        return alergias_paciente;
    }

    public void setAlergias_paciente(String alergias_paciente) {
        this.alergias_paciente = alergias_paciente;
    }

    public String getVacunas_paciente() {
        return vacunas_paciente;
    }

    public void setVacunas_paciente(String vacunas_paciente) {
        this.vacunas_paciente = vacunas_paciente;
    }
    
    public int getId_ficha() {
        return id_ficha;
    }

    public void setId_ficha(int id_ficha) {
        this.id_ficha = id_ficha;
    }

    public Doctores getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctores doctor) {
        this.doctor = doctor;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public String getNombre_ficha() {
        return nombre_ficha;
    }

    public void setNombre_ficha(String nombre_ficha) {
        this.nombre_ficha = nombre_ficha;
    }

    public Date getFecha_ficha() {
        return fecha_ficha;
    }

    public void setFecha_ficha(Date fecha_ficha) {
        this.fecha_ficha = fecha_ficha;
    }

   
    
    
}

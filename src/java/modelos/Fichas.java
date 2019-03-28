package modelos;
import java.sql.Date;

public class Fichas {
    private int id_ficha;
    private Doctores doctor;
    private Pacientes paciente;
    private String nombre_ficha;
    private Date fecha_ficha;
    
    private String alergias_paciente;
    private String vacunas_paciente;
    private String alteraciones_sistem;
    private String hab_nocivos;
    private String medicacion_actual;
    private String tiene_embarazo;
    private String tiempo_gestacion;
    private String esta_amamantando;
    private String medico_tratante;
    private String medico_tratante_nro;
    /*TieneTuvo*/
    private String presion_alta;
    private String presion_baja;
    private String fiebre_reumatica;
    private String desmayos;
    private String marcapasos_cardiacos;
    private String trat_radio_quimio;
    private String tienetuvo_especificar;
    private String ataques_cardiacos;
    private String sangrado_excesivo;
    private String moretones_inst;
    private String asma_rinitis;
    private String farmaco_especificar;
    /*FinTieneTuvo*/
    public Fichas() {
    }

    public Fichas(int id_ficha, Doctores doctor, Pacientes paciente, String nombre_ficha, Date fecha_ficha, String alergias_paciente, String vacunas_paciente, String alteraciones_sistem, String hab_nocivos, String medicacion_actual, String tiene_embarazo, String tiempo_gestacion, String esta_amamantando, String medico_tratante, String medico_tratante_nro, String presion_alta, String presion_baja, String fiebre_reumatica, String desmayos, String marcapasos_cardiacos, String trat_radio_quimio, String tienetuvo_especificar, String ataques_cardiacos, String sangrado_excesivo, String moretones_inst, String asma_rinitis, String farmaco_especificar) {
        this.id_ficha = id_ficha;
        this.doctor = doctor;
        this.paciente = paciente;
        this.nombre_ficha = nombre_ficha;
        this.fecha_ficha = fecha_ficha;
        this.alergias_paciente = alergias_paciente;
        this.vacunas_paciente = vacunas_paciente;
        this.alteraciones_sistem = alteraciones_sistem;
        this.hab_nocivos = hab_nocivos;
        this.medicacion_actual = medicacion_actual;
        this.tiene_embarazo = tiene_embarazo;
        this.tiempo_gestacion = tiempo_gestacion;
        this.esta_amamantando = esta_amamantando;
        this.medico_tratante = medico_tratante;
        this.medico_tratante_nro = medico_tratante_nro;
        this.presion_alta = presion_alta;
        this.presion_baja = presion_baja;
        this.fiebre_reumatica = fiebre_reumatica;
        this.desmayos = desmayos;
        this.marcapasos_cardiacos = marcapasos_cardiacos;
        this.trat_radio_quimio = trat_radio_quimio;
        this.tienetuvo_especificar = tienetuvo_especificar;
        this.ataques_cardiacos = ataques_cardiacos;
        this.sangrado_excesivo = sangrado_excesivo;
        this.moretones_inst = moretones_inst;
        this.asma_rinitis = asma_rinitis;
        this.farmaco_especificar = farmaco_especificar;
    }

    public String getAtaques_cardiacos() {
        return ataques_cardiacos;
    }

    public void setAtaques_cardiacos(String ataques_cardiacos) {
        this.ataques_cardiacos = ataques_cardiacos;
    }

    public String getSangrado_excesivo() {
        return sangrado_excesivo;
    }

    public void setSangrado_excesivo(String sangrado_excesivo) {
        this.sangrado_excesivo = sangrado_excesivo;
    }

    public String getMoretones_inst() {
        return moretones_inst;
    }

    public void setMoretones_inst(String moretones_inst) {
        this.moretones_inst = moretones_inst;
    }

    public String getAsma_rinitis() {
        return asma_rinitis;
    }

    public void setAsma_rinitis(String asma_rinitis) {
        this.asma_rinitis = asma_rinitis;
    }

    public String getFarmaco_especificar() {
        return farmaco_especificar;
    }

    public void setFarmaco_especificar(String farmaco_especificar) {
        this.farmaco_especificar = farmaco_especificar;
    }

 
    public String getFiebre_reumatica() {
        return fiebre_reumatica;
    }

    public void setFiebre_reumatica(String fiebre_reumatica) {
        this.fiebre_reumatica = fiebre_reumatica;
    }

    public String getDesmayos() {
        return desmayos;
    }
    
    public void setDesmayos(String desmayos) {
        this.desmayos = desmayos;
    }
    
    public String getMarcapasos_cardiacos() {
        return marcapasos_cardiacos;
    }

    public void setMarcapasos_cardiacos(String marcapasos_cardiacos) {
        this.marcapasos_cardiacos = marcapasos_cardiacos;
    }

    public String getTrat_radio_quimio() {
        return trat_radio_quimio;
    }

    public void setTrat_radio_quimio(String trat_radio_quimio) {
        this.trat_radio_quimio = trat_radio_quimio;
    }

    public String getTienetuvo_especificar() {
        return tienetuvo_especificar;
    }

    public void setTienetuvo_especificar(String tienetuvo_especificar) {
        this.tienetuvo_especificar = tienetuvo_especificar;
    }

   
    public String getTiene_embarazo() {
        return tiene_embarazo;
    }

    public void setTiene_embarazo(String tiene_embarazo) {
        this.tiene_embarazo = tiene_embarazo;
    }

    public String getTiempo_gestacion() {
        return tiempo_gestacion;
    }

    public void setTiempo_gestacion(String tiempo_gestacion) {
        this.tiempo_gestacion = tiempo_gestacion;
    }

    public String getEsta_amamantando() {
        return esta_amamantando;
    }

    public void setEsta_amamantando(String esta_amamantando) {
        this.esta_amamantando = esta_amamantando;
    }

    public String getMedico_tratante() {
        return medico_tratante;
    }

    public void setMedico_tratante(String medico_tratante) {
        this.medico_tratante = medico_tratante;
    }

    public String getMedico_tratante_nro() {
        return medico_tratante_nro;
    }

    public void setMedico_tratante_nro(String medico_tratante_nro) {
        this.medico_tratante_nro = medico_tratante_nro;
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

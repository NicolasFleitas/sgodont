/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author nicof
 */
public class GrupoSanguineos {
 private int id_gruposang;
 private String nombre_gruposang;

    public GrupoSanguineos() {
    }

    public GrupoSanguineos(int id_gruposang, String nombre_gruposang) {
        this.id_gruposang = id_gruposang;
        this.nombre_gruposang = nombre_gruposang;
    }

    public int getId_gruposang() {
        return id_gruposang;
    }

    public void setId_gruposang(int id_gruposang) {
        this.id_gruposang = id_gruposang;
    }

    public String getNombre_gruposang() {
        return nombre_gruposang;
    }

    public void setNombre_gruposang(String nombre_gruposang) {
        this.nombre_gruposang = nombre_gruposang;
    }
 
 
}

package com.mycompany.practicas;

/**
 *
 * @author juanf
 */
public class Animales {

    private String especie;
    private String raza;
    private String nombre;
    private String estado;
    private int edad;
    private boolean chip;
    private boolean vacunas;
    private int dnidueno;
    
    public Animales(){
        especie  = "";
        raza     = "";
        nombre   = "";
        estado   = "";
        edad     = 0;
        chip     = false;
        vacunas  = false;
        dnidueno = 0;
    }
    
    public Animales (String _especie, String _raza, String _nombre, String _estado, int _edad, boolean _chip, boolean _vacunas, int _dnidueno){
        especie  = _especie;
        raza     = _raza;
        nombre   = _nombre;
        estado   = _estado;
        edad     = _edad;
        chip     = _chip;
        vacunas  = _vacunas;
        dnidueno = _dnidueno;
    }
    
    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the chip
     */
    public boolean isChip() {
        return chip;
    }

    /**
     * @param chip the chip to set
     */
    public void setChip(boolean chip) {
        this.chip = chip;
    }

    /**
     * @return the vacunas
     */
    public boolean isVacunas() {
        return vacunas;
    }

    /**
     * @param vacunas the vacunas to set
     */
    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    /**
     * @return the dnidueno
     */
    public int getDnidueno() {
        return dnidueno;
    }

    /**
     * @param dnidueno the dnidueno to set
     */
    public void setDnidueno(int dnidueno) {
        this.dnidueno = dnidueno;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
}

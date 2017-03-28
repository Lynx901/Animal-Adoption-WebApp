package com.mycompany.practicas;


public class Animales {
    public int _id=0;
    private int id;
    private String nombre;
    private int edad;
    private String especie;
    private String raza;
    private String estado;
    private String sexo;
    private boolean chip;
    private boolean vacunas;
    private int dnidueno;
    private String descripcion;
        
    public Animales(){
        id=_id;
        especie  = "";
        raza     = "";
        nombre   = "";
        estado   = "";
        edad     = 0;
        sexo     = "";
        chip     = false;
        vacunas  = false;
        dnidueno = 0;
        descripcion = "";
        _id++;
    }
    
    
    

    public Animales( String _nombre, int _edad, String _sexo , String _especie, String _raza, String _estado, boolean _chip, boolean _vacunas, int _dnidueno, String _descripcion) {
        id = _id;
        nombre = _nombre;
        edad = _edad;
        sexo = _sexo;
        especie = _especie;
        raza = _raza;
        estado = _estado;
        chip = _chip;
        vacunas = _vacunas;
        dnidueno = _dnidueno;
        descripcion = _descripcion;
        _id++;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
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
     * @return the description
     */
    public String getDescription() {
        return descripcion;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String _descripcion) {
        this.descripcion = _descripcion;
    }
    
     public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}

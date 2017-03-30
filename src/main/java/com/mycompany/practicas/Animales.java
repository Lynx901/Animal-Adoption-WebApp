package com.mycompany.practicas;


public class Animales {
    private Usuario duenio;

    private int id;
    private String  nombre;
    private int     edad;
    private boolean sexo;  // True si es macho, false si es hembra

    private String  especie;
    private String  raza;
    private String  estado;
    
    private boolean chip;
    private boolean vacunas;
    
    private String descripcion;
        
    public Animales(){
        duenio = new Usuario();
        
        id       = 0;
        nombre   = "";
        edad     = 0;
        sexo     = true;
        
        especie  = "";
        raza     = "";
        estado   = "";
        
        chip     = false;
        vacunas  = false;
        
        descripcion = "";
    }

    public Animales(String _nombre, int _edad, boolean _sexo , String _especie, String _raza, String _estado, boolean _chip, boolean _vacunas, int _dni, String _descripcion) {
        duenio = new Usuario();
        duenio.setDNI(_dni); // A "duenio" habría que pasarle el dni del dueño para que lo añada
        nombre  = _nombre;
        edad    = _edad;
        sexo    = _sexo;
        
        especie = _especie;
        raza    = _raza;
        estado  = _estado;
        
        chip    = _chip;
        vacunas = _vacunas;

        descripcion = _descripcion;
    }

    /**
     * @return the duenio
     */
    public Usuario getDuenio() {
        return duenio;
    }

    /**
     * @param duenio the duenio to set
     */
    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the sexo
     */
    public boolean isSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(boolean sexo) {
        this.sexo = sexo;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

package com.ulp.clase10.model;

public class ItemPrograma {

    private String nombre;
    private int idPrograma;
    private  String descripcion;

    public ItemPrograma() {
    }

    public ItemPrograma(String nombre, int idPrograma, String descripcion) {
        this.nombre = nombre;
        this.idPrograma = idPrograma;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

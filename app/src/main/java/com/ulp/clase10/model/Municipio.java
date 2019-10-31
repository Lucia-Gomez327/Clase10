package com.ulp.clase10.model;

public class Municipio {
    private Centroide centroide;
    private String idMunicipio;
    private Provincia provincia;
    private String nombre;

    public Municipio(Centroide centroide, String idMunicipio, Provincia provincia) {
        this.centroide = centroide;
        this.idMunicipio = idMunicipio;
        this.provincia = provincia;
    }

    public Municipio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Centroide getCentroide() {
        return centroide;
    }

    public void setCentroide(Centroide centroide) {
        this.centroide = centroide;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}

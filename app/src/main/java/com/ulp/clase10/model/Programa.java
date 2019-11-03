package com.ulp.clase10.model;

public class Programa {

    private int idProgramas;
    private String url;
    private  String link;
    private  String direccion;
    private  String telefono;
    private  String descripcion;
    private  String email;
    private  String provincia;
    private  String depende_de;
    private  String autoridad;

    public Programa() {
    }

    public Programa(int idProgramas, String url, String link, String direccion, String telefono, String descripcion, String email, String provincia, String depende_de, String autoridad) {
        this.idProgramas = idProgramas;
        this.url = url;
        this.link = link;
        this.direccion = direccion;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.email = email;
        this.provincia = provincia;
        this.depende_de = depende_de;
        this.autoridad = autoridad;
    }

    public int getIdProgramas() {
        return idProgramas;
    }

    public void setIdProgramas(int idProgramas) {
        this.idProgramas = idProgramas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepende_de() {
        return depende_de;
    }

    public void setDepende_de(String depende_de) {
        this.depende_de = depende_de;
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }
}

package com.ulp.clase10.Model_municipios;

import java.util.ArrayList;

public class Resultado {
    private int cantidad;
    private int inicio;
    private ArrayList<Municipio> municipios;
    private Parametro parametro;
    private int total;

    public Resultado(int cantidad, int inicio, ArrayList<Municipio> municipios, Parametro parametro, int total) {
        this.cantidad = cantidad;
        this.inicio = inicio;
        this.municipios = municipios;
        this.parametro = parametro;
        this.total = total;
    }

    public Resultado() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

package com.ulp.clase10.model;

import java.util.ArrayList;

public class Parametro {

    private ArrayList<String> provincias;

    public Parametro(ArrayList provincias) {
        this.provincias = provincias;
    }

    public Parametro() {
    }

    public ArrayList<String> getProvincias() {
        return provincias;
    }

    public void setProvinciasS(ArrayList provincias) {
        this.provincias = provincias;
    }
}

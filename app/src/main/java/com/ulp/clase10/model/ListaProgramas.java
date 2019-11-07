package com.ulp.clase10.model;

import java.util.ArrayList;

public class ListaProgramas {

    private int count;
    private String next;
    private String previous;
    private ArrayList<Programa> programas;

    public ListaProgramas(int count, String next, String previous, ArrayList<Programa> programas) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.programas = programas;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

}

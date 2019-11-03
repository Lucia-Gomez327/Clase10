package com.ulp.clase10.model;

import java.util.ArrayList;

public class Lista_Programas {

    private int count;

    private String next;

    private String previous;

    private ArrayList<Programa> results;


    public Lista_Programas(int count, String next, String previous, ArrayList<Programa> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }


    public Lista_Programas() {
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

    public ArrayList<Programa> getResults() {
        return results;
    }

    public void setResults(ArrayList<Programa> results) {
        this.results = results;
    }

}

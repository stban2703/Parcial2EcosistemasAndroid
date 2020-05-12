package com.example.parcial2ecosistemasandroid.model;

public class Voto {
    private String id;
    private String fecha;

    public Voto(String id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Voto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

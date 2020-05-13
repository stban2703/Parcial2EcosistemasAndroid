package com.example.parcial2ecosistemasandroid.model;

import androidx.annotation.NonNull;

public class Videojuego {
    private String id;
    private String nombre;
    private String estudio;
    private String estreno;

    public Videojuego(String id, String nombre, String estudio, String estreno) {
        this.id = id;
        this.nombre = nombre;
        this.estudio = estudio;
        this.estreno = estreno;
    }

    public Videojuego() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    @Override
    public String toString() {
        return nombre + " (" + estreno + ")" + " - Estudio: " + estudio;
    }
}

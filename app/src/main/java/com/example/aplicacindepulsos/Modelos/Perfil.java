package com.example.aplicacindepulsos.Modelos;

public class Perfil {
    public String nombre;
    public String key;

    public Perfil(String nombre){
    }

    public Perfil(String key,String nombre) {
        this.nombre = nombre;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

}


package com.mycompany.prode;


public class Equipo {
    private String nombre;
    private String descripcion;
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

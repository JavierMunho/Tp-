
package com.mycompany.prode;


public class Equipo {
    private String nombre;
    private String descripcion;

    //constructores

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


//getters y setters
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

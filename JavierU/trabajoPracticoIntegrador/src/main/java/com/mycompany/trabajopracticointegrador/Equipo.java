/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopracticointegrador;

/**
 *
 * @author Javier
 */
public class Equipo {

    private int idequipo;
    private String nombre;
    private String descripcion;
    
    //Constructor
    
    public Equipo(int idequipo, String nombre, String descripcion) {
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    
    
    /* getters y setters*/
    
    public int getIdEquipo() {
        return idequipo;
    }
    
    public void setIdEquipo(int idequipo) {
        this.idequipo = idequipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

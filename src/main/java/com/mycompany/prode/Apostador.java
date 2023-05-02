package com.mycompany.prode;

import java.util.ArrayList;
import java.util.List;

public class Apostador {
    private String nombre;
    private List<Pronostico> pronosticos;
    private Integer puntosXBonus;
    int puntos;


    //Constructor
    public Apostador(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<Pronostico>();
        this.puntosXBonus = 0;
        this.puntos=0;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<Pronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

    public Integer getPuntosXBonus() {
        return puntosXBonus;
    }

    public void setPuntosXBonus(Integer puntosXBonus) {
        this.puntosXBonus = puntosXBonus;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //agregado agregar pronostico
    public void addPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    // metodo que recorre los pronosticos y recolecta los puntos acertados y nos devuelve los puntos del apostador
    public int puntosPorPronostico() {
        for (Pronostico pronostico : pronosticos) {
            puntos = puntos + pronostico.puntos();
        }
        return puntos;
    }
    // metodo que establece los puntos especiales
    public void incPuntosPorBonus(int i) {
        puntosXBonus += i;
    }
   // sumamos todos los puntos obtenidos
    public int puntosTotales() {
        return this.puntosPorPronostico() + this.puntosXBonus;
    }

}

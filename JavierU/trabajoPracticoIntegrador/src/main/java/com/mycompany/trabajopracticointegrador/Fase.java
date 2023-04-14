/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopracticointegrador;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Fase {

    private int idFase;
    private ArrayList<Ronda> rondas;

    //Constructor
    public Fase(int idFase) {
        this.idFase = idFase;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public Ronda[] getRondas() {
        return rondas;
    }

    public void setRondas(Ronda[] rondas) {
        this.rondas = rondas;
    }

    public void asignarPartido(boolean nuevaRonda, Partido partido, int idRonda) {
        if (nuevaRonda) {
            Ronda ronda = new Ronda(idRonda);
            ronda.newPartido(partido);
            this.rondas.add(ronda);
        } else {
            int cantRondas = this.rondas.size();
            Ronda ronda = this.rondas.get(cantRondas);
            ronda.newPartido(partido);
            this.rondas.set(cantRondas, ronda);
        }
    }

}

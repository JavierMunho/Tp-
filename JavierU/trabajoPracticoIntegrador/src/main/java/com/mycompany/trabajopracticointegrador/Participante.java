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
public class Participante {
    
    private String participante;
    private int puntajeObtenido;
    private ArrayList<Ronda> fases;
    
        //Constructor
    public Participante(String participante) {
        this.participante = participante;
    }

    
        //Setters y Getters
    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public void asignarPartido(boolean nuevaFase, Partido partido, int idRonda){
        if (nuevaFase){
            Ronda ronda = new Ronda(idRonda);
            ronda.newPartido(partido);
            this.fases.add(ronda);
        }else{
            int cantFases = this.fases.size();
            Ronda ronda = this.fases.get(cantFases);
            ronda.newPartido(partido);
            this.fases.set(cantFases, ronda);
        }
    }

}

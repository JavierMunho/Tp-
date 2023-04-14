
package com.mycompany.trabajopracticointegrador;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Ronda {
    private int idRonda;
    private String nro;
    private ArrayList<Partido> partidos ;

    public Ronda(int idRonda) {
        this.idRonda = idRonda;
    }
    
    public void newPartido(Partido partido){
        this.partidos.add(partido);
    }
    
    public int  puntos(){
        return -1;
    }
    
}

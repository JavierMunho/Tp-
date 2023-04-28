
package com.mycompany.prode;


import java.util.ArrayList;
import java.util.List;

public  class Ronda {

    private Integer numero;
    private List<Partido> partidos;
//constructor
    public Ronda(Integer numero) {
        super();
        this.numero = numero;
        this.partidos = new ArrayList<Partido>();
    }
//getters y setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }


// metoodo para conocer  cuantos puntos otorga  cada  ronda y cuantos se obtuvieron en esa ronda
    public boolean acertoTodos(List<Pronostico> apuestas) {
        int puntosDisponiblesRonda = this.partidos.size();
        int puntosObtenidosEnRonda = 0;

        for (Pronostico pronostico : apuestas) {
            if(pronostico.getPartido().getRonda().getNumero().equals(this.numero)) {
                puntosObtenidosEnRonda += pronostico.puntos();
            }
        }
 // compara ambos puntajes y nos indica si acerto todos o no
        boolean resultado = puntosDisponiblesRonda == puntosObtenidosEnRonda;
        return resultado;

     }

}







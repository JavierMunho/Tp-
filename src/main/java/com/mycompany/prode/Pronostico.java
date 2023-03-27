
package com.mycompany.prode;


public class Pronostico {
    
  private  Partido partido;
   private  Equipo equipo;
   ResultadoEnum resultado;
    
    public Pronostico() {
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
       
    }
   
   
}

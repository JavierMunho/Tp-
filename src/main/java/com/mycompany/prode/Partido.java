package com.mycompany.prode;

public class Partido  {

  private Equipo equipo1;
  private Equipo equipo2;
  private int golesEquipo1 , golesEquipo2;

    public Partido() {
    }

    private Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        ResultadoEnum resultado;
    }
  private String resultado(){
    if (golesEquipo1 > golesEquipo2){  
        equipo1= ResultadoEnum.ganador(); 
        equipo2= ResultadoEnum.perdedor();
        } else if (golesEquipo1 < golesEquipo2) {
        equipo1= ResultadoEnum.perdedor();
         equipo1= ResultadoEnum.ganador();
        } else if (golesEquipo1 == golesEquipo2){
      equipo1 = ResultadoEnum.empate();
        equipo2 =ResultadoEnum.empate();
        }
            return " ";
        }
      
  
}
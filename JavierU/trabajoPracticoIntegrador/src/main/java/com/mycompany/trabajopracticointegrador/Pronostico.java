/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajopracticointegrador;

/**
 *
 * @author Javier
 */
public class Pronostico {
    private int idpronostico;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

   /*Constructor*/

    public Pronostico(int idpronostico, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.idpronostico = idpronostico;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    
    
    /*Setters y Getters*/

    public int getIdpronostico() {
        return idpronostico;
    }

    public void setIdpronostico(int idpronostico) {
        this.idpronostico = idpronostico;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
    
   
    public int puntos() {
		
		ResultadoEnum resultadoReal = this.partido.resultado(this.equipo);
		if (this.resultado.equals(resultadoReal)) {
			return 1;
		} else {
			return 0;
		}

	}
 
}

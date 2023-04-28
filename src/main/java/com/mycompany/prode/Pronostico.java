
package com.mycompany.prode;


public class Pronostico {
    
	private Partido partido;
	private Equipo equipo;
	private EnumResultado resultado;
// constructor
	public Pronostico(Partido partido, Equipo equipo, EnumResultado resultado) {
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}
// getters y setters
	public Partido getPartido() {
		return this.partido;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public EnumResultado getResultado() {
		return this.resultado;
	}
/* metodo que indica si el resultado del partido coincide con la apuesta
   y asigna el puntaje por acierto si corresponde */


	public int puntos() {
		// this.resultado -> pred
		EnumResultado resultadoReal = this.partido.resultado(this.equipo);
		if (this.resultado.equals(resultadoReal)) {
			return 3;
		} else {
			return 0;
		}

	}

}
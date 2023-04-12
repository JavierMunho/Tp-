
package com.mycompany.prode;


public class Pronostico {
    
	private Partido partido;
	private Equipo equipo;
	private EnumResultado resultado;

	public Pronostico(Partido partido, Equipo equipo, EnumResultado resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public EnumResultado getResultado() {
		return this.resultado;
	}

	public int puntos() {
		// this.resultado -> pred
		EnumResultado resultadoReal = this.partido.resultado(this.equipo);
		if (this.resultado.equals(resultadoReal)) {
			return 1;
		} else {
			return 0;
		}

	}

}
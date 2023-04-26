package com.mycompany.prode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prode {

	public static void main(String[] args) {
		// Leer resultados
		Collection<Partido> partidos = new ArrayList<Partido>();

		Path pathResultados = Paths.get(args[0]);
		List<String> lineasResultados = null;
// Intentara conectarse al archivo resultados
		try {
			lineasResultados = Files.readAllLines(pathResultados);
		} catch (IOException e) {
			System.out.println("No se pudo leer la linea de resultados...");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		boolean primera = true;
		for (String lineaResultado : lineasResultados) {
			if (primera) {
				primera = false;
			} else {
				// partidos de ronda
				String[] campos = lineaResultado.split(",");
				Equipo equipo1 = new Equipo(campos[0]);
				Equipo equipo2 = new Equipo(campos[3]);
				Partido partido = new Partido(equipo1, equipo2);
				partido.setGolesEq1(Integer.parseInt(campos[1]));
				partido.setGolesEq2(Integer.parseInt(campos[2]));
				partido.setRonda(Integer.parseInt(campos[4]));
				partidos.add(partido);
			}

		}
		// Leer pronostico

		Map<String, Integer> puntosParticipante = new HashMap<>();


		//int puntos = 0; // total puntos persona

		Path pathPronostico = Paths.get(args[1]);
		List<String> lineasPronostico = null;
		try {
			lineasPronostico = Files.readAllLines(pathPronostico);
		} catch (IOException e) {
			System.out.println("No se pudo leer la linea de pronosticos...");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		primera = true;
		for (String lineaPronostico : lineasPronostico) {
			if (primera) {
				primera = false;
			} else {
				String[] campos = lineaPronostico.split(",");
				Equipo equipo1 = new Equipo(campos[0]);
				Equipo equipo2 = new Equipo(campos[4]);
				Partido partido = null;

				for (Partido partidoCol : partidos) {
					if (partidoCol.getEquipo1().getNombre(
					).equals(equipo1.getNombre())
							&& partidoCol.getEquipo2().getNombre(
					).equals(equipo2.getNombre())) {

						partido = partidoCol;

					}
				}
				Equipo equipo = null;
				EnumResultado resultado = null;
				if ("X".equals(campos[1])) {
					equipo = equipo1;
					resultado = EnumResultado.GANADOR;
				}
				if ("X".equals(campos[2])) {
					equipo = equipo1;
					resultado = EnumResultado.EMPATE;
				}
				if ("X".equals(campos[3])) {
					equipo = equipo1;
					resultado = EnumResultado.PERDEDOR;
				}
				Pronostico pronostico = new Pronostico(partido, equipo, resultado);
				// sumar los puntos correspondientes


				String nombreParticipante = campos[5];
				if (puntosParticipante.containsKey(
						nombreParticipante)) {
					puntosParticipante.put(nombreParticipante, puntosParticipante.get(nombreParticipante)
									+
									pronostico.puntos());
				} else {
					puntosParticipante.put(nombreParticipante, pronostico.puntos());
				}
			}
		}

		// mostrar los puntos
		for (String participante : puntosParticipante.keySet()) {
			System.out.println("Los puntos obtenidos por el Apostador " + participante + " fueron:");
			System.out.println(puntosParticipante.get(participante));

		}
	}
}


            
   


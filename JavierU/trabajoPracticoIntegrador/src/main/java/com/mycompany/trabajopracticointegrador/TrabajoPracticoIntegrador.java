/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajopracticointegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.sql.*;
import static conexion.ConectorSQL.DB_URL;
import static conexion.ConectorSQL.USER;
import static conexion.ConectorSQL.PASS;

/**
 *
 * @author Javier
 */
public class TrabajoPracticoIntegrador {

    public static void main(String[] args) {

        // Leer resultados
        Collection<Partido> partidos = new ArrayList<Partido>();

        Path pathResultados = Paths.get(args[0]);
        List<String> lineasResultados = null;
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
                // Argentina,1,2,Arabia Saudita
                String[] campos = lineaResultado.split(",");
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[3]);
                Partido partido = new Partido(equipo1, equipo2);
                partido.setGolesEquipo1(Integer.parseInt(campos[1]));
                partido.setGolesEquipo2(Integer.parseInt(campos[2]));
                partido.setIdPartido(Integer.parseInt(campos[4]));
                partidos.add(partido);
            }

        }
        // Leer pronostico
        int puntos = 0; // total puntos pesona

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
        
        String ultimoParticipante = "";
        Participante participante = null;
        Number ultimaFase = -1;
        boolean cambiaFase = false;
        for (String lineaPronostico : lineasPronostico) {

            if (primera) {
                primera = false;
            } else {
                String[] campos = lineaPronostico.split(",");
                if (ultimoParticipante != campos[6]) {
                    ultimoParticipante = campos[6];
                    participante = new Participante(campos[6]);
                    ultimaFase = Integer.parseInt(campos[7]);
                    cambiaFase = true;
                }
                
                nuevoPronosticoPartido(partidos,campos);
                // sumar los puntos correspondientes
                //puntos += pronostico.puntos();
            }
        }
        // mostrar los puntos
            System.out.println("Los puntos obtenidos por el usuario fueron:");
            System.out.println(puntos);
            System.out.println(participante.getParticipante());
            
            
       
    }

    private static void nuevoPronosticoPartido(Collection<Partido> partidos, String[] campos){
        
                Equipo equipo1 = new Equipo(campos[0]);
                Equipo equipo2 = new Equipo(campos[4]);

                Partido partido = null;
                //Aca se compara el id del pronostico, con el id del partido
                //cambiar a while
                for (Partido partidoColeccion : partidos) {
                    if (partidoColeccion.getIdPartido() == Integer.parseInt(campos[5])) {
                        /*if (partidoColeccion.getEquipo1().getNombre(
							).equals(equipo1.getNombre())
							&& partidoColeccion.getEquipo2().getNombre(
									).equals(equipo2.getNombre())) {*/
                        partido = partidoColeccion;
                    }
                }
                Equipo equipo = null;
                ResultadoEnum resultado = null;
                if ("X".equals(campos[1])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.GANADOR;
                }
                if ("X".equals(campos[2])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.EMPATE;
                }
                if ("X".equals(campos[3])) {
                    equipo = equipo1;
                    resultado = ResultadoEnum.PERDEDOR;
                }

                System.out.println(equipo.getNombre());
                System.out.println(partido.resultado(equipo));
                System.out.println(campos[6]);
                Pronostico pronostico = new Pronostico(partido, equipo, resultado);
    }
    
    /*  Connection conexion = null;
        Statement consulta = null;

        try {

            // Intenta abrir la conexion
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            // Ejecutar una consulta de particiantes
            
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT id, Apellido, Nombre, Puntos FROM prode.participantes";

            //En la variable resultado obtendremos las participantes cargados en la base
            ResultSet participantes = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta de participantes
            while (participantes.next()) {
                // Obtiene el valor de cada columna
                int id = participantes.getInt("id");
                String Apellido = participantes.getString("Apellido");
                String Nombre = participantes.getString("Nombre");
                int Puntos = participantes.getInt("Puntos");

                // Muestra los valores obtenidos de los participantes
                System.out.print("ID: " + id);
                System.out.print(", Apellido: " + Apellido);
                System.out.print(", Nombre: " + Nombre);
                System.out.println(", Puntos: " + Puntos);
            }
            // Ejecutar una consulta de resultados
            
            consulta = conexion.createStatement();
            String sql1;
            sql1 = "SELECT * FROM prode.resultados";
            
            //En la variable result obtendremos los resultados de los partidos 
            ResultSet result = consulta.executeQuery(sql1);

            // Obtener las distintas filas de la consulta de participantes
            while (result.next()) {
                // Obtiene el valor de cada columna
                
                String equipo1 = result.getString("Equipo1");
                int CantGolesEquipo1=result.getInt("CantGolesEquipo1");
                int CantGolesEquipo2=result.getInt("CantGolesEquipo2");
                String equipo2 = result.getString("Equipo2");
                int idRonda = result.getInt("idRonda");

                // Muestra los valores obtenidos de los resultados
                
                System.out.print("Equipo1: " + equipo1);
                System.out.print(", Cantidad de goles Equipo 1 " + CantGolesEquipo1);
                System.out.print(", Cantidad de goles Equipo 2 " + CantGolesEquipo2);
                System.out.println(", Equipo2: " + equipo2);
                System.out.print("Ronda: " + idRonda);
            }
            
            // Ejecutar una consulta de pronosticos
            
            consulta = conexion.createStatement();
            String sql2;
            sql2 = "SELECT * FROM prode.pronosticos";
            
            //En la variable pronost obtendremos los pronosticos de los participantes
            ResultSet pronost = consulta.executeQuery(sql2);

            // Obtener las distintas filas de la consulta de pronosticos
            while (pronost.next()) {
                // Obtiene el valor de cada columna
                
                String equipo1 = pronost.getString("Equipo1");
                var Gana1=pronost.getString("Gana1");
                var Empata =pronost.getString("Empata");
                var Gana2=pronost.getString("Gana2");
                String equipo2 = pronost.getString("Equipo2");
                int idParticipante = pronost.getInt("idParticipante");

                // Muestra los valores obtenidos de los pronosticos
                
                System.out.print("Equipo1: " + equipo1);
                System.out.print(", Gana 1 " + Gana1);
                System.out.print(", Empata " + Empata);
                System.out.println(", Gana 2: " + Gana2);
                System.out.println(", Equipo2: "+equipo2);
                System.out.print("Participante: " + idParticipante);
            }
            
            // Esto se utiliza par cerrar la conexion con la base de datos
            participantes.close();
            result.close();
            pronost.close();
            consulta.close();
            conexion.close();
            
        } catch (SQLException se) {
            // Execpcion ante problemas de conexion
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
            try {
                if (consulta != null)
                    consulta.close();
            } catch (SQLException se2) {
            }
            try {
                if (conexion != null)
                    conexion.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin de la lectura en la BBDD");
    }
}*/
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    /*public static void main(String[] args) {
        
        
        Collection<Partido> partidos=new ArrayList<Partido>();
        Path pathResultados=Paths.get(args[0]);  //Leer el primer archivo
        List<String> lineasResultados=null;
        try {
            lineasResultados = Files.readAllLines(pathResultados);
        } catch (IOException ex) {
            System.out.println("No se puede leer el archivo");
            System.exit(1);
        }
        boolean primera=true;
        for (String linea:lineasResultados ){
            if(primera){
                primera=false;
            } else{
                
              String[] campos=  linea.split(",");
              Equipo equipo1=new Equipo(campos[0]);
              Equipo equipo2=new Equipo(campos[3]);
                            
              Partido partido=new Partido(equipo1, equipo2);
              partido.setGolesEquipo1(Integer.parseInt(campos[1]));
              partido.setGolesEquipo2(Integer.parseInt(campos[2]));
              partido.setIdPartido(Integer.parseInt(campos[4]));
              partidos.add(partido);
              
            }
            
        }
        
        int puntos=0;
        
        Path pathPronostico=Paths.get(args[1]);  //Leer el primer archivo
        List<String> lineasPronostico=null;
        
        try {
            lineasPronostico=Files.readAllLines(pathPronostico);
            
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo de pronosticos");
            System.out.println(ex.getMessage());
        }
        
        primera=true;
        for(String lineaPronostico:lineasPronostico){
            if(primera){
                primera=false;
            } else {
                System.out.println(lineaPronostico);
                String[] campos=lineaPronostico.split(",");
                Equipo equipo1=new Equipo(campos[0]);
                Equipo equipo2=new Equipo(campos[4]);
                Partido partido=null;
                
                for(Partido partidoColeccion:partidos){
                   if(partidoColeccion.getIdPartido()==Integer.parseInt(campos[5])){
                      partido=partidoColeccion; 
                   }
                    
                    /*if(partidoColeccion.getEquipo1().getNombre().equals(equipo1.getNombre())
                            && partidoColeccion.getEquipo2().getNombre().equals(equipo2.getNombre())){
                        partido=partidoColeccion;
                    }*/
}
/*Equipo equipo=null;
                ResultadoEnum resultado=null;
                 
                if("X".equals(campos[1])){
                    equipo=equipo1;    
                    resultado=ResultadoEnum.GANADOR;
                    }
                if("X".equals(campos[2])){
                    equipo=equipo1;
                    resultado=ResultadoEnum.EMPATE;
                    }
                if("X".equals(campos[3])){
                    equipo=equipo1;
                    resultado=ResultadoEnum.PERDEDOR;
                    }
                System.out.println(equipo.getNombre());
                System.out.println(partido.resultado(equipo));
                
                Pronostico pronostico=new Pronostico(partido, equipo, resultado);
                 //puntos =puntos+ pronostico.puntos();
                 System.out.println(pronostico.getResultado());
                 System.out.println(pronostico.puntos());
            }
        }
        System.out.println("Los puntos obtenidos son"+" "+puntos);
    }*/

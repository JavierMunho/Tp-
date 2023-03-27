
package com.mycompany.prode;


public enum ResultadoEnum {
   ganador,perdedor,empate;

    static Equipo ganador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static Equipo perdedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static Equipo empate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static ResultadoEnum getGanador() {
        return ganador;
    }

    public static ResultadoEnum getPerdedor() {
        return perdedor;
    }

    public static ResultadoEnum getEmpate() {
        return empate;
    }
    
    
    
}

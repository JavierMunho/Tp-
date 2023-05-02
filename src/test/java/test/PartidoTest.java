package test;

import com.mycompany.prode.EnumResultado;
import com.mycompany.prode.Equipo;
import com.mycompany.prode.Partido;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PartidoTest {

    private Equipo equipo1;
    private Equipo equipo2;
    private Partido partido ;

    @Before
    public void setUp() {
        this.equipo1 = new Equipo("Argentina");
        this.equipo2 = new Equipo("Arabia Saudita");
        this.partido = new Partido(this.equipo1,
                this.equipo2, 1, 1);
    }

    @Test
    public void testPartidoGanadorPerdedor() {

        // nuestro escenario
        this.partido.setGolesEq1(1);
        this.partido.setGolesEq2(2);

        // Procesar
        EnumResultado resultadoObtenido1 = partido.resultado(this.equipo1);
        EnumResultado resultadoObtenido2 = partido.resultado(this.equipo2);

        // Evaluar
        assertEquals(EnumResultado.PERDEDOR, resultadoObtenido1);
        assertEquals(EnumResultado.GANADOR, resultadoObtenido2);

    }

    @Test
    public void testPartidoEmpatado() {

        // nuestro escenario
        // Esta armado

        // Procesar
        EnumResultado resultadoObtenido = partido.resultado(equipo1);

        // Evaluar
        assertEquals(EnumResultado.EMPATE, resultadoObtenido);

    }
}

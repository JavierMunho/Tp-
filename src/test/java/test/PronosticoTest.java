package test;

import com.mycompany.prode.EnumResultado;
import com.mycompany.prode.Equipo;
import com.mycompany.prode.Partido;
import com.mycompany.prode.Pronostico;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PronosticoTest {
    private Equipo equipo1;
    private Equipo equipo2;

    @Before
    public void setUp() {
        this.equipo1 = new Equipo("Argentina");
        this.equipo2 = new Equipo("Arabia Saudita");

    }

    @Test
    public void testControlarAciertos() {

        // Escenario
        Partido partido = new Partido(this.equipo1,
                this.equipo2, 0, 2);
        Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.PERDEDOR);

        // Procesar
        int puntos = pronostico.puntos();

        // Evaluar

        assertEquals(3, puntos);


    }

    @Test
    public void testControlarDesaciertos() {

        // Escenario
        Partido partido = new Partido(this.equipo1,
                this.equipo2, 2, 3);
        Pronostico pronostico = new Pronostico(partido, this.equipo1, EnumResultado.EMPATE);

        // Procesar
        int puntos = pronostico.puntos();

        // Evaluar

        assertEquals(0, puntos);


    }
}

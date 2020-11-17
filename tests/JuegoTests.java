package tests;

import org.junit.Assert;
import org.junit.Test;
import clases.Elemento;
import clases.Juego;
import clases.NumeroDeRangoEquivocadoException;

public class JuegoTests {


	@Test
	public void testUsarAtaqueSimpleDeElementoAguaConBonificacion() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Agua, Elemento.Fuego, Elemento.Aire, Elemento.Tierra);

		// ataque simple de elemento agua
		j.usarAtaque(2);

	}

	@Test
	public void testUsarAtaqueSimpleElementoFuegoConBonificacion() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Aire, Elemento.Fuego, Elemento.Aire, Elemento.Tierra);

		// ataque simple de elemento fuego
		j.usarAtaque(4);

	}

	@Test
	public void testUsarAtaqueEspecialElementoAireSinBonificacion() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Aire, Elemento.Aire, Elemento.Tierra, Elemento.Tierra);

		// ataque especial elemento aire
		j.usarAtaque(1);

	}

	@Test
	public void testUsarAtaqueEspecialElementoTierraSinBonificacion() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Tierra, Elemento.Tierra, Elemento.Tierra, Elemento.Tierra);

		// ataque especial elemento aire
		j.usarAtaque(1);

	}

	@Test
	public void testRotacionDeTurnos() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Tierra, Elemento.Tierra, Elemento.Tierra, Elemento.Tierra);

		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);

	}

	@Test(expected = NumeroDeRangoEquivocadoException.class)
	public void numeroAtaqueInvalido() throws NumeroDeRangoEquivocadoException {

		Juego j = new Juego("Ivan", "Mecha", Elemento.Tierra, Elemento.Tierra, Elemento.Tierra, Elemento.Tierra);
		j.usarAtaque(-11);

	}

	@Test()
	public void terminoDebeDarFalse() throws NumeroDeRangoEquivocadoException {
		Juego j = new Juego("Ivan", "Mecha", Elemento.Tierra, Elemento.Tierra, Elemento.Tierra, Elemento.Tierra);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);

		Assert.assertFalse(j.termino());
	}

	@Test()
	public void terminoDebeDarTrue() throws NumeroDeRangoEquivocadoException {
		Juego j = new Juego("Ivan", "Mecha", Elemento.Tierra, Elemento.Tierra, Elemento.Tierra, Elemento.Tierra);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);
		j.usarAtaque(1);
		j.usarAtaque(2);
		j.usarAtaque(3);
		j.usarAtaque(4);

		Assert.assertTrue(j.termino());

	}

}

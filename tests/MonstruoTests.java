package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clases.Elemento;
import clases.Monstruo;

public class MonstruoTests {
	
	Monstruo m1;
	Monstruo m2;

	@Test
	public void testAtacarAOtroMonstruo() {
		
		/*Testea que al atacar a otro monstruo se calcule bien el daño dependiendo del elemento*/
		m1 = new Monstruo(Elemento.Agua, Elemento.Fuego);
		m2 = new Monstruo(Elemento.Aire, Elemento.Tierra);

		Assert.assertEquals(8, m1.atacar(2, m2));
			
	}
	
	@Test
	public void testAtacarAOtroMonstruoYComprobarQueLeResteLaVida(){
		
		
		/*Testea que al atacar se reste la vida al monstruo atacado por un ataque simple de elemento agua*/
		m1 = new Monstruo(Elemento.Agua, Elemento.Fuego);
		m2 = new Monstruo(Elemento.Aire, Elemento.Tierra);
		m1.atacar(2, m2);
		
		Assert.assertEquals(92, m2.getVida());
		
	}
	
	
	

}

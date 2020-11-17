package clases;

public class Monstruo {
	Elemento elemento;
	Elemento elemento2;
	private int vida = 100;
	Ataque[] ataques = new Ataque[4];
	
	
	
	/*
	 * Usamos una matriz que contiene las 4 opciones de atacar
	 */
	public Monstruo(Elemento elemento1, Elemento elemento2){
		this.elemento = elemento1;
		this.elemento2 = elemento2;
		this.ataques[0] = new Ataque(elemento1, TipoDeAtaque.Especial);
		this.ataques[1] = new Ataque(elemento1, TipoDeAtaque.Simple);
		this.ataques[2] = new Ataque(elemento2, TipoDeAtaque.Especial);
		this.ataques[3] = new Ataque(elemento2, TipoDeAtaque.Simple);
	}
	
	public int atacar(int posicion, Monstruo monstruo){
		return this.ataques[posicion-1].atacar(monstruo);
	}
	
	public Elemento getElemento(){
		return elemento;
	}
	public Elemento getElemento2(){
		return elemento2;
	}
	public void restarVida(int dañoAtaque) {
		this.vida -= dañoAtaque;
	}
	public int getVida() {
		return vida;
	}
}


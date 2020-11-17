package clases;
public class Ataque {
	Elemento elemento;
	int da�o;
	TipoDeAtaque ataque;
	String razon = "";
	int numeroUsosMaximos = 99999;
	int usado = 0;


	public Ataque(Elemento elemento, TipoDeAtaque ataque) {
		this.elemento = elemento;
		this.ataque = ataque;
		/*
		 * De acuerdo al tipo de ataque se establece un da�o.
		 */
		if (ataque == TipoDeAtaque.Especial) {
			da�o = 15;
		} else {
			da�o = 10;
		}
		if (this.ataque == TipoDeAtaque.Especial) {
			this.numeroUsosMaximos = 4;
		}
	}

	int atacar(Monstruo monstruo) {
		
		/*
		 * Si es un ataque especial se pregunta que no se haya usado mas de 4 veces,
		 *  entonces se calcula el da�o segun el tipo de ataque y el elemento, por ultimo se devuelve el da�o del ataque
		 */
		int da�oAtaque = 0;
		
		if (this.usado < this.numeroUsosMaximos) {
			this.usado++;
			da�oAtaque = this.da�o;
			this.razon = "";
			if (this.elemento == Elemento.Fuego
					&& (monstruo.getElemento() == Elemento.Tierra
					|| monstruo.getElemento2() == Elemento.Tierra)) {
				da�oAtaque += this.da�o * 0.2;
				this.razon += "+20% por Fuego contra Tierra ";
			}
			if (this.elemento == Elemento.Fuego
					&& (monstruo.getElemento() == Elemento.Agua
					|| monstruo.getElemento2() == Elemento.Agua)) {
				da�oAtaque -= this.da�o * 0.2;
				this.razon += "-20% por Fuego contra Agua ";
			}
			if (this.elemento == Elemento.Tierra
					&& (monstruo.getElemento() == Elemento.Aire
					|| monstruo.getElemento2() == Elemento.Aire)) {
				da�oAtaque += this.da�o * 0.2;
				this.razon += "+20% por Tierra contra Aire ";
			}
			if (this.elemento == Elemento.Tierra
					&& (monstruo.getElemento() == Elemento.Agua
					|| monstruo.getElemento2() == Elemento.Agua)) {
				da�oAtaque -= this.da�o * 0.2;
				this.razon += "-20% por Tierra contra Agua ";
			}
			if (this.elemento == Elemento.Aire
					&& (monstruo.getElemento() == Elemento.Agua
					|| monstruo.getElemento2() == Elemento.Agua)) {
				da�oAtaque += this.da�o * 0.2;
				this.razon += "+20% por Aire contra Agua ";
			}
			if (this.elemento == Elemento.Aire
					&& (monstruo.getElemento() == Elemento.Fuego
					|| monstruo.getElemento2() == Elemento.Fuego)) {
				da�oAtaque -= this.da�o * 0.2;
				this.razon += "-20% por Aire contra Fuego ";
			}
			if (this.elemento == Elemento.Agua
					&&( monstruo.getElemento() == Elemento.Fuego
					|| monstruo.getElemento2() == Elemento.Fuego)) {
				da�oAtaque += this.da�o * 0.2;
				this.razon += "+20% por Agua contra Fuego ";
			}
			if (this.elemento == Elemento.Agua
					&&( monstruo.getElemento() == Elemento.Tierra
					|| monstruo.getElemento2() == Elemento.Tierra)) {
				da�oAtaque -= this.da�o * 0.2;
				this.razon += "-20% por Agua contra Tierra ";
			}
			
			/*
			 * Se le resta el da�o del ataque al monstruo atacado.
			 */
			monstruo.restarVida(da�oAtaque);
			return da�oAtaque;
		}else{
			this.razon = "No se pudo realizar el ataque por usos maximos";
		}
		return da�oAtaque;
		
	}

	public Elemento getElemento() {
		return elemento;
	}

	public String getRazon() {
		return this.razon;
	}

	public TipoDeAtaque getTipoDeAtaque() {
		return this.ataque;
	}

	public int getDa�o() {
		return da�o;
	}

}

enum TipoDeAtaque {
	Simple, Especial
};

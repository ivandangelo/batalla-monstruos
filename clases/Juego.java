package clases;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
	String jugador1;
	String jugador2;
	Monstruo monstruoj1;
	Monstruo monstruoj2;
	boolean esTurnoJ1 = true;
	String ganador;
	String jugadorActual;
	Monstruo monstruoActual;

	public Juego(String jugador1, String jugador2, Elemento MJ1elemento1,
			Elemento MJ1elemento2, Elemento MJ2elemento1, Elemento MJ2elemento2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.jugadorActual = jugador1;
		monstruoj1 = new Monstruo(MJ1elemento1, MJ1elemento2);
		monstruoj2 = new Monstruo(MJ2elemento1, MJ2elemento2);
		monstruoActual = monstruoj1;
		
	}
	
	public Ataque getAtaqueNumero(int numeroAtaque) throws NumeroDeRangoEquivocadoException{
		
		rangoValidoDel1Al4(numeroAtaque);
		return monstruoActual.ataques[numeroAtaque-1];
	}

	public Elemento elementoMonstruoActual() {
		return monstruoActual.getElemento();
	}

	public Elemento elemento2MonstruoActual() {
		return monstruoActual.getElemento2();
	}

	public void usarAtaque(int ataque) throws NumeroDeRangoEquivocadoException {
		
		rangoValidoDel1Al4(ataque);
		
		if (esTurnoJ1) {
			int dañoTotal = monstruoj1.atacar(ataque, monstruoj2);
			System.out.print("El monstruo de: "+jugador2+ " recibe el siguiente daño: "+getAtaqueNumero(ataque).getDaño()+
					" de daño porque "+getAtaqueNumero(ataque).getRazon()+" en total recibe un daño de: "+dañoTotal+" y le quedan "+monstruoj2.getVida()+"\n");
			jugadorActual = jugador2;
			monstruoActual = monstruoj2;
		} else {
			int dañoTotal = monstruoj2.atacar(ataque, monstruoj1);
			System.out.print("El monstruo de: "+jugador1+ " recibe el siguiente daño: "+getAtaqueNumero(ataque).getDaño()+
					" de daño porque "+getAtaqueNumero(ataque).getRazon()+" en total recibe un daño de: "+dañoTotal+" y le quedan "+monstruoj1.getVida()+"\n");
			jugadorActual = jugador1;
			monstruoActual = monstruoj2;
		}
		esTurnoJ1 = !esTurnoJ1;
		
	}

	public boolean termino() {
		boolean retornar = false;
		if (monstruoj1.getVida() <= 0) {
			ganador = jugador2;
			retornar = true;
		} else if (monstruoj2.getVida() <= 0) {
			ganador = jugador1;
			retornar = true;
		}
		return retornar;
	}

	public String ganador() {
		return ganador;
	}

	private static Elemento elementoConNumero(int numero) {
		Elemento elemento = null;
		if (numero == 1) {
			elemento = Elemento.Fuego;
		}
		if (numero == 2) {
			elemento = Elemento.Agua;
		}
		if (numero == 3) {
			elemento = Elemento.Tierra;
		}
		if (numero == 4) {
			elemento = Elemento.Aire;
		}
		return elemento;
	}
	
	private static int elegirElementos(String posicionElemento,String nombre, Scanner leer){
		int numeroElemento = 0;
		System.out.print("Eliga el "+posicionElemento+" elemento del Monstruo de "+nombre+" \n"
				+ "1- Fuego \n"
				+ "2- Agua \n"
				+ "3- Tierra \n"
				+ "4- Aire\n");
			
			try {
			numeroElemento = leer.nextInt();
			rangoValidoDel1Al4(numeroElemento);
		}
			catch (InputMismatchException e) {
				System.out.println("Caracter no valido, acegurese de ingresar un número de elemento correcto");
	            	leer.nextLine();
	            	numeroElemento = elegirElementos(posicionElemento, nombre, leer);
	            	}
		catch (NumeroDeRangoEquivocadoException e) {
			System.out.println(e.getMessage());
            	leer.nextLine();
            	numeroElemento = elegirElementos(posicionElemento, nombre,leer);
            	}
		return numeroElemento;
	}

	public static void main(String [ ] args) throws NumeroDeRangoEquivocadoException{
		Scanner leer = new Scanner(System.in);
		System.out.println("Nombre jugador 1 \n");
		String jugador1 = leer.next();
		int NMJ1elemento1 = elegirElementos("primer",jugador1, leer);
		int NMJ1elemento2 = elegirElementos("segundo",jugador1, leer);
		System.out.print(jugador1+" creo un monstruo de los tipos:"+elementoConNumero(NMJ1elemento1)+" y "+elementoConNumero(NMJ1elemento2)+"\n");
		System.out.println("Nombre jugador 2 \n");
		String jugador2 = leer.next();
		int NMJ2elemento1 = elegirElementos("primer",jugador2, leer);
		int NMJ2elemento2 = elegirElementos("segundo",jugador2, leer);
		System.out.print(jugador2+" creo un monstruo de los tipos:"+elementoConNumero(NMJ2elemento1)+" y "+elementoConNumero(NMJ2elemento2)+"\n");
		Juego juego = new Juego(jugador1, jugador2, elementoConNumero(NMJ1elemento1), elementoConNumero(NMJ1elemento2), 
				elementoConNumero(NMJ2elemento1), elementoConNumero(NMJ2elemento2));
		/*
		 * Mientras la hp de algun jugador sea 0 cada uno  en su turno debe realizar un ataque.
		 */
		while(!juego.termino()){
			int numeroAtaque = elegirAtaque(leer, juego);
			juego.usarAtaque(numeroAtaque);
		}
		System.out.print("El ganador es: "+juego.ganador());
	}

	private static int elegirAtaque(Scanner leer, Juego juego) {
		int numeroAtaque = 0;
		System.out.print("Es Turno "+juego.jugadorActual+"\n");
		System.out.print("Elija el ataque \n"
				+ "1- Ataque Especial elemento "+juego.elementoMonstruoActual()+ "\n"
				+ "2- Ataque Simple elemento "+juego.elementoMonstruoActual()+"\n"
				+ "3- Ataque Especial elemento "+juego.elemento2MonstruoActual()+ "\n"
				+ "4- Ataque Simple elemento "+juego.elemento2MonstruoActual()+"\n");
		try {
			numeroAtaque = leer.nextInt();
			rangoValidoDel1Al4(numeroAtaque);
		}
			catch (InputMismatchException e) {
				System.out.println("Caracter no valido, acegurese de ingresar un número de ataque valido");
	            	leer.nextLine();
	            	numeroAtaque = elegirAtaque(leer, juego);
	            	}
		catch (NumeroDeRangoEquivocadoException e) {
			System.out.println(e.getMessage());
            	leer.nextLine();
            	numeroAtaque = elegirAtaque(leer, juego);
            	}
		return numeroAtaque;
	}
	
	
	/*
	 * Valida que en el metodo "elegirAtaque" el usuario solo ingrese un numero del 1 al 4
	 */
	static void rangoValidoDel1Al4(int numeroAtaque)throws NumeroDeRangoEquivocadoException{
        if((numeroAtaque>4)||(numeroAtaque<0)){
            throw new NumeroDeRangoEquivocadoException();
        }
        
        
}
	
	
}
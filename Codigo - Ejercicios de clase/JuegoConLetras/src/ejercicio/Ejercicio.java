package ejercicio;

import java.util.Arrays;

public class Ejercicio {

	public static void main(String[] args) {
		SopaDeLetra sopita = new SopaDeLetra("entrada.in");
		
		for (int i = 0; i < sopita.getSopaDeLetras().length; i++) {					
			System.out.println(Arrays.toString(sopita.getSopaDeLetras()[i]));			
		}
		
		sopita.prepararResultado();
	}

}

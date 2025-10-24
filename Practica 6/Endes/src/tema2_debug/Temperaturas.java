package tema2_debug;

import java.util.Scanner;

/**
 * Programa con errores para practicar la depuración. El programa pide una
 * temperatura y muestra si hace frío, calor o temperatura templada. Después,
 * repite mientras el usuario quiera continuar.
 */
public class Temperaturas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		mostrarMensajeBienvenida(); // No estaba cerrado

		boolean continuar = true;

		// While sin cerrar con llaves
		// Condicion de while incorrecta
		while (true) {

			double temperatura = pedirTemperatura(sc);// No estaba cerrado
			mostrarResultado(temperatura);// No estaba cerrado

			System.out.print("¿Desea introducir otra temperatura? (s/n): ");
			String respuesta = sc.next();
			// if sin llaves de avertura y cierre. sc.close estaba fuera haciendo que aunque
			// quisiera seguir en el programa me sacaba.
			if (respuesta == "n" || respuesta == "N") {
				continuar = false;
				sc.close();// RGCS20252410: no estaba bien cerrado, esta fuera de la función, y fuera del
							// if
				System.out.println("Programa finalizado."); // RGCS20252410: no estaba bien cerrado, estaba fuera de la
															// función
			}

		}

	}

	public static void mostrarMensajeBienvenida() {
		System.out.println("Bienvenido al analizador de temperaturas.");
		System.out.println("Este programa indica si hace frío, calor o está templado.");
	}

	public static double pedirTemperatura(Scanner sc) {
		double t;
		do {
			System.out.print("Introduce la temperatura en grados: ");
			t = sc.nextDouble();
			// Es necesario poner la condicion OR para que la condición de fuera de rango se
			// cumpla.
			if (t < -10 || t > 50) {
				System.out.println("Temperatura fuera del rango permitido (-10 a 50).");
			}
		} while (t < -10 || t > 50); // Esa o esa pero no las dos gil
		return t;
	}

	public static void mostrarResultado(double temperatura) {
		// Ni if else if ni tienen llaves de avertura ni de cierre
		if (temperatura < 15) {
			System.out.println("Hace frío.");
		} else if (temperatura >= 15 && temperatura < 30) {
			System.out.println("Temperatura templada."); // Estaba sin cerrar
		} else if (temperatura >= 30) {
			System.out.println("¡Hace mucho calor!");
		} else
			System.out.println("Valor no reconocido.");
	}

}
/*
 * Si, debido a que facilita la comprensión del código, fomenta el intercambio
 * de conocimientos, lo que capacita a un equipo para saber cómo funcionan los
 * procesos y cómo suelen ser los proyectos finalizados. Es necesario para
 * garantizar la eficiencia.
 * 
 */

import java.util.Scanner;

/**
 * @author Igor Bueno
 *Clase donde están todas las funciones del programa
 */
public class Funciones {

	/**
	 * Funcion que calcula la masa corporal
	 * @param peso de la persona
	 * @param altura de la persona
	 * @return de vuelve el Indice de masa corporal
	 */
	public double calcularIMC(String peso, String altura) {
		double imc = Double.valueOf(peso) / (Double.valueOf(altura) * Double.valueOf(altura));
		return imc;
	}

	/**
	 * @param altura
	 * @param sexo
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public double pesoIdeal(String altura, String sexo) {
		double pesoIdeal = 0;
		double hombres = 0.75;
		double mujeres = 0.675;
		if (sexo.equals("H") || sexo.equals("h")) {
			pesoIdeal = (hombres * (Double.valueOf(altura)*100)) - 62.5;
		} else {
			pesoIdeal = (mujeres * (Double.valueOf(altura)*100)) - 56.25;
		}

		return pesoIdeal;
	}

	/**
	 * Función que imprime según IMC, en que condición estas y que deberías hacer.
	 * @param imc tu imc
	 * @param pesoIdeal el peso ideal que deberias tener
	 * @param nombre tu nombre,para saber a quién se lo dice
	 * @param peso 
	 */
	public void imprimir(double imc, double pesoIdeal, String nombre, String peso) {
		String indice = "";
		String resultado = "";
		if (imc < 18) {
			indice = "Peso bajo";
		} else if (imc >= 18 && imc < 25) {
			indice = "Peso normal";
		} else if (imc >= 25 && imc < 27) {
			indice = "Sobrepeso";
		} else if (imc >= 27 && imc < 30) {
			indice = "Obesidad grado I";
		} else if (imc >= 30 && imc < 40) {
			indice = "Obesidad grado II";
		} else {
			indice = "Obesidad grado III Extrema";
		}
		
		if(pesoIdeal == Double.valueOf(peso)) {
			resultado = "Tu peso es perfecto";
		}else if(pesoIdeal < Double.valueOf(peso)) {
			resultado = "Deberías adelgazar";
		}else {
			resultado = "Deberías engordar";
		}
		System.out.println(nombre + ", tu IMC es: " + imc);
		System.out.println(indice);
		System.out.println("Tu peso ideal sería: " + pesoIdeal);
		System.out.println(resultado);

	}

	/**
	 * @param sc
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public String menu(Scanner sc) {
		String seguir = "";
		String si = "s";
		String no = "n";
		String msi = "S";
		String mno = "N";
		boolean error = true;
		do {
			System.out.println("¿Quieres continuar?(s/n);");
			seguir = sc.nextLine();

			if (seguir.equals(si) || seguir.equals(no)|| seguir.equals(msi)|| seguir.equals(mno)) {
				error = true;
			} else {
				error = false;
			}
		} while (!error);
		return seguir;
	}

	/**
	 * Función que muestre el resumen del programa, con la cantidad de personas que lo han usado y sus nombres
	 * @param lista lista de los nombres de las personas
	 * @param contador el número de personas que la han usado
	 */
	public void mostrarResumen(String lista, int contador) {
		System.out.println("El número total de personas sometidas al estudio es: "+contador);
		System.out.println(lista);
		
	}

}

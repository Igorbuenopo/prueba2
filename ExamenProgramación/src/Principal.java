import java.util.Scanner;

/**
 * @author Igor Bueno
 *Programa que calcula tu condición física
 */
public class Principal {

	/**
	 * @param args no args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Funciones f = new Funciones();
		boolean repetir = true;
		String lista = "Nombres: ";
		int contador = 0;
		do {
		System.out.println("Obtener IMC y Peso Ideal");
		String vacio = "";
		String masculino = "h";
		String femenino = "m";
		String hombre = "H";
		String mujer = "M";
		String altura = "";
		String nombre = "";
		String peso = "";
		String sexo = "";

		boolean nombreError = true;

		do {
			System.out.println("Nombre: ");
			nombre = sc.nextLine();

			if (!nombre.equals(vacio)) {
				nombreError = true;
			} else {
				System.out.println("Nombre incorrecto");
				nombreError = false;
			}

		} while (!nombreError);

		boolean sexoError = true;

		do {
			System.out.println("Sexo(H/M): ");
			sexo = sc.nextLine();

			if (sexo.equals(masculino) || sexo.equals(femenino) || sexo.equals(hombre) || sexo.equals(mujer)) {
				sexoError = true;
			} else {
				System.out.println("Sexo incorrecto");
				sexoError = false;
			}

		} while (!sexoError);

		boolean pesoError = true;

		do {
			System.out.println("Peso(Kg): ");
			peso = sc.nextLine();
			double p = 0;
			try {
				p = Double.valueOf(peso);
				if (p > 0 && p < 250) {
					pesoError = true;
				} else {
					System.out.println("Peso incorrecto");
					pesoError = false;
				}

			} catch (Exception e) {
				System.out.println("Peso incorrecto");
				pesoError = false;
			}

		} while (!pesoError);

		boolean alturaError = true;

		do {
			System.out.println("Altura(metros): ");
			altura = sc.nextLine();
			double a = 0;
			try {
				a = Double.valueOf(altura);
				if (a > 0 && a <= 2) {
					alturaError = true;
				} else {
					System.out.println("Altura incorrecto");
					alturaError = false;
				}

			} catch (Exception e) {
				System.out.println("ALtura incorrecto");
				alturaError = false;
			}

		} while (!alturaError);
		
		lista += nombre +", ";
		contador++;
		
		double imc = f.calcularIMC(peso, altura);
		double pesoIdeal = f.pesoIdeal(altura, sexo);
		
		f.imprimir(imc, pesoIdeal, nombre, peso);
		
		String seguir = f.menu(sc);
		if(seguir.equals("s")) {
			repetir = false;
		}else {
			repetir = true;
		}
		
		}while(!repetir);
		
		f.mostrarResumen(lista, contador);
		
		
		sc.close();
		
		

	}

}

package impl;

import javax.jws.WebService;
import interfaces.Calculadora;

@WebService(endpointInterface="interfaces.Calculadora")
public class CalculadoraImpl implements Calculadora{

	@Override
	public double operation(int opcion, int valor1, int valor2) {
		double resultado = 0;
		switch (opcion) {
		case 1:
			resultado = valor1 + valor2;
			break;
		case 2:
			resultado = valor1 - valor2;
			break;
		case 3:
			resultado = valor1 * valor2;
			break;
		case 4:
			resultado = valor1 / valor2;
			break;

		default:
			break;
		}
		return resultado;
	}
	

}

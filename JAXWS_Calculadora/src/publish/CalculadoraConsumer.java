package publish;

import impl.Calculadora;
import impl.CalculadoraImplService;

public class CalculadoraConsumer {
	public static void main(String[] args) {
		CalculadoraImplService calculadoraService = new CalculadoraImplService();
		Calculadora consumer = calculadoraService.getCalculadoraImplPort();
		System.out.println("Suma");
		System.out.println(consumer.operation(1, 6, 4));
		System.out.println("Resta");
		System.out.println(consumer.operation(2, 6, 4));
		System.out.println("Multiplicacion");
		System.out.println(consumer.operation(3, 6, 4));
		System.out.println("Division");
		System.out.println(consumer.operation(4, 6, 2));
	}
}

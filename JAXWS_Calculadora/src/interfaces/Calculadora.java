package interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculadora {
	@WebMethod
	public double operation (int opcion, int valor1, int valor2);
}

package publish;

import javax.xml.ws.Endpoint;
import impl.CalculadoraImpl;

public class CalculadoraPublish {
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:1515/WS/Calculadora", new CalculadoraImpl());
		// http://localhost:1515/WS/Calculadora?wsdl
		/*
		 * Voy a una consola SRC/
		 * wsimport -s . http://localhost:1515/WS/Calculadora?wsdl
		 * */
	}
}

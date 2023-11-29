package controlador;

import vista.VentanaAñadir;
import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal ventana = new VentanaPrincipal();
		VentanaAñadir ventana2 = new VentanaAñadir();
		VentanaEditar ventana3 = new VentanaEditar();
		
		Controlador controlador = new Controlador(ventana);
		ventana.establecerManejador(controlador);
		

	}

}

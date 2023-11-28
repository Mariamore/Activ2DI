package controlador;

import vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		VentanaPrincipal ventana = new VentanaPrincipal();
		GestorEventos gestor = new GestorEventos(ventana);
		ventana.establecerGestor(gestor);

	}

}

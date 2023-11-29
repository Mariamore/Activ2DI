package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VentanaAñadir;
import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class ControladorEditar implements ActionListener {
	
	
	//Constructor
	
	private VentanaPrincipal ventana;
	private VentanaEditar ventanaEditar;

	public ControladorEditar(VentanaEditar ventanaEditar, VentanaPrincipal ventana) {
		this.ventanaEditar = ventanaEditar;
		this.ventana = ventana;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == ventanaEditar.getBotonOk()) {
			String nombreNuevo, telefonoNuevo;
			
			nombreNuevo= ventanaEditar.getCajaNombre().getText();
			telefonoNuevo = ventanaEditar.getCajaTelefono().getText();
			
			//ventana.getModeloTabla().addRow(new String[]{ventanaEditar.getCajaNombre().getText(),ventanaEditar.getCajaTelefono().getText()});
			ventana.agregarDatos(nombreNuevo, telefonoNuevo);
			ventanaEditar.dispose();
		}
		if(e.getSource()== ventanaEditar.getBotonCancel()) {
			ventanaEditar.dispose();
		}
		
	}

}

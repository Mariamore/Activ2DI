package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaAñadir;
import vista.VentanaPrincipal;

public class ControladorAñadir implements ActionListener {
	
	private VentanaAñadir ventanaAñadir;
	private VentanaPrincipal ventana;
	
	public ControladorAñadir(VentanaAñadir ventanaAñadir, VentanaPrincipal ventana) {
		this.ventanaAñadir = ventanaAñadir;
		this.ventana = ventana;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ventanaAñadir.getBotonOk()) {

			if(ventanaAñadir.getCajaNombre().getText().isEmpty()) {		
				JOptionPane.showInternalMessageDialog(null, "No puede estar vacio");
			}else if(ventanaAñadir.getCajaTelefono().getText().isEmpty()) {
				JOptionPane.showInternalMessageDialog(null, "No puede estar vacio");
			}else {	
				ventana.getModeloTabla().addRow(new String[]{ventanaAñadir.getCajaNombre().getText(),ventanaAñadir.getCajaTelefono().getText()});
				ventanaAñadir.dispose();
			}
		}
		
		if(e.getSource()== ventanaAñadir.getBotonCancel()) {
			ventanaAñadir.dispose();
		}
		
	}



}

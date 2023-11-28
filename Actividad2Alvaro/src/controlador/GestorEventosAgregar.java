package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaAgregar;
import vista.VentanaPrincipal;

public class GestorEventosAgregar implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private VentanaAgregar ventanaAgregar;
	
	public GestorEventosAgregar(VentanaPrincipal ventanaPrincipal,VentanaAgregar ventanaAgregar) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaAgregar = ventanaAgregar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaAgregar.getBotonCancelar()) {
			ventanaAgregar.dispose();
		}
		if(e.getSource() == ventanaAgregar.getBotonOk()) {
			if(ventanaAgregar.getCajaNombre().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Aviso", 
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(ventanaAgregar.getCajaTelefono().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío", 
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					String nombre = ventanaAgregar.getCajaNombre().getText();
					String telefono = ventanaAgregar.getCajaTelefono().getText();
					try {
						long numero = Long.parseLong(telefono);
						if(telefono.length()!=9) {
							JOptionPane.showMessageDialog(null, "El teléfono debe tener 9 dígitos", 
									"Aviso", JOptionPane.INFORMATION_MESSAGE);
						}else {
							String[] contacto = {nombre,telefono};
							ventanaPrincipal.getModel().addRow(contacto);
							ventanaAgregar.dispose();
						}
						
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Introduzca un número de teléfono válido", 
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
	}
	
}

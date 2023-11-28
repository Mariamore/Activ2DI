package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class GestorEventosEditar implements ActionListener {
	
	private VentanaPrincipal ventanaPrincipal;
	private VentanaEditar ventanaEditar;
	
	public GestorEventosEditar(VentanaPrincipal ventanaPrincipal, VentanaEditar ventanaEditar) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaEditar = ventanaEditar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaEditar.getBotonCancelar()) {
			ventanaEditar.dispose();
		}
		if(e.getSource() == ventanaEditar.getBotonOk()) {
			if(ventanaEditar.getCajaNombre().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Aviso", 
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(ventanaEditar.getCajaTelefono().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacío", 
							"Aviso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					String nombre = ventanaEditar.getCajaNombre().getText();
					String telefono = ventanaEditar.getCajaTelefono().getText();
					try {
						// Para comprobar que sea un número, lo intentamos convertir a long.
						long numero = Long.parseLong(telefono);
						if(telefono.length()!=9) {
							JOptionPane.showMessageDialog(null, "El teléfono debe tener 9 dígitos", 
									"Aviso", JOptionPane.INFORMATION_MESSAGE);
						}else {
							int fila = ventanaEditar.getFila();
							ventanaPrincipal.getModel().setValueAt(nombre, fila, 0);
							ventanaPrincipal.getModel().setValueAt(telefono, fila, 1);
							ventanaEditar.dispose();
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

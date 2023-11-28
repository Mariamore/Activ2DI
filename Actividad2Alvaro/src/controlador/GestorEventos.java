package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaAgregar;
import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class GestorEventos implements ActionListener{
	
	private VentanaPrincipal ventana;
	private VentanaEditar ventanaEditar;
	private VentanaAgregar ventanaAgregar;
	
	public GestorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventana.getBotonEditar()) {
			int fila = ventana.getTabla().getSelectedRow();
			if(ventana.getTabla().isRowSelected(fila)) {
				String nombre = (String) ventana.getModel().getValueAt(fila,0);
				String telefono = (String) ventana.getModel().getValueAt(fila,1);
				ventanaEditar = new VentanaEditar(nombre,telefono,fila);
				GestorEventosEditar gestor = new GestorEventosEditar(ventana,ventanaEditar);
				ventanaEditar.establecerGestor(gestor);
				ventanaEditar.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un contacto", "Aviso", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == ventana.getBotonEliminar()) {
			int fila = ventana.getTabla().getSelectedRow();
			if(ventana.getTabla().isRowSelected(fila)) {
				ventana.getModel().removeRow(ventana.getTabla().getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un contacto", "Aviso", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == ventana.getBotonAgregar()) {
			ventanaAgregar = new VentanaAgregar();
			GestorEventosAgregar gestor = new GestorEventosAgregar(ventana,ventanaAgregar);
			ventanaAgregar.establecerGestor(gestor);
			ventanaAgregar.setVisible(true);
		}
	}

}

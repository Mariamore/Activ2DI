package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.VentanaAñadir;
import vista.VentanaEditar;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener{
	
	private VentanaPrincipal ventana;
	private VentanaAñadir ventanaAñadir;
	private VentanaEditar ventanaEditar;
	private int filaSeleccionada = -1;
	
	private DefaultTableModel modeloTabla;
	private JTable tabla;
	
	
	
	public Controlador(VentanaPrincipal ventana) {
		this.ventana = ventana;
		this.filaSeleccionada= filaSeleccionada;
		
		cargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton añadir
		if(e.getSource() == ventana.getBotonAñadir()){
			 //Creamos el objeto de la ventana 2 y la ponemos visible
			ventanaAñadir = new VentanaAñadir();
			//Llamamos al Controlador de la ventana de añadir
			ventanaAñadir.establecerManejador2(new ControladorAñadir(ventanaAñadir, ventana));
			ventanaAñadir.setVisible(true);
			
			}
		
		
		//Boton editar
		
		   if (e.getSource()== ventana.getBotonEditar()) {
		    	  
		    	  if (filaSeleccionada != -1) {
		    		  //Variables para extraer los datos de la tabla, usamos el metodo valueAt para extraer el valor de las celdas
	                    String nombre = ventana.getTabla().getValueAt(filaSeleccionada, 0).toString();
	                    String telefono = ventana.getTabla().getValueAt(filaSeleccionada, 1).toString();

	                    ventanaEditar = new VentanaEditar();
	                    //Metodo para extrar el contenido a las cajas
	                    ventanaEditar.establecerDatos(nombre, telefono);
	                    ventanaEditar.establecerManejador3(new ControladorEditar(ventanaEditar, ventana));
	                    ventanaEditar.setVisible(true);
		            }  
		        }
		   
		   //Boton Eliminar
			   
			   if (e.getSource() == ventana.getBotonEliminar()) {
		            int filaSeleccionada = ventana.getTabla().getSelectedRow();

		            if (filaSeleccionada != -1) {
		                DefaultTableModel modeloTabla = (DefaultTableModel) ventana.getTabla().getModel();
		                modeloTabla.removeRow(filaSeleccionada);
		            }
		   }
		
		
		//Evento para la seleccionar una fila con el raton de la tabla
		ventana.getTabla().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        if (e.getSource() == ventana.getTabla()) {
		            filaSeleccionada = ventana.getTabla().getSelectedRow();
		        }
		        
		   
		    }
		});
		
	}
	
	public void cargarDatos() {
		
		ventana.getModeloTabla().addRow( new String[] {"Laura Gonzalez","680026554"});
		ventana.getModeloTabla().addRow( new String[] {"Maria Trenado","685095354"});
		ventana.getModeloTabla().addRow( new String[] {"Enrique Martinez","665614524"});
		ventana.getModeloTabla().addRow( new String[] {"Gregorio Merino","605958734"});
		ventana.getModeloTabla().addRow( new String[] {"Ana Salcedo","624859841"});
		ventana.getModeloTabla().addRow( new String[] {"Jose Martin","658741256"});
		ventana.getModeloTabla().addRow( new String[] {"Maria Trenado","654935671"});
		ventana.getModeloTabla().addRow( new String[] {"Enrique Martinez","621014574"});
		ventana.getModeloTabla().addRow( new String[] {"Gregorio Merino","604969559"});
		ventana.getModeloTabla().addRow( new String[] {"Ana Salcedo","612852659"});
		ventana.getModeloTabla().addRow( new String[] {"Laura Gonzalez","666326555"});
		ventana.getModeloTabla().addRow( new String[] {"Maria Trenado","626458712"});
		ventana.getModeloTabla().addRow( new String[] {"Enrique Martinez","630561400"});
		ventana.getModeloTabla().addRow( new String[] {"Gregorio Merino","625578732"});
		ventana.getModeloTabla().addRow( new String[] {"Ana Salcedo","674824847"});
	}
	
	  
}

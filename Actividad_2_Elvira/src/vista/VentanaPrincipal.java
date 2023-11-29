package vista;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {
	
	
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JButton botonAñadir, botonEditar, botonEliminar;
	private JScrollPane scroll;
	
	private VentanaEditar ventanaEdit;
	
	//Contructor
	
	public VentanaPrincipal() {
		
		//Propiedades de la ventanta
		setTitle("Agenda Contactos");
		setBounds(100, 100, 571, 450); //Tamaño y ubicacion a la ventana
		getContentPane().setLayout(null);
		setResizable(false); //no poder redimensionar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//decidimos que hacer cuando se cierra la ventana
		setLocationRelativeTo(null);//poner los componentes donde nosotros queramos
		//Icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/icono_agenda.png"));
		
		iniciarComponentes();
		
		setVisible(true);
		
	}
	
	
	
	//Getter and Setters
	
	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JButton getBotonAñadir() {
		return botonAñadir;
	}

	public void setBotonAñadir(JButton botonAñadir) {
		this.botonAñadir = botonAñadir;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public void setBotonEditar(JButton botonEditar) {
		this.botonEditar = botonEditar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	

	private void iniciarComponentes() {
		
		//Tabla inicializamos las variables
		
		String[]nombreColumnas = {"Nombre","Teléfono"};
		modeloTabla = new DefaultTableModel(nombreColumnas, 0);
		tabla = new JTable(modeloTabla);
		
		//Scroll
		
		scroll = new JScrollPane(tabla);//Donde queremos el scroll, en este caso la tabla
		scroll.setBounds(175, 72, 200, 200);
		getContentPane().add(scroll);
		

		//Botones
		
		botonAñadir = new JButton("Añadir Contactos");
		botonAñadir.setBounds(209, 312, 150, 40);
		getContentPane().add(botonAñadir);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(417, 202, 89, 30);
		getContentPane().add(botonEliminar);
		
		botonEditar = new JButton("Editar");
		
		
		botonEditar.setBounds(417, 242, 89, 30);
		getContentPane().add(botonEditar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 100, 173));
		panel.setBounds(0, 0, 111, 413);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 148, 233));
		panel_1.setBounds(98, 0, 46, 413);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setBounds(178, 21, 64, 21);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(21, 95, 176));
		lblNewLabel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		
	}
	
	public void establecerManejador(Controlador controlador) {
		
		botonAñadir.addActionListener(controlador);
		botonEliminar.addActionListener(controlador);
		botonEditar.addActionListener(controlador);		
		
	}

	//Metodo para editar los datos 
	public void agregarDatos(String nombre, String telefono) {
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.setValueAt(nombre, filaSeleccionada, 0); // Actualiza el nombre
            modeloTabla.setValueAt(telefono, filaSeleccionada, 1); // Actualiza el teléfono
        }
	
	
	}
}

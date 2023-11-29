package vista;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import controlador.ControladorAñadir;
import javax.swing.JPanel;
import java.awt.Color;

public class VentanaAñadir extends JFrame{
	
	private JLabel nombre, telefono;
	private JTextField cajaNombre, cajaTelefono;
	private JButton botonOk, botonCancel;
	private JPanel panel;
	private JPanel panel_1;
	
	public VentanaAñadir() {
		
		
		
		setBounds(50, 50, 383, 276);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Nuevo Contacto");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/icono_agenda.png"));
		
		inicializarComponentes();
		
		
		
	}
	
	//Getter and setters
	

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getTelefono() {
		return telefono;
	}

	public void setTelefono(JLabel telefono) {
		this.telefono = telefono;
	}

	public JTextField getCajaNombre() {
		return cajaNombre;
	}

	public void setCajaNombre(JTextField cajaNombre) {
		this.cajaNombre = cajaNombre;
	}

	public JTextField getCajaTelefono() {
		return cajaTelefono;
	}

	public void setCajaTelefono(JTextField cajaTelefono) {
		this.cajaTelefono = cajaTelefono;
	}

	public JButton getBotonOk() {
		return botonOk;
	}

	public void setBotonOk(JButton botonOk) {
		this.botonOk = botonOk;
	}

	public JButton getBotonCancel() {
		return botonCancel;
	}

	public void setBotonCancel(JButton botonCancel) {
		this.botonCancel = botonCancel;
	}
	

	private void inicializarComponentes() {
		
		nombre = new JLabel("Nombre :");
		nombre.setBounds(116, 63, 57, 30);
		getContentPane().add(nombre);
		
		telefono = new JLabel("Teléfono :");
		telefono.setBounds(116, 103, 74, 30);
		getContentPane().add(telefono);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(191, 64, 120, 30);
		getContentPane().add(cajaNombre);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(191, 104, 120, 30);
		getContentPane().add(cajaTelefono);
		
		botonOk = new JButton("Aceptar");
		botonOk.setBounds(116, 165, 85, 30);
		getContentPane().add(botonOk);
		
		botonCancel = new JButton("Cancelar");
		botonCancel.setBounds(218, 165, 93, 30);
		getContentPane().add(botonCancel);
		
		panel = new JPanel();
		panel.setBackground(new Color(33, 100, 173));
		panel.setBounds(0, 0, 59, 263);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 148, 233));
		panel_1.setBounds(57, 0, 33, 263);
		getContentPane().add(panel_1);
		
		
	}
	
	public void establecerManejador2(ControladorAñadir controlador) {
		
		botonOk.addActionListener(controlador);
		botonCancel.addActionListener(controlador);
		
		
	}
	

	
	
	
}
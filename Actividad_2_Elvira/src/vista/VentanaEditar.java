package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorEditar;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

public class VentanaEditar extends JFrame {
	
	private JLabel nombre, Teléfono;
	private JTextField cajaNombre, cajaTelefono;
	private JButton botonOk, botonCancel;
	private JPanel panel;
	private JPanel panel_1;
	
	public VentanaEditar() {
		
	
		setBounds(50, 50, 390, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Editar Contacto");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes/icono_agenda.png"));
		inicializarComponentes();
		
		
		
	}

	//Gettter and setters
	
	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JLabel getTelefono() {
		return Teléfono;
	}

	public void setTelefono(JLabel telefono) {
		this.Teléfono = telefono;
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
		nombre.setBounds(123, 60, 61, 30);
		getContentPane().add(nombre);
		
		Teléfono = new JLabel("Teléfono :");
		Teléfono.setBounds(123, 117, 61, 30);
		getContentPane().add(Teléfono);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(191, 61, 120, 30);
		getContentPane().add(cajaNombre);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(191, 118, 120, 30);
		getContentPane().add(cajaTelefono);
		
		botonOk = new JButton("Aceptar");
		botonOk.setBounds(132, 184, 91, 30);
		getContentPane().add(botonOk);
		
		botonCancel = new JButton("Cancelar");
		botonCancel.setBounds(233, 184, 91, 30);
		getContentPane().add(botonCancel);
		
		panel = new JPanel();
		panel.setBackground(new Color(33, 100, 173));
		panel.setBounds(0, 0, 67, 263);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 148, 233));
		panel_1.setBounds(60, 0, 35, 263);
		getContentPane().add(panel_1);
		
		
	}
	


	public void establecerManejador3(ControladorEditar controlador) {
		
		botonOk.addActionListener(controlador);
		botonCancel.addActionListener(controlador);
		cajaNombre.addActionListener(controlador);
		cajaTelefono.addActionListener(controlador);
		

	}
	
	public void establecerDatos(String nombre, String telefono) {
       
        cajaNombre.setText(nombre);
        cajaTelefono.setText(telefono);
    }


}

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.GestorEventosEditar;

public class VentanaEditar extends JDialog{
	
	private int fila;
	private JLabel etiquetaNombre, etiquetaTelefono;
	private JTextField cajaNombre, cajaTelefono;
	private JButton botonOk, botonCancelar;
	private GestorEventosEditar gestor;
	
	public VentanaEditar(String nombre, String telefono, int fila) {
		this.fila = fila;
		setSize(400,300);
		this.getContentPane().setBackground(new Color(150,198,224));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Editar contacto");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/editar-contacto.png"));
		setLayout(null);
		inicializarComponentes();
		cajaNombre.setText(nombre);
		cajaTelefono.setText(telefono);
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(50,60,65,30);
		etiquetaNombre.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(etiquetaNombre);
		
		etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setBounds(50,100,65,30);
		etiquetaTelefono.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(etiquetaTelefono);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(140,60,180,30);
		cajaNombre.setBackground(new Color(81,158,207));
		cajaNombre.setForeground(Color.WHITE);
		cajaNombre.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(cajaNombre);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBounds(140,100,180,30);
		cajaTelefono.setBackground(new Color(81,158,207));
		cajaTelefono.setForeground(Color.WHITE);
		cajaTelefono.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(cajaTelefono);
		
		botonOk = new JButton("OK");
		botonOk.setBounds(150,220,100,30);
		botonOk.setBackground(new Color(81,158,207));
		botonOk.setForeground(Color.WHITE);
		botonOk.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(botonOk);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(260,220,100,30);
		botonCancelar.setBackground(new Color(81,158,207));
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(botonCancelar);
	}
	
	public void establecerGestor(GestorEventosEditar gestor) {
		this.gestor = gestor;
		botonOk.addActionListener(gestor);
		botonCancelar.addActionListener(gestor);
	}

	public JButton getBotonOk() {
		return botonOk;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
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

	public int getFila() {
		return fila;
	}
	
	

}

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import controlador.GestorEventos;

public class VentanaPrincipal extends JFrame {
	
	private JLabel agenda,logo;
	private JTable tabla;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton botonEliminar, botonEditar, botonAgregar;
	
	public VentanaPrincipal() {
		setSize(850,550);
		this.getContentPane().setBackground(new Color(150,198,224));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Libreta de contactos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/libreta-de-contactos.png"));
		setLayout(null);
		inicializarComponentes();
		cargarContactos();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		agenda = new JLabel("AGENDA");
		agenda.setBounds(530, 55, 250, 60);
		agenda.setBackground(new Color(81,158,207));
		agenda.setForeground(Color.BLACK);
		agenda.setFont(new Font("Helvetica", Font.BOLD, 48));
		add(agenda);
		
		String[] columnas = {"Nombre","Teléfono"};
		model = new DefaultTableModel(columnas, 0);
		tabla = new JTable(model);
		tabla.setBackground(new Color(81,158,207));
		tabla.setForeground(Color.WHITE);
		tabla.setFont(new Font("Helvetica", Font.BOLD, 14));
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBackground(new Color(81,158,207));
		scrollPane.setBounds(50, 50, 350, 400);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(550, 150, 170, 30);
		botonEliminar.setBackground(new Color(81,158,207));
		botonEliminar.setForeground(Color.WHITE);
		botonEliminar.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(botonEliminar);
		
		botonEditar = new JButton("Editar");
		botonEditar.setBounds(550, 200, 170, 30);
		botonEditar.setBackground(new Color(81,158,207));
		botonEditar.setForeground(Color.WHITE);
		botonEditar.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(botonEditar);
		
		botonAgregar = new JButton("Añadir contacto");
		botonAgregar.setBounds(550, 250, 170, 30);
		botonAgregar.setBackground(new Color(81,158,207));
		botonAgregar.setForeground(Color.WHITE);
		botonAgregar.setFont(new Font("Helvetica", Font.BOLD, 14));
		add(botonAgregar);
		
		Image img = new ImageIcon("src/imagenes/unirfp.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		logo.setBounds(580,340,110,110);
		add(logo);
	}
	
	public void establecerGestor(GestorEventos gestor) {
		botonEditar.addActionListener(gestor);
		botonEliminar.addActionListener(gestor);
		botonAgregar.addActionListener(gestor);
	}
	
	public void cargarContactos() {
		String [] contacto1 = {"Juan López", "916210051"};
		model.addRow(contacto1);
		String [] contacto2 = {"Ana Sánchez", "936952800"};
		model.addRow(contacto2);
		String [] contacto3 = {"Alfredo Rodríguez", "617003377"};
		model.addRow(contacto3);
		String [] contacto4 = {"Elena Sanjuan", "948609266"};
		model.addRow(contacto4);
		String [] contacto5 = {"Pablo Pérez", "605220505"};
		model.addRow(contacto5);
		String [] contacto6 = {"Marta Sanz", "615280488"};
		model.addRow(contacto6);
		String [] contacto7 = {"Mario Serrano", "927212527"};
		model.addRow(contacto7);
		String [] contacto8 = {"Esther Martín", "649153821"};
		model.addRow(contacto8);
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JTable getTabla() {
		return tabla;
	}
	
	

}

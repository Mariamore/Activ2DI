package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.EventManager;

public class MainWindow extends JFrame{
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private JButton addButton, deleteButton, editButton, saveButton;
	private JLabel titleLabel;
	
	//Constructor
	
	public MainWindow() {
		
		setLocationRelativeTo(null);
		setTitle("Mis Contactos");
		setLayout(null);
		setSize(550,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		getContentPane().setBackground(new Color(225,250,252));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/phonebook.png"));
		setVisible(true);
		
	}
	
	//Generamos getters
	
	public JTable getTable() {
		return table;
	}


	public JButton getAddButton() {
		return addButton;
	}


	public JButton getDeleteButton() {
		return deleteButton;
	}


	public JButton getEditButton() {
		return editButton;
	}


	public JButton getSaveButton() {
		return saveButton;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	private void initComponents() {
		
	
		
		titleLabel = new JLabel("Mis Contactos");
		titleLabel.setBounds(135,30,400,100);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setForeground(new Color(58,77,213));
		
		add(titleLabel);
		
		String [] columnNames = {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setForeground(new Color(15,60,144));
		scroll.setBounds(68, 150, 400, 300);
		table.setBorder(null);
		add(scroll);
		
		Image addImg = new ImageIcon("src/images/add.png").getImage();
		addButton = new JButton(new ImageIcon(addImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		addButton.setBorderPainted(false);
		addButton.setBackground(new Color(225,250,252));
		addButton.setBounds(70, 480, 50, 50);
		add(addButton);
		
		Image editImg = new ImageIcon("src/images/edit.png").getImage();
		editButton = new JButton(new ImageIcon(editImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		editButton.setBorderPainted(false);
		editButton.setBackground(new Color(225,250,252));
		editButton.setBounds(190, 480, 50, 50);
		add(editButton);
		
		Image deleteImg = new ImageIcon("src/images/delete.png").getImage();
		deleteButton = new JButton(new ImageIcon(deleteImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		deleteButton.setBorderPainted(false);
		deleteButton.setBackground(new Color(225,250,252));
		deleteButton.setBounds(300, 480, 50, 50);
		add(deleteButton);
		
		Image saveImg = new ImageIcon("src/images/save.png").getImage();
		saveButton = new JButton(new ImageIcon(saveImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		saveButton.setBorderPainted(false);
		saveButton.setBackground(new Color(225,250,252));
		saveButton.setBounds(410, 480, 45, 45);
		add(saveButton);
		
	}
	
	
	public void setEventManager(EventManager eventManager) {
		addButton.addActionListener(eventManager);
		editButton.addActionListener(eventManager);
		deleteButton.addActionListener(eventManager);
		saveButton.addActionListener(eventManager);
	}

}

package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EventManagerEdit;

public class EditContactWindow extends JFrame{
	private JLabel nameLabel, phoneLabel;
	private JTextField nameTextF, phoneTextF;
	private JButton okButton, cancelButton;
	

	public EditContactWindow() {
		
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,250);
		setTitle("Editar contacto");
		initComponents();
		setVisible(true);
	}
	
	//Getters
	public JTextField getNameTextF() {
		return nameTextF;
	}

	public JTextField getPhoneTextF() {
		return phoneTextF;
	}
	
	
	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
	
	private void initComponents() {
		nameLabel = new JLabel("Nombre:");
		nameLabel.setBounds(50,50,80,30);
		add(nameLabel);
		
		nameTextF = new JTextField();
		nameTextF.setBounds(140, 50, 100,30);
		add(nameTextF);
		
		phoneLabel = new JLabel("Teléfono:");
		phoneLabel.setBounds(50,100,80,30);
		add(phoneLabel);
		
		phoneTextF = new JTextField();
		phoneTextF.setBounds(140, 100, 100,30);
		add(phoneTextF);
		
		okButton = new JButton("OK");
		okButton.setBounds(50, 150, 80, 30);
		add(okButton);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(150, 150, 100, 30);
		add(cancelButton);
		
	}

	public void setEventManager(EventManagerEdit eventManager) {
		okButton.addActionListener(eventManager);
		cancelButton.addActionListener(eventManager);
	}
	
}

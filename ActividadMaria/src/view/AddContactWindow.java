package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EventManagerAdd;

public class AddContactWindow extends JDialog{
	
	private JLabel nameLabel, phoneLabel;
	private JTextField nameTextF, phoneTextF;
	private JButton okButton, cancelButton;
	
	public AddContactWindow() {
		
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,250);
		setTitle("Añadir contacto");
		getContentPane().setBackground(new Color(225,250,252));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/phonebook.png"));
		initComponents();
		setVisible(true);
	}
	
	
	
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
		nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		nameLabel.setForeground(new Color(15,60,144));
		nameLabel.setBounds(50,50,80,30);
		add(nameLabel);
		
		nameTextF = new JTextField();
		nameTextF.setFont(new Font("Arial", Font.PLAIN, 12));
		nameTextF.setForeground(new Color(15,60,144));
		nameTextF.setBounds(140, 50, 100,30);
		add(nameTextF);
		
		phoneLabel = new JLabel("Teléfono:");
		phoneLabel.setFont(new Font("Arial", Font.BOLD, 12));
		phoneLabel.setForeground(new Color(15,60,144));
		phoneLabel.setBounds(50,100,80,30);
		add(phoneLabel);
		
		phoneTextF = new JTextField();
		phoneTextF.setFont(new Font("Arial", Font.PLAIN, 12));
		phoneTextF.setForeground(new Color(15,60,144));
		phoneTextF.setBounds(140, 100, 100,30);
		add(phoneTextF);
		
		Image okImg = new ImageIcon("src/images/ok.png").getImage();
		okButton = new JButton(new ImageIcon(okImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		okButton.setBorderPainted(false);
		okButton.setBackground(new Color(225,250,252));
		okButton.setBounds(75, 150, 40, 40);
		add(okButton);
		
		Image cancelImg = new ImageIcon("src/images/cancel.png").getImage();
		cancelButton = new JButton(new ImageIcon(cancelImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		cancelButton.setBorderPainted(false);
		cancelButton.setBackground(new Color(225,250,252));
		cancelButton.setBounds(180, 150, 45, 45);
		add(cancelButton);
		
	}
	
	public void setEventManager (EventManagerAdd eventManager) {
		okButton.addActionListener(eventManager);
		cancelButton.addActionListener(eventManager);
	}
}

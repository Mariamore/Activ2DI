package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddContactWindow;
import view.MainWindow;

public class EventManagerAdd implements ActionListener{
	
	private MainWindow window;
	private AddContactWindow addWindow;
	
	public EventManagerAdd(MainWindow window, AddContactWindow addWindow) {
		this.window = window;
		this.addWindow = addWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addWindow.getOkButton()) {
			
			String name = addWindow.getNameTextF().getText();
			String phone = addWindow.getPhoneTextF().getText();
			if(checkData()) {
				String [] newRow = {name, phone};
				
				window.getTableModel().addRow(newRow);
				addWindow.dispose();
			}
			
		} else if (e.getSource() == addWindow.getCancelButton()) {
			addWindow.dispose();
		}
		
	}
	
private boolean checkData() {
		String name = addWindow.getNameTextF().getText();
		String phone = addWindow.getPhoneTextF().getText();
		String text;
		int rowNumber = window.getTableModel().getRowCount();
		
		//Comprobamos que el número de teléfono está solo compuesto por dígitos numéricos
		try {
			long phoneNumber = Long.parseLong(phone);
			//Comprobamos que el teléfono solo tenga 9 dígitos
			if(phone.length()>9 || phone.length()<9) {
				text = "El teléfono ha de tener 9 dígitos";
				JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
				addWindow.getPhoneTextF().requestFocus();
				return false;
			}
			
			//Comprobamos que el contacto no esté guardado ya en la tabla
			for(int i = 0; i < rowNumber; i++) {
				
				if(window.getTableModel().getValueAt(i, 0).toString().equalsIgnoreCase(name) )  {
					text = "Ya existe este contacto con un número de teléfono guardado en la tabla";
					JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
					addWindow.getPhoneTextF().requestFocus();
					return false;
				} else if (window.getTableModel().getValueAt(i, 1).toString().equals(phone)){
					text = "Este número ya está guardado en la tabla";
					JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
					addWindow.getPhoneTextF().requestFocus();
					return false;
				}
			
			}
			
//			//Comprobamos que el contacto no esté guardado ya en la tabla
//			for(int i = 0; i < rowNumber; i++) {
//				
//				if(window.getTableModel().getValueAt(i, 0).toString().equalsIgnoreCase(name) && window.getTableModel().getValueAt(i, 1).toString().equals(phone)) {
//					text = "Ese contacto ya está guardado en la tabla";
//					JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
//					addWindow.getPhoneTextF().requestFocus();
//					return false;
//				}
//			}
			
			return true;
		} catch (Exception ex) {
			text = "Introduce un número de teléfono correcto";
			JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
			addWindow.getPhoneTextF().requestFocus();
			return false;
		}
		
	}


}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.EditContactWindow;
import view.MainWindow;

public class EventManagerEdit implements ActionListener{

	private EditContactWindow editWindow;
	private MainWindow window;
	
	public EventManagerEdit(MainWindow window, EditContactWindow editWindow) {
		this.editWindow = editWindow;
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == editWindow.getOkButton()) {
			int row = window.getTable().getSelectedRow();
			String newName = editWindow.getNameTextF().getText();
			String newPhone = editWindow.getPhoneTextF().getText();
			if(checkData()) {
			String [] newData = {newName, newPhone};
			for(int col = 0;col <= newData.length -1; col++) {
				window.getTableModel().setValueAt(newData[col], row, col);
			}
			
			window.getTableModel().fireTableDataChanged();
			editWindow.dispose();
			}
		} else if (e.getSource() == editWindow.getCancelButton()) {
			editWindow.dispose();
			
		}
		
	}
	
	private boolean checkData() {
		String name = editWindow.getNameTextF().getText();
		String newPhone = editWindow.getPhoneTextF().getText();
		int rowNumber = window.getTableModel().getRowCount();
		String text;
		int row = window.getTable().getSelectedRow();
	
		//Comprobamos que el número de teléfono está solo compuesto por dígitos numéricos
		try {
			long phoneNumber = Long.parseLong(newPhone);
			//Comprobamos que el teléfono solo tenga 9 dígitos
			if(newPhone.length() > 9 || newPhone.length() < 9) {
				text = "El teléfono ha de tener 9 dígitos";
				JOptionPane.showMessageDialog(null, text, "¡Error!", JOptionPane.ERROR_MESSAGE);
				editWindow.getPhoneTextF().requestFocus();
				return false;
			}
			
		
			
			//Comprobamos que el contacto no esté guardado ya en la tabla
			for(int i = 0; i < rowNumber; i++) {
				
				if(window.getTableModel().getValueAt(i, 0).toString().equalsIgnoreCase(name) &&  !window.getTableModel().getValueAt(row, 0).equals(name))  {
					
						text = "Ya existe este contacto con un número de teléfono guardado en la tabla";
						JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
						editWindow.getPhoneTextF().requestFocus();
						return false;
					
				} else if (window.getTableModel().getValueAt(i, 1).toString().equals(newPhone) && !window.getTableModel().getValueAt(row, 1).equals(newPhone)){
					
						text = "Este número ya está guardado en la tabla";
						JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
						editWindow.getPhoneTextF().requestFocus();
						return false;
					
				}
			
		}
			if(name.equals("")) {
				text = "Introduce un nombre para el contacto";
				JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
				editWindow.getPhoneTextF().requestFocus();
				return false;
			}
				return true;
		} catch (Exception ex) {
			text = "Introduce un número de teléfono correcto";
			JOptionPane.showMessageDialog(null, text, "¡Error!", JOptionPane.ERROR_MESSAGE);
			editWindow.getPhoneTextF().requestFocus();
			return false;
		}
		
	}

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.ModelFile;
import view.MainWindow;
import view.AddContactWindow;
import view.EditContactWindow;

public class EventManager implements ActionListener{

	private MainWindow window;
	private ModelFile modelFile;
	
	//Constructor
	
	public EventManager(MainWindow window, ModelFile modelFile) {
		this.window = window;
		this.modelFile = modelFile;
		modelFile.addFile();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == window.getAddButton()) {
			 AddContactWindow addWindow = new AddContactWindow();
			 EventManagerAdd addManager = new EventManagerAdd(window, addWindow);
			 addWindow.setEventManager(addManager);
			 
			 
		 } else if (e.getSource() == window.getEditButton()) {
			 EditContactWindow editWindow = new EditContactWindow();
			try { 
			EventManagerEdit editManager = new EventManagerEdit(window, editWindow);
			int row = window.getTable().getSelectedRow();
			String name = (String)window.getTableModel().getValueAt(row, 0);
			String phoneNumber = (String)window.getTableModel().getValueAt(row, 1);
			editWindow.getNameTextF().setText(name);
			editWindow.getPhoneTextF().setText(phoneNumber);
			editWindow.setEventManager(editManager);
			 } catch (Exception ex) {
				 String text = "Selecciona una fila de la tabla";
				 JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
				 editWindow.dispose();
			 }
			
			
		 } else if (e.getSource() == window.getDeleteButton()) {
			try {
			 
				int row = window.getTable().getSelectedRow();
				window.getTableModel().removeRow(row); 
				 
			 } catch (Exception ex) {
				 String text = "Selecciona una fila de la tabla";
				 JOptionPane.showMessageDialog(null, text, "", JOptionPane.ERROR_MESSAGE);
			 }
			 
				 
		 } else if (e.getSource() == window.getSaveButton()) {
			 try (BufferedWriter BW=new BufferedWriter(new FileWriter("src/model/contactFile.txt"))) {

		            for (int i = 0 ; i < window.getTableModel().getRowCount(); i++) //realiza un barrido por filas.
		            {
		                for(int j = 0 ; j < window.getTableModel().getColumnCount();j++) //realiza un barrido por columnas.
		                {
		                   BW.write((String)(window.getTableModel().getValueAt(i,j)));
		                   BW.write("--");
		                    
		                }
		                BW.newLine(); //inserta nueva linea.
		            }

		            BW.close(); //cierra archivo!
		            String text =("El archivo fue salvado correctamente!");
		            JOptionPane.showMessageDialog(null, text, "", JOptionPane.INFORMATION_MESSAGE);
				} catch(IOException ex) {
				  ex.printStackTrace();
				}
		 }
	}
}
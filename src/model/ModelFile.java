package model;

import java.io.BufferedReader;

import java.io.FileReader;


import view.MainWindow;

public class ModelFile {
	
	private MainWindow window;
	
	public ModelFile(MainWindow window){
		this.window = window;
	}
	
	public void addFile() {
		
			BufferedReader br = null;
		    try{ 
		        br = new BufferedReader(new FileReader("src/model/contactFile.txt"));
		        String line = br.readLine();
	
		        for(int row = 0; row < 10 ; row++){
		            for(int column = 0; column<2 ;column++){
		                       while (line != null )
		                       {
		                         String [] rowfields = line.split("--");
		                         window.getTableModel().addRow(rowfields);
		                         line = br.readLine();
		                        }
		                       
		                    }
		                 }
	
		            }
		    catch(Exception e)
		      {
		                System.out.println("Fichero no encontrado");
		      }
		
		}
}

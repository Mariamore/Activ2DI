package controller;

import model.ModelFile;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		ModelFile modelFile = new ModelFile(window);
		EventManager eventManager = new EventManager(window, modelFile);
		window.setEventManager(eventManager);

	}

}

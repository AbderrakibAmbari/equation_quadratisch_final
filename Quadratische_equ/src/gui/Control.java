package gui;

import business.Model;
import javafx.stage.Stage;

public class Control {
	private View view;
	private Model model;
	public Control(Stage primaryStage) {
		this.view=new View(primaryStage, this, model);
		
	}

}

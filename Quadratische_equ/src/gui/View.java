package gui;

import business.Equation;
import business.Model;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View {
	char power2='\u00B2';
	private Pane pane = new Pane();

	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblA = new Label("Geben Sie A:");
	private Label lblB = new Label("Geben Sie B:");
	private Label lblC = new Label("Geben Sie C:");
	
	private TextField txtA = new TextField();
	private TextField txtB = new TextField();
	private TextField txtC = new TextField();
	
	private TextArea txtAnzeige = new TextArea();
	
	
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");

	private Control control;
	private Model model;

	public View(Stage primaryStage, Control control, Model model) {
		Scene scene = new Scene(this.pane, 700, 350);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratische Equation");
		primaryStage.show();
		this.control = control;
		this.model = model;
		this.View_init();
		this.initButton();
	}

	

	private void View_init() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblA.setLayoutX(20);
		lblA.setLayoutY(90);
		lblB.setLayoutX(20);
		lblB.setLayoutY(130);
		lblC.setLayoutX(20);
		lblC.setLayoutY(170);
		
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblA, lblB, lblC);
		//TextField
		txtA.setLayoutX(170);
		txtA.setLayoutY(90);
		txtA.setPrefWidth(200);
		txtB.setLayoutX(170);
		txtB.setLayoutY(130);
		txtB.setPrefWidth(200);
		txtC.setLayoutX(170);
		txtC.setLayoutY(170);
		txtC.setPrefWidth(200);
		pane.getChildren().addAll(txtA,txtB,txtC);
		//TextArea
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);
		
		//button
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);
	}
	
	private void initButton() {
	
		btnEingabe.setOnAction(e -> eingabe());

		btnAnzeige.setOnAction(e -> anzeigeEquation());

}
	//to modify 
	// for every equation a=0 then first degree equation and it solution is -c/2b and 
	// if b=0 then the solution is math.sqrt(-c/a)
	//	if c=0 the the solutions are x=0 of x=-2b/a
	private void anzeigeEquation() {
		/*if(model.getEqua().getArgA()==0||model.getEqua().getArgB()==0||model.getEqua().getArgC()==0) {
			zeigeInformationsfensterAn("Es gilt nicht um ein Quadratisch Equation");
		}
		else {*/
			String equationS=""+model.getEqua().getArgA()+"x"+power2+"+2"+model.getEqua().getArgB()+"x+"+model.getEqua().getArgC() ;
			this.txtAnzeige.setText(equationS);
		//}
		
	}

	
	

	private void eingabe() {
		try {
			this.model.addNummer(Double.parseDouble(txtA.getText()),Double.parseDouble(txtB.getText()),Double.parseDouble(txtC.getText()));
			zeigeInformationsfensterAn("Equation wurde aufgenommen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	
	private void zeigeFehlermeldungsfensterAn(String message) {
		new MeldungsfensterAnzeiger(AlertType.ERROR,"Fehler",message).zeigemeldungsfensterAn();
		
	}



	void  zeigeInformationsfensterAn(String message) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION,"Information",message).zeigemeldungsfensterAn();
	}
}
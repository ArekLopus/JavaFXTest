package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PropertyElementsController {

	@FXML
	Button b1;
	
	@FXML
	Label l1;
	
	@FXML
	private void onActionHandler() {
		System.out.println("PropertyElements Button presed, properties -> "+b1.getProperties());
	}
	
	@FXML
	public void initialize() {
		System.out.println(""+l1);
		System.out.println("foo from Buttons properties -> "+b1.getProperties().get("foo"));
	}
	
}

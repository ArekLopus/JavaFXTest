package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AttributesController {

	@FXML
	private Button b1;
	
	@FXML
	private Button forController;

	@FXML
	private TextField textField;
	
	
	@FXML
	public void initialize() {
		System.out.println(""+b1);
		System.out.println("Button forController.getId() -> "+forController.getId());
		
		textField.requestFocus();
	}
	
}

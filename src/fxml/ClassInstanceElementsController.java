package fxml;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ClassInstanceElementsController {

	@FXML
	private Button b1;
	
	@FXML
	private ComboBox<String> cb;
	
	@FXML
	private Parent incl;
	
	@FXML	//Must be fx:id="incl" + Controller
	private ToInclude inclController;
	
	
	@FXML	//If private must be tagged with @FXML
	private void onActionHandler() {
		System.out.println("ClassInstanceElements Button presed");
	}
	
	@FXML	//If private must be tagged with @FXML
	public void initialize() {
		System.out.println("ToInclude root class - "+incl.getClass());
		System.out.println("ToIncludeController  - "+inclController.info);
	}
	
}

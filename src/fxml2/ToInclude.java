package fxml2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToInclude {
	
	public String info = "Info from ToIncludeController";
	
	@FXML
	private Button but1;
	
	@FXML
	private void onActionHandler() {
		System.out.println("ToInclude Button presed");
	}
	
	@FXML
	public void initialize() {
		
	}
	
	
}
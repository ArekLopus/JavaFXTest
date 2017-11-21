package fxmlController;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class NestedControllersController {
	
	private String info = "info from NestedControllersController";
	
	@FXML
	private Parent incl;
	
	@FXML	//Must be fx:id="incl" + Controller
	private ToIncludeController inclController;
	
	
	@FXML	//If private must be tagged with @FXML
	private void onActionHandler() {
		System.out.println("NestedControllers Button pressed");
	}
	
	@FXML	//If private must be tagged with @FXML
	public void initialize() {
		inclController.setMainController(this);
		
		System.out.println("ToInclude root class -> "+incl.getClass());
		System.out.println("ToIncludeController.info  -> "+inclController.info);
	}
	
	
	public String getInfo() {
		return info;
	}
}

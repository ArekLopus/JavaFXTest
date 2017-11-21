package fxmlController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToIncludeController {
	
	private NestedControllersController nc;
	public String info = "Info from ToIncludeController";
	
	
	@FXML
	private Button but1;
	
	@FXML
	private void onActionHandler() {
		if(nc != null) {
			System.out.println("ToInclude Button pressed, info from outer controller -> "+nc.getInfo());
		} else {
			System.out.println("ToInclude Button pressed, info from outer controller IS NULL");
		}
	}
	
	@FXML
	public void initialize() {
		
	}
	
	
	public void setMainController(NestedControllersController nc) {
		this.nc = nc;
	}
	
}
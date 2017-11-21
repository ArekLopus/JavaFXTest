package fxmlCustomLoaders;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLInjectionExampleController {
	
	@FXML
	private Label resourcesLabel;
	@FXML
	private Label locationLabel;
	@FXML
	private Label myClassInj;
	@FXML
	private Label myPropsInj;
	@FXML
	private Label fromResBundle;
	
	@FXML
	private URL location;
	@FXML
	private ResourceBundle resources;
	
	@MyInject
	private MyClass mc;
	
	@MyInject
	private String str;
	
	@MyInject
	private int intgr;
	
//	@MyInject
//	private Integer intgr2;
	
	
	//NOTE Initializable interface has been superseded by automatic injection of location and resources properties into the controller.
	//FXMLLoader will now automatically call any suitably annotated no-arg initialize() method defined by the controller.
	//It is recommended that the injection approach be used whenever possible.
	//Tthis method MUST be annotated with the @FXML annotation if it is NOT PUBLIC.
	@FXML
	public void initialize() {
		locationLabel.setText("Location:\t\t\t"+location.toString());
		resourcesLabel.setText("Resources:\t\t"+resources.getBaseBundleName());
		myClassInj.setText("MyClass injection:\t"+mc.getInfo());
		myPropsInj.setText("MyProps injection:\t"+str);
		fromResBundle.setText("From Res Bundle:\t"+resources.getObject("abc"));
		
	}
}
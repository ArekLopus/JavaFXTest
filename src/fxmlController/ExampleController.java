package fxmlController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

//root element -> fx:controller="fxmlController.ExampleController"
public class ExampleController {
	
	@FXML
	private URL location;
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private Button btn1;	//fx:id="btn1"
	@FXML
	private Label lab1;		//fx:id="lab1"
	
	@FXML	//button -> onAction="#buttonClick"
	private void buttonClick(ActionEvent event) {
	    System.out.print("You clicked button! ");
	    if(btn1 != null) {
	    	System.out.println(btn1.getText());
	    } else {
	    	System.out.println("btn1 is null");
	    }
	}
	
	@FXML		//If private must be tagged with @FXML
	private void labelClick(MouseEvent event) {
	    System.out.print("You clicked label! ");
	    if(btn1 != null) {
	    	System.out.println(lab1.getText());
	    } else {
	    	System.out.println("lab1 is null");
	    }
	}
	
	//NOTE Initializable interface has been superseded by automatic injection of location and resources properties into the controller.
	//FXMLLoader will now automatically call any suitably annotated no-arg initialize() method defined by the controller.
	//It is recommended that the injection approach be used whenever possible.
	//Tthis method MUST be annotated with the @FXML annotation if it is NOT PUBLIC.
	//@FXML		//If private must be tagged with @FXML
	public void initialize() {
		System.out.println("initialize() from ExampleController loaded");
		System.out.println("Location: "+location);
		System.out.println("Resource Bundle: "+resources.getBaseBundleName());
		System.out.println("ResourceBundle's 'abc' key -> "+resources.getString("abc"));
	}
	
	
	 

}

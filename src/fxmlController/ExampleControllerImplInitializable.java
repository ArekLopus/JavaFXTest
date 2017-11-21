package fxmlController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


//root element -> fx:controller="fxmlController.ExampleControllerImplInitializable"
public class ExampleControllerImplInitializable implements Initializable {
	
	@FXML
	private Button btn1;
	@FXML
	private Label lab1;
	
	@FXML	//button -> onAction="#buttonClick"
	private void buttonClick(ActionEvent event) {
	    System.out.println("You clicked button!");
	    if(btn1 != null) {
	    	System.out.println(btn1.getText());
	    } else {
	    	System.out.println("btn1 is null");
	    }
	}
	
	@FXML	//label -> onMouseClicked="#labelClick"
	private void labelClick(MouseEvent event) {
	    System.out.println("You clicked label!");
	    if(btn1 != null) {
	    	System.out.println(lab1.getText());
	    } else {
	    	System.out.println("lab1 is null");
	    }
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("initialize from AbcController loaded, it is like @PostContruct");
	}
	
}

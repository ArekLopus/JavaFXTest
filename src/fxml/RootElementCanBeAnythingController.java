package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


//ANYTHING can be a root element
public class RootElementCanBeAnythingController implements Initializable{
	
	@FXML
	private Button btn1;
	
	@FXML	//button -> onAction="#buttonClick"
	private void buttonClick(ActionEvent event) {
	    System.out.println("You clicked a button!");
	    
	    if(btn1 != null && event.getSource() == btn1) {
	    	System.out.println("Button 1 clicked, name: "+btn1.getText());
	    	System.out.println("Parent: "+((Button)event.getSource()).getParent());
	    	
	    } else {
	    	System.out.println("btn1 is null");
	    }
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	 

}

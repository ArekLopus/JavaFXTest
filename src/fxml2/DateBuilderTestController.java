package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class DateBuilderTestController implements Initializable{
	
	@FXML
	private User u1;
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println(u1);
		
	}
	
	
	 

}

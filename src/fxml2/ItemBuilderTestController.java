package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class ItemBuilderTestController implements Initializable{
	
	@FXML
	private User u1;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("Items added to a list -> "+u1.getTestList());
	}
	
}

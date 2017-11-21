package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class SceneCanBeUsedAsRootController implements Initializable {
	
	@FXML
	private Label l1;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("Labels text: "+l1.getText());
	}
	
}

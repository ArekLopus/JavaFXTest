package bindInCont2Strings;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AbcController implements Initializable{
	
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	@FXML
	private TextField tf3;
	
	StringProperty tfp1;
	StringProperty tfp2;
	StringProperty tfp3;
	
	@Override
	public void initialize(URL url, ResourceBundle res) {
		System.out.println("initialize loaded");
		
		tfp1 = tf1.textProperty();
		tfp2 = tf2.textProperty();
		tfp3 = tf3.textProperty();
		
		tfp3.bind(Bindings.concat(tfp1, " + ", tfp2));	//concat(Object... args)
		
	}
	
}

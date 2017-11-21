package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class NamespaceContainsAllNodesController implements Initializable {
	
	public String info = "Info from Contr";
	
	@FXML
	private User u2;
	
	@FXML
	private void handler1() {
		System.out.println("Handler 1");
	}
	@FXML
	private void handler2() {
		System.out.println("Handler 2");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		System.out.println(u2);
		System.out.println("map - must be read-only to add -> "+u2.getTestMap());
		System.out.println("list - must be read-only to add -> "+u2.getTestList());
	}
	
}

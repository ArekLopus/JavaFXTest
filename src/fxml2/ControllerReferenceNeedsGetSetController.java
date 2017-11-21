package fxml2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



public class ControllerReferenceNeedsGetSetController implements Initializable{
	
	public String info = "Info from Controller";
	//public static String info = "Info from Controller";
	
	
	@FXML
	private void handler1() {
		System.out.println("Handler 1 from the Controller");
	}
	@FXML
	private void handler2() {
		System.out.println("Handler 2 from the Controller");
	}
	
	//GETTER needed to use it!
	@FXML
    public EventHandler<ActionEvent> onActionHandler = evt -> {
    	System.out.println("Handler 3 - property from the Controller");
    };
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public EventHandler<ActionEvent> getOnActionHandler() {
		return onActionHandler;
	}
	public void setOnActionHandler(EventHandler<ActionEvent> onActionHandler) {
		this.onActionHandler = onActionHandler;
	}
	
	
	

}

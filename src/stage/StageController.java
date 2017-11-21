package stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;


//ANYTHING can be a root element
public class StageController implements Initializable{
	
	@FXML
	private Button btn1;
	
	
	@FXML	//button -> onAction="#buttonClick"
	private void buttonClick(ActionEvent event) {
	    System.out.println("You clicked a button!");
	    
	    if(btn1 != null && event.getSource() == btn1) {
	    	System.out.println("Button 1 clicked, name: "+btn1.getText());
	    	Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
	    	
	    	//stage.getIcons().add(new Image("file:///C:/eclipse2/Workspace/JavaFXTest/bin/stage/Smile128.png"));
	    	stage.getIcons().add(new Image("/helper/Smile128.png"));
	    	
	    	stage.setWidth(stage.getWidth()+10);
	    	stage.setHeight(stage.getHeight()+10);
	    	
	    	stage.centerOnScreen();
	    	
	    	stage.getOwner();
	    	stage.getProperties();
	    	//stage.hide();
	    	//stage.setX(10);
	    	//stage.setY(10);
	    	//stage.sizeToScene();
	    	
	    } else {
	    	System.out.println("btn1 is null");
	    }
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	 

}

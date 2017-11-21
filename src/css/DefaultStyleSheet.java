package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Application class defines 2 String constants named STYLESHEET_CASPIAN and STYLESHEET_MODENA. 
//-Use the following static methods of the Application class to set and get the application-wide default style sheet:
//	• public static void setUserAgentStylesheet(String url)
//	• public static String getUserAgentStylesheet()
//-Use the setUserAgentStylesheet(String url) to set an application–wide default. 
// A value of null will restore the platform default style sheet, fe, Modena on JavaFX 8 and Caspian on the prior versions.
//The following statement sets Caspian as the default style sheet: 
//	Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
//-Use the getUserAgentStylesheet() method to return the current default style sheet for the application. 
// If one of the built-in style sheet is the default, it returns null.
public class DefaultStyleSheet extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Default style sheet");
    	
    	TextField tf1 = new TextField();
 		tf1.setPromptText("Just a prompt");
 		CheckBox cb1 = new CheckBox("CheckBox");
    	
    	Button b1 = new Button("Change ");
 		b1.setOnAction(e -> {
 			if(Application.getUserAgentStylesheet() == null || Application.getUserAgentStylesheet().equals(STYLESHEET_MODENA)) {
 				Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
 				tf1.setText(STYLESHEET_CASPIAN);
 			} else {
 				Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
 				tf1.setText(STYLESHEET_MODENA);
 			}
 			
 		});
    	
 		
 		
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, tf1, cb1);
		
		
        Scene scene = new Scene(vb, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}
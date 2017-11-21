package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-You can add multiple style sheets to a JavaFX application.
//-Style sheets are added to a scene or parents. Scene and Parent classes maintain an observable list of string URLs linking to style sheets.
//-Use the getStylesheets() in the Scene and Parent classes to get the reference of the observable list and add additional URLs to the list.
//-How are the string URLs for a style sheet resolved? You can specify a style sheet URL in three forms:
// • A relative URL, for example, "resources/css/ss1.css"
// • An absolute URL with no scheme or authority, for example, "/resources/css/ss1.css"
// • An absolute URL, for example, "http://jdojo.com/resources/css/ss1.css" and "file:/C:/css/ss2.css"
public class AddingStyleSheet extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("AddingStyleSheet");

    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
 		
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1);
		
		vb.getStylesheets().add("/helper/test.css");
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}
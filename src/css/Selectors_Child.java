package css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A child selector matches a child node. It consists of two or more selectors separated by the greater than sign (>).
public class Selectors_Child extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Selectors");
    	
    	//Only children of vbox2 use it -> hbox > .button {}
    	Button b1 = new Button("Testing CSS");
    	b1.setOnAction(e -> { System.out.println("Button pressed"); });
    	
    	Button b2 = new Button("Testing CSS");
    	b2.setOnAction(e -> { System.out.println("Button pressed"); });
    	
		VBox vb2= new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.getChildren().addAll(new Button("Inside another VBox"));
    	
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(b1, b2, vb2);
		
		vb.getStyleClass().add("vbox2");
		
        Scene scene = new Scene(vb, 400, 250);
        
        scene.getStylesheets().add("/helper/test4.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
		
	
    
}
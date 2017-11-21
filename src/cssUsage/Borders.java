package cssUsage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-A node (a Region and a Control) can have multiple borders through CSS. A border is specified using five properties:
//  • -fx-border-color    • -fx-border-width    • -fx-border-radius    • -fx-border-insets   • -fx-border-style
public class Borders extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Borders");
    	
    	VBox vb = new VBox(5);
    	
    	
    	
    	VBox vb2 = new VBox(5);
    	vb2.setPrefSize(50, 50);
    	vb2.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-radius: 15;"
    			+ " -fx-border-insets: 0; -fx-border-style: solid;");
    	vb2.getChildren().addAll(new Button("abc"));
    	
    	VBox vb3 = new VBox(5);
    	vb3.setPrefSize(50, 50);
    	vb3.setStyle("-fx-border-color: red green blue aqua; -fx-border-width: 3; -fx-border-insets: 10;");
    	vb3.getChildren().addAll(new Button("abc"));
    	
    	VBox vb4 = new VBox(5);
    	vb4.setPrefSize(50, 50);
    	vb4.setStyle("-fx-border-color: red, black; -fx-border-width: 5, 5; -fx-border-radius: 0, 0;"
    			+ " -fx-border-insets: 0, 5; -fx-border-style: solid inside, dotted outside;");
    	vb4.getChildren().addAll(new Button("abc"));
    	
    	VBox vb5 = new VBox(5);
    	vb5.setPrefSize(50, 50);
    	vb5.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
    			+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
    	vb5.getChildren().addAll(new Button("abc"));
    	
    	vb.getChildren().addAll(vb2, vb3, vb4, vb5);
		
        Scene scene = new Scene(vb, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
        
}
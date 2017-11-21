package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
//BorderPane is commonly used as the root of a Scene, in which case its size will track the size of the scene
public class BorderPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("BorderPane");
		
		Button b1 = new Button("Top");
		Button b2 = new Button("Left");
		Button b3 = new Button("Center");
		Button b4 = new Button("Right");
		Button b5 = new Button("Bottom");
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		
		bp.setTop(b1);
		bp.setLeft(b2);
		bp.setCenter(b3);
		bp.setRight(b4);
		bp.setBottom(b5);
		
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
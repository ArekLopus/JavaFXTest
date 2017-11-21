package node;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//
public class ManagedNode extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("");

    	TextField tf1 = new TextField();
    	
    	Text t1 = new Text("This is a helping text.");
    	t1.setFont(Font.font(10));
    	t1.setFill(Color.RED);
    	
    	t1.setManaged(false);
    	
		t1.setTextOrigin(VPos.TOP);
		t1.setMouseTransparent(true);
		t1.setWrappingWidth(tf1.getLayoutBounds().getWidth());
		
		
    	VBox hb1 = new VBox(10);
    	hb1.getChildren().addAll(tf1, t1);
    	
    	
    	Scene scene = new Scene(hb1, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	double x = tf1.getLayoutX() + tf1.getLayoutBounds().getMinX() - t1.getLayoutBounds().getMinX();
		double y = tf1.getLayoutY() + tf1.getLayoutBounds().getMinY() + tf1.getLayoutBounds().getHeight() - t1.getLayoutBounds().getMinX();
		t1.setLayoutX(x);
		t1.setLayoutY(y);
    	
    	System.out.println(tf1.getLayoutX());
    	System.out.println(tf1.getLayoutY());
		System.out.println(tf1.getLayoutBounds());
		System.out.println(t1.getLayoutBounds());
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
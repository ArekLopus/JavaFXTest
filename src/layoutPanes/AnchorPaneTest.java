package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/AnchorPane.html
//topAnchor		double	distance from the anchor pane's top insets to the child's top edge.
//leftAnchor	double	distance from the anchor pane's left insets to the child's left edge.
//bottomAnchor	double	distance from the anchor pane's bottom insets to the child's bottom edge.
//rightAnchor	double	distance from the anchor pane's right insets to the child's right edge.
public class AnchorPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("AnchorPane");
		
		Button b1 = new Button("Button b1 Anchored");
		Button b2 = new Button("Button b2 setLayout");
		Button b3 = new Button("Button b3 is resizable, so it resizes to the right and bottom anchor");
		Button b4 = new Button("Button b4 Anchored");
		
		AnchorPane ap = new AnchorPane();
		ap.setPadding(new Insets(10,10,10,10));
		ap.setPrefSize(400, 400);
		
		AnchorPane.setTopAnchor(b1, 0.0);
		AnchorPane.setLeftAnchor(b1, 0.0);
		
		AnchorPane.setTopAnchor(b4, 0.0);
		AnchorPane.setRightAnchor(b4, 0.0);
		
		b2.setLayoutX(10);	//it doesnt use padding!
		b2.setLayoutY(50);
		
		Rectangle r1 = new Rectangle(100, 100);
		r1.setFill(Color.RED);
		AnchorPane.setTopAnchor(r1, 80.0);
		AnchorPane.setLeftAnchor(r1, 0.0);
		
		Rectangle r2 = new Rectangle(100, 100);
		r2.setFill(Color.YELLOW);
		AnchorPane.setTopAnchor(r2, 190.0);
		AnchorPane.setLeftAnchor(r2, 0.0);
		AnchorPane.setRightAnchor(r2, 0.0);		//Rectangle is not resizable, it wont resize to the right anchor
		
		//Button is resizable, so it resizes to the right and bottom anchor
		AnchorPane.setTopAnchor(b3, 300.0);
		AnchorPane.setLeftAnchor(b3, 0.0);
		AnchorPane.setRightAnchor(b3, 0.0);		//distance from the anchor pane's right insets to the child's right edge.		
		AnchorPane.setBottomAnchor(b3, 0.0);	//distance from the anchor pane's bottom insets to the child's bottom edge.
		
		ap.getChildren().addAll(b1, b2, r1, r2, b3, b4);
		
		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
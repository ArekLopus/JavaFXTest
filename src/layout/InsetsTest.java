package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-The Insets class represents inside offsets in four directions: top, right, bottom, and left, for a rectangular area.
//-It has 2 constructors – 1 lets you set the same offset for all four directions and another lets you set different offsets for each direction.
// • Insets(double topRightBottomLeft)	• Insets(double top, double right, double bottom, double left)
public class InsetsTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Insets");
		
		Rectangle rec1 = new Rectangle(100, 50);
		Rectangle rec2 = new Rectangle(100, 50);
		
		Label l1 = new Label("Posiitive nr insets");
		Label l2 = new Label("Negative nr insets");
		
		VBox vb2 = new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.getChildren().addAll(rec1, l1);
		vb2.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		VBox vb3 = new VBox(10);
		vb3.setPadding(new Insets(-10));
		vb3.getChildren().addAll(rec2, l2);
		vb3.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb2, vb3);
		
		
		Scene scene = new Scene(vb, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
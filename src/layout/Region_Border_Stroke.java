package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//-A Region can have a border, which consists of strokes, images, or both.
//-A Border object is immutable. It can be safely used for multiple Regions.
//-A Border object has zero or more strokes and images. 
//-The Border class provides several constructors that take multiple strokes and images as arguments.
//-The Region class contains a border property of the ObjectProperty<Border> type.
//-The border of a Region is set using the setBorder(Border b) method.
//-An instance of the BorderStroke class represents a stroke; an instance of the BorderImage class represents an image. 
//-The BorderStroke class provides constructors to set the style of the stroke. The following are the two commonly used constructors.
// The third constructor allows you to set different color and style of strokes on four sides.
//	• BorderStroke(Paint stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths)
//	• BorderStroke(Paint stroke, BorderStrokeStyle style, CornerRadii radii, BorderWidths widths, Insets insets)
//-The BorderStrokeStyle class represents the style of a stroke.
//-The BorderWidths class represents widths of a stroke on all four sides of a border.
// It lets you set the widths as absolute values or as a percentage of the dimensions of the Region.
//-BorderStrokeStyle -> DASHED, DOTTED, NODE, SOLID 
public class Region_Border_Stroke extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Border Stroke");
		
		Button b1 = new Button("Testing");	Button b2 = new Button("Testing");	Button b3 = new Button("Testing");
		Button b4 = new Button("Testing");
		
		Pane vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vb1.getChildren().add(b1);
		
		Pane vb2 = new VBox(10);
		vb2.setPadding(new Insets(10));
		vb2.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED, new CornerRadii(15), new BorderWidths(5))));
		vb2.getChildren().add(b2);
		
		Pane vb3 = new VBox(10);
		vb3.setPadding(new Insets(10));
		vb3.getChildren().add(b3);
		vb3.setStyle("-fx-border-color: red; -fx-border-style: solid inside; "
				+ "-fx-border-width: 10; -fx-border-insets: 10; -fx-border-radius: 15;");
		
		Pane vb4 = new VBox(10);
		vb4.setPadding(new Insets(10));
		vb4.getChildren().add(b4);
		vb4.setStyle("-fx-border-color: red, green; -fx-border-style: solid inside, solid outside;"
				+ " -fx-border-width: 5, 5 ;  -fx-border-insets: 0, 0; -fx-border-radius: 10, 10;");
		   
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb1, vb2, vb3, vb4);
		
		
		Scene scene = new Scene(vb, 500, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
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
import javafx.stage.Stage;

//Setting margins on a Region is not supported directly. Most layout panes support margins for their children.
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.BorderPane 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.FlowPane 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.GridPane 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.HBox 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.StackPane 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.TilePane 
//setMargin(Node, Insets) - Static method in class javafx.scene.layout.VBox 
public class Margins extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Insets");
		
		Label l1 = new Label("Labels margin 20");
		Label l2 = new Label("Labels margin 50");
		
		VBox vb2 = new VBox(10);
		vb2.getChildren().addAll(l1);
		vb2.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		VBox vb3 = new VBox(10);
		vb3.getChildren().addAll(l2);
		vb3.setBorder(new Border(new BorderStroke(Color.ORANGE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		VBox.setMargin(l1, new Insets(20));
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb2, vb3);
		
		VBox.setMargin(l2, new Insets(50));
		
		Scene scene = new Scene(vb, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
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

//-The padding of a Region is the space around its content area.
//-The Region class contains a padding property of the ObjectProperty<Insets> type.
//-You can set separate padding widths for each of the four sides: Top - Right - Bottom - Left
public class Region_Padding extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Padding");
		
		Button b1 = new Button("new Insets(30)");
		Button b2 = new Button("new Insets(30, 50, 10, 50) -> Top - Right - Bottom - Left");
		
		Pane vb1 = new VBox(10);
		vb1.setPadding(new Insets(30));
		vb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vb1.getChildren().add(b1);
		
		Pane vb2 = new VBox(10);
		vb2.setPadding(new Insets(30, 50, 10, 50));	//Top - Right - Bottom - Left
		vb2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vb2.getChildren().add(b2);
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(vb1, vb2);
		
		
		Scene scene = new Scene(vb, 500, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
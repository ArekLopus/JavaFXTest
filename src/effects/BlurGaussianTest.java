package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//GaussianBlur(), GaussianBlur(double radius)
//-The no-args constructor creates a GaussianBlur object with a default radius of 10.0px.
// The other constructor lets you specify the initial value for the radius,
public class BlurGaussianTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("GaussianBlur");
		
		GaussianBlur gb = new GaussianBlur();
		
		Text t = new Text("Gaussian Blur");
		t.setFont(Font.font(24));
		t.setEffect(gb);
		
		
		Slider radiusSl = new Slider(0, 100, 10);
		radiusSl.setShowTickLabels(true);
		gb.radiusProperty().bind(radiusSl.valueProperty());
		

		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Radius:"), radiusSl);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(t, gp);
		
		Scene scene = new Scene(vb1, 400, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//MotionBlur(), MotionBlur(double angle, double radius)
//The no-args constructor creates a MotionBlur object with a default radius of 10.0px and an angle of 0.0 degrees.
//The other constructor lets you specify the initial value for the angle and radius, as
public class BlurMotionTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("MotionBlur");
		
		MotionBlur mb = new MotionBlur();
		
		Text t = new Text("Motion Blur");
		t.setFont(Font.font(46));
		t.setEffect(mb);
		
		Slider radiusSl = new Slider(0, 60, 6);
		radiusSl.setShowTickLabels(true);
		mb.radiusProperty().bind(radiusSl.valueProperty());
		
		Slider angleSl = new Slider(0, 360, 0);
		angleSl.setShowTickLabels(true);
		mb.angleProperty().bind(angleSl.valueProperty());
		
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Radius:"), radiusSl);
		gp.addRow(1, new Label("Angle:"), angleSl);
		
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
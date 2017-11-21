package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/Light.Distant.html
public class Light_DistantTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Distant Light");
		
		 
		Light.Distant ld = new Light.Distant();
		
				
		Lighting lighting = new Lighting();
		lighting.setLight(ld);
		
		
		Text text = new Text();
		text.setText("Lighting");
		text.setFill(Color.RED);
		text.setFont(Font.font(null, FontWeight.BOLD, 100));
		text.setEffect(lighting);

		Rectangle rect = new Rectangle(420, 200);
		rect.setFill(Color.LIGHTGRAY);
		rect.setEffect(lighting);
		StackPane sp = new StackPane(rect, text);
		
		
		Slider azimSl = new Slider (0, 360, 0);
		azimSl.setMajorTickUnit(10);
		azimSl.setShowTickMarks(true);
		azimSl.setShowTickLabels(true);
		ld.azimuthProperty().bind(azimSl.valueProperty());
		
		Slider elevSl = new Slider (0, 180, 45);
		elevSl.setMajorTickUnit(10);
		elevSl.setShowTickMarks(true);
		elevSl.setShowTickLabels(true);
		ld.elevationProperty().bind(elevSl.valueProperty());
		
		ColorPicker cp = new ColorPicker(Color.WHITE);
		cp.valueProperty().addListener( (ob, o, n)->{
			ld.setColor(n);
		});
		
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Color:"), cp);
		gp.addRow(1, new Label("Azimuth:"), azimSl);
		gp.addRow(2, new Label("Elevation:"), elevSl);
		
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp, gp);
		
		Scene scene = new Scene(vb1, 450, 500);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
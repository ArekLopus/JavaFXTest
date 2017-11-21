package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//The Glow effect makes the bright pixels of the input brighter.
//-The level property specifies the intensity of the Glow effect. It is a number between 0.0 and 1.0, and its default value is 0.30.
// A level of 0.0 adds no glow and a level of 1.0 adds the maximum glow.
public class GlowTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Glow");
		
		Glow gl = new Glow();
		
		Text t1 = new Text("Glow effect");
		t1.setFill(Color.YELLOW);
		t1.setFont(Font.font(48));
		t1.setEffect(gl);
		Rectangle r1 = new Rectangle(270, 100, Color.GREY);
		StackPane sp1 = new StackPane(r1, t1);
		
		Slider levelSl = new Slider(0.0, 1.0, 0);
		levelSl.setBlockIncrement(0.1);
		levelSl.setShowTickLabels(true);
		
		gl.levelProperty().bind(levelSl.valueProperty());
		
		levelSl.valueProperty().addListener( (e, o, n) -> {
			System.out.println(n);
		});
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Level:"), levelSl);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp1, gp);
		
		Scene scene = new Scene(vb1, 400, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
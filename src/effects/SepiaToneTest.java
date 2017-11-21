package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Sepia is a reddish-brown color. Sepia toning is performed on black-and-white photographic prints to give them a warmer tone.
//level property specifies the intensity of the SepiaTone effect. It is a number between 0.0 and 1.0.
//Its defaults value is 1.0. A level of 0.0 adds no sepia toning and a level of 1.0 adds the maximum sepia toning.
public class SepiaToneTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("SepiaTone");
		
		SepiaTone sep = new SepiaTone();
		
		Text t1 = new Text("SepiaTone");
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font(48));
		t1.setEffect(sep);
		Rectangle r1 = new Rectangle(270, 100, Color.GREY);
		StackPane sp1 = new StackPane(r1, t1);
		
		Slider sepSl = new Slider(0.0, 1.0, 0);
		sepSl.setBlockIncrement(0.1);
		sepSl.setShowTickLabels(true);
		
		sep.levelProperty().bind(sepSl.valueProperty());
		
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Level:"), sepSl);
		
		
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
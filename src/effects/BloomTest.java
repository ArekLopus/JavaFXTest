package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//The Bloom effect adds a glow to the pixels of its input that have a luminosity greater than or equal to a specified limit.
//The threshold property is a number between 0.0 and 1.0. Its default value is 0.30.
// All pixels in the input having a luminosity greater than or equal to the threshold property are made to glow.
public class BloomTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Bloom");
		
		Bloom bl = new Bloom();
		
		Text t1 = new Text("Bloom");
		t1.setFill(Color.YELLOW);
		t1.setFont(Font.font(48));
		t1.setEffect(bl);
		Rectangle r1 = new Rectangle(150, 100, Color.GREY);
		StackPane sp1 = new StackPane(r1, t1);
		
		Slider treshSl = new Slider(0.0, 1.0, 0);
		treshSl.setBlockIncrement(0.1);
		treshSl.setShowTickLabels(true);
		
		bl.thresholdProperty().bind(treshSl.valueProperty());
		
		treshSl.valueProperty().addListener( (e, o, n) -> {
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
		gp.addRow(0, new Label("Treshold:"), treshSl);
		
		
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
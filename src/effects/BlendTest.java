package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Blending combines two pixels at the same location from two inputs to produce one composite pixel in the output.
//The Blend effect takes two input effects and blends the overlapping pixels of the inputs to produce an output.
//The blending of two inputs is controlled by a blending mode.
public class BlendTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("Blend");
		
		ColorInput topInput = new ColorInput(0, 0, 100, 100, Color.BISQUE);
		ColorInput bottomInput = new ColorInput(50, 50, 100, 100, Color.CHARTREUSE);
		
		Blend bl = new Blend();
		bl.setTopInput(topInput);
		bl.setBottomInput(bottomInput);
		
		Rectangle rect = new Rectangle(200, 200);
		rect.setEffect(bl);
		
		
		ComboBox<BlendMode> cb = new ComboBox<>();
		cb.setValue(bl.getMode());
		cb.getItems().addAll(BlendMode.values());
		bl.modeProperty().bind(cb.valueProperty());
		
		Slider opacitySl = new Slider (0, 1, 0.7);
		opacitySl.setMajorTickUnit(0.10);
		opacitySl.setShowTickMarks(true);
		opacitySl.setShowTickLabels(true);
		bl.opacityProperty().bind(opacitySl.valueProperty());
		
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Blend Mode:"), cb);
		gp.addRow(1, new Label("Opacity:"), opacitySl);
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(rect, gp);
		
		Scene scene = new Scene(vb1, 400, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
package effects;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//-The ColorInput effect is a simple effect that fills (floods) a rectangular region with a specified paint.
// Typically, it is used as an input to another effect.
//-Creating a ColorInput object is similar to creating a rectangle filled with the paint of the ColorInput.
public class ColorInputTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("ColorInput");
		
		ColorInput ci = new ColorInput();
		
		Rectangle r1 = new Rectangle(100, 100);
		r1.setEffect(ci);
		
		
		Slider widthSl = new Slider(0, 100, 100);
		widthSl.setShowTickLabels(true);
		ci.widthProperty().bind(widthSl.valueProperty());
		
		Slider heightSl = new Slider(0, 100, 100);
		heightSl.setShowTickLabels(true);
		ci.heightProperty().bind(heightSl.valueProperty());
		
		Slider paintSl = new Slider(0, 255, 255);
		paintSl.setShowTickLabels(true);
		ObjectBinding<Color> binding = Bindings.createObjectBinding(
				() -> Color.rgb((int)paintSl.getValue(), 0, 0)  , paintSl.valueProperty());
		ci.paintProperty().bind(binding); 
		
		Slider xSl = new Slider(0, 100, 0);
		xSl.setShowTickLabels(true);
		ci.xProperty().bind(xSl.valueProperty());
		
		Slider ySl = new Slider(0, 100, 0);
		ySl.setShowTickLabels(true);
		ci.yProperty().bind(ySl.valueProperty());
		
		
		GridPane gp = new GridPane();
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(80);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Width:"), widthSl);
		gp.addRow(1, new Label("Height:"), heightSl);
		gp.addRow(2, new Label("Red color:"), paintSl);
		gp.addRow(3, new Label("X:"), xSl);
		gp.addRow(4, new Label("Y:"), ySl);
		
		HBox hb1 = new HBox(10);
		hb1.setPadding(new Insets(0, 100, 100, 0));
		hb1.getChildren().addAll(r1);
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(hb1, gp);
		
		Scene scene = new Scene(vb1, 400, 430);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
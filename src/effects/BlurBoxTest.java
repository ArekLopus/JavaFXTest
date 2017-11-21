package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//A blur effect using a simple box filter kernel, with separately configurable sizes in both dimensions,
// and an iteration parameter that controls the quality of the resulting blur. 
//BoxBlur(double width, double height, int iterations)
public class BlurBoxTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("BoxBlur");
		
		BoxBlur bb = new BoxBlur();
		
		Text t = new Text("Box Blur");
		t.setFont(Font.font(24));
		t.setEffect(bb);
		
		Slider widthSl = new Slider(0, 100, 0);
		widthSl.setShowTickLabels(true);
		bb.widthProperty().bind(widthSl.valueProperty());
		
		Slider heightSl = new Slider(0, 100, 0);
		heightSl.setShowTickLabels(true);
		bb.heightProperty().bind(heightSl.valueProperty());
		
		Slider iterSl = new Slider(0, 10, 1);
		iterSl.setShowTickLabels(true);
		bb.iterationsProperty().bind(iterSl.valueProperty());
		
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
		gp.addRow(2, new Label("Iterations:"), iterSl);
		
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
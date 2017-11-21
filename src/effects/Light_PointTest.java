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

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/Light.Point.html
public class Light_PointTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Point Light");
		
		 
		Light.Point lp = new Light.Point();
				
		Lighting lighting = new Lighting();
		lighting.setLight(lp);
		
		Text text = new Text();
		text.setText("Lighting");
		text.setFill(Color.RED);
		text.setFont(Font.font(null, FontWeight.BOLD, 100));
		text.setEffect(lighting);

		Rectangle rect = new Rectangle(420, 200);
		rect.setFill(Color.LIGHTGRAY);
		rect.setEffect(lighting);
		StackPane sp = new StackPane(rect, text);
		
		
		Slider xSl = new Slider (0, 430, 50);
		xSl.setMajorTickUnit(10);
		xSl.setShowTickMarks(true);
		xSl.setShowTickLabels(true);
		lp.xProperty().bind(xSl.valueProperty());
		
		Slider ySl = new Slider (0, 200, 50);
		ySl.setMajorTickUnit(10);
		ySl.setShowTickMarks(true);
		ySl.setShowTickLabels(true);
		lp.yProperty().bind(ySl.valueProperty());
		
		Slider zSl = new Slider (0, 300, 50);
		zSl.setMajorTickUnit(10);
		zSl.setShowTickMarks(true);
		zSl.setShowTickLabels(true);
		lp.zProperty().bind(zSl.valueProperty());
		
		ColorPicker cp = new ColorPicker(Color.WHITE);
		cp.valueProperty().addListener( (ob, o, n)->{
			lp.setColor(n);
		});
		
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Color:"), cp);
		gp.addRow(1, new Label("X:"), xSl);
		gp.addRow(2, new Label("Y:"), ySl);
		gp.addRow(3, new Label("Z:"), zSl);
		
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp, gp);
		
		Scene scene = new Scene(vb1, 450, 400);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
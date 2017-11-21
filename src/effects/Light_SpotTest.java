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

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/Light.Spot.html
public class Light_SpotTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Spot Light");
		
		 
		Light.Spot ls = new Light.Spot();
		
		Lighting lighting = new Lighting();
		lighting.setLight(ls);
		
		Text text = new Text();
		text.setText("Lighting");
		text.setFill(Color.RED);
		text.setFont(Font.font(null, FontWeight.BOLD, 100));
		text.setEffect(lighting);

		Rectangle rect = new Rectangle(420, 200);
		rect.setFill(Color.LIGHTGRAY);
		rect.setEffect(lighting);
		StackPane sp = new StackPane(rect, text);
		
		
		Slider xSl = new Slider (0, 430, 310);
		xSl.setMajorTickUnit(10);
		xSl.setShowTickMarks(true);
		xSl.setShowTickLabels(true);
		ls.xProperty().bind(xSl.valueProperty());
		
		Slider ySl = new Slider (0, 200, 100);
		ySl.setMajorTickUnit(10);
		ySl.setShowTickMarks(true);
		ySl.setShowTickLabels(true);
		ls.yProperty().bind(ySl.valueProperty());
		
		Slider zSl = new Slider (0, 300, 50);
		zSl.setMajorTickUnit(10);
		zSl.setShowTickMarks(true);
		zSl.setShowTickLabels(true);
		ls.zProperty().bind(zSl.valueProperty());
		
		Slider specExpSl = new Slider (0, 4, 1);
		specExpSl.setMajorTickUnit(0.1);
		specExpSl.setShowTickMarks(true);
		specExpSl.setShowTickLabels(true);
		ls.specularExponentProperty().bind(specExpSl.valueProperty());
		
		Slider paxSl = new Slider (0, 1000, 0);
		paxSl.setMajorTickUnit(10);
		paxSl.setShowTickMarks(true);
		paxSl.setShowTickLabels(true);
		ls.pointsAtXProperty().bind(paxSl.valueProperty());
		
		Slider paySl = new Slider (0, 1000, 0);
		paySl.setMajorTickUnit(10);
		paySl.setShowTickMarks(true);
		paySl.setShowTickLabels(true);
		ls.pointsAtYProperty().bind(paySl.valueProperty());
		
		Slider pazSl = new Slider (0, 1000, 0);
		pazSl.setMajorTickUnit(10);
		pazSl.setShowTickMarks(true);
		pazSl.setShowTickLabels(true);
		ls.pointsAtZProperty().bind(pazSl.valueProperty());
		
		
		ColorPicker cp = new ColorPicker(Color.WHITE);
		cp.valueProperty().addListener( (ob, o, n)->{
			ls.setColor(n);
		});
		
		
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(10);
		gp.addRow(0, new Label("Color:"), cp);
		gp.addRow(1, new Label("X:"), xSl);
		gp.addRow(2, new Label("Y:"), ySl);
		gp.addRow(3, new Label("Z:"), zSl);
		gp.addRow(4, new Label("specularExponent:"), specExpSl);
		gp.addRow(5, new Label("pointsAtX:"), paxSl);
		gp.addRow(6, new Label("pointsAtY:"), paySl);
		gp.addRow(7, new Label("pointsAtZ:"), pazSl);
		
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(sp, gp);
		
		Scene scene = new Scene(vb1, 450, 600);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
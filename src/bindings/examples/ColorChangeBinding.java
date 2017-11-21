package bindings.examples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ColorChangeBinding extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Color picker");
		
		Slider sl1 = new Slider(0, 255, 255);
		sl1.setShowTickMarks(true);
		sl1.setShowTickLabels(true);
		Slider sl2 = new Slider(0, 255, 0);
		sl2.setShowTickMarks(true);
		sl2.setShowTickLabels(true);
		Slider sl3 = new Slider(0, 255, 0);
		sl3.setShowTickMarks(true);
		sl3.setShowTickLabels(true);
		
		Rectangle rec = new Rectangle();
		rec.setWidth(100);
		rec.setHeight(100);
		rec.setTranslateX(20);
		rec.setTranslateY(20);
		
		Color col = Color.RED;
		rec.setFill(col);
		
		ObjectBinding<Color> bin = Bindings.createObjectBinding( ()-> {
			int r = (int)sl1.getValue();
			int g = (int)sl2.getValue();
			int b = (int)sl3.getValue();
			return Color.rgb(r,g,b);
		} , sl1.valueProperty(), sl2.valueProperty(), sl3.valueProperty());
		System.out.println(bin.get());
		rec.fillProperty().bind(bin);
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.setSpacing(10);
		
		vb.getChildren().addAll(sl1, sl2, sl3, rec);
		
		Scene scene = new Scene(vb, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

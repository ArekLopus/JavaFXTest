package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/DisplacementMap.html
//An effect that shifts each pixel by a distance specified by the first two bands of of the specified FloatMap.
public class DisplacementMapTest extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("DisplacementMap");
		
		int width = 220;
		int height = 100;

		FloatMap floatMap = new FloatMap();
		floatMap.setWidth(width);
		floatMap.setHeight(height);

		for (int i = 0; i < width; i++) {
			double v = (Math.sin(i / 20.0 * Math.PI) - 0.5) / 40.0;
			for (int j = 0; j < height; j++) {
				floatMap.setSamples(i, j, 0.0f, (float) v);
		    }
		}

		DisplacementMap displacementMap = new DisplacementMap();
		displacementMap.setMapData(floatMap);

		Text text = new Text();
		text.setX(40.0);
		text.setY(80.0);
		text.setText("Wavy Text");
		text.setFill(Color.web("0x3b596d"));
		text.setFont(Font.font(null, FontWeight.BOLD, 50));
		text.setEffect(displacementMap);
		
		
		VBox vb1 = new VBox(10);
		vb1.setPadding(new Insets(10));
		vb1.getChildren().addAll(text);
		
		Scene scene = new Scene(vb1, 400, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
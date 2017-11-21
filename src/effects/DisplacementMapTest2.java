package effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/DisplacementMap.html
//An effect that shifts each pixel by a distance specified by the first two bands of of the specified FloatMap.
public class DisplacementMapTest2 extends Application {
	

	@Override
	public void start(Stage stage) {
		stage.setTitle("DisplacementMap");
		
		// Create a FloatMap
		int width = 250;
		int height = 50;
		FloatMap map = new FloatMap(width, height);
		double xDisplacement = 1.0;
		for (int i = 0; i < width; i++) {
		for (int j = 0; j < height; j++) {
		double u = xDisplacement;
		if (j < height / 2) {
		// Move the top-half pixels to the right
		// (a nagative value)
		u = -1.0 * (u * xDisplacement / width);
		} else {
		// Move the bottom-half pixels to the	left.(a positive value)
		u = u * xDisplacement / width;
		}
		// Set values for band 0 and 1 (x and y axes
		// displacements factors).
		// Always use 0.0f for y-axis displacement factor.
		// map.setSamples(i, j, (float)u, 0.0f);
		}
		}
		Text t1 = new Text("Displaced Text");
		t1.setFont(Font.font(36));
		DisplacementMap effect1 = new DisplacementMap();
		effect1.setMapData(map);
		t1.setEffect(effect1);
		HBox root = new HBox(t1);
		root.setStyle("-fx-padding: 10;" +
		"-fx-border-style: solid inside;" +
		"-fx-border-width: 2;" +
		"-fx-border-insets: 5;" +
		"-fx-border-radius: 5;" +
		"-fx-border-color: blue;");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Applying the DisplacementMap Effect");
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
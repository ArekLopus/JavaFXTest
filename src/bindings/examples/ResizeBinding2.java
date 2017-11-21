package bindings.examples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;


public class ResizeBinding2 extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Main window");
		
		Sphere s = new Sphere(100);
		s.setDrawMode(DrawMode.FILL);
		s.setMaterial(new PhongMaterial(Color.RED));
		
		s.translateXProperty().bind(stage.widthProperty().divide(2.1).subtract(s.radiusProperty()));
		s.translateYProperty().bind(stage.heightProperty().divide(2.2).subtract(s.radiusProperty()));
		
		DoubleBinding createDoubleBinding = Bindings.createDoubleBinding( ()-> {
			double h = stage.heightProperty().get();
			double w = stage.widthProperty().get();
			if(h > w) {
				return (w/2)-60;
			} else {
				return (h/2)-60;
			}
		} , stage.widthProperty() , stage.heightProperty());
		s.radiusProperty().bind(createDoubleBinding);
		
		VBox vb = new VBox();
		
		vb.getChildren().addAll(s);
		
		Scene scene = new Scene(vb, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

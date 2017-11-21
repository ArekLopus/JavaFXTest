package node;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

//http://stackoverflow.com/questions/28835920/when-to-use-translate-and-when-relocate-what-is-the-difference-between-transla
//layout Vs translate -  there is no difference between layout and translate functionality.
//Generally you should only change translate coordinates for fine location tuning and leave layout to layout managers
public class PositionTranslateVsLayout extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Main window");
		
		Sphere s = new Sphere(100);
		s.setDrawMode(DrawMode.FILL);
		s.setMaterial(new PhongMaterial(Color.RED));
		
		s.setTranslateX(20);
		s.setTranslateY(20);
		s.setTranslateZ(0);
		
		Slider s1 = new Slider(0, 250, 0);
		s.translateXProperty().bind(s1.valueProperty());
		Slider s2 = new Slider(0, 250, 0);
		s.translateYProperty().bind(s2.valueProperty());
		Slider s3 = new Slider(0, 450, 0);
		s.translateZProperty().bind(s3.valueProperty());
		
		Label l1 = new Label("X axis");
		Label l2 = new Label("Y axis");
		Label l3 = new Label("Z axis");
		
		l1.textProperty().bind(Bindings.format("X axis: %.0f", s1.valueProperty()));
		l2.textProperty().bind(Bindings.format("Y axis: %.0f", s2.valueProperty()));
		l3.textProperty().bind(Bindings.format("Z axis: %.0f", s3.valueProperty()));
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
		vb.getChildren().addAll(l1, s1, l2, s2, l3, s3, s);
		
		Scene scene = new Scene(vb, 500, 650);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package events;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ResizeEvent extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Main window");
		stage.widthProperty().addListener( (ob, ov, nv)->{ System.out.println("width: "+nv); } );
		stage.heightProperty().addListener( (ob, ov, nv)->{ System.out.println("height: "+nv); } );
		
		TextField tf1 = new TextField("tf1");
		TextField tf2 = new TextField("tf2");
		
		Circle c = new Circle(100);
		c.setStyle("-fx-fill: red;");

		c.translateXProperty().bind(stage.widthProperty().divide(2.1).subtract(c.radiusProperty()));
		c.translateYProperty().bind(stage.heightProperty().divide(2.5).subtract(c.radiusProperty()));
		
		DoubleBinding createDoubleBinding = Bindings.createDoubleBinding( ()-> {
			double h = stage.heightProperty().get();
			double w = stage.widthProperty().get();
			if(h > w) {
				return (w/2)-60;
			} else {
				return (h/2)-70;
			}
		} , stage.widthProperty() , stage.heightProperty());
		c.radiusProperty().bind(createDoubleBinding);
		
		
		tf1.textProperty().bind(stage.widthProperty().asString());
		tf2.textProperty().bind(stage.heightProperty().asString());
		
		VBox vb = new VBox();
		
		vb.getChildren().addAll(tf1, tf2, c);
		
		Scene scene = new Scene(vb, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

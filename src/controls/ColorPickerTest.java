package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html
//ColorPicker control allows to select a color from either a standard palette OR define their own custom color. 
public class ColorPickerTest extends Application {
	
	private Color c = Color.RED;
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ColorPicker");
		
		Label l1 = new Label();
		Label l2 = new Label();
		Label l3 = new Label();
		l1.setText("R: "+c.getRed());
		l2.setText("G: "+c.getGreen());
		l3.setText("B: "+c.getBlue());
		
		ColorPicker cp = new ColorPicker(c);
		cp.setOnAction( e -> {
			c = cp.getValue();
			l1.setText("R: "+c.getRed());
			l2.setText("G: "+c.getGreen());
			l3.setText("B: "+c.getBlue());
			System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());
		});
		
		//Appearance of a color picker control 
		//cp.getStyleClass().add("arrow-button");
		//cp.getStyleClass().add("split-button");
		cp.getStyleClass().add("button");
		cp.setStyle("-fx-background-color: #669999;  -fx-background-radius: 15 15 15 15; ");
		
		Rectangle rec = new Rectangle();
		rec.setWidth(100);
		rec.setHeight(100);
		rec.fillProperty().bind(cp.valueProperty());
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(cp, rec, l1, l2, l3);
		
		Scene scene = new Scene(vb, 300, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

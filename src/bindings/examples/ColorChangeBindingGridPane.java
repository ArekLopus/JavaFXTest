package bindings.examples;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ColorChangeBindingGridPane extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("GridPane");
		
		Label l1 = new Label("Red");
		l1.setPrefWidth(50);
		l1.setAlignment(Pos.CENTER_RIGHT);
		Label l2 = new Label("Green");
		l2.setPrefWidth(50);
		l2.setAlignment(Pos.CENTER_RIGHT);
		Label l3 = new Label("Blue");
		l3.setPrefWidth(50);
		l3.setAlignment(Pos.CENTER_RIGHT);
		
		Slider sl1 = new Slider(0, 255, 255);
		sl1.setShowTickMarks(true);
		sl1.setShowTickLabels(true);
		sl1.setPrefWidth(255);
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
		
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10,10,10,10));
		gp.setHgap(10);
		gp.setVgap(10);
		gp.add(l1, 0, 0);		//column:0	row:0
		gp.add(sl1, 1, 0);		//column:1	row:0
		gp.add(l2, 0, 1);		//column:0	row:1
		gp.add(sl2, 1, 1);		//column:1	row:1
		gp.add(l3, 0, 2);		//column:0	row:2
		gp.add(sl3, 1, 2);		//column:1	row:2
		gp.add(rec, 0, 3, 2, 2);//column:0	row:3  colspan:2  rowspan:2   - how many cols and rows it takes
		
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
		
		Scene scene = new Scene(gp, 360, 300);
		
		stage.setScene(scene);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
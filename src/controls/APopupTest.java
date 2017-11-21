package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Popup.html
//-A Popup is a special window-like container for a scene graph.
// It is typically used for tooltip like notification, drop down boxes, menus, and so forth.
//-It essentially acts as a specialized scene/window which has no decorations, is transparent, and with a null fill.
public class APopupTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Popup");
		
		Button b1 = new Button("Popup");
		b1.setOnAction( e -> {
			Popup pu = new Popup();
			pu.setWidth(200);
			pu.setHeight(100);
			pu.setAutoFix(true);
			
			Button b = new Button("Close");
			b.setOnAction( ev -> {
				pu.hide();
			});
			Rectangle rec = new Rectangle();
			rec.setHeight(100);
			rec.setWidth(200);
			rec.setFill(Color.RED);
			pu.getContent().addAll(rec, b);
			
			pu.show(stage);
		});
		
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(b1);
		
		Scene scene = new Scene(vb, 320, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

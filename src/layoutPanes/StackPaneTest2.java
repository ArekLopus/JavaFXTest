package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//The stackpane will attempt to resize each child to fill its content area.
public class StackPaneTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("StackPane");
		
		HBox hb = new HBox();
	    Button b1 = new Button("You can call me a button");
	    hb.getChildren().add(b1);
	    hb.setPrefWidth(150);
	    hb.setPadding(new Insets(10));
	    hb.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
	    
	    StackPane sp = new StackPane();
		sp.getChildren().addAll(hb);
	    
		Scene scene = new Scene(sp, 300, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//-If more than one child has the same grow priority set, then the hbox will allocate equal amounts of space to each.
//-HBox will only grow a child up to its MAXIMUM width, so if the child has a max width other than Double.MAX_VALUE,
// the application may need to override the max to allow it to grow.
public class HgrowTest extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Hgrow");
		
		Button b1 = new Button("Testing");		//It wont grow
		
		Button b2 = new Button("Testing");
		b2.setMaxWidth(Double.MAX_VALUE);
		
		Label l1 = new Label("Label 1");
		l1.setPadding(new Insets(5));
		l1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		TextField tf1 = new TextField();
		
		Region r1 = new Region();
		//r1.setPrefSize(20, 20);
		
		HBox.setHgrow(b2, Priority.ALWAYS);
		HBox.setHgrow(l1, Priority.ALWAYS);
		HBox.setHgrow(r1, Priority.ALWAYS);
		HBox.setHgrow(tf1, Priority.ALWAYS);
		
		HBox hb = new HBox(10);
		hb.setPadding(new Insets(10));
		hb.getChildren().addAll(b1, b2, tf1, r1, l1);
		
		Scene scene = new Scene(hb, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
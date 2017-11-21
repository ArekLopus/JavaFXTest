package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class RegionSetHgrow extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("setHgrow");
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setSpacing(10);
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Button b1 = new Button("Ok");
		Button b2 = new Button("Cancel");
		b1.setMinWidth(70);
		b2.setMinWidth(70);
		
		Region region = new Region();
		region.setPrefWidth(50);
		
		//Always keeps buttons on the right when resized
		HBox.setHgrow(region, Priority.ALWAYS);
		
		hb.getChildren().addAll(tf1, tf2, region, b1, b2);
		
		
		Scene scene = new Scene(hb, 550, 200);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}

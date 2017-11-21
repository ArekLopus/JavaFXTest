package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StackPaneTest3 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("StackPane");
		
		ImageView iv1 = new ImageView("/helper/Smile128.png");
		Text t1 = new Text("This is a smile");
		
		StackPane sp = new StackPane();
		sp.getChildren().addAll(iv1, t1);
	    
		StackPane.setAlignment(t1, Pos.BOTTOM_RIGHT);
		
		//t1.setTranslateX(20);
		//t1.setTranslateY(40);
		
		sp.setPadding(new Insets(20));
		
		
		Scene scene = new Scene(sp);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
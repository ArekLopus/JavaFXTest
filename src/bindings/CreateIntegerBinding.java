package bindings;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CreateIntegerBinding extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX Test");
		
		TextField tf1 = new TextField("1");
		TextField tf2 = new TextField("22");
		TextField tf3 = new TextField();
		Label l1 = new Label();
		
		IntegerBinding ib = Bindings.createIntegerBinding( () -> {
			try {
				l1.setText("");
				int i1 = Integer.parseInt(tf1.textProperty().get());
				int i2 = Integer.parseInt(tf2.textProperty().get());
				return i1 + i2;
			} catch (Exception e) {
				l1.setText("ERROR!");
				return 0;
			}
			
		} , tf1.textProperty(), tf2.textProperty());
		tf3.textProperty().bind(ib.asString());
		
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(tf1, tf2, tf3, l1);
		
		Scene scene = new Scene(vb, 320, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

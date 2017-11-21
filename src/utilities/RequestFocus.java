package utilities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RequestFocus extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Main window");
		
		TextField tf1 = new TextField("tf1");
		TextField tf2 = new TextField("tf2");
		TextField tf3 = new TextField("tf3");
		Button b1 = new Button("Request focus for TF1");
		b1.setOnAction( e -> {
			tf1.requestFocus();
			tf1.selectAll();
		});
		
		Button b2 = new Button("Who has the focus?");
		b2.setFocusTraversable(false);
				

		VBox vb = new VBox(3);
		vb.setPadding(new Insets(2));
		vb.getChildren().addAll(tf1, tf2, tf3, b1, b2);
		
		Scene scene = new Scene(vb, 300, 300);
		
		b2.setOnAction( e -> {
			System.out.println(scene.getFocusOwner());
		});
		
		//Request focus MUST be after scene construction or can be in a listener
		tf2.requestFocus();
		tf2.selectAll();
		
		stage.setScene(scene);
		
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

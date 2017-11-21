package events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageEvents extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("JavaFX Test");
		stage.initStyle(StageStyle.DECORATED);
		
		stage.setOnHidden( (e) -> System.out.println("stage OnHidden") );
		stage.setOnCloseRequest( (e) -> System.out.println("stage OnCloseRequest") );
		stage.setOnHiding( (e) -> System.out.println("stage OnHiding") );
		stage.setOnShowing( (e) -> System.out.println("stage OnShowing") );
		stage.setOnShown( (e) -> System.out.println("stage OnShown") );
		
		Button b = new Button("Just a button");
		b.setOnAction( (e)->{
			showDialog("NewDialog", "Just testing events");
		});
		
		StackPane sp = new StackPane();
		sp.getChildren().add(b);
		
		Scene scene = new Scene(sp, 300, 300);
		
		stage.setScene(scene);
			
        stage.show();
	}
	
	private void showDialog(String title, String message) {
		
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		
		stage.setOnHidden( (e) -> System.out.println("dialog stage OnHidden") );
		stage.setOnHiding( (e) -> System.out.println("dialog stage OnHiding") );
		
		Label l = new Label(message);
		Button b = new Button("Close");
		b.setOnAction( e -> stage.close() );
		
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(l, b);
		
		Scene scene = new Scene(vb);
		
		stage.setScene(scene);
		
		stage.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

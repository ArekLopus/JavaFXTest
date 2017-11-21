package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomControlTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(CustomControlTest.class.getResource("CustomControlTest.fxml"));
		VBox vBox = (VBox)fxmlLoader.load();
		
		HBox hb = new HBox(10);
		
		CustomControl cc = new CustomControl();
		cc.setText("Made by Java code");
		
		CustomControlNoFXML cc2 = new CustomControlNoFXML();
		cc2.setText("CustomControlNoFXML");
		//cc2.setMyCustomProperty("Blablala");
		
		hb.getChildren().addAll(cc, vBox, cc2);
		
		Scene scene = new Scene(hb, 500, 350);
		
		stage.setTitle("Custom Control Example");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

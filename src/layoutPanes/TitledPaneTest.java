package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TitledPane.html
public class TitledPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Titled Pane");
		
		Label l1 = new Label("Your input ");
		l1.setTextAlignment(TextAlignment.CENTER);
		TextField tf1 = new TextField();
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.BASELINE_CENTER);
		HBox.setHgrow(tf1, Priority.ALWAYS);
		hb.getChildren().addAll(l1, tf1);
		

		TitledPane titledPane = new TitledPane("My Title", hb);
		titledPane.setCollapsible(true);	//closing action
		titledPane.setAnimated(true);		//animating
		//titledPane.setText("My Titled Pane");		
		

		Group root = new Group();
		root.getChildren().add(titledPane);
		
		Scene scene = new Scene(root, 550, 300);
		
		titledPane.prefWidthProperty().bind(scene.widthProperty().divide(2));
		titledPane.prefHeightProperty().bind(scene.heightProperty().divide(2));
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
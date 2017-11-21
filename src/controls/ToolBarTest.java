package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ToolBar.html
public class ToolBarTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ToolBar");
		
		
		ToolBar tb1 = new ToolBar(
			new Button("New"),
				new Button("Open"),
				new Button("Save")
		);
		
		ToolBar tb2 = new ToolBar(
			new Button("New"),
			new Button("Open"),
			new Button("Save"),
			new Separator(),
			new Button("Clean"),
			new Button("Compile"),
			new Button("Run"),
			new Separator(),
			new Button("Debug"),
			new Button("Profile")
		);
		
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(tb1, tb2);
		
		Scene scene = new Scene(vb, 300, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

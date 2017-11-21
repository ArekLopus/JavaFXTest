package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonToggle extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ToggleButton");
		
		ToggleButton tb1 = new ToggleButton("Option 1");
		ToggleButton tb2 = new ToggleButton("Option 2");
		ToggleButton tb3 = new ToggleButton("Option 3");
		ToggleButton tb4 = new ToggleButton("Option 4");
		
		ToggleGroup toggleGroup = new ToggleGroup();

		tb1.setToggleGroup(toggleGroup);
		tb2.setToggleGroup(toggleGroup);
		tb3.setToggleGroup(toggleGroup);
		tb4.setToggleGroup(toggleGroup);		
		
		HBox vb = new HBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(tb1, tb2, tb3, tb4);
		
		Scene scene = new Scene(vb, 350, 200);
		
		//2 ways of getting which button was selected = source of the event and toggle group
		EventHandler<ActionEvent> eh = e -> {
			System.out.println("Button selected (event's source) -> "+((ToggleButton)e.getSource()).getText());
			System.out.println("Button selected (toggle group)   -> "+((ToggleButton) toggleGroup.getSelectedToggle()).getText());
		};
		
		tb1.setOnAction( eh );
		tb2.setOnAction( eh );
		tb3.setOnAction( eh );
		tb4.setOnAction( eh );
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

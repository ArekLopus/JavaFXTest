package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SplitMenuButton.html

//The SplitMenuButton, like the MenuButton is closely associated with the concept of selecting a MenuItem from a menu.
//Unlike MenuButton, the SplitMenuButton is broken into two pieces, the "action" area and the "menu open" area.

//If the user clicks in the action area, the SplitMenuButton will act similarly to a Button, firing onAction property.
//The menu open area of the control will show a menu if clicked. When the user selects an item from the menu, it is executed. 
public class ButtonSplitMenu extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SplitMenuButton");
		
		SplitMenuButton smb = new SplitMenuButton();
		smb.setText("Options");
		MenuItem mi1 = new MenuItem("Option 1", new ImageView("/helper/favorite16.png"));
		MenuItem mi2 =  new MenuItem("Option 2", new ImageView("/helper/color16.png"));
		MenuItem mi3 =  new MenuItem("Option 3", new ImageView("/helper/fruit16.png"));
		smb.getItems().addAll(mi1, mi2, mi3);
		
		//By default the menu appears below the button. 
		//smb.setPopupSide(Side.RIGHT);
		//smb.setPopupSide(Side.LEFT);
		
		smb.setOnAction( e->{
			System.out.println("Button clicked");
		});
		
		EventHandler<ActionEvent> evt = e -> {
			String text = ((MenuItem)e.getSource()).getText();
			System.out.println("Your choice: "+text);
		}; 
		mi1.setOnAction(evt);
		mi2.setOnAction(evt);
		mi3.setOnAction(evt);
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(smb);
		
		Scene scene = new Scene(vb, 300, 200);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

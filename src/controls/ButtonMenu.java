package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/MenuButton.html

//MenuButton, when clicked or pressed, will show a ContextMenu. A MenuButton shares a very similar API to the Menu control,insofar that
//you set the items in the ObservableList, and there is a Labeled.text property to specify the label shown within the MenuButton.
public class ButtonMenu extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("MenuButton");
		
		MenuButton mb = new MenuButton("Options", new ImageView("/helper/Smile32.png"));
		MenuItem mi1 = new MenuItem("Option 1", new ImageView("/helper/favorite16.png"));
		MenuItem mi2 =  new MenuItem("Option 2", new ImageView("/helper/color16.png"));
		MenuItem mi3 =  new MenuItem("Option 3", new ImageView("/helper/fruit16.png"));
		mb.getItems().addAll(mi1, mi2, mi3);
		
		//A MenuButton can be set to show its menu on any side of the button. This is specified using the popupSide property.
		//By default the menu appears below the button. 
		mb.setPopupSide(Side.RIGHT);
		//mb.setPopupSide(Side.LEFT);
		
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
		
		vb.getChildren().addAll(mb);
		
		Scene scene = new Scene(vb, 300, 200);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

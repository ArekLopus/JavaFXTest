package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonBar.html
//A ButtonBar is essentially a HBox, with the additional functionality for operating system specific button placement.
//In other words, any Node may be annotated (via the setButtonData(Node, ButtonData) method, placed inside a ButtonBar 
//(via the getButtons() list), and will then be positioned relative to all other nodes in the button list based on their annotations,
//as well as the overarching button order specified for the ButtonBar.
public class ButtonBarTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ButtonBar");
		
		//Create the ButtonBar instance 
		ButtonBar bb = new ButtonBar();
		bb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		bb.setPadding(new Insets(8));
		 
		//Create the buttons to go into the ButtonBar
		Button yesButton = new Button("Yes");
		ButtonBar.setButtonData(yesButton, ButtonData.YES); 
		 
		Button noButton = new Button("No");
		ButtonBar.setButtonData(noButton, ButtonData.NO);
		 
		//Add buttons to the ButtonBar
		bb.getButtons().addAll(yesButton, noButton);
		
		//Set the custom button order
		bb.setButtonOrder("NY+");  
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(bb);
		
		Scene scene = new Scene(vb, 300, 200);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

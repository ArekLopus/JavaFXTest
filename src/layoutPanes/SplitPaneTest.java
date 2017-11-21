package layoutPanes;

import helper.Helper;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SplitPane.html
//-A control that has two or more sides, each separated by a divider, which can be dragged by the user to give more space
// to one of the sides, resulting in the other side shrinking by an equal amount.
//-Nodes needs to be placed inside a layout container before they are added into the SplitPane. If the node is not inside a layout container
// the maximum and minimum position of the divider will be the maximum and minimum size of the content. 
//-A divider's position ranges from 0 to 1.0(inclusive)
public class SplitPaneTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("SplitPane");
		
		
		SplitPane spp1 = new SplitPane();
		
		TextArea ta1 = new TextArea(Helper.TEXT_LOREM);
		ta1.setWrapText(true);
		VBox vb1 = new VBox();
		vb1.getChildren().add(ta1);
		
		TextArea ta2 = new TextArea(Helper.TEXT_LOREM);
		ta2.setWrapText(true);
		VBox vb2 = new VBox();
		vb2.getChildren().add(ta2);
		
		spp1.getItems().addAll(vb1, vb2);
		spp1.setDividerPositions(0.6f);
		
		
		CheckBox cb1 = new CheckBox("Horizontal/Vertical");
		cb1.selectedProperty().addListener( (ob, oldv, nval ) -> {
			if(nval) {
				spp1.setOrientation(Orientation.VERTICAL);
			} else {
				spp1.setOrientation(Orientation.HORIZONTAL);
			}
		}); 
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(cb1, spp1);
		
		Scene scene = new Scene(vb, 550, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

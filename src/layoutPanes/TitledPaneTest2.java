package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Note that TitledPane extends from Labeled, the inherited properties are used to manipulate the TitledPane header, not the content area itself.
//If the intent is to modify the content area, consider using a layout container such as StackPane and setting your actual content inside of that.
//You can then manipulate the StackPane to get the layout results you are after.
public class TitledPaneTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Titled Pane");

		Button b1 = new Button("Press to change collapsible state");
		TitledPane tp1 = new TitledPane("My Title 1", b1);
		tp1.setCollapsible(false);	//closing action
		tp1.setAnimated(false);		//animating
		tp1.setPrefHeight(120);
		tp1.setPrefWidth(220);
		
		Group gr1 = new Group();
		gr1.getChildren().add(tp1);
		
		TitledPane tp2 = new TitledPane("My Title 2", new Button("Button 2"));
		tp2.setCollapsible(true);
		tp2.setAnimated(true);
		tp2.setPrefHeight(120);
		tp2.setPrefWidth(220);
		
		Group gr2 = new Group();
		gr2.getChildren().add(tp2);
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(10);
		hb.getChildren().addAll(gr1, gr2);
		
		b1.setOnAction( (e) -> {
			if(tp1.isCollapsible() == false) {
				tp1.setCollapsible(true);
			} else {
				tp1.setCollapsible(false);
			}
			
		});
		
		Scene scene = new Scene(hb, 470, 250);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html
public class BorderPaneTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("BorderPane");
		
		String[] names = {"Top", "Left", "Center", "Right", "Bottom"};
		Button[] buttons = new Button[5];
		VBox[] vbs = new VBox[5];
		
		for(int i=0; i<5; i++) {
			buttons[i] = new Button(names[i]);
			vbs[i] = new VBox();
			vbs[i].getChildren().add(buttons[i]);
			vbs[i].setPrefWidth(100);
			vbs[i].setPrefHeight(100);
			vbs[i].setAlignment(Pos.CENTER);
			vbs[i].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		}
		
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		
		bp.setTop(vbs[0]);
		bp.setLeft(vbs[1]);
		bp.setCenter(vbs[2]);
		bp.setRight(vbs[3]);
		bp.setBottom(vbs[4]);
		
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
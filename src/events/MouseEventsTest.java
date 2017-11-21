package events;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MouseEventsTest extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Mouse Events");
		stage.setOpacity(0.9);
		
		Screen sc = Screen.getPrimary();
		double screenWidth = sc.getBounds().getWidth();
		double screenHeight = sc.getBounds().getHeight();
		double prefWidth = 300;
		double prefHeight = 300;
		
		Label l1 = new Label("pos x:");
		Label l2 = new Label("pos y:");
		Label l3 = new Label("Click mouse button");
		Label l4 = new Label("Mouse outside a Group Node");
		Label l5 = new Label("Mouse pressed/released");
		Label l6 = new Label("scroll");
		
		Group gr = new Group();
		gr.setTranslateX((screenWidth/2)-(prefWidth/2));
		gr.setTranslateY((screenHeight/2)-(prefHeight/2));
		
		VBox vb = new VBox();
		vb.setPrefHeight(prefHeight);
		vb.setPrefWidth(prefWidth);
		vb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
		vb.getChildren().addAll(l1, l2, l3, l4, l5, l6);
		
		gr.getChildren().add(vb);
		
		Scene scene = new Scene(gr, screenWidth, screenHeight);
		
		scene.setOnMouseMoved( (e) -> {
			l1.setText("pos x: "+String.valueOf(e.getScreenX()));
			l2.setText("pos y: "+String.valueOf(e.getScreenY()));
		} );
		scene.setOnMouseClicked( (e) -> {
			l3.setText("Mouse clicked "+e.getButton()+", "+e.getClickCount()+", "+e.getScreenX()+", "+e.getScreenY());
		} );
		
		gr.setOnMouseEntered( (e) -> {
			l4.setText("Mouse entered a Group Node");
		} );
		gr.setOnMouseExited( (e) -> {
			l4.setText("Mouse left a Group Node");
		} );
		
		scene.setOnMousePressed( (e) -> {
			l5.setText("Mouse pressed");
		} );
		scene.setOnMouseReleased( (e) -> {
			l5.setText("Mouse released");
		} );
		scene.setOnScroll( (e) -> {
			if(e.getDeltaY() > 0) {
				l6.setText("scrolling up");
			} else if (e.getDeltaY() < 0) {
				l6.setText("scrolling down");
			}
		} );
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonRadio extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("RadioButton");
		
		
		HBox hb = new HBox();
		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb.setPadding(new Insets(10));
	    hb.setSpacing(10);
		
	    Label l1 = new Label("RadioButton Group");
		ToggleGroup tg = new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("rb1");
		rb1.setToggleGroup(tg);
		RadioButton rb2 = new RadioButton("rb2");
		rb2.setToggleGroup(tg);
		RadioButton rb3 = new RadioButton("rb3");
		rb3.setToggleGroup(tg);
		
		tg.selectedToggleProperty().addListener( new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				//System.out.println("Selected: "+((RadioButton)newValue).getText());
				//or we can use ToggleGroup
				RadioButton selectedRadioButton = (RadioButton) tg.getSelectedToggle();
				System.out.println("Selected: "+selectedRadioButton.getText());
			}
		} );
		//The same with lambdas
//		tg.selectedToggleProperty().addListener( (ChangeListener<Toggle>) (observable, oldValue, newValue) -> {
//			System.out.println("Selected: "+((RadioButton)newValue).getText());
//		});
		
		hb.getChildren().addAll(l1, rb1, rb2, rb3);
		
		
		RadioButton rb4 = new RadioButton("RadioButton with Image");
		rb4.setContentDisplay(ContentDisplay.RIGHT);
		rb4.setGraphic(new ImageView("/helper/Smile32.png"));
		
		
		
		
		VBox vb = new VBox();
		
		vb.setPadding(new Insets(10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(hb, rb4);
		
		Scene scene = new Scene(vb, 300, 400);
		
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}

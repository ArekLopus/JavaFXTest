package layoutPanes;

import java.time.LocalDate;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/DialogPane.html
//In addition to the header and content properties, there exists header_text and content_text properties.
//The way the *Text properties work is that they are a lower precedence compared to the Node properties,
public class DialogPaneTest extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert Title");
		
		DialogPane dp = new DialogPane();
		
		//setHeader() takes precedence to setHeaderText()
		dp.setHeaderText("Header Text from DialogPane");
		dp.setHeader(new DatePicker(LocalDate.now()));
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(8);
		CheckBox cb1 = new CheckBox("option1");
		CheckBox cb2 = new CheckBox("option2");
		CheckBox cb3 = new CheckBox("option3");
		hb.getChildren().addAll(cb1, cb2, cb3);
		
		//setContent() takes precedence to setContentText()
		dp.setContentText("Content Text from DialogPane");
		dp.setContent(hb);
		
		ButtonType b1 = new ButtonType("My Button");
		ButtonType b2 = new ButtonType("OK Button", ButtonData.OK_DONE);
		ButtonType b3 = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		dp.getButtonTypes().addAll(b1, b2, b3);
		
		//CSS style
		dp.setStyle("-fx-background-color: yellow;");
		
		//ExpandableContent
		TextArea ta = new TextArea("Abracadabra");
		dp.setExpandableContent(ta);
		
		alert.setDialogPane(dp);
		
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.isPresent()  && result.get() == b1) {
			System.out.println("My Button pressed");
		} else if(result.isPresent()  && result.get() == b2) {
			System.out.println("OK Button pressed");
		} else if(result.isPresent()  && result.get() == b3) {
			System.out.println("Cancel Button pressed");
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
package dialogs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ExpandableContent_Exception extends Application {
	
	@Override
	public void start(Stage stage) {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("Header Text");
		alert.setContentText("Content Text");

		Exception ex = new FileNotFoundException("File abc.txt");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String excText = sw.toString();

		Label label = new Label("The exception stacktrace:");

		TextArea textArea = new TextArea(excText);
		textArea.setEditable(false);
		textArea.setWrapText(true);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane expandableContent = new GridPane();
		expandableContent.setMinWidth(700);
		expandableContent.setMinHeight(400);
		
		expandableContent.add(label, 0, 0);
		expandableContent.add(textArea, 0, 1);

		//Setting expandable content
		alert.getDialogPane().setExpandableContent(expandableContent);

		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
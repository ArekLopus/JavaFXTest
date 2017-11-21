package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLogInExample extends Application {
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("GridPane");
		
		Label l1 = new Label("Name");
		Label l2 = new Label("Password");
		
		TextField tf1 = new TextField();
		tf1.setPromptText("name");
		PasswordField tf2 = new PasswordField();
		tf2.setPromptText("password");
		
		Button b1 = new Button("Log In");
		b1.setAlignment(Pos.CENTER);
		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(10,10,10,10));
		gp.setHgap(10);
		gp.setVgap(10);
		
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.add(l1, 0, 0);		//column:0	row:0
		gp.add(tf1, 1, 0);		//column:1	row:0
		gp.add(l2, 0, 1);		//column:0	row:1
		gp.add(tf2, 1, 1);		//column:1	row:1
		gp.add(b1, 1, 3, 2, 2); //column:0	row:3  colspan:2  rowspan:2   - how many cols and rows it takes
		
		Scene scene = new Scene(gp);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
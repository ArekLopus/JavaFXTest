package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
@SuppressWarnings("unused")
public class GridPaneSizingRowAndColls extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("GridPane");
		
		Label l1 = new Label("My Label 1");
		TextField tf1 = new TextField("My TextField 1");

		Label l2 = new Label("My Label 2");
		TextField tf2 = new TextField("My TextField 2");

		
		GridPane gp = new GridPane();
		
		gp.setPadding(new Insets(10,10,10,10));
		gp.setHgap(10);
		gp.setVgap(10);
		
//		gp.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
//	    gp.getColumnConstraints().add(new ColumnConstraints(200)); // column 1 is 200 wide
	    
//		ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
//	    column1.setHgrow(Priority.ALWAYS);
//	    ColumnConstraints column2 = new ColumnConstraints(200);
//	    gp.getColumnConstraints().addAll(column1, column2);
		
		//Percentage Sizing
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(25);
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(75);
		gp.getColumnConstraints().addAll(column1, column2);
		
		gp.add(l1, 0, 0);		//column:0	row:0
		gp.add(tf1, 1, 0);		//column:1	row:0
		gp.add(l2, 0, 1);		//column:0	row:0
		gp.add(tf2, 1, 1);		//column:1	row:0
		
		
		Scene scene = new Scene(gp, 360, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
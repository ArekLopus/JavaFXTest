package layoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//You can set the column and row indexes for a child node using one of the following three static methods of the GridPane class.
// • public static void setColumnIndex(Node child, Integer value)
// • public static void setRowIndex(Node child, Integer value)
// • public static void setConstraints(Node child,int columnIndex, int rowIndex)

//-The GridPane class contains the following convenience methods to add children with constraints.
// • void add(Node child, int columnIndex, int rowIndex)
// • void add(Node child, int columnIndex, int rowIndex, int colspan,int rowspan)
// • void addRow(int rowIndex, Node... children)
// • void addColumn(int columnIndex, Node... children)

//-A child node may span more than one row and column, which can be specified using the rowSpan and colSpan constraints.
// By default, a child node spans one column and one row.
//-These constraints can be specified while adding the child node or later using any of the following methods in the GridPane class.
// • void add(Node child, int columnIndex, int rowIndex, int colspan, int rowspan)
// • static void setColumnSpan(Node child, Integer value)
// • static void setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan)
//-The GridPane class defines a constant named REMAINING that is used for specifying the column/row span. 
// It means that the child node spans the remaining columns or remaining rows.
public class GridPaneTest2 extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("GridPane");
		
		GridPane gp = new GridPane();
		gp.setGridLinesVisible(true);	//It exists for debugging purposes only
		
		
		gp.add(new Button("Button1"), 0, 0);
		gp.add(new Button("Button2"), 0, 1);
		
		gp.addRow(2, new Button("Button3"));
		
		Button b4 = new Button("Button4");
		b4.setPrefWidth(190);
		gp.addRow(3, b4);
		GridPane.setColumnSpan(b4,3);
		
		gp.addRow(4, new Button("Button5"), new Button("Button6"), new Button("Button7"));
		
		Button b8 = new Button("Button8");
		b8.setPrefWidth(190);
		gp.add(b8, 0, 5, 3, 1);			//add(Node child, int columnIndex, int rowIndex, int colspan,int rowspan)
		
		Button b9 = new Button("Button9");
		b9.setPrefWidth(190);
		gp.add(b9, 0, 6, GridPane.REMAINING, 1);
		
		
		gp.setPadding(new Insets(10));
		gp.setHgap(10);
		gp.setVgap(10);
		
		Scene scene = new Scene(gp, 360, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
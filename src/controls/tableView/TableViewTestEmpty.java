package controls.tableView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewTestEmpty extends Application {

	private TableView<String> table = new TableView<>();

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView");
		
		Label l1 = new Label("Add some data");
		l1.setGraphic(new ImageView("/helper/Smile32.png"));
		table.setPlaceholder(l1);		//It is a node! not a String
		table.setEditable(true);

		TableColumn<String, String> firstNameCol = new TableColumn<>("First Name");
		TableColumn<String, String> lastNameCol = new TableColumn<>("Last Name");
		TableColumn<String, String> emailCol = new TableColumn<>("Email");
		
		//We can create nested columns.
		TableColumn<String, String> firstEmailCol = new TableColumn<>("Primary");
		TableColumn<String, String> secondEmailCol = new TableColumn<>("Secondary");
		emailCol.getColumns().addAll(firstEmailCol, secondEmailCol);
		//emailCol.setVisible(false);
		
		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(table);

		Scene scene = new Scene(vb);

		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
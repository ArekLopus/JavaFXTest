package controls.tableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSelectionModel extends Application {

	private TableView<Person> table = new TableView<>();
	private Label l1 = new Label("Selected: ");
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
				new Person("Will", "Johnson", "will.johnson@mail.com", ""),
				new Person("Ianthe", "Avanti", "iante.avanti@mail.com", ""),
				new Person("Bruce", "Lee", "bruce.lee@mail.com", ""),
				new Person("Jenna", "Adams", "jenna.addams@mail.com", ""));

	//@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView");

		table.setItems(data);
		
		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setPrefWidth(100);
		TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setPrefWidth(100);
		TableColumn<Person, String> emailCol = new TableColumn<>("Email");
		emailCol.setPrefWidth(200);
		TableColumn<Person, String> favColorCol = new TableColumn<>("Favorite Color");
		favColorCol.setPrefWidth(100);

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, favColorCol);
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		favColorCol.setCellValueFactory(new PropertyValueFactory<Person, String>("favoriteColor"));
		
		
		//the SelectionModel and FocusModel classes.
		//A TableView has at most one instance of each of these classes, available from selectionModel and focusModel properties
		
		//To enable muliple selection (with CTRL):
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		table.getSelectionModel().selectedItemProperty().addListener( (ob, ol, ne) -> {
			l1.setText("Selected items (Milti select with CTRL): " + table.getSelectionModel().getSelectedItems().size());
			System.out.println("Selected item: " + ne);
			System.out.println("SelectedItems: " + table.getSelectionModel().getSelectedItems());
			System.out.println("FocusedIndex: " + table.getSelectionModel().getFocusedIndex());
			System.out.println("SelectedIndex: " + table.getSelectionModel().getSelectedIndex());
			System.out.println("SelectedIndices: " + table.getSelectionModel().getSelectedIndices());
			System.out.println("-------------------------------------------------------");
		});
		
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(l1, table);
		
		Scene scene = new Scene(vb);
		l1.setFont(new Font(null, 12));
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
package controls.tableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewAddingNewItems extends Application {

	private TableView<Person> table = new TableView<>();
	private Label l1 = new Label("Selected: ");
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
				new Person("Will", "Johnson", "will.johnson@mail.com", ""),
				new Person("Ianthe", "Avanti", "iante.avanti@mail.com", ""),
				new Person("Bruce", "Lee", "bruce.lee@mail.com", ""),
				new Person("Jenna", "Adams", "jenna.addams@mail.com", ""));

	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView");

		table.setEditable(true);

		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setPrefWidth(100);
		TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setPrefWidth(100);
		TableColumn<Person, String> emailCol = new TableColumn<>("Email");
		emailCol.setPrefWidth(200);
		TableColumn<Person, String> favColorCol = new TableColumn<>("Favorite Color");
		favColorCol.setPrefWidth(100);

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, favColorCol);
		
		table.setItems(data);
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		favColorCol.setCellValueFactory(new PropertyValueFactory<Person, String>("favoriteColor"));
		
		table.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			l1.setText("Selected: " + n);
			System.out.println("Selected tem: " + n);
		});
		
		
		HBox hb = new HBox();
		hb.setSpacing(5);
		hb.setPadding(new Insets(10, 0, 5, 0));
		hb.setMaxWidth(500);
		
		TextField tf1 = new TextField("John");
		tf1.maxWidth(20);
		TextField tf2 = new TextField("Deep");
		tf2.maxWidth(20);
		TextField tf3 = new TextField("john.deep@mail.com");
		TextField tf4 = new TextField("brown");
		Button b1 = new Button("Add New User");
		b1.setMinWidth(100);
		
		
		hb.getChildren().addAll(tf1, tf2, tf3, tf4, b1);
		
		b1.setOnAction( e -> {
			Person person = new Person(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText());
			data.add(person);
			table.sort();
		} );
		
		
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(l1, table, hb);
		
		Scene scene = new Scene(vb);
		l1.setFont(new Font(null, 12));
		tf1.requestFocus();
		tf1.selectAll();
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
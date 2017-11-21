package controls.tableView;

import java.text.Collator;
import java.util.Locale;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSorting extends Application {

	private TableView<Person> table = new TableView<>();
	private Label l1 = new Label("Selected: ");
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("πAaron", "ÊSmith", "aaron.smith@mail.com", "yellow"),
				new Person("üWill", " Johnson", "will.johnson@mail.com", ""),
				new Person("ÊIanthe", "∆Avanti", "iante.avanti@mail.com", ""),
				new Person("ÒBruce", "ÍLee", "bruce.lee@mail.com", ""),
				new Person("ÍJenna", "∆Adams", "jenna.addams@mail.com", ""));

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
		
		//To sort multiple columns you need to press Shift while clicking the headers 
		
		//To disable sorting
		favColorCol.setSortable(false); 
		
		//You can set sorting preferences for each column 
		firstNameCol.setSortType(SortType.ASCENDING);
		lastNameCol.setSortType(TableColumn.SortType.DESCENDING);
		table.getSortOrder().addAll(firstNameCol, lastNameCol);
		
		//We can use custom comparators
		//lastNameCol.setComparator(Collator.getInstance(Locale.getDefault())::compare);
		//firstNameCol.setComparator(Collator.getInstance(Locale.ENGLISH)::compare);
		
		//Headers arrow
		//firstNameCol.setSortNode(new Label("a"));
		
		//Fe to use when data was updated - used in AddingNewItem
		//table.sort();
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		favColorCol.setCellValueFactory(new PropertyValueFactory<Person, String>("favoriteColor"));
		
		table.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			l1.setText("Selected: " + n);
			System.out.println("Selected tem: " + n);
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
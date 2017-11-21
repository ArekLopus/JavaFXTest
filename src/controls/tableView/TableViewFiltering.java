package controls.tableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TableViewFiltering extends Application {

	private TextField textTofilter = new TextField();
	private TableView<Person> table = new TableView<>();
	
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
				new Person("Will", "Johnson", "will.johnson@mail.com", ""),
				new Person("Ianthe", "Avanti", "iante.avanti@mail.com", ""),
				new Person("Bruce", "Lee", "bruce.lee@mail.com", ""),
				new Person("Bruceaa", "Leeaa", "bruce.lee@email.com", ""),
				new Person("Jenna", "Adams", "jenna.addams@mail.com", ""));

	//@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView");
		
		//null - to match all elements
		FilteredList<Person> filteredData = new FilteredList<>(data, null);
		
		
		textTofilter.textProperty().addListener( (obs, oldVal, newVal) -> {
            filteredData.setPredicate( person -> {
                //If filter text is empty, display all persons.
                if (newVal == null || newVal.isEmpty()) {
                    return true;
                }

                //Compare fields of every element in FilteredList with filter text.
                String lowerCaseFilter = newVal.toLowerCase();

                if (person.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;	//Filter text matches first name.
                } else if (person.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;	//Filter text matches last name.
                } else if (person.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 	//Filter text matches email address.
                } else if (person.getFavoriteColor().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 	//Filter text matches favorite color.
                }
                
                //no match.
                return false;
            });
        });
		
		SortedList<Person> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		table.setItems(sortedData);
		
		
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

		
		HBox hb = new HBox();
		hb.setSpacing(5);
		hb.setPadding(new Insets(10, 0, 5, 0));
		Label l1 = new Label("Enter text to filter data ");
		l1.setPadding(new Insets(3, 0, 0, 0));
		hb.getChildren().addAll(l1, textTofilter);
		
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(table, hb);
		
		Scene scene = new Scene(vb);
		textTofilter.requestFocus();
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
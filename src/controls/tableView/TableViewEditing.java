package controls.tableView;

import helper.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewEditing extends Application {

	private TableView<Person> table = new TableView<>();
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Aaron", "Smith", "aaron.smith@mail.com", "0xffffffff"),
				new Person("Will", "Johnson", "will.johnson@mail.com", "0xffffffff"),
				new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "0xffffffff"),
				new Person("Bruce", "Lee", "bruce.lee@mail.com", "0xffffffff"),
				new Person("Jenna", "Adams", "jenna.addams@mail.com", "0x00ffffff"));

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
		
		
		table.setEditable(true);
		
		//-Built-in cell factories - CheckBoxTableCell, ChoiceBoxTableCell, ComboBoxTableCell, ProgressBarTableCell, TextFieldTableCell
		//-Here we use TextField factory - For a TextField you HAVE TO to press Enter to commit the new value!
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//-It is very important to note that if you call TableColumn.setOnEditCommit(javafx.event.EventHandler)
		// with your own EventHandler, then you will be removing the default handler.
		//-TablePosition - represents a single row/column/cell in a TableView. 
		// Used to represent which rows/columns/cells are currently selected, focused, being edited, etc.
		firstNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> e) {
				//1.
				//((Person) e.getTableView().getItems().get(e.getTablePosition().getRow())).setFirstName(e.getNewValue())
				
				//2.
				//Person person = e.getRowValue();
				//person.setFirstName(e.getNewValue());
				
				e.getRowValue().setFirstName(e.getNewValue());
				System.out.println("Table position's row: "+e.getTablePosition().getRow());
			}
		});
		
		//Using J8 lambdas
//		firstNameCol.setOnEditCommit(
//		    e -> ((Person) e.getTableView().getItems().get(e.getTablePosition().getRow())).setFirstName(e.getNewValue())
//		);
		
		//First we set the type of editing sell factory
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		//We add edit commit event listener
		lastNameCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> e) {
				Person person = e.getRowValue();
				person.setLastName(e.getNewValue());
		    }
		});

		emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		emailCol.setOnEditCommit(new EventHandler<CellEditEvent<Person, String>>() {
			@Override
			public void handle(CellEditEvent<Person, String> e) {
				Person person = e.getRowValue();
				person.setEmail(e.getNewValue());
		    }
		});
		
		
		//Custom cell factory - color picker
		favColorCol.setCellFactory(ColorPickerTableCell<Person>::new);
		//favColorCol.setCellFactory(ColorPickerTableCell2<Person>::new);
		
		//We could add it to editComit() of our custom TabelCell but this way we have separate cell rendering and update data
		favColorCol.setOnEditCommit( e -> {
			Person person = e.getRowValue();
			person.setFavoriteColor(e.getNewValue());
		});
		
		
		Button b1 = new Button("Print all elements");
		b1.setOnAction( e -> {
			table.getItems().forEach(System.out::println);
			System.out.println("--------------------------------");
		} );

		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(table, b1);
		
		Scene scene = new Scene(vb);
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}


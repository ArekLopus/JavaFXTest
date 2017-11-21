package controls.tableView;

import helper.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewCustomCell extends Application {
	
	private Label l1 = new Label("Selected: ");
	private TableView<Person> table = new TableView<>();
	private ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
				new Person("Will", "Johnson", "will.johnson@mail.com", "orange"),
				new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "green"),
				new Person("Bruce", "Lee", "bruce.lee@mail.com", "red"),
				new Person("Jenna", "Adams", "jenna.addams@mail.com", ""));

	//@SuppressWarnings("unchecked")
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
		
		
		//Custom Cell Rendering
		//The updateItem() is called whenever the cell should be rendered.
		Callback<TableColumn<Person, String>, TableCell<Person, String>> defaultCellFactory = favColorCol.getCellFactory();
		Callback<TableColumn<Person, String>, TableCell<Person, String>> customCellFactory = column -> {
		    return new TableCell<Person, String>() {
		    	
		    	private Circle circle = new Circle(9);
		    	
		        @Override
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                
		                try {
		                	circle.setFill(Color.web(item));
		                } catch (Exception e) {
		                	//e.printStackTrace();
		                	circle.setFill(Color.web("white"));
		                }
		                setText(item);
		                setGraphic(circle);
		            }
		        }
		    };
		};
		
		
		//or before J8 lambdas
//		Callback<TableColumn<Person, String>, TableCell<Person, String>> custCellFactory = new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
//			@Override
//			public TableCell<Person, String> call(TableColumn<Person, String> param) {
//				return new TableCell<Person, String>() {
//					@Override
//			        protected void updateItem(String item, boolean empty) {
//			            super.updateItem(item, empty);
//
//			            if (item == null || empty) {
//			                setText(null);
//			            } else {
//			                Circle circle = new Circle(9);
//			                try {
//			                	circle.setFill(Color.web(item));
//			                } catch (Exception e) {
//			                	//e.printStackTrace();
//			                	circle.setFill(Color.web("white"));
//			                }
//			                setText(item);
//			                setGraphic(circle);
//			            }
//			        }
//				};
//			}
//		};
		
		
		
		CheckBox cb = new CheckBox("Cell Rendering Factory Default / Custom");
		cb.selectedProperty().addListener( (ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
			if( newValue == true ) {
				favColorCol.setCellFactory(customCellFactory);
			} else {
				favColorCol.setCellFactory(defaultCellFactory);
			}
		});
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(l1, table, cb);
		
		Scene scene = new Scene(vb);
		l1.setFont(new Font(null, 12));

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
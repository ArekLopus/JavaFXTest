package controls.tableView;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import helper.Numbers;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TableViewSortingFieldChanges extends Application {

	private TableView<Numbers> table = new TableView<>();
	private Label l1 = new Label("Round: ");
	private int loopCounter = 0;
	
	//@SuppressWarnings("unused")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView");
		
		//We need to implement a new Callback and connect it to the property(ies) we want to sort in our table.
		//When the property is updated it will trigger the table to re-sort itself.
		Callback<Numbers,Observable[]> cb = nr -> new Observable[] {  nr.getI1Property()  };
		
		//The same without lambdas
//		Callback<Numbers,Observable[]> cbOldWay = new Callback<Numbers, Observable[]>() {
//			@Override
//			public Observable[] call(Numbers nr) {
//				return new Observable[] {  nr.getI1Property() };
//			}
//		};
		
		//Our data - ObservableList that uses the Callback
		ObservableList<Numbers> data = FXCollections.observableArrayList(cb);
		data.addAll(
				new Numbers("int 1",0,2,3,4,5),
				new Numbers("int 2",8,2,3,4,5),
				new Numbers("int 3",2,2,3,4,5),
				new Numbers("int 4",4,2,3,4,5),
				new Numbers("int 5",3,2,3,4,5),
				new Numbers("int 6",1,2,3,4,5),
				new Numbers("int 7",6,2,3,4,5),
				new Numbers("int 8",5,2,3,4,5),
				new Numbers("int 9",7,2,3,4,5),
				new Numbers("our test",9,2,3,4,5));
		
		//We can use custom comparator to sort in our sorted list
		Comparator<Numbers> comparator = (Numbers nr1, Numbers nr2) -> {
	        if( nr1.getI1() < nr2.getI1() ) {
	            return -1;
	        } else if( nr1.getI1() > nr2.getI1() ) {
	            return 1;
	        } else {
	            return 0;
	        }
	    };
		
	    //A SortedList that uses the ObservableList
		SortedList<Numbers> sortedList = new SortedList<>(data /* comparator  */);
		
		//Setting the table data
		table.setItems(sortedList);
		
		//We have to bind comparator properties of the sorted list and the table
		sortedList.comparatorProperty().bind(table.comparatorProperty());
		
		//Creating columns
		TableColumn<Numbers, Integer> nr = new TableColumn<>("#");
		nr.setCellValueFactory( col -> new ReadOnlyObjectWrapper<Integer>( table.getItems().indexOf(col.getValue())));   
		nr.setSortable(false);
		nr.setPrefWidth(20);
		TableColumn<Numbers, Integer> id = new TableColumn<>("id");
		id.setPrefWidth(50);
		TableColumn<Numbers, Integer> int1 = new TableColumn<>("int1");
		int1.setPrefWidth(50);
		TableColumn<Numbers, Integer> int2 = new TableColumn<>("int2");
		int2.setPrefWidth(50);
		TableColumn<Numbers, Integer> int3 = new TableColumn<>("int3");
		int3.setPrefWidth(50);
		TableColumn<Numbers, Integer> int4 = new TableColumn<>("int4");
		int4.setPrefWidth(50);
		TableColumn<Numbers, Integer> int5 = new TableColumn<>("int5");
		int5.setPrefWidth(50);
		
		table.getColumns().addAll(int1, int2, int3, int4, int5, id, nr);
		
		//Associating the data with the table columns.
		id.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("id"));
		int1.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("i1"));
		int2.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("i2"));
		int3.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("i3"));
		int4.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("i4"));
		int5.setCellValueFactory(new PropertyValueFactory<Numbers, Integer>("i5"));

		
		
		//We HAVE TO set sort column
		int1.setSortType(TableColumn.SortType.ASCENDING);
		table.getSortOrder().addAll(int1);
		
		//Service that emulates dynamic data changes setting a new random value every 2secs
		Service<Void> backgroundThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						try {
							//We take element with id = our test
							Numbers nrToTest = sortedList.stream().filter(e -> e.getId().equals("our test")).findFirst().get();
							
							//Custom cell factory to make the circle background yellow for our element
							int1.setCellFactory( col -> {
		         				return new TableCell<Numbers, Integer>() {
		         					
		         					private Circle circle = new Circle(9);
		         					
		         					@Override
		         			        protected void updateItem(Integer item, boolean empty) {
		         						super.updateItem(item, empty);
		         			            
		         						setContentDisplay(ContentDisplay.CENTER);
		         						setTextAlignment(TextAlignment.CENTER);
		         						
		         						int tableIndex = getTableRow().getIndex();
		         			            int itemsIndex = table.getItems().indexOf(nrToTest);
 
		         			            circle.setFill(Color.WHITE);
		         			            setGraphic(circle);
		         			            
		         			            if(item == null || empty) {
		         			            	setText("");
		         			            	return;
		         			            }
		         			            
		         			            //If a row of the table equals the row of our tested element we make the cell yellow
		         			            if (tableIndex == itemsIndex) {
		         			            	circle.setFill(Color.YELLOW);
			         			            setGraphic(circle);
		         			            }
		         			            
		         			            setText(String.valueOf(item));
		         			        }
		         			    };
		         			});
		         			
		         			
							for(loopCounter = 0; loopCounter < 5; loopCounter++) {
							
							Thread.sleep(2000);
							
							Platform.runLater(new Runnable() {
				                 @Override public void run() {
				                	int ran = ThreadLocalRandom.current().nextInt(10);
				         			nrToTest.setI1(ran);
				         			
				         			l1.setText("Round: "+loopCounter+", Random nr: "+ran+ ", index in the list: "+sortedList.indexOf(nrToTest));
				         			System.out.println("Round: "+loopCounter+", Random nr -> "+ran+ ", index in the list -> "+sortedList.indexOf(nrToTest)+", index in the Table"+table.getItems().indexOf(nrToTest));
				                 }
				            });
							}
						} catch (InterruptedException e) {
							System.out.println("iterrupted");
						}
						return null;
					}
					
				};
			}
		};
		backgroundThread.start();
		
		
		
		Button b1 = new Button("Start simulation again");
		b1.setOnAction( e -> {
			System.out.println(backgroundThread.getState());
			
			backgroundThread.cancel();
			backgroundThread.reset();
			backgroundThread.start();
		});
		
		VBox vb = new VBox();
		vb.setSpacing(5);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(l1, table, b1);
		
		Scene scene = new Scene(vb);
		l1.setFont(new Font(null, 12));
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}




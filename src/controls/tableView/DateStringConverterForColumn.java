package controls.tableView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import helper.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class DateStringConverterForColumn extends Application {
	 
    @Override
    public void start(Stage stage) {
        stage.setTitle("TableView");
        
        TableColumn<User, String> name = new TableColumn<>("Name");
        TableColumn<User, String> surname = new TableColumn<>("Surname");
        TableColumn<User, Date> dob = new TableColumn<>("Birthday");
        
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(130);
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        surname.setMinWidth(130);
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        dob.setMinWidth(130);
        
        ObservableList<User> data = FXCollections.observableArrayList(
        	new User("Aaron", "Smith", new Date()),
        	new User("Will", "Johnson", new Date()),
        	new User("Jenna", "Adams", new Date())
   		);
        TableView<User> table = new TableView<>(data);        
        
        table.setEditable(true);
        //table.getSelectionModel().setCellSelectionEnabled(true);
        table.getColumns().setAll(name, surname, dob);
        
        Callback< TableColumn<User, Date>, TableCell<User, Date>> cellFactory = 
        	p -> new TextFieldTableCell<User, Date>(new StringConverter<Date>() {
			    
        		Calendar cal = new GregorianCalendar();
        		DateFormat formatter = new SimpleDateFormat("d.MM.yyyy");
        		
        		@Override
			    public String toString(Date date) {
        			
        			cal.setTime(date);
			        int day = cal.get(Calendar.DAY_OF_MONTH);
			        int month = cal.get(Calendar.MONTH)+1;		//Months start from 0!
			        int year = cal.get(Calendar.YEAR);
			    	return day+"."+month+"."+year;
			    	//return formatter.format(date);
			    }
        		
			    @Override
			    public Date fromString(String date) {
			        try {
			        	
			        	String[] split = date.split("\\.");
			        	cal.set(Integer.parseInt(split[2]), Integer.parseInt(split[1])-1, Integer.parseInt(split[0]));
			        	return cal.getTime();
			        	//return formatter.parse(date);
					} catch (Exception e) {
						return new Date();
					}
			    	
			    }                                    
			});
        
        dob.setCellFactory(cellFactory);
        dob.setOnEditCommit( e -> {
        	e.getRowValue().setDob(e.getNewValue());
        });
        
        
        Button b1 = new Button("Print all elements");
        b1.setOnAction( e -> {
        	data.forEach(System.out::println);
        });
 
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



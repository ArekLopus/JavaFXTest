package controls;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/DatePicker.html
//The value property represents the currently selected LocalDate.
//An initial date can be set via the constructor or by calling setValue(). The default value is null. 
public class DatePickerTest extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("DatePicker");
		
		
		Label l = new Label("DatePicker with the current date (LocalDate.now())");
		DatePicker dp = new DatePicker(LocalDate.now());
		dp.setStyle("-fx-background-radius: 10; -fx-background-color: orange;");
		
		Label l1 = new Label("Date picker with a prompt");
		DatePicker dp1 = new DatePicker();
		dp1.setPromptText("dd.mm.yyyy");
		
		Label l2 = new Label("Setting a custom date (LocalDate.of(2000, 2, 18))");
		DatePicker dp2 = new DatePicker();
		dp2.setValue(LocalDate.of(2000, 2, 18));		
		
		//You can customize the format using setConverter(), and use setConverter(null) to return to the default format.
		Label l3 = new Label("Date Converter (dd-mm-yyyy)");
		DatePicker dp3 = new DatePicker(LocalDate.now());
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };   
        dp3.setConverter(converter);
        dp3.setPromptText("dd-mm-yyyy");
		
        
        Label l4 = new Label("DayCellFactory - Mondays are disabled");
        DatePicker dp4 = new DatePicker(LocalDate.now());
        //DayCellFactory to create Cell of DatePicker 
        Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
 
                        //We dont like Mondays
                        if (item.getDayOfWeek() == DayOfWeek.MONDAY) {
                            setDisable(true);
                            setStyle("-fx-background-color: #dddddd;");
                        }
                    }
                };
            }
        };
        dp4.setDayCellFactory(dayCellFactory);
        
        
        Label l5 = new Label("Week numbers off");
        DatePicker dp5 = new DatePicker(LocalDate.now());
        dp5.setShowWeekNumbers(false);
        
        Label l6 = new Label("DatePicker binding: ");
        DatePicker dp6 = new DatePicker(LocalDate.now());
        dp5.setShowWeekNumbers(false);
        StringExpression bdg = Bindings.concat("DatePicker binding: ", dp6.valueProperty().asString("%td/%<tm/%<tY"));
		l6.textProperty().bind(bdg);
        
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(l, dp, l1, dp1, l2, dp2, l3, dp3, l4, dp4, l5, dp5, l6, dp6);
		
		Scene scene = new Scene(vb, 320, 450);
		
		stage.setScene(scene);
		stage.show();

	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

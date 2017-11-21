package controls.tableView;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class TableViewForMap extends Application {
	 
    public static final String Column1_MapKey = "Key1";
    public static final String Column2_MapKey = "Key2";
    
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("TableView");
        
        TableColumn<Map<String, String>, String> firstDataColumn = new TableColumn<>("Key1");
        TableColumn<Map<String, String>, String> secondDataColumn = new TableColumn<>("Key2");
        
        //MapValueFactory - A convenience impl of the Callback intf, designed for use within the TableColumn cell value factory.
        
        firstDataColumn.setCellValueFactory(new MapValueFactory(Column1_MapKey));
        firstDataColumn.setMinWidth(130);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Column2_MapKey));
        secondDataColumn.setMinWidth(130);

        ObservableList<Map<String, String>> data = FXCollections.observableArrayList();
        
        Map<String, String> dataRow = new HashMap<>();
        dataRow.put(Column1_MapKey, "c1");
        dataRow.put(Column2_MapKey, "c2");
        
        Map<String, String> dataRow1 = new HashMap<>();
        dataRow1.put(Column1_MapKey, "c1");
        dataRow1.put(Column2_MapKey, "c2");
        
        data.addAll(dataRow, dataRow1);
        
        TableView<Map<String, String>> table = new TableView<>(data);        
         
        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);
        table.getColumns().setAll(firstDataColumn, secondDataColumn);
        
        Callback<TableColumn<Map<String, String>, String>, TableCell<Map<String, String>, String>>
            cellFactoryForMap = p -> new TextFieldTableCell<Map<String, String>, String>(new StringConverter<String>() {
			    @Override
			    public String toString(String t) {
			        return t.toString();
			    }
			    @Override
			    public String fromString(String string) {
			        return string;
			    }                                    
			});
        
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);
 
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
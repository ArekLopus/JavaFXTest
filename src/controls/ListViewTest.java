package controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ComboBox.html
public class ListViewTest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ListView");

		ObservableList<String> ol = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3", "Option 4");
		ol.add("abc");
		
		ListView<String> lv1 = new ListView<>();
		lv1.setItems(ol);		//or in the constructor. 
		//DONT use: getItems().setAll(content); - the content list is being copied into the items list - meaning that subsequent changes to the content list are not observed
		
		lv1.setPrefSize(100, 100);
		
		//lv1.setValue("Option 2");
		lv1.getSelectionModel().selectFirst();
		//lv1.getSelectionModel().select("Option 2");;
		//lv1.getSelectionModel().clearSelection();
		System.out.println(lv1.getSelectionModel().getSelectedIndex());
		System.out.println(lv1.getSelectionModel().getSelectedItem());

		//getSelectionModel().getSelectedIndex() – Returns the index of the currently selected items in a single-selection mode
		//getSelectionModel().getSelectedItem() – Returns the currently selected item
		//getFocusModel().getFocusedIndex() – Returns the index of the currently focused item
		//getFocusModel().getFocusedItem() – Returns the currently focused item
		lv1.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			System.out.println("Selected item: " + n + ", old item: " + o);
		});
		lv1.getSelectionModel().selectedIndexProperty().addListener((e, o, n) -> {
			System.out.println("Selected index: " + n + ", old index: " + o);
		});
		lv1.getFocusModel().focusedItemProperty().addListener((e, o, n) -> {
			System.out.println("focused item: " + n + ", old item: " + o);
		});
		lv1.getFocusModel().focusedIndexProperty().addListener((e, o, n) -> {
			System.out.println("Focused index: " + n + ", old index: " + o);
			System.out.println("-----------------------------------------");
		});
		
	    
		ListView<String> lv2 = new ListView<>(FXCollections.observableArrayList("Multiple Selection", "SelectionMode.MULTIPLE", "Available now", "with CTRL"));
		lv2.setPrefSize(100, 100);
		
		//The default SelectionModel used when instantiating a ListView is an implementation of the MultipleSelectionModel abstract class.
		//But the default value of the selectionMode property is SelectionMode.SINGLE, to enable multiple selection use:
		lv2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//MultipleSelectionModel has the selectedItems and selectedIndices properties,
		lv2.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			ObservableList<String> list = lv2.getSelectionModel().getSelectedItems();
			System.out.println("Selected item(s) -> " +list.size()+ ", " + list);
		});

		
		ObservableList<String> options = FXCollections.observableArrayList();
		ListView<String> lv3 = new ListView<>(FXCollections.observableArrayList("ListView", "With", "A ComboBox", "selection"));
        lv3.setPrefSize(100, 100);
        
        options.addAll("Option1", "Option2", "Option3", "Option4");
        //To enhance your list, you can add data of various types by using the specific extensions of the ListCell class, such as
        //CheckBoxListCell, ChoiceBoxListCell, ComboBoxListCell, and TextFieldListCell.
        lv3.setCellFactory(ComboBoxListCell.forListView(options));
        lv3.setEditable(true);
		
        
        ListView<String> lv7 = new ListView<>(FXCollections.observableArrayList("Horztal", "Opt2", "Opt3", "Opt4"));
		lv7.setPrefSize(100,  35);
		lv7.setOrientation(Orientation.HORIZONTAL);
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);

		vb.getChildren().addAll(lv1, lv2, lv3, lv7);

		Scene scene = new Scene(vb, 200, 500);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

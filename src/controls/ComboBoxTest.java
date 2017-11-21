package controls;

import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ComboBox.html
public class ComboBoxTest extends Application {

	@SuppressWarnings("rawtypes")
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ComboBox");

		//You cant use Arrays.asList if you want to add new elements, it has fixed size
		// List<String> l = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
		ObservableList<String> ol = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3", "Option 4");
		ol.add("abc");

		ComboBox<String> cb1 = new ComboBox<>(ol);

		// cb1.setValue("Option 2");
		// cb1.getSelectionModel().selectFirst();
		// cb1.getSelectionModel().select("Option 2");;
		// cb1.getSelectionModel().clearSelection();
		System.out.println(cb1.getSelectionModel().getSelectedIndex());
		System.out.println(cb1.getSelectionModel().getSelectedItem());

		cb1.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			System.out.println("Selected item: " + n + ", old item: " + o);
		});

		cb1.setPromptText("This a promt text");

		ComboBox<String> cb2 = new ComboBox<>();
		cb2.setEditable(true);
		cb2.setPromptText("ComboBox can be editable");
		cb2.getItems().addAll("item1", "item2", "item3");
		cb2.setOnAction(e -> {
			System.out.println("ComboBox has setOnAction event, when the user commits textual input into the textfield "
					+ "(commonly by pressing the Enter keyboard key), the value property will be updated. ");
			System.out.println("Selected: " + ((ComboBox) e.getSource()).getValue());
		});

		ComboBox<Date> cb3 = new ComboBox<>();
		cb3.getItems().addAll(new Date(), new Date(), new Date());
		cb3.getSelectionModel().selectFirst();

		ComboBox<Object> cb4 = new ComboBox<>();
		cb4.setItems(FXCollections.observableArrayList("You can use any object", "Option 2", new Separator(), "Item 1",
				"Item 2", new Separator(), "Exit"));
		cb4.getSelectionModel().selectFirst();

		// By default, when the popup list is showing, the maximum number of
		// rows visible is 10, but this can be changed by modifying the
		// visibleRowCount property.
		ObservableList<Cursor> cursors = FXCollections.observableArrayList(Cursor.DEFAULT, Cursor.CROSSHAIR,
				Cursor.WAIT, Cursor.TEXT, Cursor.HAND, Cursor.MOVE, Cursor.N_RESIZE, Cursor.NE_RESIZE, Cursor.E_RESIZE,
				Cursor.SE_RESIZE, Cursor.S_RESIZE, Cursor.SW_RESIZE, Cursor.W_RESIZE, Cursor.NW_RESIZE, Cursor.NONE);
		ComboBox<Cursor> cb5 = new ComboBox<>(cursors);
		cb5.getSelectionModel().selectFirst();
		cb5.setVisibleRowCount(20);

		ObservableList<String> ol2 = FXCollections.observableArrayList("Question 1", "Question 2", "Question 3",
				"Question 4");
		String[] answers = { "Answer 1", "Answer 2", "Answer 3", "Answer 4" };
		ComboBox<String> cb6 = new ComboBox<>(ol2);
		cb6.getSelectionModel().selectFirst();
		Label l1 = new Label();

		cb6.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
			String answer = answers[cb6.getSelectionModel().getSelectedIndex()];
			l1.setText(answer);
		});
		
		
		

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);

		vb.getChildren().addAll(cb1, cb2, cb3, cb4, cb5, cb6, l1);

		Scene scene = new Scene(vb, 200, 300);
		scene.cursorProperty().bind(cb5.getSelectionModel().selectedItemProperty());

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
		// Application.launch(args);
	}
}

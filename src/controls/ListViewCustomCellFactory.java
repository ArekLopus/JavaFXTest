package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Cell.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/IndexedCell.html
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ListCell.html
//CheckBoxListCell, ChoiceBoxListCell, ComboBoxListCell, TextFieldListCell ->  extend ListCell
public class ListViewCustomCellFactory extends Application {
	
	//We can create a new class that extends ListCell
	static class ColorRectCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			Circle circle = new Circle(20);
			if (item != null) {
				circle.setFill(Color.web(item));
				setGraphic(circle);
			}
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("ListView");
		
		Label l1 = new Label();
		
		ListView<String> lv1 = new ListView<String>();
		
		ObservableList<String> data = FXCollections.observableArrayList("red", "gold", "coral",  "black", "blue", "blueviolet", "brown");
		lv1.setItems(data);
		
		//Using our class
//		lv1.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//			@Override
//			public ListCell<String> call(ListView<String> list) {
//				return new ColorRectCell();
//			}
//		});
		
		//Using anonymous class
		lv1.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> list) {
				//ListCell extends Labeled
				return new ListCell<String>() {			
					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						Circle circle = new Circle(20);
						if (item != null) {
							circle.setFill(Color.web(item));
							setGraphic(circle);
							setText(item);
							setEditable(true);
							//setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						}
					}
				};
			}
		});

		lv1.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (ov, oldVal, newVal) -> {
			l1.setText(newVal);
			l1.setTextFill(Color. web(newVal));
		});
		
		
		l1.setPrefSize(200, 20);
        l1.setFont(Font.font("", 20));
        l1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);
		VBox.setVgrow(lv1, Priority.ALWAYS);
		
		vb.getChildren().addAll(lv1, l1);

		Scene scene = new Scene(vb, 200, 200);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	
	
	
}

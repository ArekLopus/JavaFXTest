package controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxCustomCellFactory extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Custom CellFactory for ComboBox");
		
		 
		ComboBox<Color> cb1 = new ComboBox<Color>();
		cb1.setPromptText("Custom cellFactory");
		cb1.getItems().addAll(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.YELLOWGREEN);

		cb1.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
			@Override public ListCell<Color> call(ListView<Color> p) {
				return new ListCell<Color>() {
					private final Rectangle rectangle;
					{ 
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
						rectangle = new Rectangle(10, 10);
					}
					
					@Override protected void updateItem(Color item, boolean empty) {
						super.updateItem(item, empty);
						
						if (item == null || empty) {
							setGraphic(null);
						} else {
							rectangle.setFill(item);
							setGraphic(rectangle);
						}
					}
				};
			}
		});
		
		
		ComboBox<String> cb2 = new ComboBox<>(FXCollections.observableArrayList("Highest", "High", "Normal", "Lower", "Lowest"));
		cb2.setPromptText("Priority custom cellFactory");
		cb2.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				final ListCell<String> cell = new ListCell<String>() {
					{
						super.setPrefWidth(100);
					}

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item);
							if (item.contains("High")) {
								setTextFill(Color.RED);
							} else if (item.contains("Low")) {
								setTextFill(Color.GREEN);
							} else {
								setTextFill(Color.BLACK);
							}
						} else {
							setText(null);
						}
					}
				};
				return cell;
			}
		});
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(cb1, cb2);
		
		Scene scene = new Scene(vb, 300, 300);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
        //Application.launch(args);
    }
}


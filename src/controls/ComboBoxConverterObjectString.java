package controls;

import helper.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ComboBoxConverterObjectString extends Application {

	@SuppressWarnings("rawtypes")
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("User - String Converter");

		final ComboBox<User> cb1 = new ComboBox<>();
		cb1.getItems().addAll(new User("John", "Doe"), new User("Jessica", "Yeager"), new User("Joe", "Black"));
		cb1.setConverter(new UserStringConverter());
		cb1.setPromptText("select user");

		cb1.getSelectionModel().selectedItemProperty().addListener((observable, oV, nV) -> {
			System.out.println("selection model's selectedItem -> "+nV);
		});

		cb1.setOnAction(e -> {
			System.out.println("onAction event -> "+((ComboBox) e.getSource()).getValue());
		});

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(10);

		vb.getChildren().addAll(cb1);

		Scene scene = new Scene(vb, 300, 300);

		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class UserStringConverter extends StringConverter<User> {

	// Method to convert User object to a String
	@Override
	public String toString(User user) {
		return user == null ? null : user.getName() + " " + user.getSurname();
	}

	// Method to convert a String to a User object
	@Override
	public User fromString(String string) {
		User user = null;

		if (string == null) {
			return user;
		}

		int separator = string.indexOf(" ");

		if (separator == -1) {
			user = new User(string, "");
		} else {
			String name = string.substring(separator+1);
			String surname = string.substring(0, separator);
			user = new User(name, surname);
		}

		return user;
	}
}

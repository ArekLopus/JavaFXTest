package fxml;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

//-The CustomControl class extends VBox (the type declared by the <fx:root> element in CustomControl.fxml),
// and sets itself as both the root and controller of the FXML document in its constructor. 
//-When the document is loaded, the contents of CustomControl will be populated with the contents of the FXML document
public class CustomControl extends VBox {
    
	@FXML
    private TextField textField;
	
	@FXML
    private Button button;
	
    public CustomControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomControl.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }
    
    public String getMyCustomProperty() {
        return textProperty().get();
    }

    public void setMyCustomProperty(String value) {
        textProperty().set(value);
    }
    
    
    public StringProperty textProperty() {
        return textField.textProperty();
    }

    @FXML
    protected void doSomething() {
        System.out.println("The button was clicked!, "+textField.getText());
        textField.selectAll();
    }
    
    @FXML
    private void initialize() {
        System.out.println("Initialized");
        button.setFocusTraversable(false);
    }
}
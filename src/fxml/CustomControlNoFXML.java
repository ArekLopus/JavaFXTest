package fxml;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class CustomControlNoFXML extends VBox {
	
	private TextField textField;
	private Button button;
	
	public CustomControlNoFXML() {
        textField = new TextField();
        button = new Button("Click Me");
        
        button.setFocusTraversable(false);
        button.setOnAction( e -> doSomething() );
        
        getChildren().addAll(textField, button);
        
        System.out.println("Initialized");
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

    
    private void doSomething() {
        System.out.println("The button was clicked!, "+textField.getText());
        textField.selectAll();
    }
    
    
}
package fxml2;

import java.util.Date;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class DateBuilderFactory implements BuilderFactory {
    private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();
    @Override
    
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Date.class) {		// You supply a Builder only for Item type
            return new DateBuilder();
        }
        return fxFactory.getBuilder(type);	// Let the default Builder do the magic
    }
}
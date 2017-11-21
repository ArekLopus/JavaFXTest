package fxml2;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class ItemBuilderFactory implements BuilderFactory {
    
	private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();
    
	@Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Item.class) {			//You supply a Builder only for Item type
            return new ItemBuilder();
        }
        return fxFactory.getBuilder(type);	//Let the default Builder do the magic
    }
}
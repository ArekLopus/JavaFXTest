package controls;

import helper.Person;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
 
public class SpinnerTest extends Application {
	
	private ObservableList<Person> data = FXCollections.observableArrayList(
			new Person("Aaron", "Smith", "aaron.smith@mail.com", "yellow"),
			new Person("Will", "Johnson", "will.johnson@mail.com", "orange"),
			new Person("Ianthe", "Avanti", "iante.avanti@mail.com", "yellow"),
			new Person("Bruce", "Lee", "bruce.lee@mail.com", "red"),
			new Person("Jenna", "Adams", "jenna.addams@mail.com", "orange"));
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Spinner");
    	
    	Label l1 = new Label("Spinner with Person-String converter");
    	
    	Spinner<Person> sp1 = new Spinner<>();
    	
    	SpinnerValueFactory<Person> vf = new SpinnerValueFactory.ListSpinnerValueFactory<>(data);
    	sp1.setValueFactory(vf);
    	
    	vf.setConverter(new MyPersonStringConverter());
    	
    	
    	ChangeListener<Object> ln = (obs, oldV, newV) -> {
    		System.out.println("Change Listener, new value: "+newV);
    	}; 
    	
    	sp1.valueProperty().addListener( ln);
    	Button b1 = new Button("Check the value");
    	b1.setOnAction( e -> {
    		System.out.println(sp1.getValue());
    	});
    	
    	
    	Label l2 = new Label("Integer Spinner with start, end, and step value");
    	Spinner<Integer> sp2 = new Spinner<>();
    	SpinnerValueFactory<Integer> vf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 4, 2);
    	sp2.setValueFactory(vf2);
    	
    	Label l3 = new Label("Double Spinner with start, end, and step value");
    	Spinner<Double> sp3 = new Spinner<>();
    	SpinnerValueFactory<Double> vf3 = new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 2.0, 1.5, 0.1);
    	sp3.setValueFactory(vf3);
    	
    	Label l4 = new Label("Editable Spinner");
    	Spinner<Integer> sp4 = new Spinner<>(1,100,1,1);
    	sp4.setEditable(true);
    	sp4.getValueFactory().setConverter(new MyIntegerStringConverter());
    	sp4.valueProperty().addListener( ln );
    	
    	Label l5 = new Label("Arrow styles (default - right vertical)");
    	ObservableList<String> styles = FXCollections.observableArrayList(
    			"default - right vertical",
            	Spinner.STYLE_CLASS_ARROWS_ON_RIGHT_HORIZONTAL,
                Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL,
                Spinner.STYLE_CLASS_ARROWS_ON_LEFT_HORIZONTAL,
                Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL,
                Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
  
        FlowPane flow = new FlowPane();
        flow.setHgap(10);
        flow.setVgap(10);
        flow.setPadding(new Insets(10, 10, 10, 0));
  
        for (int i=0; i<styles.size(); i++) {
        	Spinner<String> spinner = new Spinner<>(styles);
        	spinner.getStyleClass().add(styles.get(i));
        	spinner.getValueFactory().setValue(styles.get(i));
        	spinner.setPrefWidth(200);
        	flow.getChildren().add(spinner);
        }

    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(l1, sp1, b1, l2, sp2, l3, sp3, l4, sp4, l5, flow);
        
        Scene scene = new Scene(vb, 440, 460);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
    
    private class MyIntegerStringConverter extends StringConverter<Integer> {
		@Override
		public String toString(Integer i) {
			return String.valueOf(i);
		}

		@Override
		public Integer fromString(String string) {
//			if (!string.matches("\\d*")) {
//				System.out.println("no match");
//				return Integer.parseInt(string.replaceAll("[^\\d]", ""));
//            } else {
//            	System.out.println("match");
//            	return Integer.parseInt(string);
//            }
			try {
				return Integer.parseInt(string);
			} catch (Exception e) {
				System.out.println("Exception thrown: "+e.getMessage());
				return 1;
			}
		}
	}
    
    private class MyPersonStringConverter extends StringConverter<Person> {
		@Override
		public String toString(Person p) {
			return p.getFirstName()+" "+p.getLastName();
		}

		@Override
		public Person fromString(String string) {
			String[] split = string.split("\\ ");
			Person prsn = data.stream().filter( p -> p.getFirstName().equals(split[0]) && p.getLastName().equals(split[1])  ).findFirst().orElse(null);
			return prsn;
		}
	}
    
    
}
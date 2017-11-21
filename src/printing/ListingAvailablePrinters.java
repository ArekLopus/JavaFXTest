package printing;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ListingAvailablePrinters extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Listing Available Printers");

    	ObservableSet<Printer> allPrinters = Printer.getAllPrinters();
    	
    	System.out.println(allPrinters);
    	
    	Printer defaultprinter = Printer.getDefaultPrinter();
    	if (defaultprinter != null) {
    		System.out.println("Default printer: " + defaultprinter.getName());
    	} else {
    		System.out.println("No default printer.");
    	}
    	
    	Printer myPrinter = null;
    	for(Printer pr : allPrinters) {
    		if (pr.getName().equals("Microsoft XPS Document Writer")) {
    			myPrinter = pr;
    			break;
    		}
    	}
    	
    	if(myPrinter != null) {
    		System.out.println("myPrinter: "+myPrinter);
    	}
    	
    	
    	VBox hb1 = new VBox(10);
    	hb1.getChildren().addAll();
    	
    	Scene scene = new Scene(hb1, 300, 200);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
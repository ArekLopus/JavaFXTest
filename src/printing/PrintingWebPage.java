package printing;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//
public class PrintingWebPage extends Application {
	
	private Printer myPrinter = null;
	private Label jobStatus = new Label();
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Printing A Web Page");

    	ObservableSet<Printer> allPrinters = Printer.getAllPrinters();
    	
    	for(Printer pr : allPrinters) {
    		if (pr.getName().equals("Microsoft XPS Document Writer")) {
    			myPrinter = pr;
    			break;
    		}
    	}
    	
    	if(myPrinter != null) {
    		System.out.println("myPrinter: "+myPrinter);
    	}
    	
    	WebView webView = new WebView();
    	WebEngine webEngine = webView.getEngine();
    	webEngine.load("https://google.com");
    	
        VBox root = new VBox(5);
                
        Button printPage = new Button("Print Page");
        printPage.setOnAction( e-> {
        	jobStatus.textProperty().unbind();
            jobStatus.setText("Creating a printer job...");
            
            PrinterJob job = PrinterJob.createPrinterJob(myPrinter);
            if (job != null) {
                jobStatus.textProperty().bind(job.jobStatusProperty().asString());
                webEngine.print(job);
                job.endJob();		                //endJob() is very important, problems with file reading when printing to a file
                jobStatus.textProperty().unbind();
            } else {
                jobStatus.setText("Could not create a printer job.");
            }
            
        });
        
        HBox jobStatusBox = new HBox(5, new Label("Print Job Status:"), jobStatus);
        HBox buttonBox = new HBox(5, printPage);
        root.getChildren().addAll(jobStatusBox, webView, buttonBox);
        
        Scene scene = new Scene(root, 1024, 670);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
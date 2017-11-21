package printing;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-JavaFX 8 added support for printing nodes. The API consists of the following classes and a number of enums:
// • Printer    • PrinterAttributes    • PrintResolution    • PrinterJob    • JobSettings
// • Paper      • PaperSource          • PageLayout         • PageRange

//endJob() is very important, problems with file reading when printing to a file
public class PrintingNode extends Application {
	
	private Printer myPrinter = null;
	private Label jobStatus = new Label();
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Printing a node");

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
    	
        VBox root = new VBox(5);
        
        TextArea text = new TextArea();
        text.setPrefRowCount(10);
        text.setPrefColumnCount(20);
        text.setWrapText(true);
        
        Button printTextBtn = new Button("Print Text");
        printTextBtn.setOnAction(e -> print(text));
        
        Button printSceneBtn = new Button("Print Scene");
        printSceneBtn.setOnAction(e -> print(root));
        
        HBox jobStatusBox = new HBox(5, new Label("Print Job Status:"), jobStatus);
        HBox buttonBox = new HBox(5, printTextBtn, printSceneBtn);
        root.getChildren().addAll(jobStatusBox, text, buttonBox);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
	private void print(Node node) {
        jobStatus.textProperty().unbind();
        jobStatus.setText("Creating a printer job...");
        
        PrinterJob job = PrinterJob.createPrinterJob(myPrinter);
        if (job != null) {
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
            boolean printed = job.printPage(node);
            if (printed) {
                job.endJob();		                //endJob() is very important, problems with file reading when printing to a file
            } else {
                jobStatus.textProperty().unbind();
                jobStatus.setText("Printing failed.");
            }
        } else {
            jobStatus.setText("Could not create a printer job.");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
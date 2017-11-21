package printing;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.print.PrinterJob.JobStatus;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//
public class PageSetupAndPrintDialog extends Application {
	
	private PrinterJob job = PrinterJob.createPrinterJob();
	private Label jobStatus = new Label();
	private TextArea text = new TextArea();
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Showing Page Setup and Print Dialog");

        VBox root = new VBox(5);
        text.setPrefRowCount(20);
        text.setPrefColumnCount(20);
        text.setWrapText(true);
        text.setText(job.toString());
        
        Button printTextBtn = new Button("Print Text");
        printTextBtn.setOnAction(e -> print(text));
        
        Button printSceneBtn = new Button("Print Scene");
        printSceneBtn.setOnAction(e -> print(root));
        
        Button pageSetupBtn = new Button("Page Setup");
        pageSetupBtn.setOnAction(e -> {
        	checkStatus();
        	job.showPageSetupDialog(stage);
        	text.clear();
        	text.setText(job.toString());
        });
        Button printSetupBtn = new Button("Print Setup");
        printSetupBtn.setOnAction(e -> {
        	checkStatus();
        	job.showPrintDialog(stage);
        	text.clear();
        	text.setText(job.toString());
        });
        Button jobStatusBtn = new Button("Job Status");
        jobStatusBtn.setOnAction(e -> {
        	text.setText(job.toString());
        });
        
        HBox jobStatusBox = new HBox(5, new Label("Print Job Status:"), jobStatus);
        HBox buttonBox = new HBox(5, printTextBtn, printSceneBtn);
        HBox settingsBox = new HBox(5, pageSetupBtn, printSetupBtn, jobStatusBtn);
        root.getChildren().addAll(jobStatusBox, text, buttonBox, settingsBox);
        
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
    
	private void print(Node node) {
        jobStatus.textProperty().unbind();
        jobStatus.setText("Creating a printer job...");
        
        checkStatus();
    	
        if (job != null) {
            jobStatus.textProperty().bind(job.jobStatusProperty().asString());
            boolean printed = job.printPage(node);
            if (printed) {
                job.endJob();		                // End the printer job
            } else {
                jobStatus.textProperty().unbind();
                jobStatus.setText("Printing failed.");
            }
        } else {
            jobStatus.setText("Could not create a printer job.");
        }
    }
    
	private void checkStatus() {
		if(job.getJobStatus() == JobStatus.DONE || job.getJobStatus() == JobStatus.ERROR) {
        	job = PrinterJob.createPrinterJob();
        }
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
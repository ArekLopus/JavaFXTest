package printing;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.JobSettings;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-The Print API does not let you change the printer attributes as you cannot change the capabilities of a printer. You can only use
// its capabilities. You cannot create a PrinterAttributes object directly, You get it from a Printer object using the getPrinterAttributes().
//-A JobSettings contains the printer attributes to be used for a print job for a specific printer. You can obtain the JobSettings of a print
// job using the getJobSettings() method of the PrinterJob object. A JobSettings is a mutable object. It contains a property for each printer
// attribute that can be set for a print job. By default, its properties are initialized to the default properties of the printer.
// You can change the property that will be used for the current print job. If you change the property of a JobSettings that is not supported
// by the printer, the property reverts to the default value for the printer.
public class PrinterAttrAndJobSettings extends Application {
	
	@Override
    public void start(Stage stage) {
    	stage.setTitle("Printer Attributes And Job Settings");
    	
    	ObservableList<Printer> allPrinters = FXCollections.observableArrayList(Printer.getAllPrinters());
    	PrinterJob job = PrinterJob.createPrinterJob();
    	JobSettings jobSettings = job.getJobSettings();
    	
    	TextArea ta = new TextArea();
    	//ta.setWrapText(true);
    	ta.setPrefRowCount(21);
    	
    	ComboBox<Printer> cb = new ComboBox<>(allPrinters);
    	cb.setOnAction(e->{
    		printrAttrs(ta, cb.getValue().getPrinterAttributes());
    	});
    	cb.getSelectionModel().select(Printer.getDefaultPrinter());
    	printrAttrs(ta, cb.getValue().getPrinterAttributes());
    	
    	Button jsBtn = new Button("Show Job Settings");
    	jsBtn.setOnAction(e->{
    		ta.clear();
        	ta.setText(jobSettings.toString());
    	});
    	
    	HBox butttonsBox = new HBox(5, jsBtn, cb);
    	
    	VBox hb1 = new VBox(10);
    	hb1.getChildren().addAll(ta, butttonsBox);
    	
    	Scene scene = new Scene(hb1, 500, 400);
    	stage.setScene(scene);
    	stage.show();
    	
    }
    
	private void printrAttrs(TextArea ta, PrinterAttributes printerAttributes) {
		ta.clear();
		ta.appendText("DefaultCopies:\t\t\t"+printerAttributes.getDefaultCopies());
		ta.appendText("\nMaxCopies:\t\t\t"+printerAttributes.getMaxCopies());
		ta.appendText("\nsupportsPageRanges:\t"+printerAttributes.supportsPageRanges());
		ta.appendText("\nDefaultCollation:\t\t"+printerAttributes.getDefaultCollation());
		ta.appendText("\nDefaultPageOrientation:\t"+printerAttributes.getDefaultPageOrientation());
		ta.appendText("\nDefaultPaper:\t\t\t"+printerAttributes.getDefaultPaper());
		ta.appendText("\nDefaultPaperSource:\t"+printerAttributes.getDefaultPaperSource());
		ta.appendText("\nDefaultPrintColor:\t\t"+printerAttributes.getDefaultPrintColor());
		ta.appendText("\nDefaultPrintQuality:\t\t"+printerAttributes.getDefaultPrintQuality());
		ta.appendText("\nDefaultPrintResolution:\t"+printerAttributes.getDefaultPrintResolution());
		ta.appendText("\nDefaultPrintSides:\t\t"+printerAttributes.getDefaultPrintSides());
		ta.appendText("\nSupportedCollations:\t"+printerAttributes.getSupportedCollations());
		ta.appendText("\nSupportedPageOrient:\t"+printerAttributes.getSupportedPageOrientations());
		ta.appendText("\nSupportedPapers:\t\t"+printerAttributes.getSupportedPapers());
		ta.appendText("\nSupportedPaperSources:\t"+printerAttributes.getSupportedPaperSources());
		ta.appendText("\nSupportedPrintColors:\t"+printerAttributes.getSupportedPrintColors());
		ta.appendText("\nSupportedPrintQuality:\t"+printerAttributes.getSupportedPrintQuality());
		ta.appendText("\nSupportedPrintRes:\t\t"+printerAttributes.getSupportedPrintResolutions());
		ta.appendText("\nSupportedPrintSides:\t"+printerAttributes.getSupportedPrintSides());
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}
package controls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

//https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
//-Dialogs have look and feel of the platform UI components which is independent of JavaFX.
//-A FileChooser can be used to invoke file open dialogs for selecting single file (showOpenDialog),
// file open dialogs for selecting multiple files (showOpenMultipleDialog) and file save dialogs (showSaveDialog).
public class FileAndDirectoryChooser extends Application {
	
	private TextArea ta1 = new TextArea();
	private Consumer<String> cons =  s -> {
		ta1.appendText(s+"\n");
	}; 
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("File And Directory Chooser");
		
		
		Button b1 = new Button("File Chooser - 1 file");
		b1.setOnAction( e -> {
			FileChooser fc = new FileChooser();
			fc.setTitle("Open File");
			fc.setInitialDirectory(new File("c:/"));
			
			fc.getExtensionFilters().addAll(
			    new ExtensionFilter("Text Files", "*.txt")
			);
			
			
			File selFile = fc.showOpenDialog(stage);
			if(selFile != null) {
				System.out.println("File: "+selFile);
				
				try {
					List<String> readAllLines = Files.readAllLines(Paths.get(selFile.getPath()));
					System.out.println("Size: "+readAllLines.size());
					ta1.clear();
					readAllLines.forEach(cons);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		});
		
		
		Button b2 = new Button("File Chooser - Multi files");
		b2.setOnAction( e ->{
			FileChooser fc = new FileChooser();
			fc.setTitle("Open File(s)");
			fc.setInitialDirectory(new File("c:/"));
			List<File> selFiles = fc.showOpenMultipleDialog(stage);
			
			if(selFiles != null) {
				System.out.println("Selected files: "+selFiles.size());
			}
			
		});
		
		
		Button b3 = new Button("File Chooser - Save file");
		b3.setOnAction( e -> {
			FileChooser fc = new FileChooser();
			fc.setTitle("Open File(s)");
			fc.setInitialDirectory(new File("d:/"));
			fc.setInitialFileName("Abc.txt");
			
			File savFile = fc.showSaveDialog(stage);
			if (savFile != null) {
				System.out.println(savFile);
				try {
					PrintWriter pw = new PrintWriter(savFile);
					pw.println("File Chooser test.");
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		Button b4 = new Button("Directory Chooser");
		b4.setOnAction( e -> {
			DirectoryChooser dc = new DirectoryChooser();
			dc.setTitle("Open Directory");
			dc.setInitialDirectory(new File("d:/"));
			
			File selDir = dc.showDialog(stage);
			if(selDir != null) {
				System.out.println(selDir+", is Directiry -> "+selDir.isDirectory());
			}
		});
		
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10));
	    vb.setSpacing(10);
		
		vb.getChildren().addAll(b1, ta1, b2, b3, b4);
		
		Scene scene = new Scene(vb, 320, 300);
		
		stage.setScene(scene);
		stage.show();

	}
	
	
	
	public static void main(String[] args) {
        launch(args);
    }
}

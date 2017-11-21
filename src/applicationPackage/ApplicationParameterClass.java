package applicationPackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//-Encapsulates the set of parameters for an application. This includes arguments passed on
// the command line, unnamed parameters specified in a JNLP file, and <name,value> pairs specified in a JNLP file.
//-Note that the application and the preloader both get the same set of parameters for a given run of an application. 
public class ApplicationParameterClass extends Application {
	
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Application.Parameter.class Test");
    	
    	Button b1 = new Button("Press to call Platform.exit()");
    	b1.setOnAction( e -> {
    		Platform.exit();
    	});
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(b1);
		
        Scene scene = new Scene(vb, 300, 350);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    @Override
	public void init() throws Exception {
		super.init();
		
		System.out.println("getParameters() instanceof Application.Parameters -> "+(getParameters() instanceof Application.Parameters)+"\n");
		
		System.out.println("getParameters().getNamed()\t"+getParameters().getNamed());
		System.out.println("getParameters().getRaw()\t"+getParameters().getRaw());
		System.out.println("getParameters().getUnnamed()\t"+getParameters().getUnnamed());
	}


	public static void main(String[] args) {
		args = new String[5];
		args[0] = "arg1";
		args[1] = "arg2";
        launch(args);
    }
    
		
	
    
}
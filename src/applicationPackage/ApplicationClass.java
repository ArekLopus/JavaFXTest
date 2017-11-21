package applicationPackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//The JavaFX runtime does the following, whenever an application is launched: 
//1. Constructs an instance of the specified Application class 
//2. Calls the init() method
//3. Calls the start(Stage) method
//4. Waits for the application to finish, which happens when either of the following occur:
//    • the application calls Platform.exit() 
//    • the last window has been closed and the implicitExit attribute on Platform is true 
//5. Calls the stop() method
public class ApplicationClass extends Application {
	
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Application.class Test");
    	System.out.println("start() called, it runs on thread\t\t: "+Thread.currentThread().getName());
    	
    	Button b1 = new Button("Press to call Platform.exit()");
    	b1.setOnAction( e -> {
    		Platform.exit();
    	});
    	Button b2 = new Button("If you call System.exit(), stop() wont run!");
    	b2.setOnAction( e -> {
    		System.out.println("System.exit(1) called, stop() wont run");
    		System.exit(1);
    	});
    	
    	
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(b1, b2);
		
        Scene scene = new Scene(vb, 300, 350);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    @Override
	public void init() throws Exception {
		super.init();
		System.out.println("init() called, it runs on thread\t\t: "+Thread.currentThread().getName());
		
		System.out.println("getParameters().getNamed()\t"+getParameters().getNamed());
		System.out.println("getParameters().getRaw()\t"+getParameters().getRaw());
		System.out.println("getParameters().getUnnamed()\t"+getParameters().getUnnamed());
	}


	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop() called, it runs on thread\t\t: "+Thread.currentThread().getName());
	}


	public static void main(String[] args) {
		args = new String[2];
		args[0] = "arg1";
		args[1] = "arg2";
        launch(args);
    }
    
		
	
    
}
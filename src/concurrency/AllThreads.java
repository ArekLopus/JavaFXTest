package concurrency;

import java.util.Arrays;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AllThreads extends Application {
	
	private ObservableList<String> threadNames = FXCollections.observableArrayList();
	private ObservableList<String> stackTraces = FXCollections.observableArrayList();
	private ListView<String> lv = new ListView<>();
	private TextArea ta = new TextArea();
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Task fires only once");
    	
    	System.out.println("Main thread is:\t\t\t\t"+Thread.currentThread().getName()+", "+Thread.currentThread().getThreadGroup());
     	
    	
    	Task<Void> task = new Task<Void>() {
    		
    		@Override
    		protected Void call() throws Exception {
    			System.out.println("Thread from a Task:\t\t\t"+Thread.currentThread().getName()+", "+Thread.currentThread().getThreadGroup());
    			return null;
    		}
    	};
    	new Thread(task).start();    	
    	
    	
    	Platform.runLater( ()->{
    		System.out.println("Thread from a Platform.runLater:\t"+Thread.currentThread().getName()+", "+Thread.currentThread().getThreadGroup());
    	});


    	lv.setItems(threadNames);
    	lv.getSelectionModel().selectedItemProperty().addListener( (obs, oldV, newV) -> {
    		ta.setText(stackTraces.get(lv.getSelectionModel().getSelectedIndex()));
    	} );
    	
    	lv.setPrefHeight(270);
    	ta.setPrefHeight(320);
    	
    	getAllStackTraces();
    	
    	
    	Button b1 = new Button("Check Event Thread");
    	b1.setOnAction( e -> {
    		System.out.println("Thread from a Button click event:\t"+Thread.currentThread().getName()+", "+Thread.currentThread().getThreadGroup());
    	});
    	Label l1 = new Label("Live Threads:");
    	
    	
    	VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		
		vb.getChildren().addAll(b1, l1, lv, ta);
		
        Scene scene = new Scene(vb, 650, 650);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
	public void init() throws Exception {
		super.init();
		System.out.println("Thread from init():\t\t\t"+Thread.currentThread().getName()+", "+Thread.currentThread().getThreadGroup());
	}
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void getAllStackTraces() {
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
			threadNames.add("- " + entry.getKey().getName());
			
			StringBuilder sb = new StringBuilder("StackTrace:\n");
			Arrays.stream(entry.getValue()).forEach( el -> sb.append("  at "+el.toString()).append("\n") );
			stackTraces.add(sb.toString());
		}
	}
    
}
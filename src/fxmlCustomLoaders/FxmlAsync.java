package fxmlCustomLoaders;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FxmlAsync extends Application {
	
	private Executor executor = Platform::runLater;
	
	private FlowPane fp = new FlowPane();
	private Button startB = new Button("Start");
	private Button totalB = new Button("Total time");
	
	static int threadCounter = 0;
	static int timeCounter = 0;
	
	//ThreadFactory intf -> Thread newThread(Runnable r);
	private final static Executor THREAD_POOL = Executors.newCachedThreadPool( runnable -> {
        Thread thread = Executors.defaultThreadFactory().newThread(runnable);
        threadCounter++;
        //thread.setDaemon(true);
        return thread;
	});

	
	@Override
	public void start(Stage stage) throws Exception {
		
		startB.setOnAction( e -> {
			fp.getChildren().clear();
			timeCounter = 0;
			for (int i = 0; i<200; i++) {
				Circle c = new Circle(10, Color.RED);
				StackPane sp = new StackPane();
				sp.setPadding(new Insets(1));
				sp.getChildren().add(c);
				
				//addSync(() -> sp, fp.getChildren()::add);
				addAsync(() -> sp, fp.getChildren()::add);
				
			}
			System.out.println("Threads created: "+threadCounter);
		});
		
		totalB.setOnAction( e-> {
			System.out.println("Total time: "+(timeCounter/1000)+" seconds, Threads created: "+threadCounter);
		});

		
		VBox vb = new VBox(5);
		vb.setPadding(new Insets(5));
		vb.getChildren().addAll(startB, totalB, fp);
		
		Scene scene = new Scene(vb, 450, 300);
		
		stage.setTitle("FXML Asynchronous Initialization");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void addSync(Supplier<Parent> child, Consumer<Parent> parent) {
		//sleepTime();
        CompletableFuture.supplyAsync(child, executor).thenAccept(parent);
    }

    
    public void addAsync(Supplier<Parent> child, Consumer<Parent> parent) {
        THREAD_POOL.execute( () -> {
        	sleepTime();
        	addSync(child, parent);
        });
    }
	
    private void sleepTime() {
    	int sleep = (ThreadLocalRandom.current().nextInt(10)+1)*100;
		try {
			Thread.sleep(sleep);
			timeCounter += sleep;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sleep);
    }
	
    
	@Override
	public void stop() throws Exception {
		((ExecutorService)THREAD_POOL).shutdown();		//needed if THREAD_POOL uses no daemon threads
	}

	public static void main(String[] args) {
		launch(args);
	}
}
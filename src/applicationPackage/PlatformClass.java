package applicationPackage;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PlatformClass extends Application {
	
	ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	Executor exec = Platform::runLater;	
	
	Supplier<String> sup = () -> {
		return "It runs on thread: "+Thread.currentThread().getName(); 
	};
	
	Callable<String> cal = () -> {
		System.out.println("It runs on thread: "+Thread.currentThread().getName());
		return null;
	};
	
	Runnable run = () -> {
		System.out.println("It runs on thread: "+Thread.currentThread().getName()); 
	};
	
	
	public PlatformClass() {
		Platform.runLater( () -> {} );
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		System.out.println("Available processors: "+Runtime.getRuntime().availableProcessors());
		
		Platform.runLater( () -> {
			System.out.println("It runs on thread: "+Thread.currentThread().getName()); 
		});
		
		CompletableFuture.supplyAsync(sup,  exec).thenAccept(System.out::println);
		
		Thread.sleep(100);
		
		es.execute(run);
		es.submit(cal);
		
		es.shutdown();
		
		Platform.exit();
	}

	
	public static void main(String[] args) {
		launch(args);
	}

	
}

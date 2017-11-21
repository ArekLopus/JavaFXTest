package charts;

import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class AnimatedLineChartMy extends Application {
	
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("My portfolio");
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
        
        Service<Void> backgroundThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						final int[] ii = new int[1]; 
						for (int i = 0; i < 1000; i++) {
	             			int ran = ThreadLocalRandom.current().nextInt(10)+1;
	             			ii[0] = i;
	             			try {
	             				Thread.sleep(1000);
	             				Platform.runLater(new Runnable() {
	             					@Override public void run() {
	             						series.getData().add(new XYChart.Data<>(ii[0], ran));
	             					}
	             				});
	             			} catch (InterruptedException e) {
	             				e.printStackTrace();
	             			}
	             		} 
						return null;
					}
				};
			}
		};

        backgroundThread.start();
        
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
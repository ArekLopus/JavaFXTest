package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class AaSimple1LineChart extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Charts Test");
		
		//Defining X axis 
		NumberAxis xAxis = new NumberAxis("Label X",0, 10, 1);	//label, lower and upper bpind, tick unit 
		        
		//Defining y axis 
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setTickUnit(10);
		yAxis.setLabel("Label Y"); 
		
		LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
		chart.setTitle("Chart Title");
		
		//Preparing the Data - Instantiate the XYChart.Series class
		XYChart.Series<Number, Number> series = new XYChart.Series<>(); 
		series.setName("Series name");
		
		//add the data (a series of, x and y coordinates) to the Observable list of this class
		series.getData().add(new XYChart.Data<Number, Number>(1, 2)); 
		series.getData().add(new XYChart.Data<Number, Number>(2, 4)); 
		series.getData().add(new XYChart.Data<Number, Number>(3, 8)); 
		series.getData().add(new XYChart.Data<Number, Number>(4, 16)); 
		series.getData().add(new XYChart.Data<Number, Number>(5, 32)); 
		series.getData().add(new XYChart.Data<Number, Number>(6, 64));
		
		//Add Data to the Line Chart
		chart.getData().add(series);
		
		//Group root = new Group(chart); 
		//Scene scene = new Scene(root, 600, 500);
		Scene scene = new Scene(chart, 600, 500);
		
		stage.setScene(scene);
			
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

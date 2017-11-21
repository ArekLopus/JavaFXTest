package controls;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProgressBarDownloadSim extends Application {
	
	private Label infoL = new Label("Download images:");
	private Label statusL = new Label();
	
	private Button startB = new Button("Start");
	private Button cancelB = new Button("Cancel");
	
	private ProgressBar pb = new ProgressBar(0);
	private ProgressIndicator pi = new ProgressIndicator(0);
	
	private DownloadTask dlTask;

	
	@Override
	public void start(Stage stage) {
		stage.setTitle("ProgressBar and ProgressIndicator");
		
		statusL.setPrefWidth(200);
		statusL.setTextFill(Color.BLUE);
		
		
		startB.setOnAction( e -> {
			startB.setDisable(true);
			cancelB.setDisable(false);
			
			pb.setProgress(0);
			pi.setProgress(0);
			
			dlTask = new DownloadTask();
			
			unbindProperties();		//Just in case
			bindProperties();

			//Runs when task completes
			dlTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
				@Override
				public void handle(WorkerStateEvent t) {
					List<Image> copied = dlTask.getValue();
					
					unbindProperties();
					
					statusL.setText("Download finished, downloaded: " + copied.size());

					startB.setDisable(false);
					cancelB.setDisable(true);
				}
			});

			new Thread(dlTask).start();

		});
		
		
		cancelB.setOnAction(event -> {
			startB.setDisable(false);
			cancelB.setDisable(true);
			
			dlTask.cancel(true);
			unbindProperties();
			pb.setProgress(0);
			pi.setProgress(0);
		});
		
		
		HBox hb1 = new HBox();
		hb1.setSpacing(10);
		hb1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb1.setPadding(new Insets(10, 10, 10, 10));
		hb1.getChildren().addAll(startB, cancelB);
		
		HBox hb2 = new HBox();
		hb2.setSpacing(10);
		hb2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb2.setPadding(new Insets(10, 10, 10, 10));
		hb2.getChildren().addAll(infoL, pb, pi, statusL);

		VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		

		vb.getChildren().addAll(hb1, hb2);
		
        Scene scene = new Scene(vb, 500, 450);
        
		stage.setScene(scene);
		stage.show();
	}
	
	
	private void bindProperties() {
		pb.progressProperty().bind(dlTask.progressProperty());
		pi.progressProperty().bind(dlTask.progressProperty());
		statusL.textProperty().bind(dlTask.messageProperty());
	}
	
	private void unbindProperties() {
		pb.progressProperty().unbind();
		pi.progressProperty().unbind();
		statusL.textProperty().unbind();
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	private class DownloadTask extends Task<List<Image>> {

		@Override
		protected List<Image> call() {

			int parsedImages = 100;
			List<Image> downloadedImages = new ArrayList<>();

			for (int i = 0; i < parsedImages; i++) {
				try {
					Image img = downloadImgage("Image " + i);
					downloadedImages.add(img);
					this.updateProgress(i+1, parsedImages);
				} catch (Exception e) {
					System.out.println("Exception thrown: " + e.getMessage());
				}
			}

			return downloadedImages;
		}

		private Image downloadImgage(String name) throws Exception {
			int sleepTime = ThreadLocalRandom.current().nextInt(200);
			Thread.sleep(sleepTime);
			
			this.updateMessage("Dowloading: " + name);
			
			return new Image("/helper/Smile32.png");
		}

	}

}
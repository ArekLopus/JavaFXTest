package media;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.FileChooser.ExtensionFilter;

public class MediaPlayerTest extends Application {
	
	private Label statusL = new Label();
	private Label durationL = new Label();
	private Media media;
	private MediaPlayer player;
	private MediaView mediaView = new MediaView();
	private Slider timeSl = new Slider();
	private Slider volSl = new Slider();
	private CheckBox loopCB = new CheckBox("Loop");
	
	@Override
	public void start(Stage stage) throws MalformedURLException {
		stage.setTitle("MediaPlayer");
		
		//String path = "d:/Download/Music/a.mp3";
		//String mediaPath = "http://edge.flowplayer.org/flowplayer-700.flv";
		//String path = "d:/Download/Music/aa.avi";
		//String path = "d:/Download/Music/aa.mp4";
		
		//File file = new File(path);
		//String mediaPath = file.toURI().toString(); 
		
		Button loadB = new Button("Open file");
		loadB.setOnAction( e -> {
			FileChooser fc = new FileChooser();
			fc.setTitle("Open File");
			fc.setInitialDirectory(new File("d:/Download/Music"));
			
			fc.getExtensionFilters().addAll(
				new ExtensionFilter("All files", "*.*"),
			    new ExtensionFilter("Audio files", "*.mp3"),
			    new ExtensionFilter("Video files", "*.mp4"),
			    new ExtensionFilter("Video files", "*.avi")
			);
			
			
			File selFile = fc.showOpenDialog(stage);
			if(selFile != null) {
				System.out.println("File: "+selFile);
				stage.setTitle(selFile.getName());
				
				if(player != null) {
					player.stop();
				}
				
				//media = new Media(mediaPath);
				media = new Media(selFile.toURI().toString());
				player = new MediaPlayer(media);
				//player.setCycleCount(MediaPlayer.INDEFINITE);		//To play in a loop
				
				player.setAutoPlay(true);
				player.setOnPlaying( () -> {
					durationL.textProperty().bind(player.totalDurationProperty().asString());
					timeSl.setMax(player.totalDurationProperty().get().toMillis());
					
					timeSl.valueProperty().addListener(new InvalidationListener() {
					    public void invalidated(Observable ov) {
					       if (timeSl.isValueChanging()) {
					    	   player.seek(Duration.millis((double)timeSl.getValue()));
					       }
					    }
					});
					
					player.currentTimeProperty().addListener(new InvalidationListener() {
						@Override
						public void invalidated(Observable observable) {
							timeSl.setValue(player.currentTimeProperty().get().toMillis());
						}
					});
					
//					timeSl.valueChangingProperty().addListener(  (ob, oldv, nval) -> {
//						player.seek(Duration.millis(timeSl.getValue()));
//					});
					
//					timeSl.setOnMouseReleased( ee -> {
//						System.out.println("mouse rel");
//						player.seek(Duration.millis((double)timeSl.getValue()));
//					} );
//					timeSl.valueProperty().addListener( (ob, oldv, nval) -> {
//						player.seek(Duration.millis((double)nval));
//					});
//					player.currentTimeProperty().addListener( (ob, oldv, nval) -> {
//						timeSl.setValue(nval.toMillis());
//					});
					
				});
				player.setOnReady( ()->{
					durationL.textProperty().unbind();
					player.seek(Duration.ZERO);
					timeSl.setValue(0);
				});
				player.setOnEndOfMedia( () -> {
					if(loopCB.isSelected()) {
						player.stop();
						player.play();
					} else {
						player.stop();
					}
					
				});
				player.setOnError(() -> System.out.println(player.getError().getMessage()));
				
				mediaView.setMediaPlayer(player);
				
				statusL.textProperty().bind(player.statusProperty().asString());
				volSl.valueProperty().bindBidirectional(player.volumeProperty());
			}
			
		});
		
		mediaView.setFitWidth(600);
		mediaView.setFitHeight(400);
		
		Button playB = new Button("Play");
		playB.setOnAction(e -> {
			if (player != null && player.getStatus() == PLAYING) {
				player.stop();
				player.play();
			} else if (player != null){
				player.play();
			}
		});

		Button stopB = new Button("Stop");
		stopB.setOnAction(e -> {
			if(player != null)
				player.stop();
		});
		
		statusL.setPrefHeight(25);
		durationL.setPrefHeight(25);
		
		volSl.setMin(0);
		volSl.setMax(1);
		
		loopCB.setSelected(true);
		
		HBox hb1 = new HBox(5, loadB,  playB, stopB, loopCB, statusL, durationL);
		hb1.setPadding(new Insets(5));
		
		Label timeL = new Label("Time: ");
		Label volL = new Label("Volume: ");
		
		HBox hb2 = new HBox(5, timeL, timeSl, volL, volSl);
		hb2.setPadding(new Insets(5));
		
		VBox vb1 = new VBox();
		vb1.getChildren().addAll(mediaView, hb1, hb2);
		
		Scene scene = new Scene(vb1);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	private class CurrentTimeListener implements InvalidationListener {
		@Override
		public void invalidated(Observable observable) {
			Platform.runLater(() -> {
				MediaPlayer mediaPlayer = player;
				final Duration currentTime = mediaPlayer.getCurrentTime();
				//currentTimeLabel.setText(formatDuration(currentTime));
				updatePositionSlider(currentTime);
			});
		}
	}
	
	private void updatePositionSlider(Duration currentTime) {
		if (timeSl.isValueChanging())
			return;
		MediaPlayer mediaPlayer = player;
		Duration total = mediaPlayer.getTotalDuration();
		if (total == null || currentTime == null) {
			timeSl.setValue(0);
		} else {
			timeSl.setValue(currentTime.toMillis() / total.toMillis());
		}
	}
	
	
	private class PositionListener implements ChangeListener<Boolean> {
		@Override
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			if (oldValue && !newValue) {
				double pos = timeSl.getValue();
				MediaPlayer mediaPlayer = player;
				final Duration seekTo = mediaPlayer.getTotalDuration().multiply(pos);
				seekAndUpdatePosition(seekTo);
			}
		}
	}
	
	private void seekAndUpdatePosition(Duration duration) {
		MediaPlayer mediaPlayer = player;
		if (mediaPlayer.getStatus() == Status.STOPPED) {
			mediaPlayer.pause();
		}
		mediaPlayer.seek(duration);
		if (mediaPlayer.getStatus() != Status.PLAYING) {
			updatePositionSlider(duration);
		}
	}
	

	
	
}

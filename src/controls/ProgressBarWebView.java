package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

 
public class ProgressBarWebView extends Application {
 
	private WebView wv = new WebView();
    private WebEngine we = wv.getEngine();
    
    private ProgressBar pb = new ProgressBar(0);
	private ProgressIndicator pi = new ProgressIndicator(0);
	
	private TextField tf = new TextField("java.com");
	private Label l1 =  new Label("Loading status: ");
	private Button b1 = new Button("Click to download");
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("ProgressBar");
    	
    	Worker<Void> worker = we.getLoadWorker();
    	worker.stateProperty().addListener(new ChangeListener<State>() {
        	@Override
            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
        		l1.setText("Loading status: " + newValue.toString());
                if (newValue == Worker.State.SUCCEEDED) {
                	System.out.println("Finished");
                }
            }
        });

    	
        pb.progressProperty().bind(we.getLoadWorker().progressProperty());
        pi.progressProperty().bind(we.getLoadWorker().progressProperty());
                
        
        l1.setPrefWidth(160);
        l1.setPrefHeight(25);
        l1.setAlignment(Pos.CENTER_LEFT);
        
        
        b1.setGraphic(pb);
        b1.setOnAction( e -> {
        	we.load("http://"+tf.getText());
        });
        
        HBox hb = new HBox();
        hb.setPrefHeight(100);
		hb.setSpacing(10);
		hb.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.getChildren().addAll(tf, l1, b1, pi);
 
        VBox vb = new VBox();
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(wv, hb);
        
        Scene scene = new Scene(vb, 1100, 700);
        
        tf.requestFocus();
        tf.selectAll();
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
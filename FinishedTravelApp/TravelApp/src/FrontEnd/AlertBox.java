package FrontEnd;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class AlertBox extends Application {
	
	
	public static void display(String message)
	{
		// create objects
		Stage primaryStage = new Stage();  // make the stage
		Scene scene;                      // Reference for scene
		Button btn = new Button("Close the Window");  // button to close window
		Label label = new Label();      // label for message
		VBox pane = new VBox(10);       // layout for page
		
		primaryStage.setTitle("Error");  // title of page
		
		// block interaction with other windows
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		
		label.setText(message);       // set the label color and text
		label.setTextFill(Color.RED);
		
		
		// when button is clicked close the window
		btn.setOnAction(e -> primaryStage.close());
		
		
		// assign children to pane 
		pane.getChildren().addAll(label,btn);
		pane.setAlignment(Pos.CENTER);
		
		// initialize scene with pane
		scene = new Scene(pane,500,500);
		
		// show the stage 
		primaryStage.setScene(scene);
		primaryStage.showAndWait();
		
		
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		
		
		
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}

}

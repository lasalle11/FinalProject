package FrontEnd;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import FrontEnd.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;   // allow splash screen to open to menu
import javafx.util.Duration;   // the length of the animation in milliseconds

public class Splash extends Application {

	// objects
	private Scene scene;    /// create the scene
	private Image image = new Image("sunset-plane.png");   /// set the image 
	private FlowPane pane; // make a stack pane for image and button
	private ImageView iv;   // make image view to hold photo
	private PauseTransition delay;  // make a transition delay for splash screen
	
	private Menu m;
		
	
	@Override
	public void start(Stage stage) throws Exception {
	
		
		int delayTime = 5;
		
		// try to create objects or catch an the exception and print the error in console
		try{
			// Initiate variables
			pane = new FlowPane();  
			iv = new ImageView();
			scene = new Scene(pane);  // set pane to scene
			
			
			iv.setImage(image); // set image to image view
			iv.setFitWidth(500);  // set the width and height
			iv.setFitHeight(500);
			
		    
			pane.getChildren().addAll(iv);  // add image view and button to pan
			
	
			stage.setScene(scene);  // add scene to the stage
			stage.setTitle("Travel App"); // set stage title
			stage.show();         // show the stage
			
			 delay = new PauseTransition(Duration.seconds(delayTime));  // set delay to delayTime seconds
			 
			 // after delayed time run 
			delay.setOnFinished( e -> {
				m = new Menu();  // create menu object to open menu GUI
				
			// try to run start in the menu class
			try {
				m.start(stage);
			} catch (Exception error) {
				
				System.out.println(error.getMessage());
			}
			finally{
				m = null;
			}
	
			});
			delay.play();
			
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String [] args)
	{
		
		launch(args);		
		
	}
	

}

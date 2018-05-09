package FrontEnd;
/// not needed
import Backend.Database;
import flightApp.VariableObject;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Login extends Application {
	
	// objects
		private Scene scene;    /// create the scene 
		private GridPane pane = new GridPane(); // make a stack pane for image and button
		private Button loginBtn, backBtn,getPasswordBtn;
		private Text errorMessage = new Text();
		
		private Menu m;
		private GetPassword gp;
		private Member member;
		
		VariableObject v = new VariableObject();
		Database d = new Database(v);
		
		
		// Initialize objects
		final TextField usernameField = new TextField();
		final TextField passwordField = new TextField();
		
		


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		usernameField.setPromptText("Enter your username");
		passwordField.setPromptText("Enter your username");
		
		loginBtn = new Button("Login");
		backBtn = new Button("Back");
		getPasswordBtn = new Button("Forgot Password?");
		
		
		GridPane.setRowIndex(usernameField, 0);
		GridPane.setColumnIndex(usernameField, 0);
		GridPane.setColumnSpan(usernameField, 2);
		
		GridPane.setRowIndex(passwordField, 1);
		GridPane.setColumnIndex(passwordField, 0);
		GridPane.setColumnSpan(usernameField, 2);
		
		GridPane.setRowIndex(loginBtn, 2);
		GridPane.setColumnIndex(loginBtn, 0);
		
		GridPane.setRowIndex(getPasswordBtn, 2);
		GridPane.setColumnIndex(getPasswordBtn, 3);
		
		GridPane.setRowIndex(errorMessage, 3);
		GridPane.setColumnIndex(errorMessage, 0);
		GridPane.setColumnSpan(errorMessage, 3);
		
		GridPane.setRowIndex(backBtn, 4);
		GridPane.setColumnIndex(backBtn, 4);
		
		pane.getChildren().addAll(loginBtn, backBtn,getPasswordBtn,usernameField,passwordField,errorMessage);
		
		scene = new Scene(pane,400,200);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// action when login button is clicked
		// log the user in
		loginBtn.setOnAction(e -> {
		
			
			
			// get the username and password from the textfields
			String inputUsername = usernameField.getText();
			String inputPassword = passwordField.getText();
			
			try{
				
				errorMessage.setText(null);
			// check if the username and password is in the database
			d.loginUser(v);
			
			// if found open user menu
			if(v.getUsername() == inputUsername && v.getPassword() == inputPassword){
				
				// open to member page
				member = new Member();
				
				member.start(primaryStage);
				
			}
			// not found display error Username and Password not in our records
			else{
				throw new Exception();
			}
			}catch(Exception ex){
				// deallocate object for garbage collection
				v = null;
				// alert message with red text saying username and password not found
				errorMessage.setFill(Color.FIREBRICK);
				errorMessage.setText("Username and Password not found");
				
			}finally{
				
				// deallocate object for garbage collection
				d = null;
			}
			

		
		});
		// action when back button is clicked to go to menu
		backBtn.setOnAction(e -> {
			try{

				 m = new Menu();
				
				m.start(primaryStage);
			}catch(Exception ex){

				System.out.println(ex.getMessage());

			}finally{
				// deallocate object for garbage collection

				m = null;
			}

		});

		// action when get password button is clicked open password retrieval page
		getPasswordBtn.setOnAction(e -> {


			try{

				GetPassword gp = new GetPassword();
				
				gp.start(primaryStage);
			}catch(Exception ex){

				System.out.println(ex.getMessage());

			}finally{
				// deallocate object for garbage collection

				gp = null;
			}

		});		
		
		
	}
	
	public static void main(String [] args)
	{
		launch(args);
		
	}
	
	

}

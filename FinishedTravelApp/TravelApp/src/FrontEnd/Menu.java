package FrontEnd;

import Backend.Database;
import flightApp.VariableObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Menu extends Application {
	
	// make references
	private Scene scene;
	private Button loginBtn,signupBtn,getPasswordBtn;
	private Signup s;
	private GetPassword gp;
	private Member member;
	
	
	// Initialize objects
	private Text welcomeText = new Text("Welcome to Travel App!!!");  
	private Text forgotPasswordText = new Text("Trouble Signing In?");
	private Text notMemberText = new Text("Not a member?");
	
	private final TextField usernameField = new TextField();
	private final TextField passwordField = new TextField();
	private GridPane pane = new GridPane(); 
	
	private Text errorMessage = new Text();
	private VariableObject v = new VariableObject();
	private Database d = new Database(v);

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		loginBtn = new Button("Login");
		signupBtn = new Button("Sign Up");
		getPasswordBtn = new Button("Forgot Password");
		

		GridPane.setRowIndex(welcomeText, 0);  // put welcome text in first row
		GridPane.setColumnSpan(welcomeText, 3);  // make the column span 3 rows
	 
		GridPane.setRowIndex(usernameField, 1);   // put username field in 2nd row 2nd column
		GridPane.setColumnIndex(usernameField, 1);
		
		GridPane.setRowIndex(passwordField, 2);  // put password field in 3rd row 2nd column
		GridPane.setColumnIndex(passwordField,1 );
		
		GridPane.setRowIndex(loginBtn, 2);    // put login button in 3rd row 3rd column
		GridPane.setColumnIndex(loginBtn, 2); 
		
		GridPane.setRowIndex(errorMessage, 3);    // put login button in 3rd row 3rd column
		GridPane.setColumnIndex(errorMessage, 0); 
		GridPane.setColumnSpan(errorMessage, 3); 
		
		GridPane.setRowIndex(getPasswordBtn, 4);   // put password button in 4th row 3rd column
		GridPane.setColumnIndex(getPasswordBtn, 2);
		
		GridPane.setRowIndex(forgotPasswordText, 4);   // put password text in 4th row 1st column
		GridPane.setColumnIndex(forgotPasswordText,1);
		
		GridPane.setRowIndex(notMemberText, 6);         // put not member text in 6th row 1st column
		GridPane.setColumnIndex(notMemberText, 1);
		
		GridPane.setRowIndex(signupBtn, 6);         // put in signup button 6th row 3rd column
		GridPane.setColumnIndex(signupBtn, 2);
		
		// set all children into the pane
		pane.getChildren().setAll(welcomeText,forgotPasswordText,notMemberText,loginBtn,signupBtn,
				getPasswordBtn,passwordField,usernameField,errorMessage);
		
	
		scene = new Scene(pane,400,300);   // put pane inside the scene
		primaryStage.setScene(scene); // put scene in the stage
		primaryStage.setTitle("Travel App Menu");  // set the stage title
		primaryStage.show();  // show the stage
		
		// action when login button is clicked open login page
		loginBtn.setOnAction(e -> {
			
					// get the username and password from the textfields
					String inputUsername = usernameField.getText();
					String inputPassword = passwordField.getText();
					
					try{
						
						
						v.setUsername(inputUsername);
						v.setPassword(inputPassword);
						errorMessage.setText(null);;
					// check if the username and password is in the database
					d.loginUser(v);
					
					// if found open user menu
					if(v.getUsername().equals(inputUsername) && v.getPassword().equals(inputPassword)){
						
						
						
						
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
						
						// alert message with red text saying username and password not found
						errorMessage.setFill(Color.FIREBRICK);
						errorMessage.setText("Username and Password not found");
						
						System.out.println(ex.getMessage());
						
						
					}finally{
						
						// deallocate object for garbage collection
						d = null;
					}
					

				
				

		});

		// action when signup button is clicked open signup page
		signupBtn.setOnAction(e -> {

			try{
				s = new Signup();
				s.start(primaryStage);


			}catch(Exception ex){

				System.out.println(ex.getMessage());
				AlertBox.display("Unexpected Error");

			}finally{

				s = null;
			}



		} );

		// action when get password button is clicked open password retrieval page
		getPasswordBtn.setOnAction(e -> {
			try{

				gp = new GetPassword();
				gp.start(primaryStage);
			}catch(Exception ex){

				System.out.println(ex.getMessage());
				AlertBox.display("Unexpected Error");

			}finally{

				gp = null;
			}



		} );
		
	}
	
	public static void main(String [] args)
	{
		launch(args);
	}
	

}

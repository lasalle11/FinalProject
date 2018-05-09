package FrontEnd;

import Backend.Database;
import flightApp.VariableObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class GetPassword extends Application {
	
	VariableObject v = new VariableObject();
	Database d = new Database(v);
	Menu m;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			primaryStage.setTitle("Retrieve Password");
		
			// create a button to retrieve password
			Button getPassBtn = new Button("Retrieve Password");
			
			
			Button backBtn = new Button("Back");
			// label for text field
			Label userName1 = new Label("User Name:");
			
			
		
			
			// make a test field for username
			TextField userTextField1 = new TextField();
		
			
			// make choice box for the security question the user signed up with
			ChoiceBox<String> securityQuestion = new ChoiceBox<>();
			securityQuestion.getItems().addAll("first pet's name?", "first car's make");

			
			// label and text field for answer
			Label answer = new Label("Security Question Answer:");
		
			
			TextField txtAnswer = new TextField();

			
			// text for error if they error
			final Text actiontarget1 = new Text();
		

			// create  vbox layout , scene and show it on the stage
			VBox layout = new VBox();
			layout.getChildren().addAll(userName1,userTextField1,securityQuestion,answer,txtAnswer,actiontarget1,getPassBtn,backBtn);
			
			
			Scene scene = new Scene(layout, 500, 500);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
			
			
			
	// when button is clicked run code to find password
			getPassBtn.setOnAction(e->{
					actiontarget1.setText(null);
					try{
					actiontarget1.setFill(Color.FIREBRICK);
					// get the values of user inputs
					v.setUsername(userTextField1.getText());
					v.setSecurity_question(securityQuestion.getValue());
					
					// run database method to check for password
					d.forgotPassword(v);
				
					System.out.println(txtAnswer.getText());
					System.out.println(v.getQuestion_answer() );
					System.out.println(securityQuestion.getValue());
					
					// if the answer from the database equals the imput from user show their password else tell them you can't find them in the DB
					if(v.getQuestion_answer().equalsIgnoreCase(txtAnswer.getText()) )
					{
						
						actiontarget1.setText("Your password is " + v.getPassword());
						actiontarget1.setFill(Color.BLACK);
					}
					else
					{
						throw new Exception();
					}
					
					
					
					
				}catch(Exception ex){
					actiontarget1.setText("Username and Password not found");
					actiontarget1.setFill(Color.RED);
					v = null;
					
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
			

			}
		
	}



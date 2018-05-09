package FrontEnd;

import Backend.Database;
import flightApp.VariableObject;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class Signup extends Application {
	
	public static void main(String [] args)
	{
		launch(args);
	}

	// objects											
	private Button backBtn;


	private Menu m;

	VariableObject v = new VariableObject();
	Database d = new Database(v);

	// Initialize objects
	final TextField usernameField = new TextField();
	final TextField passwordField = new TextField();
	
	Stage stage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		/*pane = new GridPane();
		addUIControls();
		
		scene = new Scene(pane);
		
		primaryStage.setTitle("SignUp");
		primaryStage.show();*/
		primaryStage.setTitle("Registration Form For New User");

		// Create the registration form grid pane
		GridPane gridPane = createRegistrationFormPane();
		// Add UI controls to the registration form grid pane
		addUIControls(gridPane);
		
		backBtn = new Button("Back");
		
		gridPane.add(backBtn, 2, 13);
		
		// Create a scene with registration form grid pane as the root node
		Scene scene = new Scene(gridPane, 850, 550);
		// Set the scene in primary stage
		primaryStage.setScene(scene);

		primaryStage.show();
		
		
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
	private GridPane createRegistrationFormPane() {
		// Instantiate a new Grid Pane
		GridPane gridPane = new GridPane();

		// Position the pane at the center of the screen, both vertically and
		// horizontally
		gridPane.setAlignment(Pos.CENTER);

		// Set a padding of 20px on each side
		gridPane.setPadding(new Insets(40, 40, 40, 40));

		// Set the horizontal gap between columns
		gridPane.setHgap(10);

		// Set the vertical gap between rows
		gridPane.setVgap(8);

		// Add Column Constraints

		// columnOneConstraints will be applied to all the nodes placed in
		// column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100,
				100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in
		// column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200,
				Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		gridPane.getColumnConstraints().addAll(columnOneConstraints,
				columnTwoConstrains);

		return gridPane;
	}

	private void addUIControls(final GridPane gridPane) {
		// Add Header
		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		

		// Add First Name Label
		Label FnameLabel = new Label("First Name : ");
		gridPane.add(FnameLabel, 0, 2);

		// Add First Name Text Field
		final TextField FnameField = new TextField();
		FnameField.setPrefHeight(40);
		gridPane.add(FnameField, 1, 2);

		// Add Last Name Label
		Label LnameLabel = new Label("Last Name: ");
		gridPane.add(LnameLabel, 0, 3);

		// Add Last Name Text Field
		final TextField LnameField = new TextField();
		LnameField.setPrefHeight(40);
		gridPane.add(LnameField, 1, 3);

		// Label for Address
		Label addressLabel = new Label("Address");
		gridPane.add(addressLabel, 0, 4);

		// text field address
		final TextField addressField = new TextField();
		addressField.setPrefHeight(40);
		gridPane.add(addressField, 1, 4);

		// Label for state
		Label stateLabel = new Label("State");
		gridPane.add(stateLabel, 0, 5);

		// Text for state
		final TextField stateField = new TextField();
		stateField.setPrefHeight(40);
		gridPane.add(stateField, 1, 5);

		// label for zip
		Label zipLabel = new Label("Zip");
		gridPane.add(zipLabel, 0, 6);

		// TextField for zip
		final TextField zipField = new TextField();
		zipField.setPrefHeight(40);
		gridPane.add(zipField, 1, 6);

		// label username
		Label usernameLabel = new Label("Username");
		gridPane.add(usernameLabel, 0, 7);

		// textfield username
		final TextField usernameField = new TextField();
		usernameField.setPrefHeight(40);
		gridPane.add(usernameField, 1, 7);

		// label password
		Label passwordLabel = new Label("Password");
		gridPane.add(passwordLabel, 0, 8);

		// TextField
		final TextField passwordField = new TextField();
		passwordField.setPrefHeight(40);
		gridPane.add(passwordField, 1, 8);

		// Add Email Label
		Label emailLabel = new Label("Email: ");
		gridPane.add(emailLabel, 0, 9);

		// Add Email Text Field
		final TextField emailField = new TextField();
		emailField.setPrefHeight(40);
		gridPane.add(emailField, 1, 9);

		// Add SSN label
		Label ssnLabel = new Label("SSN");
		gridPane.add(ssnLabel, 0, 10);

		// Add ssn textfield
		final TextField ssnField = new TextField();
		ssnField.setPrefHeight(40);
		gridPane.add(ssnField, 1, 10);
		

		// Security Question Label
		Label SQLabel = new Label("Security Question:");
		gridPane.add(SQLabel, 0, 11);

	
		
		// Choice box for security question
		ChoiceBox<String> SQField = new ChoiceBox<>();
		SQField.getItems().addAll("first pet's name?", "first car's make");
		gridPane.add(SQField, 1, 11);
				

		// Security Answer label
		Label SALabel = new Label("Security Answer");
		gridPane.add(SALabel, 0, 12);

		// Security Answer TextField
		final TextField SAField = new TextField();
		SAField.setPrefHeight(40);
		gridPane.add(SAField, 1, 12);

		// Add Submit Button
		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 13, 2, 1);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
	
		
	

		submitButton.setOnAction(e -> {
		
				// set the field to variable object
				v.setFirst_name(FnameField.getText());
				v.setLast_name(LnameField.getText());
				v.setAddress(addressField.getText());
				v.setZip(zipField.getText());
				v.setState(stateField.getText());
				v.setUsername(usernameField.getText());
				v.setPassword(passwordField.getText());
				v.setEmail(emailField.getText());
				v.setSsn(ssnField.getText());
				v.setSecurity_question(SQField.getValue());
				v.setQuestion_answer(SAField.getText());
				
				// make sure there are no blank fields
				try {
					// make sure no field is empty
					if(v.getFirst_name().equalsIgnoreCase(" ") && v.getLast_name().equalsIgnoreCase(" ") && v.getAddress().equalsIgnoreCase(" ") &&
							v.getZip().equalsIgnoreCase(" ") && v.getState().equalsIgnoreCase(" ") && v.getUsername().equalsIgnoreCase(" ") &&
							v.getPassword().equalsIgnoreCase(" ") && v.getEmail().equalsIgnoreCase(" ") && v.getSsn().equalsIgnoreCase(" ") &&
							v.getSecurity_question().equalsIgnoreCase(" ") && v.getQuestion_answer().equalsIgnoreCase(" ")){

						// sign the user up
						d.signupCustomer(v);
						
					    m = new Menu();
						
						m.start(stage);
						
						

					}
					else{
						throw new Exception();
					}


				} catch (Exception ex) {
						AlertBox.display("Fill out every field");
                       
				}finally{
					m = null;
				}




			




		});
		

		
	}
	

	}



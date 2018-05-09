package Backend;
import java.sql.*;


import flightApp.Customer;
import flightApp.Flight;
import flightApp.VariableObject;

public class Database {

	// null customer object
	Customer cust = null;



	
	public Database(VariableObject o){

		// call the set customer method
		setCust(o);

	}

	/**works*/
	public void signupCustomer(VariableObject o){
		
		/*String first_name,String last_name,String address,String zip,String username,String
		 password,String email,String ssn,String security_question,String question_answer*/
	
	// objects needed for connection
	Connection connection = null;
	PreparedStatement statement = null;
	int resultSet;
	
	
	/** nned to make sure username email ssn is not already in system*/



	try {

		// Establish a connection
		connection = getDriverConnection();
				System.out.println("Database connected");

		// Create a statement
		statement = connection.prepareStatement(Query.INSERT_CUSTOMER_INTO_PERSON_DATABASE);

		statement.setInt(1, 2);  // need to havee auto increment so we dont need variable
		statement.setString(2, o.getFirst_name());
		statement.setString(3, o.getLast_name());
		statement.setString(4, o.getAddress());
		statement.setString(5, o.getZip());
		statement.setString(6,o.getUsername());
		statement.setString(7,o.getPassword());
		statement.setString(8, o.getEmail());
		statement.setString(9, o.getSsn());
		statement.setString(10, o.getSecurity_question());
		statement.setString(11, o.getQuestion_answer());
		statement.setBoolean(12, false);
	



		// Execute a statement
		resultSet = statement.executeUpdate();
		
		System.out.println("User added");


	} catch (ClassNotFoundException e) {


		System.out.println(e.getMessage());
	} catch (SQLException e) {



		System.out.println(e.getMessage());
	}
	// Close the connection
	finally{
		try {
			connection.close();
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}

}
	/**works*/	
	public void signupAdmin(VariableObject o){	
		
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet;
		
		
		/** nned to make sure username email ssn is not already in system*/



		try {
	

			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.INSERT_ADMIN_INTO_PERSON_DATABASE);

			
			statement.setInt(1, 2);  // need to havee auto increment so we dont need variable
			statement.setString(2, o.getFirst_name());
			statement.setString(3, o.getLast_name());
			statement.setString(4, o.getAddress());
			statement.setString(5, o.getZip());
			statement.setString(6,o.getUsername());
			statement.setString(7,o.getPassword());
			statement.setString(8, o.getEmail());
			statement.setString(9, o.getSsn());
			statement.setString(10, o.getSecurity_question());
			statement.setString(11, o.getQuestion_answer());
			statement.setBoolean(12, true);
		
			/*statement.setString(1, o.getFirst_name());
			statement.setString(2, o.getLast_name());
			statement.setString(3, o.getAddress());
			statement.setString(4, o.getZip());
			statement.setString(5,o.getUsername());
			statement.setString(6,o.getPassword());
			statement.setString(7, o.getEmail());
			statement.setString(8, o.getSsn());
			statement.setString(9, o.getSecurity_question());
			statement.setString(10, o.getQuestion_answer());
		*/
		



			// Execute a statement
			resultSet = statement.executeUpdate();
			
			System.out.println("User added");


		} catch (ClassNotFoundException e) {

          
			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		// Close the connection
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
	}
	/**works*/	
	public void showAllUser(){
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet;



		try {
		
			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.SELECT_ALL_FROM_PERSON);



			// Execute a statement
			resultSet = statement.executeQuery();
			
			while (resultSet.next())
			{
				/* original System.out.println("username: " +resultSet.getString(2) + " password: " +resultSet.getString(3)
				+ " Fname: " + resultSet.getString(4) + " Lname: " + resultSet.getString(5)
				+ " address" + ": " +resultSet.getString(6) + " zip: " + resultSet.getString(7)
				+ " email: " + resultSet.getString(8) + " ssn: " + resultSet.getString(9) 
				+ " Question: " + resultSet.getString(10)+ " answer: " +resultSet.getString(11) 
				+ " admin: " +resultSet.getBoolean(12));*/
				
				System.out.println("username: " +resultSet.getString(7) + " password: " +resultSet.getString(8)
				+ " Fname: " + resultSet.getString(2) + " Lname: " + resultSet.getString(3)
				+ " address" + ": " +resultSet.getString(4) + " state: " + resultSet.getString(5) 
				+ " zip: " + resultSet.getString(6)
				+ " email: " + resultSet.getString(9) + " ssn: " + resultSet.getString(10) 
				+ " Question: " + resultSet.getString(11)+ " answer: " +resultSet.getString(12) 
				+ " admin: " +resultSet.getBoolean(13));
			}


		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		// Close the connection
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
	}
	/** works*/		
	public void showAllFlights(VariableObject o) {

		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;



		try {
		

			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.SELECT_ALL_FLIGHTS); 


			// Execute a statement
			resultSet = statement.executeQuery();
			
			o.removeFlights();

			// Iterate through the result and print the student names
			while (resultSet.next())
				/*System.out.println("Flight# : " +resultSet.getString(1) + " Departure City: " + resultSet.getString(2) +
									" Departure Day: " + resultSet.getString(4) + " Departure Time: " + resultSet.getString(6)    
					               + " Arrival City: " + resultSet.getString(3) + " Arrival Day: " + resultSet.getString(5)
					               +" Arrival Time: " + resultSet.getString(7) +" Customer#: " + resultSet.getString(8)
					               +" Capacity: " + resultSet.getString(9));*/
				
				o.addFlights(new Flight(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(6),
						resultSet.getString(3),resultSet.getString(5),resultSet.getString(7),resultSet.getInt(8),
						resultSet.getInt(9)));
				

		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		// Close the connection
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}

		
	}
	
	/** works*/		
	public void searchFlights(VariableObject o) {

		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;



		try {
		

			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.SELECT_FLIGHTS); 

			statement.setString(1, o.getDeparted_city());
			statement.setString(2, o.getArrival_city());
			statement.setString(3, o.getDepartureDay());
			statement.setString(4, o.getArrivalDay());
			statement.setString(5, o.getDepart_time());
			statement.setString(6, o.getArrival_time());

			// Execute a statement
			resultSet = statement.executeQuery();

			// Iterate through the result and print the student names
			while (resultSet.next())
				System.out.println("Flight# : " +resultSet.getString(1) + " Departure City: " + resultSet.getString(2) +
									" Departure Day: " + resultSet.getString(4) + " Departure Time: " + resultSet.getString(6)    
					               + " Arrival City: " + resultSet.getString(3) + " Arrival Day: " + resultSet.getString(5)
					               +" Arrival Time: " + resultSet.getString(7) +" Customer#: " + resultSet.getString(8)
					               +" Capacity: " + resultSet.getString(9));
			
			
		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		// Close the connection
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}






		
	}
		/**works*/
	
	
	
	/**works*/
	public void addFlightToDB(VariableObject o){
		
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet;
		
		ResultSet rs = null;


		if(o.isAdmin())
		{
		
		
		
		
			try {

				
				// check if the flight is already in database
				// Establish a connection
				connection = getDriverConnection();
				System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.CHECK_IF_FLIGHT_IS_ALREADY_IN_DATABASE);

				statement.setString(1,o.getDeparted_city());
				statement.setString(2,o.getArrival_city());
				statement.setString(3,o.getDepartureDay());
				statement.setString(4, o.getArrivalDay());
				statement.setString(5, o.getDepart_time());
				statement.setString(6, o.getArrival_time());
				
				// Execute a statement
				rs = statement.executeQuery();
				

				int rows = 0; // hold the number of rows
				
				// add to integer everytime there is a row
				while(rs.next())
				{
					rows++;
				}
				
				
				// if there are no rows run following code
				if(rows == 0)
				{

				// Establish a connection
				connection = getDriverConnection();
				System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.INSERT_FLIGHT_TO_DATABASE);

				statement.setString(1,o.getDeparted_city());
				statement.setString(2,o.getArrival_city());
				statement.setString(3,o.getDepartureDay());
				statement.setString(4, o.getArrivalDay());
				statement.setString(5, o.getDepart_time());
				statement.setString(6, o.getArrival_time());
			
				



				// Execute a statement
				resultSet = statement.executeUpdate();

				System.out.println("Flight added");
				}
				else
				{
					System.out.println("Database already has this flight");
				}



			} catch (ClassNotFoundException e) {


				System.out.println(e.getMessage());
			} catch (SQLException e) {



				System.out.println(e.getMessage());
			}	// Close the connection
			finally{
				try {
					connection.close();
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				}
			}
			
			
		}

	}

	

		/**works*/
	public void addUserToFlightDB(VariableObject o){
		
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet;
		int set;
		int capacity = -1;
		int numberOfCustomers = -1;


		ResultSet rs = null;

		// get the number of customers in the flight
		try {
		
			
			
			
					// check if the userflight combination is already in database
					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					// Create a statement
					statement = connection.prepareStatement(Query.CHECK_IF_USER_FLIGHT_IS_ALREADY_IN_DATABASE);

					statement.setInt(1,o.getUserid());
					statement.setInt(2,o.getFlight_number());
					
					
					// Execute a statement
					rs = statement.executeQuery();
					

					int rows = 0; // hold the number of rows
					
					// add to integer everytime there is a row
					while(rs.next())
					{
						rows++;
					}
					
					// if row is not zero then skip code to get number of customers
					if(rows == 0)
					{
						
					
					
			
			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.GET_NUMBER_OF_CUSTOMERS);

		
			statement.setInt(1,o.getFlight_number()); 
			statement.setString(2, o.getDeparted_city());
			statement.setString(3, o.getArrival_city());



			// Execute a statement
			resultSet = statement.executeQuery();
			
			// set number of customers and capacity
			if(resultSet.next())
			{
			System.out.println("Row Found");
			numberOfCustomers = resultSet.getInt(1);
			capacity = resultSet.getInt(2);
			System.out.println(numberOfCustomers);
			System.out.println(capacity);
			
			}
			else
			{
				System.out.println("Row not Found");
			}
					}


		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
				statement = null;
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
      // if number of customers and capacity over -1 amd number of customers under capcity add customer to flight
		if(numberOfCustomers > -1 && capacity > -1 && numberOfCustomers < capacity)
		{
			try {
		
				// Establish a connection
				connection = getDriverConnection();
				System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.ADD_USER_TO_FLIGHT);

				statement.setInt(1, ++numberOfCustomers);
				statement.setInt(2,o.getFlight_number()); 
				statement.setString(3, o.getDeparted_city());
				statement.setString(4, o.getArrival_city());




				// Execute a statement
				set = statement.executeUpdate();
				
				// add the user to the user flight database
				 addUserToUserFlightDB(o);

				System.out.println("Customer added");
				System.out.println("New Number of customer " + numberOfCustomers);


			} catch (ClassNotFoundException e) {


				System.out.println(e.getMessage());
			} catch (SQLException e) {



				System.out.println(e.getMessage());
			}
			finally{
				try {
					connection.close();
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			System.out.println("Flight was not found");
		}
	}

	/**works*/
	private void addUserToUserFlightDB(VariableObject o){
		
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet;
		int set;
		int capacity = -1;
		int numberOfCustomers = -1;


		try{
			
			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.ADD_USER_AND_FLIGHT_TO_USERFLIGHT);

		
			statement.setInt(1,o.getUserid());
			statement.setInt(2,o.getFlight_number()); 
			



			// Execute a statement
			resultSet = statement.executeUpdate();
			


		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
				statement = null;
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
     
	}
	
	/**works*/
	public void deleteFlightDB(VariableObject o)
	{
		// objects needed for connection
				Connection connection = null;
				PreparedStatement statement = null;
				int resultSet;

				if( o.isAdmin())
				{

				try {
				
					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					// Create a statement
					statement = connection.prepareStatement(Query.DELETE_FLIGHT_FROM_DATABASE);

					statement.setInt(1, o.getFlight_number());
					statement.setString(2,o.getDeparted_city());
					statement.setString(3,o.getArrival_city());
					statement.setString(4,o.getDepartureDay());
					statement.setString(5, o.getArrivalDay());
					statement.setString(6, o.getDepart_time());
					statement.setString(7, o.getArrival_time());


					

					// Execute a statement
					resultSet = statement.executeUpdate();
					 deleteFlightUserFlightDB(o);
					System.out.println("flight deleted");

				} catch (ClassNotFoundException e) {


					System.out.println(e.getMessage());
				} catch (SQLException e) {



					System.out.println(e.getMessage());
				}	// Close the connection
				finally{
					try {
						connection.close();
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
					}
				}
				}
				else{
					System.out.println("user is not an admin");
				}

	}
	/**works*/	
private void deleteFlightUserFlightDB(VariableObject o)
	{
		// objects needed for connection
				Connection connection = null;
				PreparedStatement statement = null;
				int resultSet;

				try {
				
					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					// Create a statement
					statement = connection.prepareStatement(Query.DELETE_FLIGHT_FROM_USERFLIGHT_DATABASE);

					statement.setInt(1, o.getFlight_number());
				


					

					// Execute a statement
					resultSet = statement.executeUpdate();
					System.out.println("flight deleted");

				} catch (ClassNotFoundException e) {


					System.out.println(e.getMessage());
				} catch (SQLException e) {



					System.out.println(e.getMessage());
				}	// Close the connection
				finally{
					try {
						connection.close();
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
					}
				}
			

	}
	
	
/**works*/
	public void removeUserFromFlightDB(VariableObject o){

		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet;
		int set;
		int capacity = -1;
		int numberOfCustomers = -1;



		// get the number of customers in the flight
		try {
		
			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");

			// Create a statement
			statement = connection.prepareStatement(Query.GET_NUMBER_OF_CUSTOMERS);


			statement.setInt(1,o.getFlight_number()); 
			statement.setString(2, o.getDeparted_city());
			statement.setString(3, o.getArrival_city());



			// Execute a statement
			resultSet = statement.executeQuery();

			if(resultSet.next())
			{
				System.out.println("Row Found");
				numberOfCustomers = resultSet.getInt(1);
				capacity = resultSet.getInt(2);
				System.out.println(numberOfCustomers);
				System.out.println(capacity);

			}
			else
			{
				System.out.println("Row not Found");
			}


		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
				statement = null;
			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
		}



		if(numberOfCustomers > 0 && capacity > -1)
		{
			try {
		
				// Establish a connection
				connection = getDriverConnection();
				System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.REMOVE_USER_FROM_FLIGHT);

				statement.setInt(1, --numberOfCustomers);
				statement.setInt(2,o.getFlight_number()); 
				statement.setString(3, o.getDeparted_city());
				statement.setString(4, o.getArrival_city());




				// Execute a statement
				set = statement.executeUpdate();
				
				removeFlightAndUserFromUserFlightDB(o);

				System.out.println("Customer removed");
				System.out.println("New Number of customer " + numberOfCustomers);


			} catch (ClassNotFoundException e) {


				System.out.println(e.getMessage());
			} catch (SQLException e) {



				System.out.println(e.getMessage());
			}
			finally{
				try {
					connection.close();
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			System.out.println("Flight was not found");
		}
	}
	
	private void removeFlightAndUserFromUserFlightDB(VariableObject o)
	{
		// objects needed for connection
				Connection connection = null;
				PreparedStatement statement = null;
				int resultSet;

				try {
				
					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					// Create a statement
					statement = connection.prepareStatement(Query.DELETE_USER_AND_FLIGHT_FROM_USERFLIGHT_DATABASE);

					statement.setInt(1, o.getUserid());
					statement.setInt(2, o.getFlight_number());
				    


					

					// Execute a statement
					resultSet = statement.executeUpdate();
					System.out.println("user and flight deleted from userflight");

				} catch (ClassNotFoundException e) {


					System.out.println(e.getMessage());
				} catch (SQLException e) {



					System.out.println(e.getMessage());
				}	// Close the connection
				finally{
					try {
						connection.close();
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
					}
				}
			

	}

	
	public void updateFlightDB(VariableObject o,int newFlightNum,String newDepartCity,String newDestinationCity)
	{
		
		// objects needed for connection
				Connection connection = null;
				PreparedStatement statement = null;
				int resultSet;
			
				
				try {
				

					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					// Create a statement
					statement = connection.prepareStatement(Query.UPDATE_FLIGHT);

					statement.setInt(1,newFlightNum);
					statement.setString(2, newDepartCity);
					statement.setString(3, newDestinationCity);
					statement.setInt(4,o.getFlight_vo().getFlight_number());
					statement.setString(5, o.getFlight_vo().getDeparted_city());
					statement.setString(6, o.getFlight_vo().getArrival_city());



					// Execute a statement
					resultSet = statement.executeUpdate();
					System.out.println("flight updated");

				} catch (ClassNotFoundException e) {


					System.out.println(e.getMessage());
				} catch (SQLException e) {



					System.out.println(e.getMessage());
				}	// Close the connection
				finally{
					try {
						connection.close();
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
					}
				}

	}


	
/**works*/
	
	public void loginUser(VariableObject o){
		// objects needed for connection
				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet resultSet;
				int rows = 0;



				try {
				
					// Establish a connection
					connection = getDriverConnection();
					System.out.println("Database connected");

					
					for(int i =0;i <2;i++)
					{
					// Create a statement
					statement = connection.prepareStatement(Query.LOGIN_PERSON);


					statement.setString(1, o.getUsername());
					statement.setString(2, o.getPassword());

					// Execute a statement
					resultSet = statement.executeQuery();
					// check the number of rows from sql
					if(i == 0)
					{
						while (resultSet.next())
						{
						rows++;
						}
					
					}
					if(i == 1 && rows == 1)
					{
					while (resultSet.next())
					{
						/* original System.out.println("username: " +resultSet.getString(2) + " password: " +resultSet.getString(3)
						+ " Fname: " + resultSet.getString(4) + " Lname: " + resultSet.getString(5)
						+ " address" + ": " +resultSet.getString(6) + " zip: " + resultSet.getString(7)
						+ " email: " + resultSet.getString(8) + " ssn: " + resultSet.getString(9) 
						+ " Question: " + resultSet.getString(10)+ " answer: " +resultSet.getString(11) 
						+ " admin: " +resultSet.getBoolean(12));*/

						
						System.out.println("start");
						System.out.println("id: " +resultSet.getInt(1) +"username: " +resultSet.getString(7) + " password: " +resultSet.getString(8)
						+ " Fname: " + resultSet.getString(2) + " Lname: " + resultSet.getString(3)
						+ " address" + ": " +resultSet.getString(4) + " state: " + resultSet.getString(5) 
						+ " zip: " + resultSet.getString(6)
						+ " email: " + resultSet.getString(9) + " ssn: " + resultSet.getString(10) 
						+ " Question: " + resultSet.getString(11)+ " answer: " +resultSet.getString(12) 
						+ " admin: " +resultSet.getBoolean(13));
						
					   o.setUserid(resultSet.getInt(1));
					   o.setFirst_name(resultSet.getString(2));
						o.setLast_name(resultSet.getString(3));
						o.setAddress(resultSet.getString(4));
						o.setState(resultSet.getString(5));
						o.setZip(resultSet.getString(6));
						o.setUsername(resultSet.getString(7));
						o.setPassword(resultSet.getString(8));
						o.setEmail(resultSet.getString(9));
						o.setSsn(resultSet.getString(10));
						o.setSecurity_question(resultSet.getString(11));
						o.setQuestion_answer(resultSet.getString(12));
						o.setAdmin(resultSet.getBoolean(13));
						
						System.out.println("done");
					}
					}
					}


				} catch (ClassNotFoundException e) {


					System.out.println(e.getMessage());
				} catch (SQLException e) {



					System.out.println(e.getMessage());
				}
				// Close the connection
				finally{
					try {
						connection.close();
					} catch (SQLException e) {
						
						System.out.println(e.getMessage());
					}
				}
				
		
	}
	
/**works*/
	public String forgotPassword(VariableObject o)
	{
		// objects needed for connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet;
		int rows = 0;



		try {

			// Establish a connection
			connection = getDriverConnection();
			System.out.println("Database connected");


			
			// Create a statement
				statement = connection.prepareStatement(Query.SHOW_SECURITY_QUESTION_AND_GET_ANSWER);


				statement.setString(1, o.getUsername());
				System.out.println(o.getUsername());
				//statement.setString(2, o.getSecurity_question());

				// Execute a statement
				resultSet = statement.executeQuery();
				// check the number of rows from sql
			
					

					while (resultSet.next())
					{
						
						
						System.out.println("Answer: " +resultSet.getString(1));
						
						o.setQuestion_answer(resultSet.getString(1));
						o.setPassword(resultSet.getString(2));
						
						System.out.println(o.getQuestion_answer());
						
						System.out.println("done");
						return o.getQuestion_answer();
					}
				
				
			
			
	} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		// Close the connection
		finally{
			try {
				connection.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
		}


		if(o.getQuestion_answer() != null)
		{
			return o.getQuestion_answer();
		}
		else
		{
			return "Username was not found";
		}

	}

	public Customer getCust() {
		return cust;
	}


	public void setCust(VariableObject o) {
		this.cust = o.getCust_vo();
	}
	
public void getUsersFlightsFromUserFlightDB(VariableObject o){
		
	// objects needed for connection
			Connection connection = null;
			PreparedStatement statement = null;           // first statement ran
			ResultSet resultSet = null;
		



			try {
			

				// Establish a connection
				connection = getDriverConnection();
				System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.GET_USERS_FLIGHTS_FROM_USERFLIGHT); 

				statement.setInt(1, o.getUserid());

				// Execute a statement
				resultSet = statement.executeQuery();
				
				o.removeFlights();

				// Iterate through the result and print the student names
				while (resultSet.next())
				//	System.out.println((resultSet.getInt(1)));
					showUsersFlightsFromFlightDB(o,resultSet.getInt(2));

		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
				statement = null;
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
     
	}
private void showUsersFlightsFromFlightDB(VariableObject o,int flightNum){
	
	// objects needed for connection
			Connection connection = null;
			PreparedStatement statement = null;           // first statement ran
			ResultSet resultSet = null;
			
		



			try {
			

				// Establish a connection
				connection = getDriverConnection();
			//	System.out.println("Database connected");

				// Create a statement
				statement = connection.prepareStatement(Query.GET_USERS_FLIGHTS_INFO_FROM_FLIGHT); 

				statement.setInt(1, flightNum);

				// Execute a statement
				resultSet = statement.executeQuery();

				// Iterate through the result and print the student names
				while (resultSet.next())/*
					System.out.println("Flight# : " +resultSet.getInt(1) + " Departure City: " + resultSet.getString(2) +
							" Departure Day: " + resultSet.getString(4) + " Departure Time: " + resultSet.getString(6)    
							+ " Arrival City: " + resultSet.getString(3) + " Arrival Day: " + resultSet.getString(5)
							+" Arrival Time: " + resultSet.getString(7) +" Customer#: " + resultSet.getInt(8)
							+" Capacity: " + resultSet.getInt(9));*/
				
				
				
				
				// call method to display table view with result set
				//System.out.println(o.getUserid());
				o.addFlights(new Flight(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getString(6),
						resultSet.getString(3),resultSet.getString(5),resultSet.getString(7),resultSet.getInt(8),
						resultSet.getInt(9)));
				
				
			              
				
		} catch (ClassNotFoundException e) {


			System.out.println(e.getMessage());
		} catch (SQLException e) {



			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
				statement = null;
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		
		
     
	}
	
	
		    
		     
// method to check for drivers and start connection
	
	private Connection getDriverConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection = null;
		
		Class.forName(Query.DRIVER);
		
		System.out.println("Driver loaded");
		
		// Establish a connection
		connection = DriverManager.getConnection
				(Query.DATABASE, Query.USERNAME,Query.PASSWORD );
		
	
		return connection;
	}
	
		     
}




		
	



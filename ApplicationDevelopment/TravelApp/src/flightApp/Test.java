package flightApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Backend.Database;


// class to test code outside GUI
public class Test {

	public void run(){
	
		try{
	  //show splash screeen 
		
		// then the menu
		// create a variable to hold the logged in customer or admin
		Person current = null;

		
		
		// run program until user choose to exit	
			
			
		VariableObject v = new VariableObject();
		//2, "Orlando", "Atlanta","1200", "1330"
		/*v.setDeparted_city("Orlando");
		v.setArrival_city("New York");
		v.setDepart_time("1200");
		v.setArrival_time("1500");
		v.setDepartureDay("01/02/2018");
		v.setArrivalDay("01/02/2018");
		v.setFlight_number(6);
		v.setUsername("LL11");
		v.setUserid(0);
		
		 
			v.setUsername("LL11");
	
			v.setSecurity_question("First pet's name?");
			
		*/
		
		v.setUserid(1);
		Database d = new Database(v);
		
		//d.getUsersFlightsFromUserFlightDB(v);
		
		d.showAllFlights(v);
		
		ArrayList<Flight> list = new ArrayList<Flight>();
		
		list = v.getFlights();
		for(int i = 0; i < list.size() ; i++)
		System.out.println(list.get(i).getDeparted_city());
		
		
		

		}
		catch(NullPointerException e)
		{
			System.out.println("Object is " + e.getMessage());
		}
	
	
	
		
		
		
		

	}

	
	// delete following
	/*public Person login() throws SQLException, ClassNotFoundException {
						  
	
		
		
				 Customer cust = null;
				  Connection connection = null;
				  PreparedStatement statement = null;
				  ResultSet resultSet = null;
				  Scanner scan = new Scanner(System.in);*/
				  
			
					/** add try catch */
				/*  try{
				  System.out.println("Enter your username");
				  String username = scan.next();
				  System.out.println("Enter your password");
				  String password = scan.next();
				  
			    // Load the JDBC driver
			    Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Driver loaded");
			
			    // Establish a connection
			    connection = DriverManager.getConnection
			      ("jdbc:mysql://localhost/final?autoReconnect=true&useSSL=false", "root", "");
			    System.out.println("Database connected");
			
			
			
			    
		
			    // check if only one row was pulled
			    
			    
			    // Create a statement
			    statement = connection.prepareStatement("select * from person where username = ? and password = ? ");
			    
			    statement.setString(1,username);
			    statement.setString(2,password);
			    
			    // Execute a statement
			    resultSet = statement.executeQuery();
			  
			    while (resultSet.next())
			    {
				  String userName = resultSet.getString(2);
				   String passwordDb  =resultSet.getString(3);
				   String fname  =resultSet.getString(5);
				   String lname = resultSet.getString(4);
				   String address  =resultSet.getString(6);
						   String zip = resultSet.getString(7);
				   String email  =resultSet.getString(8);
				   String ssn  =resultSet.getString(9);
				   String securityQuestion  =resultSet.getString(10);
				   String answer  =resultSet.getString(11);
				     Boolean admin  =resultSet.getBoolean(12);
			    	
			    System.out.println("UserName : " + username);
			     System.out.println("Password : " +passwordDb);
			     System.out.println("Name : " + lname + "," +fname);
			     System.out.println("Address : " + address+ "," + zip);
			     System.out.println("Email : " +email);
			     System.out.println("SSN : " +ssn);
			     System.out.println("Security Question : " +securityQuestion);
			     System.out.println("Answer : " +answer);
			     System.out.println("Admin : " +admin);
			     
			     cust = new Customer(username,passwordDb,fname,lname,address,zip,email,ssn,securityQuestion,answer,admin);
				    		
			    }
			    
			     
			     
			     
			     
			    
			
			  //if(resultSet.last())
			
			    
			    return cust;
			    
				  }
			    // Close the connection
			    finally{
			 //   connection.close();
			    scan.close();
				//resultSet.close();
				//statement.close();
				cust = null;
			    }
			  }*/
	}



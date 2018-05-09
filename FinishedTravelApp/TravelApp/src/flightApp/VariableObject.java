package flightApp;

import java.util.ArrayList;

public class VariableObject {
	// Flight variables
	private int max_customers;         // max number of customers
	private int num_of_customers;      // number of customers on the flight
	private ArrayList<Customer> cust;  // arraylist to hold all the customers info
	private String departed_city;      // the city the plane leaves
	private String depart_time;        // the day and time the flight begins
	private String arrival_city;        // the arrival_city city
	private String arrival_time;       // the day and time the flight will end
	private int flight_number;      // the flights number
	private String departureDay;       // the day the flight starts
	private String arrivalDay;         // the day the flight ends
	private double price;              // the price of the flight// might need to use bigdecimal for rounding issue
	private ArrayList<Flight> flights = new ArrayList<Flight>();  // arraylist to hold all the customer flights info


	// person variables
	private int userid;         // hold the persons id number
	private String first_name;  // hold the persons first name
	private String last_name;   // hold the persons last name
	private String address;     // hold the persons address
	private String state;       // hold person state
	private String zip;         // hold the person zip code
	private String username;    // hold the persons username 
	private String password;     // hold the persons password
	private String email;         // hold the persons email
	private String ssn;           // hold the persons social security number
	private String security_question;   // hold the persons security question
	private String question_answer;   // hold the persons security questions answer	
	private boolean admin;
	
	// aggregation objects
	private Customer cust_vo;     // used to hold value of a customer
	private Flight flight_vo;     // used to hold value of a flight
	
	// default constructor
	public VariableObject() {
		// TODO Auto-generated constructor stub
	}
	
	// constructor to for flights
	public VariableObject(int num_of_customers, String departed_city, String depart_time, String arrival_city,
			String arrival_time, int flight_number) {
		super();
		this.num_of_customers = num_of_customers;
		this.departed_city = departed_city;
		this.depart_time = depart_time;
		this.arrival_city = arrival_city;
		this.arrival_time = arrival_time;
		this.flight_number = flight_number;
		//this.setFlight_vo(num_of_customers, departed_city, depart_time, arrival_city, arrival_time, flight_number);
	}

	// construtor to make user with autoincremented person id
	public VariableObject(String first_name, String last_name, String address, String zip, String username,
			String password, String email, String ssn, String security_question, String question_answer,
			boolean admin) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.zip = zip;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.security_question = security_question;
		this.question_answer = question_answer;
		this.admin = admin;
		
	}

	// construtor to make user with user entered person id
	public VariableObject(int id,String first_name, String last_name, String address, String zip, String username,
			String password, String email, String ssn, String security_question, String question_answer) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.zip = zip;
		this.username = username;
		this.password = password;
		this.email = email;
		this.ssn = ssn;
		this.security_question = security_question;
		this.question_answer = question_answer;
		this.setCust_vo(first_name, last_name, address, zip, username,
			password, email, ssn, security_question, question_answer);

}
	

	
	

	
	// return the array list of customers inside variable
	public ArrayList<Customer> getCust() {
		return cust;
	}
	// add a customer to the arraylist
	public void addCust(ArrayList<Customer> cust, Customer c) {
		
		cust.add(c);
	}
	// remove a customer from the arraylist
	public void removeCust(ArrayList<Customer> cust, Customer c) {
		
		cust.remove(c);
	}

	
	// return the customer object inside the variable object
	public Customer getCust_vo() {
		return cust_vo;
	}
		
   // set the variables into customer object inside Variable Object
	public void setCust_vo(String first_name, String last_name, String address, String zip, String username,
			String password, String email, String ssn, String security_question, String question_answer) {
		
		this.cust_vo.setFirst_name(first_name);
		this.cust_vo.setLast_name(last_name);
		this.cust_vo.setAddress(address);
		this.cust_vo.setZip(zip);
		this.cust_vo.setUsername(username);
		this.cust_vo.setPassword(password);
		this.cust_vo.setEmail(email);
		this.cust_vo.setSsn(ssn);
		this.cust_vo.setSecurity_question(security_question);
		this.cust_vo.setQuestion_answer(question_answer);
		this.cust_vo.setSecurity_question(security_question);

	}
	// return the flight object in variable object
	public Flight getFlight_vo() {
		return flight_vo;
	}
	
	// set the object flight inside Variable Object
	public void setFlight_vo( int flight_number, String departed_city,String depart_day, String depart_time,
			                                     String arrival_city,String arrival_day, String arrival_time,
			                                     int num_of_customers,int max_customers) {
	
		this.flight_vo.setNum_of_customers(num_of_customers);
		this.flight_vo.setDeparted_city(departed_city); 
		this.flight_vo.setDepart_time(depart_time);
		this.flight_vo.setDepartureDay(depart_day);
		this.flight_vo.setArrival_time(arrival_time);
		this.flight_vo.setArrival_city(arrival_city);
		this.flight_vo.setArrivalDay(arrival_day);
		
		this.flight_vo.setFlight_number(flight_number);
		this.flight_vo.setMax_customers(max_customers);
		System.out.println(flights);
		
	}

	

	
	// regular getters + setters
	public int getMax_customers() {
	return max_customers;
}
	public void setMax_customers(int max_customers) {
	this.max_customers = max_customers;
}
	public int getNum_of_customers() {
		return num_of_customers;
	}
	public void setNum_of_customers(int num_of_customers) {
		this.num_of_customers = num_of_customers;
	}
	public String getDeparted_city() {
		return departed_city;
	}
	public void setDeparted_city(String departed_city) {
		this.departed_city = departed_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int i) {
		this.flight_number = i;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(String question_answer) {
		this.question_answer = question_answer;
	}
	public String getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	public String getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(String arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	


}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights.addAll(flights);
	}
	public void addFlights(Flight flights) {
		this.flights.add(flights);
	}
	public void removeFlights() {
		this.flights.clear();
	}

}
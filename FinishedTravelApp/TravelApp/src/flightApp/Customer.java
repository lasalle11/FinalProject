package flightApp;

import java.util.ArrayList;


public class Customer extends Person {




private ArrayList<Flight> bookedFlights;
 
 public Customer(VariableObject o){
	 
	 
	 super(o);
	 

 }
 
 
 
@Override
 public String toString(Object o){
	 return "The customer is " + getFirst_name()+ " " + getLast_name();
	 
 }
 
 
@Override
 public boolean equals(Object o){
	 
	 if(o instanceof VariableObject)
	 {
		 VariableObject vo = (VariableObject) o;
		 
		 if(vo.getFirst_name() == getFirst_name() && 
				 vo.getLast_name() == getLast_name() && 
				 vo.getSsn() == getSsn())
		 {
			 return true;
		 }
	 }
	
	 return false;
 }
 
 public ArrayList<Flight> getBookedFlights() {
		return bookedFlights;
	}


	public void setBookedFlights(VariableObject o) {
	
		this.bookedFlights.add(o.getFlight_vo());
	
	}
	
	

}

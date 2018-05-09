package flightApp;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
public class Admin extends Customer {
	
	
	
	 public Admin(VariableObject o){
		 
		 
		 super(o);
		 
		 
	 }
	 
	 
	@Override
	 public String toString(Object o){
		 return "The customer is " + getFirst_name()+ " " + getLast_name();
		 
	 }
	 
	 

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
	
		
		

	

	 
	 
}

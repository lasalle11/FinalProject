package flightApp;

import java.util.Random;

public abstract class Plane implements AirCraft {

	
	private int max_customers;   // max number of customer that can fit on our plane
	private int plane_number;    // the serial number of the plane 
	
	public Plane(int max_customers) {
		
		this.max_customers = max_customers;  // set max customer
		Random r = new Random();             // create a random number
		this.setPlane_number(r.nextInt());   // assign the number to plane number
	}

	// return the max number of customers for the plane
	public int getMax_customers() {
		return max_customers;
	}

	// set the max number of customer for the plane
	public void setMax_customers(int max_customers) {
		this.max_customers = max_customers;
	}

	// get the planes serial number
	public int getPlane_number() {
		return plane_number;
	}

	// set the planes serial number
	private void setPlane_number(int plane_number) {
		this.plane_number = plane_number;
	}


}

package flightApp;

public interface AirCraft {

	// methods for aircraft behaivor
	static void ascend(){
		System.out.print("Gaining altitude");
	}
	
	static void descend(){
		System.out.print("Losing altitude");
	}
	
	static void land(){
		System.out.print("Drop landing gear");
	}
	
	
	static void start(){
		System.out.print("Engine Cranking ...");
	}
	
	static void stop(){
		System.out.print("Engine shutting down ...");
	}
	
}

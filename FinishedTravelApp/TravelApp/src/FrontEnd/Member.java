package FrontEnd;
import java.util.ArrayList;

import Backend.Database;
import flightApp.Flight;
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
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
public class Member extends Application {

	Scene scene;
	Button searchFlightBtn,showPurchasedFlightsBtn,purchaseFlightBtn,refundFlightBtn,addFlightDbBtn,removeFlightDbBtn,editFlightDbBtn,backBtn;
	ChoiceBox<String> departCity,departTime,departDay,arrivalCity,arrivalTime,arrivalDay;
	ChoiceBox<Integer> flightNum;   
	
	
	Label departCityTxt = new Label("Depart City"),departTimeTxt  = new Label("Depart Time"),departDayTxt  = new Label("Depart Day"),
			arrivalCityTxt  = new Label("Arrival City"),arrivalTimeTxt  = new Label("Arrival Time"),arrivalDayTxt  = new Label("Arrival Day"),
			flightNumTxt = new Label("Flight Number");
	
	TableView<Flight> table = new TableView<Flight>();
	ArrayList<Flight> list = new ArrayList<Flight>();

	
	
	GridPane pane = new GridPane();
	VariableObject v = new VariableObject();
	Database d = new Database(v);
	
	FrontEnd.Menu m;
	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		v.setAdmin(true);
		v.setFirst_name("LL");
		v.setLast_name("Led");
		v.setUserid(1);

		table.setMaxWidth(1400);
		table.setMinWidth(800);
		
		table.setMaxHeight(1200);
		table.setMinHeight(600);
		
		// flight num column
		TableColumn<Flight,String> flight_numCol = new TableColumn<>("flightnum");
		flight_numCol.setMinWidth(100);
		flight_numCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("flight_number"));

		// flight depart city column
 	TableColumn<Flight,String> depart_cityCol = new TableColumn<>("Depart City");
 	depart_cityCol.setMinWidth(150);
 	depart_cityCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("departed_city"));

		// departDay column
		TableColumn<Flight,String> depart_dayCol = new TableColumn<>("Day");
		depart_dayCol.setMinWidth(150);
		depart_dayCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("departureDay"));

		// depart_time column
		TableColumn<Flight,String> depart_timeCol = new TableColumn<>("Time");
		depart_timeCol.setMinWidth(150);
		depart_timeCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("depart_time"));

		// arrival_city column
		TableColumn<Flight,String> arrival_cityCol = new TableColumn<>("Arrival City");
		arrival_cityCol.setMinWidth(150);
		arrival_cityCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("arrival_city"));

		// arrival_day column
		TableColumn<Flight,String>arrival_dayCol = new TableColumn<>("Day");
		arrival_dayCol.setMinWidth(150);
		arrival_dayCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("arrivalDay"));

		// arrival_time column
		TableColumn<Flight,String> arrival_timeCol = new TableColumn<>("Time");
		arrival_timeCol.setMinWidth(150);
		arrival_timeCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("arrival_time"));

		// num_of_customers column
		TableColumn<Flight,String> num_of_customersCol = new TableColumn<>("Booked Passenagers");
		num_of_customersCol.setMinWidth(150);
		num_of_customersCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("num_of_customers"));

		// max_customers column
		TableColumn<Flight,String> max_customersCol = new TableColumn<>("Max Passenagers");
		max_customersCol.setMinWidth(150);
		max_customersCol.setCellValueFactory(new PropertyValueFactory<Flight,String>("max_customers"));
		
		
		table.setItems(getFlights());
		table.getColumns().addAll(flight_numCol,depart_cityCol,depart_dayCol, depart_timeCol, arrival_cityCol, arrival_dayCol, arrival_timeCol, num_of_customersCol, max_customersCol);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		searchFlightBtn = new Button("Search");
		showPurchasedFlightsBtn  = new Button("Purchased Flight");
		purchaseFlightBtn  = new Button("Buy Flight");
		refundFlightBtn  = new Button("Refund Flight");
		addFlightDbBtn = new Button("Add Flight ");
		removeFlightDbBtn  = new Button("Remove Flight");
		editFlightDbBtn  = new Button("Edit Flight");
		backBtn  = new Button("Back");
		
		departCity = new ChoiceBox<String>();
		departCity.getItems().addAll("Atlanta","Orlando","New York");
		
		departTime  = new ChoiceBox<String>();
		departTime.getItems().addAll("1200","1330","1500");
		
		departDay = new ChoiceBox<String>();
		departDay.getItems().addAll("01/01/2018","01/02/2018","01/03/2018");
		
		
		arrivalCity = new ChoiceBox<String>();
		arrivalCity.getItems().addAll("Atlanta","Orlando","New York");
		
		arrivalTime  = new ChoiceBox<String>();
		arrivalTime.getItems().addAll("1200","1330","1500");
		
		arrivalDay = new ChoiceBox<String>();
		arrivalDay.getItems().addAll("01/01/2018","01/02/2018","01/03/2018");
		
		flightNum = new ChoiceBox<Integer>();
		flightNum.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
	
			
			pane.add(table, 0, 0, 7,7);
			
			
			pane.add(departCityTxt, 0, 8);
			pane.add(departCity, 1, 8, 4, 1);
			//departCity.setValue("Atlanta");
			
			pane.add(arrivalCityTxt, 4,8);
			pane.add(arrivalCity, 5, 8, 4, 1);
			//arrivalCity.setValue("Atlanta");
			
			pane.add(departDayTxt, 0, 9);
			pane.add(departDay, 1, 9, 4, 1);
			//departDay.setValue("01/01/2018");
			
			pane.add(arrivalDayTxt, 4, 9 );
			pane.add(arrivalDay, 5, 9, 4, 1);
			//arrivalDay.setValue("01/01/2018");
			
			pane.add(departTimeTxt, 0, 10);
			pane.add(departTime, 1, 10, 4, 1);		
			//departTime.setValue("1200");
			
			pane.add(arrivalTimeTxt, 4, 10);
			pane.add(arrivalTime, 5, 10, 4, 1);
			//arrivalTime.setValue("1200");
			
			pane.add(flightNumTxt, 4, 11);
			pane.add(flightNum, 5, 11, 4, 1);
			//arrivalTime.setValue("1200");
			
			
			pane.add(searchFlightBtn, 0, 12);
			pane.add(showPurchasedFlightsBtn, 2, 12);
			pane.add(purchaseFlightBtn, 4, 12);
		    pane.add(refundFlightBtn, 6, 12);
		    
		    
		    if(v.isAdmin()){
			pane.add(addFlightDbBtn, 0, 13,1,2);
			pane.add(removeFlightDbBtn, 2, 13,1,2);
		//	pane.add(editFlightDbBtn, 4, 13,1,2);
		    }
			
			
			pane.add(backBtn, 6, 14);
			
			
			scene = new Scene(pane,1300,1400);
			primaryStage.setTitle(v.getFirst_name() + " " + v.getLast_name()+ " flight info");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			

		
			searchFlightBtn.setOnAction(e ->{
			
					showFlights();
				
				
				table.setItems(getFlights());
			});
			
			showPurchasedFlightsBtn.setOnAction(e ->{
				setUserFlights();
				table.setItems(getFlights());
				
			});
			
			purchaseFlightBtn.setOnAction(e ->{
				
				v.setDepartureDay(departDay.getValue());
				v.setDepart_time(departTime.getValue());
				v.setDeparted_city(departCity.getValue());
				
				v.setArrival_city(arrivalCity.getValue());
				v.setArrival_time(arrivalTime.getValue());
				v.setArrivalDay(arrivalDay.getValue());
				v.setFlight_number(flightNum.getValue());

				
				d.addUserToFlightDB(v);
				
				
			});
			
		    refundFlightBtn.setOnAction(e ->{
		    	
		    	v.setDepartureDay(departDay.getValue());
				v.setDepart_time(departTime.getValue());
				v.setDeparted_city(departCity.getValue());
				
				v.setArrival_city(arrivalCity.getValue());
				v.setArrival_time(arrivalTime.getValue());
				v.setArrivalDay(arrivalDay.getValue());
				v.setFlight_number(flightNum.getValue());

				
				d.removeUserFromFlightDB(v);
				
		    });
		    
		    
		  
			addFlightDbBtn.setOnAction(e ->{
				
				v.setDepartureDay(departDay.getValue());
				v.setDepart_time(departTime.getValue());
				v.setDeparted_city(departCity.getValue());
				
				v.setArrival_city(arrivalCity.getValue());
				v.setArrival_time(arrivalTime.getValue());
				v.setArrivalDay(arrivalDay.getValue());
				v.setFlight_number(flightNum.getValue());

			  d.addFlightToDB(v);
			 
				
			});
			
			removeFlightDbBtn.setOnAction(e ->{
				
				v.setDepartureDay(departDay.getValue());
				v.setDepart_time(departTime.getValue());
				v.setDeparted_city(departCity.getValue());
				
				v.setArrival_city(arrivalCity.getValue());
				v.setArrival_time(arrivalTime.getValue());
				v.setArrivalDay(arrivalDay.getValue());
				v.setFlight_number(flightNum.getValue());

				d.deleteFlightDB(v);
				
				
				
			});
		/*	editFlightDbBtn.setOnAction(e ->{
				
				
			});*/
		   
			
			
			backBtn.setOnAction(e ->{
				try{
				FrontEnd.Menu m = new Menu();
				m.start(primaryStage);
				
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}finally{
					m = null;
					
				}
			});
		
		
		
	}
	
	public ObservableList<Flight> getFlights(){
		
		ObservableList<Flight> flight = FXCollections.observableArrayList();
		
		for(int i = 0; i < list.size() ; i++)
		flight.add(new Flight(list.get(i).getFlight_number(),list.get(i).getDeparted_city()
				,list.get(i).getDepartureDay(),list.get(i).getDepart_time(),
				list.get(i).getArrival_city(),list.get(i).getArrivalDay(),list.get(i).getArrival_time()
				,list.get(i).getNum_of_customers(),list.get(i).getMax_customers()));
	
		
		return flight;
		
	}
	/**works*/
	public void showFlights(){
		
		
		d.showAllFlights(v);
		
		
		list = v.getFlights();
	
		//System.out.println(list.get(i).getDeparted_city());
		
		
	}
		
	
	public void setUserFlights()
	{
	
		d.getUsersFlightsFromUserFlightDB(v);
		
		list = v.getFlights();
	}
	public void showPurchasedFlights(){
		setUserFlights();
	}
	public void purchaseFlight(){
		
	}
	public void refundFlight(){
		
	}
	public void addFlight(){
		
	}
	public void removeFlight(){
		
	}
	public void editFlight(){
		
	}
	public void adminView(Stage primaryStage){

		
	}
	public void memberView(){
		
		 
			
			pane.add(table, 0, 0, 7,7);
			
			pane.add(departCity, 0, 8, 3, 1);
			
			pane.add(arrivalCity, 4, 8, 3, 1);
			
			pane.add(departDay, 0, 9, 3, 1);
			
			pane.add(arrivalDay, 4, 9, 3, 1);
			
			pane.add(departTime, 0, 10, 3, 1);		
			
			pane.add(arrivalTime, 4, 10, 3, 1);		
			

			pane.add(searchFlightBtn, 0, 11);
			pane.add(showPurchasedFlightsBtn, 1, 11);
			pane.add(purchaseFlightBtn, 2, 11);
			pane.add(refundFlightBtn, 3, 11);
		
			pane.add(backBtn, 3, 12);
		
		
		

	}

	public static void main(String [] args)
	{
		launch(args);
	}
}

package project3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Javafx UI, takes user information from label;
 * Calculates TripCost with combo box; 
 * It also converts units
 * 
 * <p>
 * Course: CMSC 215
 * <p>
 * Date: 6/25/2024
 * <p>
 * Project: Project 3
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class Project3 extends Application {
	
	 /**
	  * KILOMETERS_PER_MILE constant conversion
	  */
	private final double KILOMETERS_PER_MILE = 1.609347;
	
	 /**
	  * LITERS_PER_GALLON constant conversion
	  */
	private final double LITERS_PER_GALLON = 3.78541178;
	
	 /**
	  * Distance TextField and label, Javafx
	  */
	private final TextField tfDistance = new TextField();
	
	 /**
	  * GasolineCost TextField and label, Javafx
	  */
	private final TextField tfGasolineCost = new TextField();
	
	 /**
	  * GasMileage TextField and label, Javafx
	  */
	private final TextField tfGasMileage = new TextField();
	
	 /**
	  * NumberOfDays TextField and label, Javafx
	  */
	private final TextField tfNumberOfDays = new TextField();
	
	 /**
	  * HotelCost TextField and label, Javafx
	  */
	private final TextField tfHotelCost = new TextField();
	
	 /**
	  * FoodCost TextField and label, Javafx
	  */
	private final TextField tfFoodCost = new TextField();
	
	 /**
	  * Attractions TextField and label, Javafx
	  */
	private final TextField tfAttractions = new TextField();
	
	 /**
	  * TotalTripCost TextField and label, Javafx
	  */
	private final TextField tfTotalTripCost = new TextField();
	
	 /**
	  * Calculate Button and label, Javafx
	  */
	private final Button tfCalculate = new Button("Calculate");
	
	 /**
	  * Distance ComboBox Button 1, Javafx
	  */
	private final ComboBox<String> cbo = new ComboBox<>();
	
	 /**
	  * GasolineCosts ComboBox Button 2, Javafx
	  */
	private final ComboBox<String> cbo2 = new ComboBox<>();
	
	 /**
	  * GasMileage ComboBox Button 3, Javafx
	  */
	private final ComboBox<String> cbo3 = new ComboBox<>();
	
	 /**
	  * Distance ComboBox Button 1 option labels with String [], Javafx
	  */
	private final String[] distanceTitles = {"miles", "kilometers"};
	
	 /**
	  * GasolineCosts ComboBox Button 2 option labels with String [], Javafx
	  */
	private final String[] GasolineCostTitles = {"dollars/liter", "dollars/gallon"};
	
	 /**
	  * GasMileage ComboBox Button 3 option labels with String [], Javafx
	  */
	private final String[] GasMileageTitles = {"kms/liter", "miles/gallon"};
	
	
	/**
     * Javafx UI, creates labels or text fields, combo box, button layout;
     * Calculates TripCost with combo box; Strings [] for combo box choices;
     * It also converts units;
     * 
     * @Override override the start method in Application class
	 *
	 * @throws Exception if the user input is incorrect with not 4 items
	 *                               on one line
	 * @param primaryStage creates the primary stage for the Javafx UI Application
	 */
	@Override
	public void start (Stage primaryStage) throws Exception {
		
		// Set text fields alignment
		tfDistance.setAlignment(Pos.BOTTOM_RIGHT);
		tfGasolineCost.setAlignment(Pos.BOTTOM_RIGHT);
		tfGasMileage.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumberOfDays.setAlignment(Pos.BOTTOM_RIGHT);
		tfHotelCost.setAlignment(Pos.BOTTOM_RIGHT);
		tfFoodCost.setAlignment(Pos.BOTTOM_RIGHT);
		tfAttractions.setAlignment(Pos.BOTTOM_RIGHT);
		tfTotalTripCost.setAlignment(Pos.BOTTOM_RIGHT);
		tfCalculate.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		// Create a grid pane and place all nodes, labels, and buttons into it
		GridPane pane = new GridPane();
		pane.setVgap(3);                // Vertical height
		pane.setHgap(3);                // Horizontal height
		pane.setAlignment(Pos.CENTER);  // Position center
		
		
		// Create Distance
		pane.add(new Label("Distance\t"),0, 0); //x, y; Set up label
		pane.add(tfDistance, 2, 0);             // Set up text field for distance user input
		
		
		// Add Combo box 1 option for Distance
	    pane.add(cbo, 6, 0);
	    cbo.setValue("miles");  // Set default label
	    cbo.setPrefWidth(120);  // Set fixed width size
	    ObservableList<String> items = 
	  	      FXCollections.observableArrayList(distanceTitles);
	  	    cbo.getItems().addAll(items); // Add items to combo box
	  	    
		
	  	// Create Gasoline Cost
		pane.add(new Label("Gasoline Cost\t"), 0, 2);  // Set up label
		pane.add(tfGasolineCost, 2, 2);                // Set up text field for user input
		
		
		// Add Combo box 2 option for Gasoline Cost
	    pane.add(cbo2, 6, 2);
	    cbo2.setPrefWidth(120);         // Set fixed width size
	    cbo2.setValue("dollars/liter"); // Set default label
	    ObservableList<String> items2 = 
		  	      FXCollections.observableArrayList(GasolineCostTitles);
		  	    cbo2.getItems().addAll(items2); // Add items to combo box
		
		  	    
		// Create Gas Mileage 	    
		pane.add(new Label("Gas Mileage\t"), 0, 4);  // Set up label
		pane.add(tfGasMileage, 2, 4);                // Set up text field for user input
		
		
		// Add Combo box 3 option for Gas Mileage
	    pane.add(cbo3, 6, 4);
	    cbo3.setPrefWidth(120);      // Set fixed width size
	    cbo3.setValue("kms/liter");  // Set default label
	    ObservableList<String> items3 = 
		  	      FXCollections.observableArrayList(GasMileageTitles);
		  	    cbo3.getItems().addAll(items3); // Add items to combo box
		
		
		// Create Number of Days
		pane.add(new Label("Number Of Days:\t"), 0, 6);  // Set up label
		pane.add(tfNumberOfDays, 2, 6);                  // Set up text field for user input
		
		// Create Hotel Cost
		pane.add(new Label("Hotel Cost\t"), 0, 8);       // Set up label
		pane.add(tfHotelCost, 2, 8);                     // Set up text field for user input
		
		// Create Food Cost
		pane.add(new Label("Food Cost\t"), 0, 10);       // Set up label
		pane.add(tfFoodCost, 2, 10);                     // Set up text field for user input
		
		// Create Attractions
		pane.add(new Label("Attractions\t"), 0, 12);     // Set up label
		pane.add(tfAttractions, 2, 12);                  // Set up text field for user input
		
		// Create Button
		// Button for calculating TripCost
		pane.add(tfCalculate, 2, 14);                    // Set up button for calculation button
		
		// Create Total Trip Cost
		// For Outputting Total Trip Cost
		pane.add(new Label("Total Trip Cost\t"), 0, 16); // Set up label
		pane.add(tfTotalTripCost, 2, 16);                // Set up text field for calculation output
		
		
		
		/**
		 *  Handles action when the 'miles' combo box is clicked;
		 *  Convert units between miles to kilometers if user would like to;
		 *
		 * @param event The event triggered by clicking the button.
		 */	
		cbo.setOnAction(event -> {
			
		    if (tfDistance.getText().length() > 0) { // User has input
		    	
		    	// Take user input
		        double distance = Double.parseDouble(tfDistance.getText());
		        
		        // If it is miles label, T v. F convert
		        double conversionFactor = cbo.getValue().equals("miles") ? 1.0 / KILOMETERS_PER_MILE : KILOMETERS_PER_MILE;
		        double convertedDistance = distance * conversionFactor;
		        
		        // Format conversion
		        DecimalFormat decimalFormat = new DecimalFormat("#.##"); 
		        String formattedDistance = decimalFormat.format(convertedDistance);
		        
		        // Output Conversion Format
		        tfDistance.setText(String.valueOf(formattedDistance));
		    }
		}); // End combo box 1 action
		
		
		/**
		 *  Handles action when the 'dollars/liter' combo box is clicked;
		 *  Convert units between dollars/liter to dollars/gallon if user would like to;
		 *
		 * @param event The event triggered by clicking the button.
		 */			
		cbo2.setOnAction(event -> {
			
		    if (tfGasolineCost.getText().length() > 0) { // User has input
		    	
		    	// Take user input
		        double gas_costss = Double.parseDouble(tfGasolineCost.getText());
		        
		        // If it is dollars/liter label, T v. F convert
		        double conversionFactor = cbo2.getValue().equals("dollars/liter") ? LITERS_PER_GALLON : 1.0 / LITERS_PER_GALLON;
		        double convertedGasolineCost = gas_costss * conversionFactor;
		        
		        // Format conversion
		        DecimalFormat decimalFormat = new DecimalFormat("#.##"); 
		        String formattedGasolineCost = decimalFormat.format(convertedGasolineCost);
		        
		        // Output Conversion Format
		        tfGasolineCost.setText(String.valueOf(formattedGasolineCost));
		    }
		}); // End combo box 2 action

		
		/**
		 *  Handles action when the 'kms/liter' combo box is clicked;
		 *  Convert units between kms/liter to miles/gallon if user would like to;
		 *
		 * @param event The event triggered by clicking the button.
		 */		
		cbo3.setOnAction(event -> {
			
		    if (tfGasMileage.getText().length() > 0) { // User has input
		    	
		    	// Take user input
		        double gas_mileagess = Double.parseDouble(tfGasMileage.getText());
		        
			    // Another alternative conversion factor (long way) (did not include)
		        //double conversionFactor = cbo3.getValue().equals("kms/liter") ? (235.214584/gas_mileagess)/ gas_mileagess : (235.214584/gas_mileagess)/ gas_mileagess;
		        
		        // If it is kms/liter label, T v. F convert
		        double conversionFactor = cbo3.getValue().equals("kms/liter") ? (1.0/0.425143707) : (0.425143707);
		        double convertedGasMileage = gas_mileagess * conversionFactor;
		        
		        // Format conversion
		        DecimalFormat decimalFormat = new DecimalFormat("#.##"); 
		        String formattedGasMileage = decimalFormat.format(convertedGasMileage);
		           
		        // Output Conversion Format
		        tfGasMileage.setText(String.valueOf(formattedGasMileage));
		    }
		}); // End combo box 3 action

		
		/**
		 *  Handles action when the 'Calculate' button is clicked;
		 *  Calculates the TotalTripCost and outputs it;
		 *  Makes sure no invalid input and creates alerts/pop up for errors
		 *
		 * @param event The event triggered by clicking the button.
		 */
		tfCalculate.setOnAction(event-> {
			
		    /**
		     * Try/catch for calculating TotalTripCost and User Input
		     * 
		     * @throws NumberFormatException if the user input on file is incorrect
		     */
			try {
				
				// Puts user input into variables
				double MAX_NUMBER = 1000000; // Constant Maximum number for the max user input
				double gasoline_costt = Double.parseDouble(tfGasolineCost.getText()); // Takes user input of Gasoline Cost
				double distance = Double.parseDouble(tfDistance.getText());          // Takes user input of Distance
				double gas_mileage = Double.parseDouble(tfGasMileage.getText());     // Takes user input of Gas Mileage
				double hotel_cost = Double.parseDouble(tfHotelCost.getText());       // Takes user input of Hotel Cost
				double food_cost = Double.parseDouble(tfFoodCost.getText());         // Takes user input of Food Cost
				int number_of_days = Integer.parseInt(tfNumberOfDays.getText());     // Takes user input of Number of Days
				double attractions = Double.parseDouble(tfAttractions.getText());    // Takes user input of Attractions
				
		        double newDistance = distance;          // Creates newDistance to make sure it converts if mixed units
		        double newGasolineCost = gasoline_costt; // Creates newGasolineCost to make sure it converts if mixed units
		        double newGasMileage = gas_mileage;     // Creates newGasMileage to make sure it converts if mixed units
				
		        // Checks if there is no user input/empty, it will pop an Alert for Invalid
		        if (tfDistance.getText().isEmpty() || tfGasolineCost.getText().isEmpty()
		        		|| tfDistance.getText().isEmpty() 
		        		|| tfGasMileage.getText().isEmpty()
		        		|| tfHotelCost.getText().isEmpty()
		        		|| tfFoodCost.getText().isEmpty()
		        		|| tfNumberOfDays.getText().isEmpty()
		        		|| tfAttractions.getText().isEmpty()) {
	                // Show a custom popup message here (using a Popup or Alert)
		        		showInvalidInputPopup("Enter valid numbers between: 0 =< Number < 1M and no empty slots.");
	                return; // Exit early if input is invalid
		        }
		        
		        // Checks if Number of Days is not an integer, it will pop an Alert for Invalid
			    if (number_of_days != (int) number_of_days) {
				        // Show an error message using an Alert
				        showInvalidInputPopup("Enter valid numbers between: 0 =< Number < 1M and no empty slots.");
			        return; // Exit early if input is invalid
			    }
			    
			    // Checks if Any inputs have Letters or Symbols, it will pop an Alert for Invalid
				if (tfDistance.getText().matches("[a-zA-Z\\s]*") || tfGasolineCost.getText().matches("[a-zA-Z\\s]*") 
		        		|| tfDistance.getText().matches("[a-zA-Z\\s]*") 
		        		|| tfGasMileage.getText().matches("[a-zA-Z\\s]*")
		        		|| tfHotelCost.getText().matches("[a-zA-Z\\s]*")
		        		|| tfFoodCost.getText().matches("[a-zA-Z\\s]*")
		        		|| tfNumberOfDays.getText().matches("[a-zA-Z\\s]*")
		        		|| tfAttractions.getText().matches("[a-zA-Z\\s]*")) {
	                // Show a custom popup message here (using a Popup or Alert)
	                return; // Exit early if input is invalid
	            }
				
				// Checks if Any inputs are greater than Max input or not positive, it will pop an Alert for Invalid
				if ((gasoline_costt > MAX_NUMBER || gasoline_costt <= -1) || (distance > MAX_NUMBER || distance <= -1)) {
	                // Show a custom popup message here (e.g., using a Popup or Alert)
					showInvalidInputPopup("Enter valid numbers between: 0 =< Number < 1M and no empty slots.");
	                return; // Exit early if input is invalid
				}
				else if ((gas_mileage > MAX_NUMBER || gas_mileage <= -1)
		        		|| (hotel_cost > MAX_NUMBER || hotel_cost <= -1)
		        		|| (food_cost > MAX_NUMBER || food_cost <= -1)
		        		|| (number_of_days > MAX_NUMBER || number_of_days <= -1)
		        		|| (attractions > MAX_NUMBER || attractions <= -1)) {
	                // Show a custom popup message here (e.g., using a Popup or Alert)
					showInvalidInputPopup("Enter valid numbers between: 0 =< Number < 1M and no empty slots.");
	                return; // Exit early if input is invalid
	            }
			
			//Converts units for a mix of imperial v. metric
			if(cbo.getValue().equals("miles") && (cbo2.getValue().equals("dollars/liter"))&& (cbo3.getValue().equals("kms/liter"))) {
				newDistance = distance * KILOMETERS_PER_MILE; // Converts miles to kilometers
			}
			else if(cbo.getValue().equals("kilometers") && (cbo2.getValue().equals("dollars/gallon"))&& (cbo3.getValue().equals("miles/gallon"))) {
				newDistance = distance / KILOMETERS_PER_MILE;  // Converts kilometers to miles
			}
			else if(cbo.getValue().equals("miles") && (cbo2.getValue().equals("dollars/gallon"))&& (cbo3.getValue().equals("kms/liter"))) {
				newGasMileage = gas_mileage / 0.425143707;   // Converts kms/liter to miles/gallon
			}
			else if(cbo.getValue().equals("kilometers") && (cbo2.getValue().equals("dollars/liter"))&& (cbo3.getValue().equals("miles/gallon"))) {
				newGasMileage = gas_mileage * 0.425143707; // Converts miles/gallon to kms/liter
			}
			else if(cbo.getValue().equals("miles") && (cbo2.getValue().equals("dollars/liter"))&& (cbo3.getValue().equals("miles/gallon"))) {
				newGasolineCost = gasoline_costt * LITERS_PER_GALLON; // Converts dollars/liter to dollars/gallon
			}
			else if(cbo.getValue().equals("kilometers") && (cbo2.getValue().equals("dollars/gallon"))&& (cbo3.getValue().equals("kms/liter"))) {
				newGasolineCost = gasoline_costt / LITERS_PER_GALLON; // Converts dollars/gallon to dollars/liter
			}
			
			// Calls in the TripCost class with constructor and sends in object to find calculation
		    TripCost trip = new TripCost(newGasolineCost, newDistance, newGasMileage, hotel_cost, food_cost, number_of_days, attractions);
		    double totalTripCost = trip.getTotalTripCost();  // Gets the value of the calculation
		    	
		        // Check if totalTripCost is NaN or zero; set to zero
			    if (Double.isNaN(totalTripCost) || totalTripCost == 0.0) {
			        tfTotalTripCost.setText("$0.00"); // Set to zero
			    }
			    else {
				    // Format and set the total trip cost in the text field
				    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
				    currencyFormatter.setMinimumFractionDigits(2);
				    String formattedTotalTripCost = currencyFormatter.format(totalTripCost);
				    
				    // Show the output to $#.## Format.
				    tfTotalTripCost.setText(formattedTotalTripCost);
			    } // End if/else
			    
			} catch (NumberFormatException e) {
	            // Handle invalid input (pop up an error)
	            showInvalidInputPopup("Enter valid numbers between: 0 =< Number < 1M, integers for number of days, and no empty slots.");
	        } // End try/catch
			
	    }); // End Calculate button action
		
		
		// Output the application, scene, pane, and primary stage
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 400);      // Set the scene width and height
		primaryStage.setTitle("Trip Cost Estimator"); // Set the stage title
		primaryStage.setScene(scene);                 // Place the scene in the stage
		primaryStage.show();                          // Display the stage / application
	} // End start method for Javafx Application
	
	/**
     * Javafx UI; Creates alerts; Error/Invalid input message into a pop up Alert;
	 *
	 * @param message the error/invalid input alert message for the Javafx UI Application
	 */
	private void showInvalidInputPopup(String message) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Error: Invalid Input");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	} // End showInvalidInputPopup for alert message
	
} // End Project3 class
	


package project4;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Javafx UI, takes user information from label;
 * Compares Time Intervals and Checks Time
 * 
 * <p>
 * Course: CMSC 215
 * <p>
 * Date: 7/9/2024
 * <p>
 * Project: Project 4
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class Project4 extends Application {
	
	 /**
	  * Start of Time Interval 2 TextField and label, Javafx
	  */
	private final TextField tfStartTimeInterval1 = new TextField();
	
	 /**
	  * End of Time Interval 1 TextField and label, Javafx
	  */
	private final TextField tfEndTimeInterval1 = new TextField();
	
	 /**
	  * Start of Time Interval 2 TextField and label, Javafx
	  */
	private final TextField tfStartTimeInterval2 = new TextField();
	
	 /**
	  * End of Time Interval 2 TextField and label, Javafx
	  */
	private final TextField tfEndTimeInterval2 = new TextField();
	
	 /**
	  * Time To Check TextField and label, Javafx
	  */
	private final TextField tfTimeToCheck = new TextField();
	
	 /**
	  * TimeToOverlap TextField and label, Javafx
	  */
	private final TextField tfTimeToOverlap = new TextField();
	
	 /**
	  * Compare Intervals Button and label, Javafx
	  */
	private final Button tfCompareIntervalsButton = new Button("Compare Intervals");
	
	 /**
	  * Check Time Button and label, Javafx
	  */
	private final Button tfCheckTimeButton = new Button("Check Time");
    
	/**
     * Javafx UI, creates labels or text fields, combo box, button layout;
     * Compares Intervals and Checks Time with Buttons
     * 
     * @Override override the start method in Application class
	 *
	 * @throws Exception if the user input is incorrect with invalid inputs
	 * @param primaryStage creates the primary stage for the Javafx UI Application
	 */
	@Override
	public void start (Stage primaryStage) throws Exception {
		
		
		// Set text fields alignment
		tfStartTimeInterval1.setAlignment(Pos.CENTER);
		tfEndTimeInterval1.setAlignment(Pos.CENTER);
		tfStartTimeInterval2.setAlignment(Pos.CENTER);
		tfEndTimeInterval2.setAlignment(Pos.CENTER);
		tfCompareIntervalsButton.setAlignment(Pos.CENTER);
		tfTimeToCheck.setAlignment(Pos.CENTER);
		tfCheckTimeButton.setAlignment(Pos.CENTER);
		tfTimeToOverlap.setAlignment(Pos.BOTTOM_LEFT);
		
		
		// Create a grid pane and place all nodes, labels, and buttons into it
		GridPane pane = new GridPane();
		pane.setVgap(3);                // Vertical height
		pane.setHgap(3);                // Horizontal height
		pane.setAlignment(Pos.CENTER);  // Position center
		
		
		// Create Start Time Label and Interval 1
		pane.add(new Label("Start Time\t"),1, 0);         //x, y; Set up label
		pane.add(tfStartTimeInterval1, 1, 1);             // Set up text field for distance user input
		 
	  	// Create End Time Label and Interval 1
		pane.add(new Label("End Time\t"), 2, 0);          // Set up label
		pane.add(tfEndTimeInterval1, 2, 1);               // Set up text field for user input
		
		// Create Time Interval 1; row 1    
		pane.add(new Label("Time Interval 1\t"), 0, 1);   // Set up label
		pane.add(tfStartTimeInterval2, 1, 2);             // Set up text field for user input
		
		// Create Time Interval 2; row 2
		pane.add(new Label("Time Interval 2\t"), 0, 2);   // Set up label
		pane.add(tfEndTimeInterval2, 2, 2);               // Set up text field for user input
		
		// Create Compare Intervals Button
		// Button for comparing intervals
		pane.add(tfCompareIntervalsButton, 1, 3);    
		
		pane.add(new Label("Time to Check\t"), 0, 4);     // Set up label
		pane.add(tfTimeToCheck, 1, 4);                    // Set up text field for user input
		
		// Create Check Time Button
		// Button for Time to Check: TimeToOverlap Button
		pane.add(tfCheckTimeButton, 1, 5);                // Set up button for calculation button
		
		// Create TimeToOverlap
		// For Outputting if intervals overlap
		pane.add(tfTimeToOverlap, 1, 6);                 // Set up text field for calculation output
		
		
		/**
		 *  Handles action when the 'Compare Intervals' button is clicked;
		 *  Compares Intervals
		 *  Makes sure no invalid input and creates alerts/pop up for errors
		 *
		 * @param event The event triggered by clicking the button.
		 */
		tfCompareIntervalsButton.setOnAction(event-> {
			
				// Puts user input into variables
				String eT1 = tfEndTimeInterval1.getText();
				String sT1  = tfStartTimeInterval1.getText();
				String eT2 = tfEndTimeInterval2.getText();
				String sT2  = tfStartTimeInterval2.getText();
				
			    /**
			     * Try/catch for comparing intervals from user input
			     * 
			     * @throws InvalidTime if the user input is incorrect
			     */
				try {
					
				// Convert user input variables passing into time to create object
			    Time endTimeInterval1 = new Time(eT1);
			    Time startTimeInterval1 = new Time(sT1);
			    Time endTimeInterval2 = new Time(eT2);
			    Time startTimeInterval2 = new Time(sT2);
			    
			    //Alternative method... Testing here..
				/*Time endTimeInterval1 = parseUserInput(eT1);
				Time startTimeInterval1  = parseUserInput(sT1);
				Time endTimeInterval2 = parseUserInput(eT2);
				Time startTimeInterval2  = parseUserInput(sT2);*/

			
	        // Creates objects; Initialize intervals and current time
	        Interval<Time>interval1 = new Interval<>(startTimeInterval1, endTimeInterval1);
	        Interval<Time>interval2 = new Interval<>(startTimeInterval2, endTimeInterval2);

	        // Checks if it is subinterval, overlap, or disjoint.
	        if (interval1.subinterval(interval2)) {
	        	tfTimeToOverlap.setText("Interval 2 is a sub-interval of interval 1");
	        } else if (interval2.subinterval(interval1)) {
	        	tfTimeToOverlap.setText("Interval 1 is a sub-interval of interval 2");
	        } else if (interval1.overlaps(interval2)) {
	        	tfTimeToOverlap.setText("The intervals overlap");
	        } else if (interval2.overlaps(interval1)) {
	        	tfTimeToOverlap.setText("The intervals overlap");
	        }
	        else {
	        	tfTimeToOverlap.setText("The intervals are disjoint");
	        }
	        
	        	//catches the error and grabs the message format of InvalidTime
				}catch (InvalidTime e) {
				    Alert alert = new Alert(AlertType.ERROR);
				    alert.setTitle("Error: Invalid Input");
				    alert.setHeaderText(null);
				    alert.setContentText("Error: " + e.getMessage());
				    alert.showAndWait();
				} // End try/catch
			
	    }); // End Compare button

		
		/**
		 *  Handles action when the 'Check Time' button is clicked;
		 *  Checks Time and outputs if the intervals overlaps
		 *  Makes sure no invalid input and creates alerts/pop up for errors
		 *
		 * @param event The event triggered by clicking the button.
		 */
		tfCheckTimeButton.setOnAction(event-> {
		
				// Puts user input into variables
				String t2C = tfTimeToCheck.getText();
				String eT1 = tfEndTimeInterval1.getText();
				String sT1  = tfStartTimeInterval1.getText();
				String eT2 = tfEndTimeInterval2.getText();
				String sT2  = tfStartTimeInterval2.getText();
				
			    /**
			     * Try/catch for comparing intervals from user input
			     * 
			     * @throws InvalidTime if the user input is incorrect
			     */
				try {
					
				// Convert user input variables passing into time to create object
				Time timeToCheck = new Time(t2C);
		        Time endTimeInterval1 = new Time(eT1);
		        Time startTimeInterval1 = new Time(sT1);
		        Time endTimeInterval2 = new Time(eT2);
		        Time startTimeInterval2 = new Time(sT2);
		          
		       //Alternative method... Testing here..
				/*Time timeToCheck = parseUserInput(t2C);
				Time endTimeInterval1 = parseUserInput(eT1);
				Time startTimeInterval1  = parseUserInput(sT1);
				Time endTimeInterval2 = parseUserInput(eT2);
				Time startTimeInterval2  = parseUserInput(sT2); */

				// Creates objects; Initialize intervals and current time
		        Interval<Time>interval1 = new Interval<>(startTimeInterval1, endTimeInterval1);
		        Interval<Time>interval2 = new Interval<>(startTimeInterval2, endTimeInterval2);
		        Interval<Time>currentTime = new Interval<>(timeToCheck, timeToCheck);

		        // Checks if it is both intervals, interval 1, interval 2, or neither intervals
		        if (interval1.within(currentTime) && interval2.within(currentTime)) {
		        	tfTimeToOverlap.setText("Both intervals contain the time " + timeToCheck.toString());
		        } else if (interval1.within(currentTime)) {
		        	tfTimeToOverlap.setText("Only interval 1 contains the time " + timeToCheck.toString());
		        } else if (interval2.within(currentTime)) {
		        	tfTimeToOverlap.setText("Only interval 2 contains the time " + timeToCheck.toString());
		        }
		        else {
		        	tfTimeToOverlap.setText("Neither interval contains the time " + timeToCheck.toString());
		        }
		        
		        //catches the error and grabs the message format of InvalidTime
				}catch (InvalidTime e) {
				    Alert alert = new Alert(AlertType.ERROR);
				    alert.setTitle("Error: Invalid Input");
				    alert.setHeaderText(null);
				    alert.setContentText("Error: " + e.getMessage());
				    alert.showAndWait();
				} // End try/catch
		        
		}); // End Check Time Button
		
		
		// Output the application, scene, pane, and primary stage
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 250);      // Set the scene width and height
		primaryStage.setTitle("Time Interval Checker"); // Set the stage title
		primaryStage.setScene(scene);                 // Place the scene in the stage
		primaryStage.show();                          // Display the stage / application
	} // End start method for Javafx Application
    
	
} // End Project4 class
	


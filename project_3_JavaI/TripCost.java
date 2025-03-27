package project3;


/**
 * Immutable class to create TripCost object through Project3;
 * Takes user information from label;
 * Calculates TripCost with combo box;
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
public final class TripCost extends Project3 {
	
	   /**
	    * Gas Cost double value of user input in Javafx
	    */
	   private final double gas_costs;
	   
	   /**
		* Distance double value of user input in Javafx
		*/
	   private final double distance;
	   
	   /**
		* Gas Mileage double value of user input in Javafx
		*/
	   private final double gas_mileage;
	   
	   /**
		* Hotel Cost double value of user input in Javafx
		*/
	   private final double hotel_cost;
	   
	   /**
		* Food Cost of double value of user input in Javafx
		*/
	   private final double food_cost;
	   
	   /**
		* Number of Days integer value of user input in Javafx
		*/
	   private final int number_of_days;
	   
	   /**
		* Attractions value double of user input in Javafx
		*/
	   private final double attractions;
	   
	   
		/**
		 * Constructs TripCost object by user input in Javafx labels / text field
		 *
		 * @param gas_costs           Double gas costs value number from user
		 * @param distance            Double distance value number from user
		 * @param gas_mileage         Double gas mileage value number from user
		 * @param hotel_cost          Double hotel cost value number from user
		 * @param food_cost           Double food cost value number from user
		 * @param number_of_days      Integer number of days value number from user
		 * @param attractions         Double attractions value number from user
		 */
	   public TripCost(double gas_costs, double distance, double gas_mileage, double hotel_cost, double food_cost, int number_of_days, double attractions) {
	       this.gas_costs = gas_costs;
	       this.distance = distance;
	       this.gas_mileage = gas_mileage;
	       this.hotel_cost = hotel_cost;
	       this.food_cost = food_cost;
	       this.number_of_days = number_of_days;
	       this.attractions = attractions;
	   }
	   
	   
		/**
		 * double getTotalTripCost() for TripCost Object; 
		 * Calculate total trip cost based on total gasoline cost and formula given with user input
		 * Formula: gasoline cost = ((distance/gas_mileage) * (gas_costs));
		 * Formula: total trip cost = ((gasoline_cost) + (hotel_cost + food_cost) * (number_of_days) + (attractions));
		 *
		 * @return total_trip_cost it outputs total trip cost calculation
		 */
	   public double getTotalTripCost() {
		    double gasoline_cost = ((distance/gas_mileage) * (gas_costs));
		    double total_trip_cost = ((gasoline_cost) + (hotel_cost + food_cost) * (number_of_days) + (attractions));
		    return (double) total_trip_cost;
	   }

	}

package project4;

/**
 * Immutable class to create Interval object through Project4;
 * Takes user information from label;
 * Detects if within, subinterval, or overlaps by pressing the button
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
public final class Interval<T extends Comparable<T>> implements Comparable<Interval<T>> {

		   /**
		    * Start T value of user input in Javafx
		    */
		   private final T start;
		   
		   
		   /**
			* End T value of user input in Javafx
			*/
		   private final T end;
		   
		   
			/**
			 * Constructs Interval object by user input in Javafx labels / text field
			 *
			 * @param start         start of interval
			 * @param end           end of interval
			 */	    
		    public Interval(T start, T end) {
		        this.start = start;
		        this.end = end;
		    }
		    
		    // No setter methods; Included Getter only;
		    
			/**
			 * getter of start Interval object
			 *
			 * @return start         returns start of interval
			 */	
		    public T getStart() {
		        return start;
		    }
		    
		    
			/**
			 * getter of end Interval object
			 *
			 * @return end         returns end of interval
			 */	
		    public T getEnd() {
		        return end;
		    }

		    
			/**
			 * Checks if time is within Interval object by user input in Javafx labels / text field
			 *
			 * @param currentTime             currentTime interval object by user input to compare in Javafx
			 * @return startAndEndValues      returns if (other.start) <= 0 || (other.end) >= 0
			 */	  
		    public boolean within(Interval<T> currentTime) {
		    	return start.compareTo(currentTime.start) <= 0 || end.compareTo(currentTime.end) >= 0;
		    }
		    
		    
			/**
			 * Checks if time is subinterval of Interval object by user input in Javafx labels / text field
			 *
			 * @param other                   interval object by user input to compare in Javafx
			 * @return startAndEndValues      returns if (other.start) <= 0 && (other.end) >= 0
			 */	  
		    public boolean subinterval(Interval<T> other) {
		    	return start.compareTo(other.start) <= 0 && end.compareTo(other.end) >= 0;
		    }
		    
		    
			/**
			 * Checks if time overlaps Interval object by user input in Javafx labels / text field
			 *
			 * @param other                   interval object by user input to compare in Javafx
			 * @return startAndEndValues      returns if (other.start) <= 0 || (other.end) >= 0
			 */	  
		    public boolean overlaps(Interval<T> other) {
		    	//Other Testing alternatives:
		    		//return start.compareTo(other.end) <= 0 || end.compareTo(other.start) >= 0;
		    		//return (start.compareTo(other.end) < 0) && (end.compareTo(other.start) > 0);

		    	if((start.compareTo(other.end) < 0) || (end.compareTo(other.start) > 0)) {
		    		return (start.compareTo(other.end) < 0) && (end.compareTo(other.start) > 0);
		    	}
		    	else {
		    		return start.compareTo(other.start) < 0 || end.compareTo(other.end) > 0;
		    	}
		    }
		    
		    
			/**
			 * Override CompareTo to compare Interval objects (start;end) by user input in Javafx labels / text field
			 *
			 * @param other                   interval object by user input to compare in Javafx
			 * @return startAndEndValues      returns if (other.start) or (other.end) if it meets the conditions
			 */	  
		    @Override
		    public int compareTo(Interval<T> other) {
		    	//return start.compareTo(other.start);
		        // Compare based on start times
		        int startComparison = start.compareTo(other.start);
		        
		        if (startComparison != 0) {
		            // If start times are different, return the result of start comparison
		            return startComparison;
		        } else {
		            // If start times are equal, compare based on end times
		            return end.compareTo(other.end);
		        }
		    }	 
		    
} // End Interval class


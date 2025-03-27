package project4;

/**
 * Immutable class to create a Time Interval object;
 * Takes user information from label passes into time to check;
 * Parse the string and split it into Hours, Minutes, and Meridian.
 * When comparing, converts it to minutes/24 hour format;
 * Prints HH:MM AM/PM through toString();
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
public final class Time implements Comparable<Time> {
	
	
	   /**
	    * Variable hours in integer format
	    */
	    private final int hours;
	    
	    
		 /**
		  * Variable minutes in integer format
		  */
	    private final int minutes;
	    
	    
		 /**
		  * Variable meridian in string format
		  */
	    private final String meridian;
	    
	    
	    /**
		 * Constructs Time with the comparable Time
		 *
		 * @param hours           integer parse the user inputs of HH for hours
		 * @param minutes         integer parse the user inputs of MM for minutes
		 * @param meridian        string parse the user inputs of AM/PM for meridian
		 */
	    public Time(int hours, int minutes, String meridian) throws InvalidTime {
	        validateHoursAndMinutes(hours, minutes);
	        validateMeridian(meridian);
	        this.hours = hours;
	        this.minutes = minutes;
	        this.meridian = meridian;
	    }
	    
	    


		/**
	     * Constructor checks the Time parseUserInput for the try with this Time class.
	     * It splits it into HH:MM AM/PM into HH, MM, AM/PM without : and spaces; Checks meridian
	     * Error/Invalid input message into a pop up Alert;
	     * Throws InvalidTime message
		 *
		 * @param timeString      the error/invalid input alert message for the Javafx UI Application
		 * @return 
		 * @throws InvalidTime    error get message from the InvalidTime.
		 */
	    public Time(String timeString) throws InvalidTime {
	        String[] parts = timeString.split(" ");
	        if (parts.length != 2) {
	            throw new InvalidTime("Time format must be HH:MM AM/PM");
	        }
	        String[] timeParts = parts[0].split(":");
	        int parsedHours;
	        int parsedMinutes;
	        validateMeridian(parts[1].toUpperCase());
	        try {
	            parsedHours = Integer.parseInt(timeParts[0]);
	            parsedMinutes = Integer.parseInt(timeParts[1]);
	        } catch (NumberFormatException e) {
	            throw new InvalidTime("Time format must be HH:MM AM/PM");
	        }
	        validateHoursAndMinutes(parsedHours, parsedMinutes);
	        this.hours = parsedHours;
	        this.minutes = parsedMinutes;
	        this.meridian = parts[1].toUpperCase();  
	    }	   
	    
	    
		/**
	     * Validate hours and minutes for the try and object passed into Time;
	     * Error/Invalid input message into a pop up Alert;
	     * Throws InvalidTime message
		 *
		 * @param hours    checks if the hours are within 1-12
		 * @param minutes  checks if the minutes are within 0-60
		 * @throws InvalidTime    error get message from the InvalidTime.
		 */
	    private void validateHoursAndMinutes(int hours, int minutes) throws InvalidTime {
	        if (hours < 0 || hours > 12 || minutes < 0 || minutes >= 60) {
	            throw new InvalidTime("Hours (1-12) and minutes (0-60) must be within valid range.");
	        }
	        if (hours == 0 && minutes == 0) {
	            throw new InvalidTime("Hours (1-12) and minutes (0-60) must be within valid range.");
	        }
	    }
	    
	    
		/**
	     * Validate meridian for the try and object passed into Time;
	     * Error/Invalid input message into a pop up Alert;
	     * Throws InvalidTime message
		 *
		 * @param meridian2    checks if meridian is only am/pm either upper or lowercase
		 * @throws InvalidTime    error get message from the InvalidTime.
		 */
	    private void validateMeridian(String meridian) throws InvalidTime {
	        if (!meridian.equals("AM") && !meridian.equals("PM")) {
	            throw new InvalidTime("Time format must be HH:MM AM/PM");
	        }
	    }

	    
		/**
		 * Override CompareTo to compare Interval objects (start;end) by user input
		 * This shares another method of CompareTo in Interval class to compare intervals;
		 * Compares by total minutes and converts it to 24 hour format
		 *
		 * @param other                   interval object by user input to compare in Javafx
		 * @return startAndEndValues      returns if (other.start) or (other.end) if it meets the conditions
		 */	 
	    @Override
	    public int compareTo(Time other) {
	        // Compare based on total minutes (convert to 24-hour format)
	        int thisTotalMinutes = (hours % 12) * 60 + minutes;
	        int otherTotalMinutes = (other.hours % 12) * 60 + other.minutes;
	        return Integer.compare(thisTotalMinutes, otherTotalMinutes);
	    }

	    
		/**
		 * Override String toString print out the format HH:MM AM/PM when called.
		 *
		 * @param other                   interval object by user input to compare in Javafx
		 * @return hhMMamPM               returns in the format of HH:MM AM/PM when printed out
		 */	 
	    @Override
	    public String toString() {
	        int displayHours = hours % 12;
	        if (displayHours == 0) {
	            displayHours = 12;
	        }
	        return String.format("%02d:%02d %s", displayHours, minutes, meridian);
	    }
	    
} // End Time class
	

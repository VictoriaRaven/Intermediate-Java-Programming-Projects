package project4;


/**
 * Immutable class to create a message if it is invalid time with InvlaidTime;
 * Takes user information from label passes into time to check;
 * if it is invalid time, passes the message.
 * It should pass the message into the alert/error box pop up.
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
public final class InvalidTime extends Exception {
	
	
    /**
	 * String variable to create the InvalidTime object message
	 */
    private String message = "Time format must be HH:MM AM/PM";
    
    
    /**
	 * Constructs InvalidTime object for message
	 *
	 * @param message         grabs the message here or grabs the message that was thrown in the classes
	 */
    public InvalidTime(String message) {
        this.message = message;
    }
    
    
    /**
	 * Returns the InvalidTime object message
	 *
	 * @return message        returns error message or grabs the message that was thrown in the classes
	 */
    public String getMessage() {
		return message;
    }
    
} // End InvalidTime class



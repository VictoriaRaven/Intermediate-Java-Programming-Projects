package project2;

/**
 * Constructs Student object by information from file; Calculates GPA;
 * Method for a student is eligible for Honor Society 
 * based on the set GPA threshold given;
 * Prints out the Student's information from toString
 * 
 * <p>
 * Course: CMSC 215
 * <p>
 * Date: 6/10/2024
 * <p>
 * Project: Project 2
 *
 * @author Victoria Lee
 *
 * @version JRE17
 */
public class Student {
	
	/**
	 * Name of the student in string format from file for student name
	 */
	protected String name;
	
	/**
	 * CreditHours of the student in Integer format read from file for GPA calculation
	 */
	protected int creditHours;
	
	/**
	 * QualityPoints of the student in Integer format from file for GPA calculation
	 */
	protected int qualityPoints;
	
	/**
	 * Level of the student in String format from file for year of student or degree program
	 */
	protected String level;
	
	/**
	 * Double gpaThreshold of file user manual input/set for the minimum GPA threshold eligibleForHonorSociety
	 */
	protected static double gpaThreshold;
	
	/**
	 * Constructs Student object by information from file with name, creditHours, qualityPoints, and level.
	 *
	 * @param name           String name (for student name)
	 * @param creditHours    Integer creditHours (for GPA calculation)
	 * @param qualityPoints  Integer qualityPoints (for GPA calculation)
	 * @param level          String level (for year of student or degree program)
	 */
	public Student(String name, int creditHours, int qualityPoints, String level){
		this.name = name;
		this.creditHours = creditHours;
		this.qualityPoints = qualityPoints;
		this.level = level;
	}
	
	/**
	 * double calculateGpa() for Student Object; 
	 * GPA calculation based on qualityPoints and creditHours given;
	 * Outputs: GPA: {}
	 *
	 * @return GpaValue it outputs GPA by dividing qualityPoints / creditHours
	 */
	public double calculateGpa() {
		// Calculate the GPA per each student by dividing qualityPoints / creditHours as given in the file
		double gpa = (double) qualityPoints/creditHours;
		// This returning way allows if the GPA is equal to gpaThreshold
		return Math.round(gpa * 100.0) / 100.0; // This way helps to rounds numbers correctly when comparing
	}
	
	/**
	 * Boolean eligibleForHonorSociety for Student Object/Information;
	 * Outputs: True/False
	 *
	 * @return String+BooleanValue it outputs True or False based on GPA and Threshold given
	 */
	public boolean eligibleForHonorSociety() {
		//returns if the calculated GPA is greater than or equal to the gpaThreshold of either 3.64 or 3.59 manually inputed
		return (calculateGpa() >= gpaThreshold);
	}
	
	/**
	 * String toString() for Student Object;
	 * Outputs: Name: {} GPA: {}
	 *
	 * @return String+GpaValue it outputs Student name and GPA from calculateGpa() method and %.2f is for 2 decimal places
	 */
	public String toString() {
		//returns student information in a string
		return "Name: " + name + " GPA " + String.format("%.2f", calculateGpa());
	}
	
	/**
	 * Void method of setGPAThreshold sets up the minimum GPA to be considered
	 * for honor society; User will manually set it through the main function;
	 *
	 * @param threshold it sets the user manually input of the gpaThreshold
	 * for honor society requirements with static double gpaThreshold
	 */
	public static void setGpaThreshold(double threshold) {
		// Sets the minimum GPA threshold for honor = 3.64 or 3.59 as per the sample output from the main in Project2 class.
		// Checks for invalid GPA threshold input (no negative numbers or GPA greater than 5.0)
		if (threshold < 0 || threshold > 5) {
            throw new IllegalArgumentException("GPA threshold cannot be negative or a number greater than 5");
        }
		else {
			gpaThreshold = threshold;
		}
	}
	
}

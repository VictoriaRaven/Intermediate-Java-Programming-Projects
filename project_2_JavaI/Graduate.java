package project2;

/**
 * Extends Student's information from file in this class (imports);
 * Override Method for a student is eligible for Honor Society
 * based on GPA threshold from Student and the program level;
 * Override of toString to prints out Graduates's information
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
public class Graduate extends Student {
	
	/**
	 * String program of file for for program of student such as B.S., M.S., PhD.
	 */
	private String program;  // B.S., M.S., PhD.
	
	/**
	 * Constructs Graduate object by information from file with name, creditHours, qualityPoints, and program;
	 * Imports Student class with Super
	 *
	 * @param name           String name (for student name)
	 * @param creditHours    Integer creditHours (for GPA calculation)
	 * @param qualityPoints  Integer qualityPoints (for GPA calculation)
	 * @param program        String program (for degree program)
	 */
	public Graduate(String name, int creditHours, int qualityPoints, String program) {
		super(name, creditHours, qualityPoints, program);
		this.program = program;
	}
	
	/**
	 * Override with eligibleForHonorSociety;
	 * Outputs: Name: {} Age: {} Program: {};
	 *
	 * @return string+value it outputs graduate information
	 */
	@Override
	public boolean eligibleForHonorSociety() {
		//returns if the calculated GPA is greater than or equal to the gpaThreshold of either 3.64 or 3.59 manually inputed and is in a masters program
		return (calculateGpa() >= gpaThreshold) && ("Masters".equalsIgnoreCase(program));
	}
	
	/**
	 * Override with toString() from Student class;
	 * Outputs: Name: {} GPA: {} Program: {}
	 *
	 * @return string+value it outputs undergraduate information, GPA with calculateGpa() with %.2f is for 2 decimal places, and program with toUpperCase() for all CAPS.
	 */
	@Override
	public String toString() {
		//returns graduate information in a string
		return "Name: " + name + " GPA " + String.format("%.2f", calculateGpa()) + " " + program.toUpperCase();
	}

}

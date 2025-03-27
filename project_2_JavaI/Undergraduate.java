package project2;

/**
 * Extends Student's information from file in this class (imports);
 * Override Method for a student is eligible for Honor Society
 * based on GPA threshold from Student and the Year;
 * Override of toString to prints out Undergraduate's information
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
public class Undergraduate extends Student {
	
	/**
	 * String year of file for for year of student such as Freshman, Sophomore, Junior, or Senior
	 */
	private String year; // Freshman, Sophomore, Junior, or Senior
	
	/**
	 * Constructs Undergraduate object by information from file with name, creditHours, qualityPoints, and year;
	 * Imports Student class with Super
	 *
	 * @param name           String name (for student name)
	 * @param creditHours    Integer creditHours (for GPA calculation)
	 * @param qualityPoints  Integer qualityPoints (for GPA calculation)
	 * @param year           String level (for year of student)
	 */
	public Undergraduate(String name, int creditHours, int qualityPoints, String year) {
		super(name, creditHours, qualityPoints, year);
		this.year = year;	
	}
	
	/**
	 * Override with eligibleForHonorSociety;
	 * Outputs: Name: {} GPA: {} Year: {};
	 *
	 * @return string+value it outputs undergraduate information
	 */
	@Override
	public boolean eligibleForHonorSociety() {
		//returns if the calculated GPA is greater than or equal to the gpaThreshold of either 3.64 or 3.59 manually inputed and is an junior/senior
		return (calculateGpa() >= gpaThreshold) && ("Junior".equalsIgnoreCase(year) || "Senior".equalsIgnoreCase(year));
	}
	
	/**
	 * Override with eligibleForHonorSociety from Student class;
	 * Outputs: Name: {} GPA: {} Year: {};
	 *
	 * @return string+value it outputs undergraduate information, GPA with calculateGpa() with %.2f is for 2 decimal places, and year with toUpperCase() for all CAPS.
	 */
	@Override
	public String toString() {
		//returns undergraduate information in a string
		return "Name: " + name + " GPA " + String.format("%.2f", calculateGpa()) + " " + year.toUpperCase();
	}

}

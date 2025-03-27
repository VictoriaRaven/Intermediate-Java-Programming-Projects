package project2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Takes Student's information from file, separated by an array; 
 * Student object added to an ArrayList based on Undergraduate/Graduate;
 * Calculates GPA for honors and prints out students;
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
public class Project2 {

	/**
	 * Project2 uses Student, Undergraduate, Graduate classes; 
	 * Takes Student's information from file, separated by an array; 
     * Student object added to an ArrayList based on Undergraduate/Graduate;
     * Calculates GPA for honors and prints out students; has try/catch, else for invalid
	 * inputs; It has a try/catch 2x because of 2 different files in ".txt" format
	 *
	 * @throws Exception if the user input is incorrect with not 4 items
	 *                               on one line
	 * @param args the command line arguments for main method
	 */
	 public static void main(String[] args) throws Exception {
		
		// Manually set the GPA threshold for Honor Society eligibility for students.txt (path1)
		// Calling the void setGpaThreshold method from the Student class
	    Student.setGpaThreshold(3.64);
		
	    // Create the ArrayList for students based on the Student class for students.txt (path1)
		ArrayList<Student> students = new ArrayList<>();
		
	    // Create the ArrayList for students based on the Student class for studentsTrek.txt (path2)
	    ArrayList<Student> students2 = new ArrayList<>();
		
		// File paths of both path1 and path2 are in project2 package; project 2 package is in source;
	    // The "src\\project2\\students.txt" & "src\\project2\\studentsTrek.txt" must be in project2 package together
		Path path1 = Paths.get("src\\project2\\students.txt");
		Path path2 = Paths.get("src\\project2\\studentsTrek.txt");
		
		// For repeats of Exception file not found printing
		String fileNotFound = "File Not Found";
		
		// Check if file exists
		if((Files.notExists(path1)) || (Files.notExists(path2))) { // path1 or path 2 not found
			
			if(!(Files.notExists(path1)) && (Files.notExists(path2)) ) {
				// path1 found but path2 not found; print/throw Exception
				System.out.println(fileNotFound);
				throw new Exception("studentsTrek.txt (The system cannot find the file specified)");
			}
			
			else if((Files.notExists(path1)) && (Files.notExists(path2))) {
				// path1 and path2 not found; print/throw Exception
				System.out.println(fileNotFound);
				throw new Exception("students.txt & studentsTrek.txt (The system cannot find the files specified)");
			}
			
			else { // path1 not found but path2 found; print/throw Exception
				System.out.println(fileNotFound);
				throw new Exception("students.txt (The system cannot find the file specified)");
			}
		} // End of 1st "if" statement to check if path1 or path2 exists
		else { // If path1 and path2 is found, try for path1 & then the second try for path2
			
	    /**
	     * Try/catch for file (path1): students.txt; Reads file, creates objects, then prints out the eligible students
	     * 
	     * @throws IoException if the user.dir is invalid
	     * @throws NumberFormatException if the user input on file is incorrect
	     */
	        try(Stream<String> stream = Files.lines(path1)) { // Reads the contents in file of path1; You can change path1 to path2 instead if you want
	        	
	            stream.forEach(line -> { // Reads the contents of path1 per line
	            	
	            	    // Split the line into parts using a comma as the delimiter
	                    String[] nameAndGrades = line.trim().split("\\s+");
	                    
	                    // Line must have four elements: name, grade1, grade2, level
	                    if (nameAndGrades.length == 4) { // Check if there are four elements after splitting
	                    	
	                        String name = nameAndGrades[0]; // name is into a string variable
	                        int grade1 = Integer.parseInt(nameAndGrades[1]); // grade1 is into an integer variable
	                        int grade2 = Integer.parseInt(nameAndGrades[2]); // grade2 is into an integer variable
	                        String level = nameAndGrades[3]; // level is into a string variable
	                        
	                        // Create a new Student object and add it to the list
	                        Student student;
	                        
	                        //Add a new Student based on Undergraduate v. Graduate
	                        if ("Freshmen".equalsIgnoreCase(level) || "Sophmore".equalsIgnoreCase(level) || "Junior".equalsIgnoreCase(level) || "Senior".equalsIgnoreCase(level)) {
	                        	// Add a new Student if it meets the level of Undergraduate
	                        	student = new Undergraduate(name, grade1, grade2, level);
	                            students.add(student);
	                        }
	                        else if("Bachelors".equalsIgnoreCase(level) || "Masters".equalsIgnoreCase(level) || "Doctorate".equalsIgnoreCase(level)) {
	                        	// Add a new Student if it meets the level of Graduate
	                            student = new Graduate(name, grade1, grade2, level);
	                            students.add(student);
	                        }
	                        
	                    } // End of if statement for checking four elements
	                    else { // Throw a NumberFormatException if the line does not have four elements after splitting
	                        System.out.println("Invalid format in '.txt' file: " + line);
	                        throw new StringIndexOutOfBoundsException(line);
	                    }
	            }); // End of reading the contents of path1 per line with stream
	        
	            
	        // Print out the GPA threshold and eligible for Honor Society.
            System.out.println("GPA threshold for membership is " + Student.gpaThreshold);
            System.out.println();
            System.out.println("Student(s) eligible for Honor Society: ");

            // Set up a flag to print out a notification once if no students are eligible for honor society
            boolean foundEligibleStudentNot = false;
            // Print out each student eligible for Honor Society
            for (Student s : students) { // For each s (student) in students ArrayList
                if (s.eligibleForHonorSociety()) { // If true, print out all students eligible and information
                    System.out.println(s);
                    foundEligibleStudentNot = true; // Sends notification to true after for loop
                }
            }
            
            // Catch the flag of no eligible students for honor society
            if (!foundEligibleStudentNot) {
            	System.out.println("No students are eligible for Honor Society.");
            }
			  
        } // End of try for reading file path1
	    catch(IOException | StringIndexOutOfBoundsException | NumberFormatException e) { // Prints out the exceptions
        	System.out.println(System.getProperty("user.dir"));
            throw new IOException("An I/O, String index out of bounds, or number format error occurred: " + e.getMessage());
        } // End of catch for exceptions
        
// You could comment this line and down of Copy of try/catch for path2 instead if you want
// and change path1 to path2 above; and change the threshold from 3.64 to 3.59       
// Add some space/line for printing out next file path which is path2
System.out.println();
        
        
	// Manually set the GPA threshold for Honor Society eligibility for studentsTrek.txt (path2)
    // Calling the void setGpaThreshold method from the Student class
	Student.setGpaThreshold(3.59);
        
    /**
     * Copy of try/catch for file (path2): studentsTrek.txt; Reads file, creates objects, then prints out the eligible students
     * 
     * @throws IoException if the user.dir is invalid
     * @throws NumberFormatException if the user input on file is incorrect
     */
        try(Stream<String> stream = Files.lines(path2)) { // Reads the contents in file of path2
        	
            stream.forEach(line -> { //Reads the contents of path2 per line
            	
            	    // Split the line into parts using a comma as the delimiter
                    String[] nameAndGrades2 = line.trim().split("\\s+");
                    
                    // Line must have four elements: name_2, grade1_2, grade2_2, level_2
                    if (nameAndGrades2.length == 4) { // Check if there are four elements after splitting
                    	
                        String name_2 = nameAndGrades2[0]; // name_2 is into a string variable
                        int grade1_2 = Integer.parseInt(nameAndGrades2[1]); // grade1_2 is into an integer variable
                        int grade2_2 = Integer.parseInt(nameAndGrades2[2]); // grade2_2 is into an integer variable
                        String level_2 = nameAndGrades2[3]; // level_2 is into a string variable
                        
                        // Create a new Student object and add it to the list
                        Student student;
                        
                        // Add a new Student based on Undergraduate v. Graduate
                        if ("Freshmen".equalsIgnoreCase(level_2) || "Sophmore".equalsIgnoreCase(level_2) || "Junior".equalsIgnoreCase(level_2) || "Senior".equalsIgnoreCase(level_2)) {
                        	// Add a new Student if it meets the level of Undergraduate
                        	student = new Undergraduate(name_2, grade1_2, grade2_2, level_2);
                            students2.add(student);
                        }
                        else if("Bachelors".equalsIgnoreCase(level_2) || "Masters".equalsIgnoreCase(level_2) || "Doctorate".equalsIgnoreCase(level_2)) {
                        	// Add a new Student if it meets the level of Graduate
                            student = new Graduate(name_2, grade1_2, grade2_2, level_2);
                            students2.add(student);
                        }
                        
                    } // End of if statement for checking four elements
                    else { // Throw a NumberFormatException if the line does not have four elements after splitting
                        System.out.println("Invalid format in '.txt' file: " + line);
                        throw new StringIndexOutOfBoundsException(line);
                    }
            }); // End of reading the contents of path2 per line with stream
	        
	            
	        // Print out the GPA threshold and eligible for Honor Society.
	        System.out.println("GPA threshold for membership is " + Student.gpaThreshold);
	        System.out.println();
	        System.out.println("Student(s) eligible for Honor Society: ");
	
            // Set up a flag to print out a notification once if no students are eligible for honor society
            boolean foundEligibleStudentNot_2 = false;
	        // Print out each student eligible for Honor Society
	        for (Student s : students2) { // For each s (student) in students2 ArrayList
	            if (s.eligibleForHonorSociety()) { // If true, print out all students eligible and information
	                System.out.println(s);
	                foundEligibleStudentNot_2 = true; // Sends notification to true after for loop
	            }
	        }
	        
            // Catch the flag of no eligible students for honor society
            if (!foundEligibleStudentNot_2) {
            	System.out.println("No students are eligible for Honor Society.");
            }
			  
	    } // End of try for reading file path2
	    catch(IOException | StringIndexOutOfBoundsException | NumberFormatException e) { // Prints out the exceptions
        	System.out.println(System.getProperty("user.dir"));
            throw new IOException("An I/O, String index out of bounds, or number format error occurred: " + e.getMessage());
	    } // End of catch for exceptions
      
	} // End of else for checking file does not exist from the very beginning for both path1 and path2
		
  } // End of main method
} // End of Project2 class

import java.util.ArrayList;

import java.util.*;
import java.io.*;

public class ResultProcessSystem {

	//Constant for file name - do not change.
	private final static String STUDENTS_DATA_FILE_NAME = "students.csv";
	private final static String UNITS_RESULT_DATA_FILE_NAME = "units_result.csv";
	private final static String RESULTS_RELEASE__OUTPUT_FILENAME = "results_release.csv";
	private final static String UNMATCH_UNITS_RESULT_FILENAME = "unmatch_units_result.csv";
	
	//One ArrayList to store both Coursework and Research Student and
	//one Arraylist to store both Unit
	//make use of Polymorphism!
	private static ArrayList<Student> students;
	private static ArrayList<Unit> units;
	
	public static void run() {
		students = new ArrayList<Student>();
		units = new ArrayList<Unit>();
		readInStudentsDataFromCSVFile();
		readInStudentsUnitResultFromCSVFile();
		matchUnitToStudent();
		sortStudentsArrayListByStudentID();
		printStudentArrayListToResultReleaseCSV();
		printUnitsWithNoStudentsMatchToCSV();
	}
	
	private static void readInStudentsDataFromCSVFile() {
		
		try {
			Scanner file = new Scanner(new File(STUDENTS_DATA_FILE_NAME ));
			while(file.hasNextLine()) {
				//TODO: convert each record to a student object
				//add student object to ArrayList students
				file.nextLine();
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Student data file not found");
		}
	}
	
	private static void readInStudentsUnitResultFromCSVFile() {
		try {
			Scanner file = new Scanner(new File(UNITS_RESULT_DATA_FILE_NAME));
			while(file.hasNextLine()) {
				//TODO: convert each record to either a Unit_Coursework
				//or Unit_Research object and add it to ArrayList units.
				file.nextLine();
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println(UNITS_RESULT_DATA_FILE_NAME+" file not found");
		}
	}

	private static void matchUnitToStudent() {
		//TODO: look for each student object unit results in units ArrayList
		//assign the unit into the student object
		//remove the assigned unit from units ArrayList
	}
	
	private static void sortStudentsArrayListByStudentID() {
		//TODO: sort the ArrayList students by Student ID
	}
	
	private static void printStudentArrayListToResultReleaseCSV() {
		
		try {
			PrintWriter pw = new PrintWriter(RESULTS_RELEASE__OUTPUT_FILENAME);
			//TODO: print result_release.csv
			pw.close();
		
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open "+RESULTS_RELEASE__OUTPUT_FILENAME);
		}
	}
	
	private static void printUnitsWithNoStudentsMatchToCSV() {
		try {
			PrintWriter pw = new PrintWriter(UNMATCH_UNITS_RESULT_FILENAME);
			//TODO: print unmatch_units_result.csv
			pw.close();
		
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open "+UNMATCH_UNITS_RESULT_FILENAME);
		}
	}
	
	public static String getStudentsDataFileName() {
		return STUDENTS_DATA_FILE_NAME;
	}

	public static String getUnitsResultDataFileName() {
		return UNITS_RESULT_DATA_FILE_NAME;
	}

	public static String getResultsReleaseOutputFilename() {
		return RESULTS_RELEASE__OUTPUT_FILENAME;
	}

	public static String getUnmatchUnitsResultFilename() {
		return UNMATCH_UNITS_RESULT_FILENAME;
	}

	public static void main(String[] args) {
		run();
	}
}



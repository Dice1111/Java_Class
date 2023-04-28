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

				String line = file.nextLine();
				if(line.equals("")){
                    continue;
                }
				String[] studentData = line.split(",");
				String studentID = studentData[0].trim();
				String firstName = studentData[1].trim();
				String lastName = studentData[2].trim();
				String id = studentData[3].trim();
				if(studentID.equals("C")){
					Student_Coursework student = new Student_Coursework(firstName, lastName, id);
					students.add(student);
				}else if(studentID.equals("R")){
					Student_Research student = new Student_Research(firstName, lastName, id);
					students.add(student);
				}
				
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
				String line = file.nextLine();
				if(line.equals("")){
                    continue;
                }
				
				String[] unitData = line.split(",");
				String studentID = unitData[0].trim();
				
				if(studentID.contains("C")){
					String unitCode = unitData[1].trim();
					double a1 = Double.parseDouble(unitData[2].trim());
					double a2 = Double.parseDouble(unitData[3].trim());
					double exam = Double.parseDouble(unitData[4].trim());
					Unit_Coursework unit = new Unit_Coursework(studentID, unitCode, a1, a2, exam);
					units.add(unit);
				}else if(studentID.contains("R")){
					double proposal = Double.parseDouble(unitData[1].trim());
					double finalDissertation = Double.parseDouble(unitData[2].trim());
					Unit_Research unit = new Unit_Research(studentID, proposal, finalDissertation);
					units.add(unit);
				}				
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println(UNITS_RESULT_DATA_FILE_NAME+" file not found");
		}
	}

	private static void matchUnitToStudent() {
		//TODO: look for each student object unit results in units ArrayList
		//assign the unit into the student object
		//remove the assigned unit from units ArrayList
		for(Student student:students){
			for(int i=0;i<units.size();i++){
				if(student.getId().equals(units.get(i).getStudentID())){
					student.setUnit(units.get(i));
					// System.out.println(student.getId()+units.get(i).getStudentID());
					units.remove(units.get(i));
				}
			}
		}


	}
	
	private static void sortStudentsArrayListByStudentID() {
		//TODO: sort the ArrayList students by Student ID
		boolean swap = true;
		while (swap) {
			swap = false;
		  	for (int i = 1; i < students.size(); i++) {
				Student id1 = students.get(i - 1);
				Student id2 = students.get(i);
				if (id1.studentIDMoreThan(id2)) { 
			  		students.set(i - 1, id2);
			  		students.set(i, id1);
			  		swap = true;
	
				}
		  	}
		}
	}

	
	
	private static void printStudentArrayListToResultReleaseCSV() {
		
		try {
			PrintWriter pw = new PrintWriter(RESULTS_RELEASE__OUTPUT_FILENAME);
			//TODO: print result_release.csv
			for(Student student: students){
				pw.write(student.getCSVString()+"\n");
			}
			pw.close();
		
		}catch(FileNotFoundException ex) {
			System.out.println("Unable to open "+RESULTS_RELEASE__OUTPUT_FILENAME);
		}
	}
	
	private static void printUnitsWithNoStudentsMatchToCSV() {
		try {
			PrintWriter pw = new PrintWriter(UNMATCH_UNITS_RESULT_FILENAME);
			//TODO: print unmatch_units_result.csv
			for(Unit unit:units){
				pw.write(unit.getCSVString()+"\n");
	
			}
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



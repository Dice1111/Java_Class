package Lesson6;

import java.util.*;
import java.io.*;

public class ReadFromCSV {
    public static void main(String[] args) {
        String fileName = "result.csv";
        String outputFileName = "grade.csv";
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            PrintWriter pw = new PrintWriter(outputFileName);
            File file = new File(fileName);
            Scanner reader = new Scanner(file); 
            String header = reader.nextLine().trim(); 
            // System.out.println(header);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                if(line.equals("")){
                    continue;
                }
                String[] data = line.split(",");
                String studentNumber = data[0].trim();
                String firstName = data[1].trim();
                String lastName = data[2].trim();
                double score = Double.parseDouble(data[3].trim());
                // System.out.println(line);
                // System.out.println(studentNumber);
                // System.out.println(firstName);
                // System.out.println(lastName);
                // System.out.println(score);

                Student student = new Student(studentNumber,firstName,lastName,score);
                students.add(student);
            } 
            reader.close();
            for(Student student: students){
                pw.write(student.toCSVString()+"\n");
                
            }

            pw.close();
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        

    }
}

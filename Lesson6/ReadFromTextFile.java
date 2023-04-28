package Lesson6;

import java.io.*;
import java.util.*;


public class ReadFromTextFile {
    public static void main(String[] args) {
       
        String fileName = "fruits1.txt";
        try{
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            int lineCounter=0;
            while(reader.hasNextLine()){
                lineCounter++;
                String line = reader.nextLine();
                System.out.println(line);
            }
            System.out.println(lineCounter);
            reader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

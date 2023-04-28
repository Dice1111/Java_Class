package Lesson6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToTextFile {
    public static void main(String[] args) {
        String fileName = "fruits.txt";
        try{
            PrintWriter pw = new PrintWriter(fileName);

            pw.write("Apple\n");
            pw.write("Orange\n");
            pw.write("Pear\n");

            pw.close();
        }
        catch(FileNotFoundException e){

        }
    }
}

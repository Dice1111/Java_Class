package Lesson6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteToBinFile {
    public static void main(String[] args) {
        char[] characters = {'a','b','c'};
        int[] ints = {1,2,3};

        String fileName = "test.bin";

        try{
            OutputStream opStream= new FileOutputStream(fileName);
            for(char c: characters){
                opStream.write(c);
            }

            for(int i: ints){
                opStream.write(i);
            }

            opStream.close();
        }catch(IOException e){

        }
    }
}

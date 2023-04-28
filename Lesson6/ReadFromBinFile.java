package Lesson6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ReadFromBinFile {

    public static void main(String[] args) {
        String fileName = "test.bin";

        try{
            InputStream iStream= new FileInputStream(fileName);
            boolean carryOnReading = true;
            int counter=0;
            while(carryOnReading){
                int byteRead = iStream.read();
                counter++;
    
                if(byteRead==-1){
                    carryOnReading = false;
                }else{
                    System.out.println(byteRead);
                    if(counter<=3){
                        byte[] bytes = {(byte)byteRead};
                        String str = new String(bytes,Charset.forName("UTF-8"));
                        System.out.println(str);
                    }
                }
            }

            iStream.close();
        }catch(IOException e){
    
        }  
    }
    
}

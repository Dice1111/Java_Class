package Lesson1;

import java.security.DrbgParameters.Reseed;

public class Q10 {
    public static void main(String[] args) {
        char response = getResponse();
        System.out.println(response);
    }

    public static char getResponse(){
        boolean carryOn=true;
        char r =' ';

        while (carryOn){
            r = Helper.getChar("Enter a char (y,n,Y,N):");

            if(r=='y' || r=='n' || r=='Y' || r=='N'){
                carryOn= false;
            }else{
                System.out.println("Invalid");
            }
        }

        return r;
    }
}

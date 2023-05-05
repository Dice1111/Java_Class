import java.io.*;
import java.util.*;
public class CreatePlayersBin {

    public static void createPlayersBin(ArrayList<Player> players){

        try {
            FileOutputStream file = new FileOutputStream("players.bin");
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            for(Player player:players){
                opStream.writeObject(player); 
            }   
            opStream.close(); 
        } catch (IOException e) {
        }
        
    }
    // public static void main(String[] args) {
    //     createPlayer();
    // }
}

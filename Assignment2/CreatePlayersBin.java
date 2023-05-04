import java.io.*;
public class CreatePlayersBin {

    public static void createPlayer(){
        boolean create = true;
        while(create){
            String playerName = Keyboard.readString("Enter Player Name: ");
            String password =  Keyboard.readString("Enter Password: ");
            int chips = Keyboard.readInt("Enter chip amount: ");
            Player player = new Player(playerName,password,chips);
            
            try {
                FileOutputStream file = new FileOutputStream("players.bin");
                ObjectOutputStream opStream = new ObjectOutputStream(file);
                opStream.writeObject(player);     
                opStream.close(); 
            } catch (IOException e) {
            // TODO: handle exception
            }
            create = Keyboard.readBoolean("Do you want to create more player: Y/N");
        }
        
    }
    // public static void main(String[] args) {
    //     createPlayer();
    // }
}

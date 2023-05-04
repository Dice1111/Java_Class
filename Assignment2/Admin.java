import java.util.*;
import java.io.*;
public class Admin {
    private ArrayList<Player>players;
    private final String PLAYERS_FILENAME ="players.bin";
    

    public Admin(){
        players = new ArrayList<Player>();
        loadPlayers();
    }

    public void createPlayer(){
          CreatePlayersBin.createPlayer();    
    }

    public void loadPlayers(){
        try {
            FileInputStream file = new FileInputStream(PLAYERS_FILENAME);
            ObjectInputStream output = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                
                try {
                    Player player = (Player)output.readObject();
                    players.add(player);
                
                } catch (EOFException e) {
                    endOfFile = true;
                    // TODO: handle exception
                }
            }
            output.close();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        
        System.out.println("Players Information loaded");
    }

    private  void displayPlayer(){
        loadPlayers();
        for(Player player:players){
           System.out.println(player.getLoginName()+"\n");
           System.out.println(player.getHashPassword()+"\n");
           System.out.println(player.getChips()+"\n");
        }
    }
    private void updatePlayer(){
        for(Player player : players){
            player.addChips(100);
        }
    }
  
    public void run(){
        displayPlayer();
        createPlayer();
        displayPlayer();
    }
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.run();
       
    }
    
}

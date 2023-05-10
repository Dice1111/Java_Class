import java.util.*;
import java.io.*;
public class Admin extends User{
    private ArrayList<Player>players;
    private final String PLAYERS_FILENAME ="players.bin";
    private final String ADMIN_HASHPASSWORD ="admin.txt";


    public Admin(){
        super("Admin","");
        players = new ArrayList<Player>();
        readAdminPassword();
        loadPlayers();
    }

    public ArrayList<Player> getPlayersArray(){
        return this.players;
    }

    private void createAdminPassword(String password){
        try {
            FileOutputStream file = new FileOutputStream("admin.txt");
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            
            opStream.writeObject(Utility.getHash(password)); 
            readAdminPassword(); 
            System.out.println("Admin password file created.");
            opStream.close(); 
            
        } catch (IOException e) {
            System.out.println("IOException Error.");
        }
    }

    private void readAdminPassword(){
        try {
            FileInputStream file = new FileInputStream(ADMIN_HASHPASSWORD);
            ObjectInputStream output = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile){
                
                try {
                    String password = (String)output.readObject();
                    setHashPassword(password);
                    System.out.println("Admin password loaded.");
                } catch (EOFException e) {
                    endOfFile = true;
                    // TODO: handle exception
                }
            }
            output.close();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
        }catch(FileNotFoundException e){
            System.out.println("No admin password file found! Will create default file.");
            createAdminPassword("password");
            readAdminPassword();
        }catch(IOException e){  
            
        }
    }

    public void createPlayersBin(){

        try {
            FileOutputStream file = new FileOutputStream(PLAYERS_FILENAME);
            ObjectOutputStream opStream = new ObjectOutputStream(file);
            for(Player player:players){
                opStream.writeObject(player); 
                
            }  
            System.out.println("Player info saved."); 
            opStream.close(); 
        } catch (IOException e) {
        }
        
    }

    private void loadPlayers(){
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
                    
                }
            }
            output.close();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found.");
        }catch(FileNotFoundException e){
            System.out.println("Player file not found. Create new Players.");
        }catch(IOException e){
            
        }
    }

    private void getUserOption(){
        String title = "menu";
        String[] menu = {"Create a Player","Delete a Player","View all Players","Issue more Chips to a Player","Reset Player's Password","Change Admin Password","Logout"};
        int option = Keyboard.getUserOption(title,menu);
        switch(option){
            case(1):createPlayer();break;
            case(2):deletePlayer();break;
            case(3):displayPlayer();break;
            case(4):addMoreChips();break;
            case(5):resetPlayerPassword();break;
            case(6):resetAdminPassword();break;
            case(7):return;
            case(0):System.exit(0);
            
        }
        getUserOption();
    }

    private void displayPlayer(){
        System.out.println("PLAYER INFO");
        System.out.println("==============================================================");
        for(Player player:players){
           System.out.println("Player Name: "+player.getLoginName());
           System.out.println("Player Password: "+player.getHashPassword());
           System.out.println("Player Chips: "+player.getChips()+"\n");
        }
    }

    private void addMoreChips(){
        String playerName = Keyboard.readString("Enter Player Name: ");
        for(int i = 0; i<players.size();i++){
            if(playerName.equals(players.get(i).getLoginName())){
                int addChips = Keyboard.readInt("Enter chip amount to add: ");
                players.get(i).addChips(addChips);
                System.out.println("Chips added!\n");
                System.out.println("Player Name: "+players.get(i).getLoginName());
                System.out.println("Player Chips: "+players.get(i).getChips()+"\n");
                createPlayersBin(); 
                break;
                
            }else if(i==players.size()-1){
                System.out.println("Player not found!");
            }
        }
                
    } 

    private void createPlayer(){
        String playerName = Keyboard.readString("Enter Player Name: ");
        for(int i = 0;i<players.size();i++){
            if(playerName.equals(players.get(i).getLoginName())){
                System.out.println("Player already exist!");
                return;
            }
        }
        String password =  Keyboard.readString("Enter Password: ");
        int chips = Keyboard.readInt("Enter chip amount: ");
        Player player = new Player(playerName,password,chips);
        players.add(player);
        System.out.println("Player created!");
        createPlayersBin();  
        displayPlayer(); 
    }

    private void deletePlayer(){
        String playerName = Keyboard.readString("Enter Player Name: ");
        for(int i = 0; i<players.size();i++){
            if(playerName.equals(players.get(i).getLoginName())){
                players.remove(i);
                System.out.println("Player Deleted.");
                createPlayersBin(); 
                break;
            }else if(i==players.size()-1){
                System.out.println("Player not found!");
            }
        }
        
    }

    private void resetPlayerPassword(){
        String playerName = Keyboard.readString("Enter Player Name: ");
        for(int i = 0; i<players.size();i++){
            if(playerName.equals(players.get(i).getLoginName())){
                String resetPassword = Keyboard.readString("Enter reset password: ");
                players.get(i).setHashPassword(Utility.getHash(resetPassword));
                createPlayersBin();
                System.out.println("Password Reset!\n");
                System.out.println("Player Name: "+players.get(i).getLoginName());
                System.out.println("Player New Password: "+players.get(i).getHashPassword()+"\n");
                break;
            }else if(i==players.size()-1){
                System.out.println("Player not found!");
            }
        }
                
    }

    private void resetAdminPassword(){
        String password = Keyboard.readString("Enter Admin Password to Confirm: ");
        if(Utility.getHash(password).equals(this.getHashPassword())){
            System.out.println("Password Confirmed.");
            String newPassword = Keyboard.readString("Enter new Password: ");
            this.createAdminPassword(newPassword);
            System.out.println("Password reset successful.");

        }else{
            System.out.println("Wrong Password.");
        }
    }

    //user varification
    private boolean checkPassword(String loginPassword, Player player){
        return player.getHashPassword().equals(Utility.getHash(loginPassword));
    }

    public Player userLogin(){

        Player choosePlayer = null;
        boolean nameCheck = true;
        while(nameCheck){
            String loginName = Keyboard.readString("Please Enter Your Name:");

            if(loginName.equals(this.getLoginName())){
                adminPasswordCheck();
            }else if(players.isEmpty()){
                System.out.println("No player is inside database. Create Player.");
            }else{
                for(int i =0;i<players.size();i++){
                    if(loginName.equals(players.get(i).getLoginName())){
                        System.out.println("Hello "+players.get(i).getLoginName()+"!");
                        choosePlayer = userLoginPassword(players.get(i));
                        return choosePlayer;
                    }else if(i==players.size()-1){
                        System.out.println("Player not found! Please enter your name again!\n");
                    }
                }
            } 
        }
        return choosePlayer;  
             
    }

    private Player userLoginPassword(Player player){
        String loginpassword = Keyboard.readString("Please Enter Your Password:");
        if(!checkPassword(loginpassword,player)){
            System.out.println("Wrong password.Please enter your password again!\n");
            userLoginPassword(player);
        }else{
            System.out.println("Login successful.");
        }
        return player;
       
    }

    private void adminPasswordCheck(){
        String loginpassword = Keyboard.readString("Please Enter Your Admin Password:");
        if(Utility.getHash(loginpassword).equals(this.getHashPassword())){
            System.out.println("Login successful.");
            getUserOption();
        }else{
            System.out.println("Wrong Admin Password. Going back to User Name.");
            userLogin();
        }
    }

    public void run(){
        getUserOption();
    }

    public static void main(String[] args) {
        Admin admin = new Admin();

        admin.run();
       
    }
    
}

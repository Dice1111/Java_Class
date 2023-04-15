
import java.util.*;

public class Player extends User {
    private int chips;
    protected ArrayList<Card> cardsOnHand;
    private static int betOnTable = 0;



    public Player(String loginName, String password, int chips) {
        super(loginName, password);
        this.chips = chips;
        this.cardsOnHand = new ArrayList<Card>();
    }

    public void showPlayerInfo(){
        
        System.out.println("\n"+getLoginName()+", you have "+getChips()+" chips.\n");
    }

    public int getChips(){
        return this.chips;
    }

    public void setChips(){
        this.chips = 100;
    }
    public void setChips(int amount){
        this.chips += amount;
    }
    public void setBetOntable(){
        betOnTable = 0;
    }

    public void deductChips(int amount){
            this.chips -= amount;
    }

    public void addChipToTable(int amount){
       betOnTable += amount;
    }



    public int getBetOnTable(){
        return betOnTable;
    }

    public void addCard(Card card) {
        this.cardsOnHand.add(card);
    }

    public ArrayList<Card> getCardsOnHand() {
        return this.cardsOnHand;
    }

    public void showCardsOnHand(Boolean roundEnd) {
        System.out.println(getLoginName());

        if(roundEnd){
            for (Card c : cardsOnHand) {
                System.out.print(c + " ");
            }
            System.out.println();
        }else if(!roundEnd){
            System.out.print("<HIDDEN CARD> ");
            for(int i =1; i<cardsOnHand.size();i++){
                System.out.print(cardsOnHand.get(i) + " ");
            }
            System.out.println();
        }
    }

    public void showTotalCardsValue() {
        System.out.println("Value: " + getTotalCardsValue());
    }

    public int getSuitLevel(){
        int suitLevel = 0;
        Card lastCard = cardsOnHand.get(cardsOnHand.size()-1);
        String []suits  ={"Diamond", "Club", "Heart", "Spade"};
        for (int i=0;i<suits.length;i++){
            if(suits[i]==lastCard.getSuit()){
                suitLevel = i;
                break;
            }
        }
        return suitLevel;
    }

    public int getCardLevel(){
        int cardLevel = 0;
        Card lastCard = cardsOnHand.get(cardsOnHand.size()-1);
        String []name  ={"10", "Jeck", "King", "Queen"};
        for (int i=0;i<name.length;i++){
            if(name[i]==lastCard.getSuit()){
                cardLevel = i;
                break;
            }
        }
        return cardLevel;   
    }

    public int getTotalCardsValue() {
        int total = 0;
        for (Card c : this.cardsOnHand) {
            total += c.getValue();
        }
        return total;
    }
    
    //player start betting
    public boolean betting(Dealer dealer,Player player,int i){
        boolean  betting  = true;
        String turn = dealer.checkTurn(dealer, player);
        if(player.getChips()<10){
            System.out.println("You have no enough chips. You loses.");
            return betting = false;
        }
        if(turn == "dealer"){
            // System.out.println(turn);    
            int amount = 10;
            System.out.println("Dealer call, state bet: "+amount);
           
            dealer.deductChips(amount);
            dealer.addChipToTable(amount);

            //player bet or not...
            Boolean playerCall = Keyboard.readBoolean("Do you want to follow? [Y/N]:");
            if(playerCall){
                player.deductChips(amount);
                player.addChipToTable(amount);
            }else if(!playerCall){
                System.out.println("\n"+player.getLoginName()+" Loses.");
                betting = false;
                return betting;
            }
            // System.out.println("dealer: "+dealer.getChips());
            System.out.println(player.getLoginName()+","+"You are left with "+player.getChips());
            System.out.println("Bet on Table: "+betOnTable);

        }else if(turn=="player"){

            if(i>1){
                String playerPlay = Keyboard.readString("Do you want to [C]all or [Q]uit?: ");
                if(playerPlay.equalsIgnoreCase("Q")){
                   System.out.println(player.getLoginName()+" Loses.");
                   betting = false;
                   return betting;
                }
            }
            //player turn.....
            int amount = playerBet(player);  
            player.deductChips(amount);
            player.addChipToTable(amount);
            //dealer turn.....
            dealer.deductChips(amount);
            dealer.addChipToTable(amount);

            // System.out.println("dealer: "+dealer.getChips());
            System.out.println(player.getLoginName()+","+"You are left with "+player.getChips());
            System.out.println("Bet on Table: "+betOnTable);                
        }
        return betting;
    }


    public int playerBet(Player player){
        int amount = Keyboard.readInt("Player call, state bet: ");
        while(amount>player.getChips()){
            System.out.println("Not enough Chips.");
            amount = Keyboard.readInt("Player call, state bet: ");    
        }
        
        return amount;
    }

    public void comparePoint(Dealer dealer,Player player){
        if(dealer.getTotalCardsValue()<player.getTotalCardsValue()){
            System.out.println( player.getLoginName()+" Wins");
            player.setChips(player.getBetOnTable());
            System.out.println(player.getLoginName()+", You have "+player.getChips()+" chips.");
        }else if(dealer.getTotalCardsValue()==player.getTotalCardsValue()){
            System.out.println("Draw.");
        }else if(dealer.getTotalCardsValue()>player.getTotalCardsValue()){
            System.out.println(player.getLoginName()+ " Loses");
        }
    }

    // public void playerEnter(){
    //     String input = Keyboard.readString("Press 1 to login:\nPress 2 to register:\n");
    //     if(!checkInput(input)){
    //         playerEnter();
    //     }
    //     if(input=="1"){
    //         playerLogin();
    //     }else if(input=="2"){
    //         playerRegister();
    //     }
    // }

    // public void playerLogin(){
    //     String loginName = Keyboard.readString("Please Enter your name:");
    //     for()
    //     String password = Keyboard.readString("Please Enter your password:");

    // }

    // public void playerRegister(){

    // }

    // public boolean checkInput(String input){  
    //     boolean valid = false;
    //     while (!valid) {
    //         try {
    //             if(input.equals("1") || input.equals("2")){
    //                 valid = true;
    //             }else{
    //                 throw new IllegalArgumentException();
    //             }
    //         } catch (IllegalArgumentException e) {
    //             System.out.println("Please enter a valid number."); 
    //             break; 
    //         }  
    //     }
    //     return valid;
    // 

    public static void main(String[] args) {
        Player player = new Player("A", "A", 100);
        System.out.println("Welcome to the game.");
        // player.playerEnter();
        Deck deck = new Deck();
        deck.shuffle();
        Card card1 = deck.dealCard();
        Card card2 = deck.dealCard();
        Card card3 = deck.dealCard();
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.showCardsOnHand(true);
        player.showTotalCardsValue();
    }
}

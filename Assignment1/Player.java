
import java.util.*;

public class Player extends User {
    private int chips;
    protected ArrayList<Card> cardsOnHand;



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

    // public void addChip(){
    //    String input = System.out.println("Would you like to add more chip?yes/no: ");
    //     Keyboard.readBoolean(input);
    // }



    public void addCard(Card card) {
        this.cardsOnHand.add(card);
    }

    public ArrayList<Card> getCardsOnHand() {
        return this.cardsOnHand;
    }

    public void showCardsOnHand() {
        System.out.println(getLoginName());
        for (Card c : cardsOnHand) {
            System.out.print(c + " ");
        }
        System.out.println();
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



    public int getTotalCardsValue() {
        int total = 0;
        for (Card c : this.cardsOnHand) {
            total += c.getValue();
        }
        return total;
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
        player.showCardsOnHand();
        player.showTotalCardsValue();
    }
}

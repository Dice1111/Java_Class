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
        
        System.out.println("\n"+getLoginName()+", you have "+getChips()+" chips.");
        GameUI.underLineSm();
    }

    public int getChips(){
        return this.chips;
    }

    public void setChips(int chips){
        this.chips = chips;
    }

    public void addChips(int chips){
        this.chips += chips;
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
        }
        else if(!roundEnd){
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
                boolean Call = false;
                while(!Call){
                    String playerPlay = Keyboard.readString("Do you want to [C]all or [Q]uit?: ");
                    if(playerPlay.equalsIgnoreCase("Q")){
                    System.out.println(player.getLoginName()+" Loses.");
                    betting = false;
                    return betting;
                    }else if(playerPlay.equalsIgnoreCase("C")){
                        Call = true;
                    }else{
                        System.out.println("Please enter Q or C.");
                    }
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
            player.addChips(player.getBetOnTable());
            System.out.println(player.getLoginName()+", You have "+player.getChips()+" chips.");
        }else if(dealer.getTotalCardsValue()==player.getTotalCardsValue()){
            System.out.println("Draw.");
            player.addChips(betOnTable/2);
            System.out.println("Return own bet amount");
            System.out.println(player.getLoginName()+","+"You are left with "+player.getChips());
        }else if(dealer.getTotalCardsValue()>player.getTotalCardsValue()){
            System.out.println(player.getLoginName()+ " Loses");
        }
    }

}

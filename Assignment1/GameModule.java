
public class GameModule {

    private Dealer dealer;
    private Player player;

    public GameModule() {
        dealer = new Dealer();
        player = new Player("a", "a", 100);
    }

    public void run() {
        boolean run = true;
        while(run){
            player.userLoginName(player);
            player.showPlayerInfo();

            boolean gameLoop = true;
            while(gameLoop){
                dealer.shuffleCards();
                dealer.dealCardToAll(dealer,player);
                roundStart(dealer, player);
                // roundEnd(dealer, player);
                dealer.roundReset(dealer, player);
                if(!checkAnotherGame()){
                break;
                }
                
            }
            break;
        }

    }


    public void roundStart(Dealer dealer,Player player){
        System.out.println("\nHighSum Game\n");
        for(int i=1;i<5;i++){
            System.out.println("\nDealer dealing cards - ROUND "+i+"\n");
            dealer.dealCardToAll(dealer,player);
            dealer.showCardsOnHand(false);
            System.out.println();
            player.showCardsOnHand(false);
            System.out.println("Show value: "+player.getTotalCardsValue());
            //bet.......
            boolean betting = player.betting(dealer,player,i);
            if(!betting){
                break;
            }else if(betting){
                roundEnd(dealer, player);
            }   
        } 
        
    }

    public void roundEnd(Dealer dealer,Player player){
        System.out.println("\nGame End - Dealer reveal hidden cards");
        dealer.showCardsOnHand(true);
        System.out.println("Show value: "+dealer.getTotalCardsValue());
        System.out.println();
        player.showCardsOnHand(true);
        System.out.println("Show value: "+player.getTotalCardsValue());
        player.comparePoint(dealer, player);
    }


    public boolean checkAnotherGame(){
        boolean condition =Keyboard.readBoolean("Next Game? (Y/N) > ");
        return condition;
    }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
    }
}



public class GameModule {

    private Dealer dealer;
    private Player player;

    public GameModule() {
        dealer = new Dealer();
        player = new Player("a", "a", 100);
    }

    public void run() {
        // game start here
        // player.playerEnter();
        System.out.println("HighSum Game\n");
        player.userLoginName(player);
        player.showPlayerInfo();
        dealer.shuffleCards();

        // System.out.println("\nRound 1..............\n");
        // dealer.dealCardTo(dealer);
        // dealer.dealCardTo(player);
        // dealer.dealCardTo(dealer);
        // dealer.dealCardTo(player);
        // dealer.showCardsOnHand();
        // System.out.println();
        // player.showCardsOnHand();
        // System.out.println("Show value: "+player.getTotalCardsValue());

        //init cards....
        dealer.dealCardToAll(dealer,player);
        
        for(int i=1;i<5;i++){
        System.out.println("\nRound "+i+"...............\n");
        dealer.dealCardToAll(dealer,player);
        dealer.showCardsOnHand();
        System.out.println();
        player.showCardsOnHand();
        System.out.println("Show value: "+player.getTotalCardsValue());
        //bet.......
        player.betting(dealer,player);

        }
        
        // System.out.println(player.getSuitLevel());
        // System.out.println(dealer.getSuitLevel());
        // player.showTotalCardsValue();
        // dealer.showTotalCardsValue();
        // System.out.println(dealer.checkTurn(player, dealer));
        // System.out.println(player.getCardsOnHand().get(player.getCardsOnHand().size()-1).getValue());
   
    }

    // public void dealCardToAll(){
    //     dealer.dealCardTo(dealer);
    //     dealer.dealCardTo(player);
    // }

    // public void betting(){
    //     String turn = dealer.checkTurn(dealer, player);
    //     if(turn == "dealer"){
    //         System.out.println(turn);
    //     }else if(turn=="player"){
    //         System.out.println(turn);
    //     }
    // }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
    }
}


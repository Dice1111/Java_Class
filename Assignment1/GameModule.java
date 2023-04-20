
public class GameModule {

    private Dealer dealer;
    private Player player;

    public GameModule() {
        dealer = new Dealer();
        player = new Player("IcePeak", "password", 100);
    }

    public void run() {
        boolean run = true;
        while(run){
            System.out.println("HighSum GAME");
            GameUI.underLine();
            player.userLoginName(player);
            System.out.println("\nHighSum GAME");
            GameUI.underLine();  
            boolean gameLoop = true;
            while(gameLoop){
                player.showPlayerInfo();
                dealer.shuffleCards();
                dealer.dealCardToAll(dealer,player);
                roundStart(dealer, player);
                dealer.roundReset(dealer, player);
                if(!checkAnotherGame()){
                break;
                }
                
            }
            break;
        }

    }

    public void roundStart(Dealer dealer,Player player){
        for(int i=1;i<5;i++){
            GameUI.underLineSm();
            System.out.println("Dealer dealing cards - ROUND "+i);
            GameUI.underLineSm();
            dealer.dealCardToAll(dealer,player);
            dealer.showCardsOnHand(false);
            System.out.println();
            player.showCardsOnHand(true);
            System.out.println("Show value: "+player.getTotalCardsValue()+"\n");
            //bet.......
            boolean betting = player.betting(dealer,player,i);
            if(!betting){
                break;
            }
            
            if(i==4){
                roundEnd(dealer, player);
            }   
        } 
        
    }

    public void roundEnd(Dealer dealer,Player player){
        
        System.out.println("\nGame End - Dealer reveal hidden cards");
        GameUI.underLine();
        dealer.showCardsOnHand(true);
        System.out.println("Show value: "+dealer.getTotalCardsValue());
        System.out.println();
        player.showCardsOnHand(true);
        System.out.println("Show value: "+player.getTotalCardsValue());
        player.comparePoint(dealer, player);

           
    }

    public boolean checkAnotherGame(){
        boolean condition = Keyboard.readBoolean("Next Game? (Y/N) > ");
        return condition;
    }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
    }
}


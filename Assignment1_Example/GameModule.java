package Assignment1_Example;
public class GameModule {

    private Dealer dealer;
    private Player player;

    public GameModule() {
        dealer = new Dealer();
        player = new Player("IcePeak", "password", 100);
    }

    public void run() {
        // game start here
        dealer.shuffleCards();
        dealer.dealCardTo(dealer);
        dealer.dealCardTo(player);
        player.showCardsOnHand();
        dealer.showCardsOnHand();
    }

    public static void main(String[] args) {
        GameModule app = new GameModule();
        app.run();
    }
}

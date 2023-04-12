package Assignment1_Example;
public class Dealer extends Player {
    private Deck deck;

    public Dealer() {
        super("Dealer", "", 0);
        deck = new Deck();
    }

    public void shuffleCards() {
        System.out.println("Dealer shuffle deck");
        deck.shuffle();
    }

    public void dealCardTo(Player player) {
        Card card = deck.dealCard();
        player.addCard(card);
    }

}

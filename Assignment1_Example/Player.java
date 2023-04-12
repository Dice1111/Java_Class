package Assignment1_Example;
import java.util.*;

public class Player extends User {
    private int chips;
    protected ArrayList<Card> cardsOnHand;

    public Player(String loginName, String password, int chips) {
        super(loginName, password);
        this.chips = chips;
        this.cardsOnHand = new ArrayList<Card>();
    }

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

    public int getTotalCardsValue() {
        int total = 0;
        for (Card c : this.cardsOnHand) {
            total += c.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Player player = new Player("A", "A", 100);
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

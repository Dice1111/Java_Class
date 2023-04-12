package Assignment1_Example;

public class Card {
    public String suit;
    public String name;
    public int value;

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "<" + this.suit + " " + this.name + ">";
    }

    public static void main(String[] args) {
        Card card = new Card("Heart", "Ace", 1);
        System.out.println(card);
    }
}
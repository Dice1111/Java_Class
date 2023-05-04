import java.util.*;

public class Deck {
    
    private ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<Card>();
        String []suits  ={"Diamond", "Club", "Heart", "Spade"};
        
        for(int i=0;i<suits.length;i++){
            String suit = suits[i];
            Card card = new Card(suit,"Ace",1);
            cards.add(card);
            for(int x=2;x<=10;x++){
                Card nextcard = new Card(suit, "" + x, x);
                cards.add(nextcard);
            }
            Card jackCard = new Card(suit, "Jack", 10);
            cards.add(jackCard);

            Card queenCard = new Card(suit, "Queen", 10);
            cards.add(queenCard);

            Card kingCard = new Card(suit, "King", 10);
            cards.add(kingCard);
        }
        
    }

    public Card dealCard() {
        return cards.remove(0);
    }
    // add back arraylist of card
    public void appendCard(ArrayList<Card> cards) {
        for (Card c : cards) {
            this.cards.add(c);
        }
    }
    
    public void removeAllCard(ArrayList<Card> cards){
        cards.removeAll(cards);
    }

    public void shuffle() {
        
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int indexA = random.nextInt(cards.size());
            int indexB = random.nextInt(cards.size());
            Card cardA = cards.get(indexA);
            Card cardB = cards.get(indexB);
            cards.set(indexA, cardB);
            cards.set(indexB, cardA);
        }
    }

    public void showCards() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }
    
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.showCards();
    }
}

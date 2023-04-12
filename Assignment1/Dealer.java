public class Dealer extends Player {
    private Deck deck;

    public Dealer() {
        super("Dealer", "", 100);
        deck = new Deck();
    }

    public void shuffleCards() {
        System.out.println("Game start! - Dealer shuffles Deck.\n");
        deck.shuffle();
    }

   public String checkTurn(Player dealer,Player player){
        String turn = "dealer";
        int playerCardValue = player.getCardsOnHand().get(player.getCardsOnHand().size()-1).getValue();
        int playerSuitLevel = player.getSuitLevel();
        int dealerCardValue = dealer.getCardsOnHand().get(dealer.getCardsOnHand().size()-1).getValue();
        int dealerSuitLevel = dealer.getSuitLevel();
        if(playerCardValue>dealerCardValue){
            turn = "player";
        }else if(playerCardValue==dealerCardValue){
            if(playerSuitLevel>dealerSuitLevel){
                turn = "player";
            }else if(playerSuitLevel<dealerSuitLevel){
                turn ="dealer";
            }
        }else if(playerCardValue<dealerCardValue){
            turn = "dealer";
        }
        return turn;
   }

    public void dealCardTo(Player player) {
        Card card = deck.dealCard();//remove card from deck
        player.addCard(card);//add card to player hand
    }

    public void dealCardToAll(Player dealer,Player player){
        dealCardTo(dealer);
        dealCardTo(player);
    }

    public void betting(Player dealer,Player player){
        String turn = checkTurn(dealer, player);
        if(turn == "dealer"){
            System.out.println(turn);
            String amount = Keyboard.readString("Enter banana: ");
        }else if(turn=="player"){
            System.out.println(turn);
        }
    }

}

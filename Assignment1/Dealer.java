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

        }
        else if(playerCardValue==dealerCardValue){
            int dealerCardLevel = dealer.getCardLevel();
            int playerCardLevel = player.getCardLevel();
             
            if(dealerCardLevel>playerCardLevel){
                turn = "dealer";
            }else if(dealerCardLevel<playerCardLevel){
                turn = "player";
            }else if(dealerCardLevel==playerCardLevel){
            
                if(playerSuitLevel>dealerSuitLevel){
                    turn = "player";
                }else if(playerSuitLevel==dealerSuitLevel){
                
                    
                }else if(playerSuitLevel<dealerSuitLevel){
                    turn ="dealer";
                }
            }

        }
        else if(playerCardValue<dealerCardValue){
            turn = "dealer";
        }
        return turn;
   }

    public void dealCardTo(Player player) {
        Card card = deck.dealCard();//remove card from deck
        player.addCard(card);//add card to player hand
    }

    public void dealCardToAll(Dealer dealer,Player player){
        dealCardTo(player);
        dealCardTo(dealer);
        
    }



    public void roundReset(Dealer dealer,Player player){
        deck.appendCard(dealer.cardsOnHand);
        deck.appendCard(player.cardsOnHand);
        deck.removeAllCard(dealer.cardsOnHand);
        deck.removeAllCard(player.cardsOnHand);
        dealer.setChips();
        player.setChips();
        dealer.setBetOntable();
    }



}

package Controller;
import Model.Dealer;
import Model.Player;
import View.ViewController;

public class GameController {

	private Dealer dealer;
	private Player player;
	private ViewController view;
	private int chipsOnTable;
	private String winOrLose;
	char r;
	
	public GameController(Dealer dealer,Player player,ViewController view) {
		this.dealer = dealer;
		this.player = player;
		this.view = view;
		this.chipsOnTable = 0;
	}
	
	public void run() {
		boolean login = false;
		while(!login){
			login=view.userLoginGUI();
			if(login==false){
				view.displayError("Login Fail. Try Again!");
			}else{
				view.displayGameGUI();
			}
		}
	
		boolean carryOn = true;
		while (carryOn) {
			view.displayDealerCardInitValueGUI();
			view.coverDealerCardGUI();
			view.displayPlayerNameGUI(player.getLoginName());
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
			runOneRound();
			if (r == 'n') {
				carryOn = false;
			}
		}
	
		this.view.displayPlayerNameAndLeftOverChips(this.player);
		this.view.displayExitGame();
		this.view.displayExistGameGUI();
	}
	
	public void runOneRound() {
		
		this.view.displayGameTitle();
		this.view.displayDoubleLine();
		this.view.displayPlayerNameAndChips(this.player);//
		this.view.displaySingleLine();
		this.view.displayGameStart();
		this.view.displaySingleLine();
		this.view.displayShuffleCardGUI();
		this.dealer.shuffleCards();
		try{
			Thread.sleep(3000);
		}catch(Exception e){

		}
		this.chipsOnTable = 0;
		boolean playerQuit = false;
				
		for(int round = 1;round<=4;round++) {
			this.view.displaySingleLine();
			this.view.displayDealerDealCardsAndGameRound(round);
			this.view.displaySingleLine();

			if(round==1) {//round 1 deal extra card
				this.dealer.dealCardTo(this.player);
				this.dealer.dealCardTo(this.dealer);
			}
			this.dealer.dealCardTo(this.player);
			this.dealer.dealCardTo(this.dealer);
			view.displayPlayerCardValueGUI(player.getTotalCardsValue());
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
			view.displayUpdateHands();
			
			this.view.displayPlayerCardsOnHand(this.dealer);
			this.view.displayBlankLine();
			this.view.displayPlayerCardsOnHand(player);
			this.view.displayPlayerTotalCardValue(player);

			int whoCanCall = this.dealer.determineWhichCardRankHigher(dealer.getLastCard(), player.getLastCard());
			
			if(whoCanCall==1) {//dealer call
				int chipsToBet = this.view. getDealerCallBetChips();
				//ask player want to follow?
				char r = this.view.getPlayerFollowOrNot(this.player,chipsToBet);
				if(r=='y') {
					this.player.deductChips(chipsToBet);
					this.chipsOnTable+=2*chipsToBet;	
					this.view.displayPlayerNameAndLeftOverChips(this.player);
					this.view.displayBetOntable(this.chipsOnTable);
					
				}else {
					playerQuit = true;
					break;
				}
			}else {//player call
				if(round==1) {//round 1 player cannot quit
					int chipsToBet = view.getPlayerCallBetChip(this.player);
					this.player.deductChips(chipsToBet);
					this.chipsOnTable+=2*chipsToBet;
					this.view.displayBetOntable(this.chipsOnTable);
				}else {
					char r = this.view.getPlayerCallOrQuit();
					if(r=='c') {
						int chipsToBet = view.getPlayerCallBetChip(this.player);
						this.player.deductChips(chipsToBet);
						this.chipsOnTable+=2*chipsToBet;
						this.view.displayPlayerNameAndLeftOverChips(this.player);
						this.view.displayBetOntable(this.chipsOnTable);
					}else {
						playerQuit = true;
						break;
					}
				}
			}
			
			view.displayPlayerCardValueGUI(player.getTotalCardsValue());
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
		
		}

		
		view.displayDealerCardValueGUI(dealer.getTotalCardsValue());
		// view.displayPlayerCardValueGUI(player.getTotalCardsValue());
		// view.displayPlayerChipAmountGUI(player.getChips());
		// view.displayBetOntableGUI(chipsOnTable);
		view.showDealerCardGUI();
		
		//check who win
		if(playerQuit) {
			this.view.displayPlayerNameAndLeftOverChips(this.player);
			this.view.displayPlayerQuit();
			winOrLose = "You have quit the current game. ";
			r = this.view.getPlayerNextGame(winOrLose);
		}
		else if(this.player.getTotalCardsValue()>this.dealer.getTotalCardsValue()) {
			this.view.displayPlayerWin(this.player);
			winOrLose = "You WIN! ";
			this.player.addChips(chipsOnTable);
			this.chipsOnTable=0;
			this.view.displayPlayerNameAndLeftOverChips(this.player);
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
			r = this.view.getPlayerNextGame(winOrLose);

		}else if(this.player.getTotalCardsValue()<this.dealer.getTotalCardsValue()) {
			this.view.displayDealerWin();
			winOrLose = "You LOST! ";
			this.chipsOnTable=0;
			this.view.displayPlayerNameAndLeftOverChips(this.player);
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
			r = this.view.getPlayerNextGame(winOrLose);
		}else {
			this.view.displayTie();
			winOrLose = "It is a TIE! ";
			this.player.addChips(chipsOnTable/2);
			this.chipsOnTable=0;
			this.view.displayPlayerNameAndLeftOverChips(this.player);
			view.displayPlayerChipAmountGUI(player.getChips());
			view.displayBetOntableGUI(chipsOnTable);
			r = this.view.getPlayerNextGame(winOrLose);
		}



		
		
		
		//put all the cards back to the deck
		dealer.addCardsBackToDeck(dealer.getCardsOnHand());
		dealer.addCardsBackToDeck(player.getCardsOnHand());
		dealer.clearCardsOnHand();
		player.clearCardsOnHand();

	}
	
	
}

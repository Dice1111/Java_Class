package View;

import Helper.Keyboard;
import Model.*;
import java.awt.*;
import javax.swing.*;
import GUI.GameTableFrame;

//all input and output should be done view ViewController
//so that it is easier to implement GUI later
public class ViewController {
	private GameTableFrame frame;
	private Dealer dealer;
	private Player player;

	public ViewController(Dealer dealer,Player player){
		this.dealer = dealer;
		this.player = player;
	}

	//GUI...............................
	public void displayGameGUI(){
		frame = new GameTableFrame(dealer,player);
	}

	public void displayPlayerNameGUI(String name){
		frame.getGamePanel().getRightPanel().setPlayerName(name);
	}


	public void displayPlayerChipAmountGUI(int chip){
		frame.getGamePanel().getRightPanel().setChipAmount(chip);
	}

	public void displayPlayerCardValueGUI(int value){
		frame.getGamePanel().getRightPanel().setValue(value);;
	}

	public void displayBetOntableGUI(int totalBet){
		frame.getGamePanel().getLeftPanel().setBettingPool(totalBet);
	}

	public void displayDealerCardValueGUI(int value){
		frame.getGamePanel().getRightPanel().setDealerValue(value);
	}

	public void displayDealerCardInitValueGUI(){
		frame.getGamePanel().getRightPanel().setDealerInitValue();
	}

	public void showDealerCardGUI(){
		frame.getGamePanel().getRightPanel().showDealerCard();
	}

	public void coverDealerCardGUI(){
		frame.getGamePanel().getRightPanel().coverDealerCard();
	}

	public void displayUpdateHands(){
		frame.getGamePanel().getRightPanel().repaint();
	}

	public void displayExistGameGUI(){

        Object[] options = {"Quit"};
        int choice = JOptionPane.showOptionDialog(null,
                "Thank you for playing HighSum Game",
                "HighSum Game",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            frame.dispose();
        	System.exit(0);
        }
	}

	public void displayShuffleCardGUI(){
		frame.addLoading();
	}
	
	public boolean userLoginGUI(){
		JPanel panel = new JPanel();
		JLabel name = new JLabel("Login Name: ");
		name.setBounds(10, 20, 100, 25);
		JTextField nameInput = new JTextField(10);
		nameInput.setBounds(120, 20, 100, 25);

		JLabel password = new JLabel("Password: ");
		password.setBounds(10, 60, 100, 25);
		JTextField passInput = new JPasswordField(10);
		passInput.setBounds(120, 60, 100, 25);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(300, 100));
		panel.add(name);
		panel.add(nameInput);
		panel.add(password);
		panel.add(passInput);
		
		boolean validLogin = false;

		int check = JOptionPane.showOptionDialog(
			null,
			panel,
			"User Login",
			JOptionPane.OK_OPTION,
			JOptionPane.PLAIN_MESSAGE,
			null,
			new Object[]{"Login"},
			nameInput);

		if(check == JOptionPane.OK_OPTION){
				
			String playerName = nameInput.getText();
			String loginPassword = passInput.getText();
			if(playerName.equals(player.getLoginName()) && player.checkPassword(loginPassword)){
				validLogin = true;
			}else{
				validLogin = false;
			}
		}
	
		
		return validLogin;
		
	}

	//GUI................................

	



	public void displayExitGame() {
		System.out.println("Thank you for playing HighSum game");
	}


	
	public void displayBetOntable(int bet) {
		System.out.println("Bet on table : "+bet);
	}
	
	public void displayPlayerWin(Player player) {
		System.out.println(player.getLoginName()+" Wins!");
	}
	
	public void displayDealerWin() {
		System.out.println("Dealer Wins!");
	}
	
	public void displayTie() {
		System.out.println("It is a tie!");
	}
	
	public void displayPlayerQuit() {
		System.out.println("You have quit the current game.");
	}
	
	public void displayPlayerCardsOnHand(Player player) {
		
		System.out.println(player.getLoginName());

		if(player instanceof Dealer) {
			
			for(int i=0;i<player.getCardsOnHand().size();i++) {
				if(i==0) {
					System.out.print("<HIDDEN CARD> ");
				}else {
					System.out.print(player.getCardsOnHand().get(i).toString()+" ");
				}
			}
		}else {
			for(Card card:player.getCardsOnHand()) {
				System.out.print(card+" ");
			}
		}
		System.out.println();
	}
	
	public void displayBlankLine() {
		System.out.println();
	}
	
	public void displayPlayerTotalCardValue(Player player) {
		System.out.println("Value:"+player.getTotalCardsValue());
	}
	
	public void displayDealerDealCardsAndGameRound(int round) {
		System.out.println("Dealer dealing cards - ROUND "+round);
	}
	
	public void displayGameStart() {
		System.out.println("Game starts - Dealer shuffle deck");
	}
	
	public void displayPlayerNameAndChips(Player player) {
		System.out.println(player.getLoginName()+", You have "+player.getChips()+" chips");
	}
	
	public void displayPlayerNameAndLeftOverChips(Player player) {
		System.out.println(player.getLoginName()+", You are left with "+player.getChips()+" chips");
	}
	
	public void displayGameTitle() {
		System.out.println("HighSum GAME");
	}
	
	public void displaySingleLine() {
		for(int i=0;i<30;i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public void displayDoubleLine() {
		for(int i=0;i<30;i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	
	public char getPlayerCallOrQuit() {

		char r ='q';
		// char[] choices = {'c','q'};
		// char r = Keyboard.readChar("Do you want to [c]all or [q]uit?:",choices);
		Object[] options = {"Call", "Quit"};

        // Display Yes/No dialog box
        int choice = JOptionPane.showOptionDialog(null,
                "Do you want to Call?",
                "Call",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        // Check the user's choice
        if (choice == JOptionPane.YES_OPTION) {
			r = 'c';
        } else if (choice == JOptionPane.NO_OPTION) {
			r = 'q';
        }
		return r;
	}
	
	public char getPlayerFollowOrNot(Player player, int dealerBet) {
		char r = 'n';
		Object[] options = {"Yes", "No"};

        // Display Yes/No dialog box
        int choice = JOptionPane.showOptionDialog(null,
                "Dealer deal 10 chips. Do you want to follow?",
                "Follow",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        // Check the user's choice
        if (choice == JOptionPane.YES_OPTION) {
			r = 'y';
        } else if (choice == JOptionPane.NO_OPTION) {
			r = 'n';
        }
		return r;
	}
	
	public char getPlayerNextGame(String custom) {

		char r = 'n';
        int choice = JOptionPane.showConfirmDialog(null,
                custom+"Next Game?",
                "Next Game",
                JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE
				);	

        // Check the user's choice
        if (choice == JOptionPane.YES_OPTION) {
			r = 'y';
        } else if (choice == JOptionPane.NO_OPTION) {
			r = 'n';
        }

		return r;
	}
	
	public int getPlayerCallBetChip(Player player) {

		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter your bet: ");
		JTextField textField = new JTextField(10);
		panel.add(label);
		panel.add(textField);

		boolean validBetAmount = false;
		int chipsToBet = 0;

		while(!validBetAmount) {
			int input = JOptionPane.showOptionDialog(
				null,
				panel,
				"Bet",
				JOptionPane.OK_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				new Object[]{"OK"},
				textField);

			if(input == JOptionPane.OK_OPTION){
				
				String inputValue = textField.getText();
				try {
					chipsToBet = Integer.parseInt(inputValue);
	
					if (chipsToBet < 0) {
						System.out.println("Chips cannot be negative");
						displayError("Chips cannot be negative");
					} else if (chipsToBet > player.getChips()) {
						System.out.println("You do not have enough chips");
						displayError("You do not have enough chips.");
					} else {
						validBetAmount = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid integer.");
					displayError("Invalid input. Please enter a valid integer.");
				}
			}
		}	
		
		return chipsToBet;
	}
	
	public int getDealerCallBetChips() {
		System.out.println("Dealer call, state bet: 10");
		return 10;
	}

	public void displayError(String message){
        JOptionPane.showMessageDialog(null,
				message);
	}


	
	
	
}

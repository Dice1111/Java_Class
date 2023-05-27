package GUI;
import javax.swing.*;
import java.awt.*;
import Model.*;
public class RightGamePanel extends JPanel{
	private Dealer dealer;
	private Player player;
    private ImageIcon cardBackImage;
	JLabel  chips;
	JLabel playerValue;
	JLabel playerTitle;
	JLabel dealerValue;
    public RightGamePanel(Dealer dealer, Player player){
		this.player = player;
		this.dealer = dealer;
		// Set the font size
        Font font = new Font("Arial", Font.BOLD, 20);
        cardBackImage= new ImageIcon("images/back.png");
        setBackground(Color.decode("#B33F26"));
		setPreferredSize(new Dimension(1200, 900));
		setLayout(null);

		//display dealer name
        int x=60;
        int y=270;
        JLabel dealerTitle = new JLabel("Dealer");
        dealerTitle.setForeground(Color.white);
        dealerTitle.setFont(font);
		
        dealerTitle.setBounds(x, y, 100, 100);
        add(dealerTitle);

		//display dealer value
        x=250;
        y=270;
        dealerValue = new JLabel("");
        dealerValue.setBounds(x, y, 100, 100);
		dealerValue.setForeground(Color.white);
        dealerValue.setFont(font);
        add(dealerValue);

		 //display player name
         x=60;
         y=740;
         playerTitle = new JLabel("Player");
		 playerTitle.setForeground(Color.white);
		 playerTitle.setFont(font);
         playerTitle.setBounds(x, y, 200, 100);
         add(playerTitle);
		//player value
		 x=60;
         y=790;
         playerValue = new JLabel("Value: ");
		 playerValue.setForeground(Color.white);
		 playerValue.setFont(font);
         playerValue.setBounds(x, y, 200, 100);
         add(playerValue);
		 //player chips
		 x=250;
         y=790;
         chips = new JLabel("Balance Chips: ");
		 chips.setForeground(Color.white);
		 chips.setFont(font);
         chips.setBounds(x, y, 200, 100);
         add(chips);

		

    }

    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 50;
		int y = 70;
		int i =0;
		//dealer.................
		for (Card card: dealer.getCardsOnHand()) {
			// display dealer cards
			if (i == 0) {
				Image resizedImage = cardBackImage.getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH);
				ImageIcon cardIcon = new ImageIcon(resizedImage);
				cardIcon.paintIcon(this, g, x, y);
				i++;

			} else {
				Image resizedImage = card.getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH);
				ImageIcon cardIcon = new ImageIcon(resizedImage);
				cardIcon.paintIcon(this, g, x, y);
			}

			x += 200;
		}

		// display player cards
		x = 50;
		y = 550;

		for (Card card:player.getCardsOnHand()) {
				Image resizedImage = card.getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH);
				ImageIcon cardIcon = new ImageIcon(resizedImage);
				cardIcon.paintIcon(this, g, x, y);
			x += 200;
		}   
	}

	public void setPlayerName(String name){
		playerTitle.setText(name);
		// repaint();
	}

	public void setValue(int value){
		playerValue.setText("Value: "+value);
		// repaint();
	}

	public void setChipAmount(int chipAmount){
		chips.setText("Balance Chips: "+chipAmount);
		// repaint();
	}

	public void setDealerValue(int value){
		dealerValue.setText("Value: "+value);
	}

	public void setDealerInitValue(){
		dealerValue.setText("");
	}

	public void showDealerCard(){
		cardBackImage = dealer.getCardsOnHand().get(0);
		repaint();
	}

	public void coverDealerCard(){
		cardBackImage = new ImageIcon("images/back.png");
		repaint();
	}


	

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame();
    //     RightGamePanel panel = new RightGamePanel();
    //     frame.add(panel);
    //     frame.pack();
    //     frame.setVisible(true);
    //     panel.repaint();
        
    // }

}

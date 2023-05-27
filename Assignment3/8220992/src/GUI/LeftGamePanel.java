package GUI;
import javax.swing.*;
import java.awt.*;
import Model.*;
public class LeftGamePanel extends JPanel {
    private JLabel BetOnTable ;

    public LeftGamePanel(Dealer dealer,Player player){
        // Set the font size
        Font font = new Font("Arial", Font.BOLD, 20);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#B33F26"));
        setPreferredSize(new Dimension(500, 900));

        // Load the image..............
        ImageIcon DeckIcon = new ImageIcon("images/back.png");
        Image resizedImage = DeckIcon.getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH);
        ImageIcon newDeckIcon = new ImageIcon(resizedImage);
        JLabel newDeck = new JLabel(newDeckIcon);
        JLabel DeckLabel = new JLabel("Deck");
        // Set the color
        DeckLabel.setForeground(Color.white);
        
        DeckLabel.setFont(font);
        newDeck.setAlignmentX(Component.CENTER_ALIGNMENT);
        DeckLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        ImageIcon BettingPoolIcon = new ImageIcon("images/betOnTable.png");
        Image resizedImage1 = BettingPoolIcon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        ImageIcon newBettingPoolIcon = new ImageIcon(resizedImage1);
        JLabel BettingPoolImage = new JLabel(newBettingPoolIcon);
        BetOnTable = new JLabel("Bet On Table: ");
        // Set the color
        BetOnTable.setForeground(Color.white);
        // Set the font size
        BetOnTable.setFont(font);
        BettingPoolImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        BetOnTable.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(Box.createRigidArea(new Dimension(0, 70)));
        add(newDeck);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(DeckLabel);
        add(Box.createRigidArea(new Dimension(0, 80)));
        add(BettingPoolImage);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(BetOnTable);
    }


    public void setBettingPool(int totalBet){
        BetOnTable.setText("Bet On table: "+ totalBet);
    }
}

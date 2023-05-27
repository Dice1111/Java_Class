package GUI;
// import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameTableFrame extends JFrame{
	 
    private GameTablePanel gameTablePanel;
    private GameShuffle gameShuffle;

    
    public GameTableFrame(Dealer dealer, Player player)
    {
        gameTablePanel = new GameTablePanel(dealer,player);
        gameShuffle = new GameShuffle();
        add(gameTablePanel); 
        pack();
        setTitle("HighSum Game");
        setVisible(true);
    }

    public void addLoading(){
        remove(gameTablePanel);
        add(gameShuffle);
        pack();
        revalidate();
        repaint();
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(gameShuffle);
                add(gameTablePanel);
                pack();
                revalidate();
                repaint();
            }
        });
        timer.setRepeats(false); // Set to false to only execute once
        timer.start();
    }

    

    public GameTablePanel getGamePanel(){
        return gameTablePanel;
    }
    
    public void updateGameTable()
    {
        gameTablePanel.repaint();
    }
}

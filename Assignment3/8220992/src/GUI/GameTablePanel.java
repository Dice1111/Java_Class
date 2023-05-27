package GUI;
import java.awt.*;
import javax.swing.*;

import Model.*;

public class GameTablePanel extends JPanel {
	private LeftGamePanel leftPanel;
	private RightGamePanel rightPanel;
	

	public GameTablePanel(Dealer dealer, Player player) {
		
		setBackground(Color.decode("#B33F26"));
		setPreferredSize(new Dimension(1800, 900));

		//left Panel.................
		leftPanel = new LeftGamePanel(dealer,player);
		add(leftPanel);

		//right panel...................
		rightPanel = new RightGamePanel(dealer, player);

		add(rightPanel);	
		
		rightPanel.repaint();
	}


	public LeftGamePanel getLeftPanel() {
		return leftPanel;
	}


	public RightGamePanel getRightPanel() {
		return rightPanel;
	}










	// public static void main(String[] args) {
	// 	GameTablePanel game = new GameTablePanel();
	// 	JFrame frame = new JFrame();
	// 	frame.add(game);
	// 	frame.pack();
	// 	frame.setVisible(true);
	// }

	
}



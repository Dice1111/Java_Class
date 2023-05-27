package GUI;
import javax.swing.*;
import java.awt.*;

import java.awt.Color;
public class GameShuffle extends JPanel {
    public GameShuffle(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        

         
    
        Color backgroundColor = Color.decode("#B33F26"); // Replace with your desired color code
        setBackground(backgroundColor);
        //setWindowSize................
        setPreferredSize(new Dimension(1800, 900));

        
        //image
        ImageIcon originalIcon = new ImageIcon("images/shuffle.gif");

        
        //Two Labels....................
        JLabel image = new JLabel(originalIcon);
        JLabel labeltext = new JLabel("Shuffling...");
        
        
        // Set the color
        labeltext.setForeground(Color.white);

        // Set the font size
        Font font = new Font("Arial", Font.ITALIC, 20);
        labeltext.setFont(font);

        
        
        //set horizontal center.........
        image.setAlignmentX(Component.CENTER_ALIGNMENT);
        labeltext.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Empty spaces..................
        add(Box.createRigidArea(new Dimension(0, 150)));
        add(image);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(labeltext);
        add(Box.createRigidArea(new Dimension(0, 50)));
        

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GameShuffle panel = new GameShuffle();

        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);


    }
}
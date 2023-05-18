package Lesson7;
import java.awt.*;
import javax.swing.*;
public class SimpleFrame {
    public static void main(String[] args) {
        //create a frame
        JFrame frame = new JFrame("A simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(300, 300));

        //create 2 labels
        JLabel label1 = new JLabel("Demo Program");
        JLabel label2 = new JLabel("CSIT121");

        //add labels into panel
        panel.add(label1);
        panel.add(label2);

        //add panel into frame
        frame.add(panel);



        //resize the frame 
        frame.pack();

        //display the frame
        frame.setVisible(true);





    }
}

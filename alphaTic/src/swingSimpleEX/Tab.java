package swingSimpleEX;

import java.awt.*;
import javax.swing.*;

public class Tab extends JFrame{
	private static final long serialVersionUID = 1L;
	final static String Mode1 = "1P-Mode";
    final static String Mode2 = "2P-Mode";
    
    JFrame frame = new JFrame("Tic-Tae-Toe");
	
    public Tab() {
    	frame.pack();
    	frame.setSize(600,800);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane, BorderLayout.CENTER);

        JPanel card1 = new JPanel(new GridLayout(4,3));        
        JPanel card2 = new JPanel(new GridLayout(0,3));
        card1.add(new player(card1, true));
        card2.add(new player(card2, false));
        
        tabbedPane.add(Mode1, card1);
        tabbedPane.add(Mode2, card2);
    }
    
}
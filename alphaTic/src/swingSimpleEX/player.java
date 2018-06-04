package swingSimpleEX;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class player extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	user player=new user();
	ai ai= new ai();
	int currentPlayer=1, aiNum=2, score1=0, score2=0;
	boolean needAI;
	JButton [] btn = new JButton [9];
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new BorderLayout());
	
	ImageIcon Bono = new ImageIcon(this.getClass().getResource("Bono.png"));
	ImageIcon Pika = new ImageIcon(this.getClass().getResource("Pika.png"));
	ImageIcon White = new ImageIcon(this.getClass().getResource("Whi.png"));
	JLabel wind = new JLabel("         Pikachu: "+score1+" vs "+"Bonobono: "+score2);
	public player(JPanel panelC, boolean plymode) {
		for(int i=0; i < 9; i++){
			btn[i] = new JButton(i+"¹öÆ°");
			panelC.add(btn[i]);
			btn[i].setIcon(White);
			btn[i].addActionListener(this);	
		}
		panel1.add(new JLabel("Copyright(c) Euncharming & Wind"));
		panel2.add(wind);
		panelC.add(panel1, "South");
		panelC.add(panel2, "South");
		needAI=plymode;
	}
	private void resetButton() {
		for(int i=0; i < 9; i++){
			btn[i].setIcon(White);
		}
	}
	private void toggleCurrentPlayer(int i) {
	 	if(currentPlayer==1) btn[i].setIcon(Pika);
	   	else if(currentPlayer==2) btn[i].setIcon(Bono);  
	  	if(currentPlayer==1) currentPlayer=2;
	  	else if(currentPlayer==2) currentPlayer=1;
	}	
   
	@Override
	public void actionPerformed(ActionEvent e){
		if(player.checkWinCondition()!=0) {
			if(player.checkWinCondition()==1) score1++;
			else score2++;
			wind.setText("         Pikachu: "+score1+" vs "+"Bonobono: "+score2);
			resetButton();
			player.resetindex(player.index);
			aiTurn();
			return;
		}
		int i;
		for(i=0; i<9; i++) {
			if(e.getSource().equals(btn[i])) 
				break;
		}
		if(player.userInput(currentPlayer, i)) toggleCurrentPlayer(i);
		
		if(player.checkWinCondition()!=0) return;
		  aiTurn();
	}
	private void aiTurn() {
		   if(!needAI) return;
		   int aiChoice=ai.isItMe(currentPlayer, player.index, aiNum);
			  System.out.println(aiChoice);
			  if(aiChoice!=-1) {
				  player.userInput(aiNum, aiChoice);
				  toggleCurrentPlayer(aiChoice);
		      }   
	   }
}

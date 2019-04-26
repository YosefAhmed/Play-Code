package Entities;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import forms.IF_form;
import javafx.util.Pair;

public class bag {

	private Player g;
	private String cardName="";
	private int cardNo=0;
	
	public boolean isEmpty() {
		return cardName=="";
	}
	public boolean isNoEmpty() {
		return cardNo==0;
	}
	public void addComponants() {
		if(g.game.get_panel().getComponentCount()==0) {
			JButton b=new JButton("open");
			g.game.get_panel().add(b);
			g.game.get_panel().setBackground(Color.CYAN);
			
			//JOptionPane.showMessageDialog(null,"");
		}
		else
			g.game.get_panel().setBackground(Color.WHITE);
	}
	
	public void set_card(String card)
	{
		this.cardName=card;
	}
	public void set_cardNo(int cardNo)
	{
		this.cardNo=cardNo;
	}
	public String get_card() 
	{
		return cardName;
	}
	public int get_cardNo() 
	{
		return cardNo;
	}
}

package Entities;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import forms.IF_form;

public class bag {

	private Player g;
	private String card="";
	
	
	public boolean isEmpty() {
		return card=="";
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
		this.card=card;
	}
	public String get_card() 
	{
		return card;
	}
}

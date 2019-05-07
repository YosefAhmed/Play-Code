package Entities;


public class bag {

	private Player g;
	private String cardName="";
	private int cardNo=0;
	
	public boolean isEmpty() {
		return cardName=="";
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

package graphics;

import java.text.DecimalFormat;

import forms.GameForm;
import javafx.util.Pair; 


public class Locations {

  //contains a character that represents the location of the click
	private byte location=0;
	private Pair<String,String> Location;
  //to get size of the canvas 
	private GameForm game;
	public String lastObject="";
	public Locations(GameForm game) {
		this.game=game;
	}
	
	
	/**
	 	this function relates pixels to the size of the canvas
	 	@param pixels : the number of pixels 
	 	@param coordinate : X or Y to relate the pixels to the width of the canvas or to the height 
	 */
	private static DecimalFormat df2 =new DecimalFormat("#.###");
	public int relateToCanvas(float pixels,char coordinate) {
		if(coordinate=='x')
			return (int)(game.getcanvas().getWidth()*(Float.valueOf(df2.format(pixels/809))));
		else
			return (int)(game.getcanvas().getHeight()*(Float.valueOf(df2.format(pixels/562))));
	}
	
	public Pair<String, String> CheckLocation(int clickX, int clickY) 
	{	
			
		// locations of book shelfs  
		// first column Integers
			if(clickX>relateToCanvas(172,'x') && clickX < relateToCanvas(294, 'x'))
			{
				// first row
				if((clickY > relateToCanvas(43, 'y') && clickY < relateToCanvas(98, 'y')))
				{
					Location = new Pair<String, String>("i", "1");
					return Location;
				}
				// second row
				else if (clickY > relateToCanvas(111, 'y') && clickY < relateToCanvas(202, 'y'))
				{
					Location = new Pair<String, String>("i", "2");
					return Location;
				}
				// third row
				else if(clickY > relateToCanvas(215, 'y') && clickY < relateToCanvas(272, 'y'))
				{
					Location = new Pair<String, String>("i", "3");
					return Location;
				}
				
			}
		// second column Floats
			else if(clickX>relateToCanvas(306, 'x') && clickX < relateToCanvas(423, 'x'))
			{
				// first row
				if((clickY > relateToCanvas(43, 'y') && clickY < relateToCanvas(98, 'y')))
				{
					Location = new Pair<String, String>("f", "1");
					return Location;
				}
				// second row
				else if (clickY > relateToCanvas(111, 'y') && clickY < relateToCanvas(202, 'y'))
				{
					Location = new Pair<String, String>("f", "2");
					return Location;
				}
				// third row
				else if(clickY > relateToCanvas(215, 'y') && clickY < relateToCanvas(272, 'y'))
				{
					Location = new Pair<String, String>("f", "3");
					return Location;
				}
			}
		// third column Strings
			else if(clickX>relateToCanvas(434, 'x') && clickX < relateToCanvas(572, 'x'))
			{
				// first row
				if((clickY > relateToCanvas(43, 'y') && clickY < relateToCanvas(98, 'y')))
				{
					Location = new Pair<String, String>("s", "1");
					return Location;
				}
				// second row
				else if (clickY > relateToCanvas(111, 'y') && clickY < relateToCanvas(202, 'y'))
				{
					Location = new Pair<String, String>("s", "2");
					return Location;
				}
				// third row
				else if(clickY > relateToCanvas(215, 'y') && clickY < relateToCanvas(272, 'y'))
				{
					Location = new Pair<String, String>("s", "3");
					return Location;
				}
			}			
			Location = new Pair<String, String>("Wrong", "Wrong");
			return Location;
	}
	
	public String checkObjectLocation(int clickX, int clickY, int imgIndex)
	{
		if(clickX > relateToCanvas(280, 'x') && clickX < relateToCanvas(280+170, 'x') && clickY > relateToCanvas(380, 'y') && clickY < relateToCanvas(500, 'y') )
		{
			if(imgIndex >=0 && imgIndex <=2) {
				lastObject="S";
				return "S";	
			}
			 
			else if(imgIndex >=3 && imgIndex <=5) {
				lastObject="F";
				return "F";
			}
			else if(imgIndex >=6 && imgIndex <=8) {
				lastObject="I"; 
				return "I";
			}
				
		}
		return "wrong";
	}
	
}

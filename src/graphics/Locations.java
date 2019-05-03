package graphics;

import forms.GameForm;

public class Locations {

	boolean i=false, f=false, s=false;
	
	//relates the location to the canvas
	public int relateToCanvas(float pixels,GameForm game,char coordinate) {
	//	System.out.println(pixels/809);

		if(coordinate=='x')
			return (int)(game.getcanvas().getWidth()*(pixels/809));
		else
			return (int)(game.getcanvas().getHeight()*(pixels/562));
	}
	
	
	public boolean checkLocation(int x, int y) {
		
		
		
		return false;
	}
	
	
	
}

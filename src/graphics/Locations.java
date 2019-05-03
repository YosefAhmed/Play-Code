package graphics;

import forms.GameForm;

public class Locations {

	//public boolean i=false, f=false, s=false;
	private byte type=0;
	public int x,y;
	private GameForm game;
	
	public Locations(GameForm game) {
		this.game=game;
	}
	
	//relates the location to the canvas
	public int relateToCanvas(float pixels,char coordinate) {
	//	System.out.println(pixels/809);

		if(coordinate=='x')
			return (int)(game.getcanvas().getWidth()*(pixels/809));
		else
			return (int)(game.getcanvas().getHeight()*(pixels/562));
	}
	
	
	public byte checkLocation(int pointeX, int pointerY) {
		type=0;
		if((pointerY> relateToCanvas(43, 'y') && pointerY < relateToCanvas(98, 'y')) || //1st row
		   (pointerY> relateToCanvas(111, 'y') && pointerY < relateToCanvas(202, 'y'))||//2nd row
		   (pointerY> relateToCanvas(215, 'y') && pointerY < relateToCanvas(272, 'y'))) {//3rd row
			
		//integers column
			if(pointeX>relateToCanvas(172,'x') && pointeX < relateToCanvas(294, 'x')) {
				//i=true;
				type = 'i';
			}
		//floats column
			else if(pointeX>relateToCanvas(306, 'x') && pointeX < relateToCanvas(423, 'x')) {
				//f=true;
				type = 'f';
			} 
		//strings column
			else if(pointeX>relateToCanvas(434, 'x') && pointeX < relateToCanvas(572, 'x')) {
				//s=true;
				type = 's';
			}
		}
		
		return type;
	}
	
	
	
}

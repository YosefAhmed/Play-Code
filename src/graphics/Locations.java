package graphics;

import forms.GameForm;

public class Locations {

  //contains a character that represents the location of the click
	private byte location=0;
	
  //to get size of the canvas 
	private GameForm game;
	
	public Locations(GameForm game) {
		this.game=game;
	}
	
	
	/**
	 	this function relates pixels to the size of the canvas
	 	@param pixels : the number of pixels 
	 	@param coordinate : X or Y to relate the pixels to the width of the canvas or to the height 
	 */
	public int relateToCanvas(float pixels,char coordinate) {
		
		if(coordinate=='x')
			return (int)(game.getcanvas().getWidth()*(pixels/809));
		else
			return (int)(game.getcanvas().getHeight()*(pixels/562));
	}
	
	
	/** 
	 	this function checks if the X, Y coordinates of the pointer is on any 
	 	object on the floor, or on any of the shelfs
	 	@param clickX : the X coordinate of the click
	 	@param clickY : the Y coordinate of the click
	 */
	
	public byte checkLocation(int clickX, int clickY) {
		location=0;
	
	// locations of book shelfs  
		if((clickY> relateToCanvas(43, 'y') && clickY < relateToCanvas(98, 'y')) || //1st row
		   (clickY> relateToCanvas(111, 'y') && clickY < relateToCanvas(202, 'y'))||//2nd row
		   (clickY> relateToCanvas(215, 'y') && clickY < relateToCanvas(272, 'y'))) {//3rd row
			
		//integers column
			if(clickX>relateToCanvas(172,'x') && clickX < relateToCanvas(294, 'x')) {
				
				location = 'i';
			}
		//floats column
			else if(clickX>relateToCanvas(306, 'x') && clickX < relateToCanvas(423, 'x')) {
				location = 'f';
			} 
		//strings column
			else if(clickX>relateToCanvas(434, 'x') && clickX < relateToCanvas(572, 'x')) {
				location = 's';
			}
		}
		
	// locations of the objects on the floor
			else if( ( (clickX >= relateToCanvas(22, 'x') && clickX <= relateToCanvas(22+65, 'x') && 
					(clickY >= relateToCanvas(400, 'y') && clickY <= relateToCanvas(450, 'y')  )  ) ||
					( (clickX >= relateToCanvas(338, 'x') && clickX <= relateToCanvas(338+110, 'x') && 
					(clickY >= relateToCanvas(413, 'y') && clickY <= relateToCanvas(413+60, 'y')   )   ) || 
					(  (clickX >= relateToCanvas(150, 'x') && clickX <= relateToCanvas(250, 'x') && 
					(clickY >= relateToCanvas(481, 'y') && clickY <= relateToCanvas(481+50, 'y')    )    )					
					)  )  )  ) {
				location = 'S';
			}
		
			else if( ( (clickX >= relateToCanvas(196, 'x') && clickX <= relateToCanvas(296, 'x') && 
					(clickY >= relateToCanvas(412, 'y') && clickY <= relateToCanvas(412+70, 'y')  )  ) ||
					( (clickX >= relateToCanvas(485, 'x') && clickX <= relateToCanvas(485+79, 'x') && 
					(clickY >= relateToCanvas(360, 'y') && clickY <= relateToCanvas(360+81, 'y')   )   ) || 
					(  (clickX >= relateToCanvas(322, 'x') && clickX <= relateToCanvas(422, 'x') && 
					(clickY >= relateToCanvas(468, 'y') && clickY <= relateToCanvas(468+70, 'y')    )    )					
					)  )  )  ) {
				location = 'F';
			}
		
			else if( ( (clickX >= relateToCanvas(20, 'x') && clickX <= relateToCanvas(80, 'x') && 
					(clickY >= relateToCanvas(460, 'y') && clickY <= relateToCanvas(460+75, 'y')  )  ) ||
					( (clickX >= relateToCanvas(108, 'x') && clickX <= relateToCanvas(108+60, 'x') && 
					(clickY >= relateToCanvas(400, 'y') && clickY <= relateToCanvas(475, 'y')   )   ) || 
					(  (clickX >= relateToCanvas(390, 'x') && clickX <= relateToCanvas(390+60, 'x') && 
					(clickY >= relateToCanvas(355, 'y') && clickY <= relateToCanvas(355+75, 'y')    )    )					
					)  )  )  ) {
				location = 'I';
			}
		
		
		return location;
	}
	
	
	
}

package Entities;

import java.awt.*;
import java.io.IOException;

import forms.GameForm;
import graphics.Assets;

/**This class responsible for moving the player based on the key input */
public class Player extends Creature{

	private GameForm game;
	/**the constructor 
	 * @param game : GameForm
	 * @param x :float for X coordinate
	 * @param y :float for Y coordinate
	 */
	public Player(GameForm game,float x, float y) {
		super(x, y);
		this.game=game;
	}
	
	/**mark :char to mark the position*/
	char mark;  
	
	/**represents every tick */
	@Override
	public void tick() {		
	try {	
		System.out.println("X "+x+" width "+game.canvas.getWidth());
		System.out.println("Y "+y+" height "+game.canvas.getHeight());

		if(y<game.canvas.getHeight()*81/200)
			mark='u';  //up
	    else if(y>=(game.canvas.getHeight()*81/200)+4 &&y<=game.canvas.getHeight()*109/200)
			mark='c';  //center
	    else if(y>game.canvas.getHeight()*111/200)
	    	mark='d';  //down.


		//Left collision
		if(x<=GameForm.canvas.getWidth()*83/200) {
			  if(mark=='u') { //if up left
				  x=GameForm.canvas.getWidth()*83/200;
			  }
			  else if(mark=='c') { //if center left
				  
			    	if(y<(GameForm.canvas.getHeight()*81/200)+4) //if center left top
				       y=(GameForm.canvas.getHeight()*81/200)+4;
			    	
			    	else if(y>game.canvas.getHeight()*111/200-3) //if center left bottom 
			    		y=game.canvas.getHeight()*111/200-3;
			   } 
			  else { //if down
				  x=GameForm.canvas.getWidth()*83/200;
			  }
		}
		
		//right collision
		if(x>=GameForm.canvas.getWidth()*27/50) {
			  if(mark=='u') { //if up right
				  x=GameForm.canvas.getWidth()*27/50;
			  }
			  else if(mark=='c') { //if center right
				  
			    	if(y<(GameForm.canvas.getHeight()*81/200)+4) //if center right top
				       y=(GameForm.canvas.getHeight()*81/200)+4;
			    	
			    	else if(y>game.canvas.getHeight()*111/200-3) //if center right bottom 
			    		y=game.canvas.getHeight()*111/200-3;
			   } 
			  else { //if down
				  x=GameForm.canvas.getWidth()*27/50;
			  }
		}
			
		
		if(game.getKeyManager().up){//move up
			if(y<=0)
				y=0;
			else
			    y-=3;
		}
		if(game.getKeyManager().down){ //move down
			if(y>=game.canvas.getHeight()-58)
				y=game.canvas.getHeight()-58;			
			else
				y+=3;
		}
		if(game.getKeyManager().left){ //move left
			if(x<=0)
				x=0;
			else 
				x-=3;
		}
		if(game.getKeyManager().right){ //move right
			if(x>=game.canvas.getWidth()-80)
				x=game.canvas.getWidth()-80;
			else
				x+=3;
		}
	} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**to draw the player*/
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y,GameForm.canvas.getWidth()*6/100,GameForm.canvas.getHeight()*19/400, null);
		
	}
	
	

}

package Entities;

import java.awt.*;
import java.io.IOException;

import forms.GameForm;
import forms.IF_form;
import graphics.Assets;

/**This class responsible for moving the player based on the key input */
public class Player extends Creature{

	private IF_form game;
	/**the constructor 
	 * @param game : GameForm
	 * @param x :float for X coordinate
	 * @param y :float for Y coordinate
	 */
	public Player(IF_form game,float x, float y) {
		super(x, y);
		this.game=game;
	}
	
	/**mark :char to mark the Y position
	 * markX :char to mark the X position
	 * */
	char mark,markX;  
	

	/**represents every tick */
	@Override
	public void tick() {		
	try {	
		System.out.println("X "+x+" width "+game.canvas.getWidth());
		System.out.println("Y "+y+" height "+game.canvas.getHeight());

		if(y<game.canvas.getHeight()*81/200)
			mark='u';  //up
	    else if(y>=(game.canvas.getHeight()*81/200)+4 &&y<=game.canvas.getHeight()*109/200)
			mark='c';  //center Y
	    else if(y>game.canvas.getHeight()*111/200)
	    	mark='d';  //down.


		//Left collision
		if(x<=game.canvas.getWidth()*83/200) {
			  if(mark=='u') { //if up left
				  x=game.canvas.getWidth()*83/200;
			  }
			  else if(mark=='c') { //if center left
				  
			    	if(y<(game.canvas.getHeight()*81/200)+4) //if center left top
				       y=(game.canvas.getHeight()*81/200)+4;
			    	
			    	else if(y>game.canvas.getHeight()*111/200-3) //if center left bottom 
			    		y=game.canvas.getHeight()*111/200-3;
			   } 
			  else { //if down
				  x=game.canvas.getWidth()*83/200;
			  }
		}
		
		//right collision
		if(x>=game.canvas.getWidth()*27/50) {
			  if(mark=='u') { //if up right
				  x=game.canvas.getWidth()*27/50;
			  }
			  else if(mark=='c') { //if center right
				  
			    	if(y<(game.canvas.getHeight()*81/200)+4) //if center right top
				       y=(game.canvas.getHeight()*81/200)+4;
			    	
			    	else if(y>game.canvas.getHeight()*111/200-3) //if center right bottom 
			    		y=game.canvas.getHeight()*111/200-3;
			   } 
			  else { //if down
				  x=game.canvas.getWidth()*27/50;
			  }
		}
		
			if(x<game.canvas.getWidth()*83/200)
				markX='l'; //left
			if(x>=game.canvas.getWidth()*83/200 && x<=game.canvas.getWidth()*27/50)
				markX='c';  //center X
			if(x>game.canvas.getWidth()*27/50)
				markX='r';  //right

			System.out.println(mark+" "+markX);

			//down collision
			if(mark=='d'&& markX=='c') { 
				if(y>=game.canvas.getHeight()*675/1000) //if down center X  
					y=game.canvas.getHeight()*675/1000;
			}
			//left collision
			else if(mark=='c' && markX=='l') {
				if(x<=game.canvas.getWidth()*164/500) //if center Y left
					x=game.canvas.getWidth()*164/500;
			}
			//right collision
			else if(mark=='c' && markX=='r') {
				if(x>=game.canvas.getWidth()*63/100) //if center Y right
					x=game.canvas.getWidth()*63/100;
			}
			
			//up collision
			if(mark=='u'&& markX=='c') {
				if(y>=game.canvas.getHeight()*22/100) //if up center X
					y=game.canvas.getHeight()*22/100;
			}
			
		//move up
		if(game.getKeyManager().up){
			if(y<=0)
				y=0;
			else
			    y-=3;
		}
		
		//move down
		if(game.getKeyManager().down){
			if(y>=game.canvas.getHeight()-58)
				y=game.canvas.getHeight()-58;			
			else
				y+=3;
		}
		
		//move left
		if(game.getKeyManager().left){ 
			if(x<=0)
				x=0;
			else 
				x-=3;
		}
		
		//move right
		if(game.getKeyManager().right){ 
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
		g.drawImage(Assets.player, (int)x, (int)y,IF_form.canvas.getWidth()*6/100,IF_form.canvas.getHeight()*19/400, null);
		
	}
	
	

}

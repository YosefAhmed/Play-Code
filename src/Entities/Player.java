package Entities;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;

import IF_Level.IF_Level_Code;
import IF_Level.IF_form;
import Variables_Level.Var_Level_Code;
import forms.GameForm;
import graphics.Animation;
import graphics.Assets;
import graphics.collision;

/**This class responsible for moving the player based on the key input */
public class Player {

	private static  float x;
	private static float y;
	public static IF_form game;
	public static boolean IsFinished = false;
	
	public Player(IF_form game,float x, float y) {
		Player.game=game;
		this.x=x;
		this.y=y;
	}
	
	public static collision coll =new collision(x, y);
	
	String markY,markX, down_blocks_markX;  
	
	
	/**represents every tick */
	public void tick() 
	{
	try {	
			coll.setX(x);
			coll.setY(y);
			coll.leftCollision();
			coll.rightCollision();
			coll.downWalksidesCollision();
			coll.blocksCollision();
     		x=coll.getX();
     		y=coll.getY();


		
	/*================================================== Movement ==================================*/

		//move up
		if(game.getKeyManager().up){
			if(y<=0)
				y=0;
			else
			    y-=3;
		}
		
		//move down
		if(game.getKeyManager().down){
			if(y>=IF_form.get_canvas().getHeight()-58)
			{
				if(!IsFinished)
				{
					IF_form.frmGame.dispose();
					new IF_Level_Code();
					IsFinished = true;					
				}
			}
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
			if(x>=IF_form.get_canvas().getWidth()-80)
				x=IF_form.get_canvas().getWidth()-80;
			else
				x+=3;
		}
	/*================================================== Movement ==================================*/

		
	} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//tick brackets

	/**to draw the player*/
	public void render(Graphics g) 
	{
		g.drawImage(Assets.player, (int)x, (int)y,50,50, null);
	}
	
	

}

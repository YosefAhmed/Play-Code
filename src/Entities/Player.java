package Entities;

import java.awt.*;
import java.io.IOException;

import javax.swing.JButton;

import forms.GameForm;
import forms.IF_form;
import graphics.Assets;

/**This class responsible for moving the player based on the key input */
public class Player extends Creature{

	public static IF_form game;

	private bag bag =new bag();
	/**the constructor 
	 * @param game : GameForm
	 * @param x :float for X coordinate
	 * @param y :float for Y coordinate
	 */
	public Player(IF_form game,float x, float y) {
		super(x, y);
		Player.game=game;
	}
	
	/**mark :char to mark the Y position
	 * markX :char to mark the X position
	 * */
	String markY,markX, down_blocks_markX;  
	
	
	/**represents every tick */
	@Override
	public void tick() {		
	try {	
		System.out.println("X "+x+" width "+IF_form.get_canvas().getWidth());
		System.out.println("Y "+y+" height "+IF_form.get_canvas().getHeight());
		markX="c";
		
		//Mark Y
		if(y<IF_form.get_canvas().getHeight()*81/200)
			markY="u";  //up
	    else if(y>=(IF_form.get_canvas().getHeight()*81/200) &&y<=IF_form.get_canvas().getHeight()*109/200)
			markY="c";  //center Y
	    else if(y>IF_form.get_canvas().getHeight()*111/200)
	    	markY="d";  //down.
		
		//Mark X
		if(x<=IF_form.get_canvas().getWidth()*69/200)
			markX="l"; // left X
		if(x>IF_form.get_canvas().getWidth()*69/200 && x<=IF_form.get_canvas().getWidth()*601/1000)
			markX="c";  // center X
		if(x>=IF_form.get_canvas().getWidth()*601/1000)
			markX="r";  // right X	
				
		//Down blocks Mark X
		if(x<=(IF_form.get_canvas().getWidth()*57/125)-4)
			down_blocks_markX="L"; //left side
		else if(x>=IF_form.get_canvas().getWidth()*57/125 && x<=IF_form.get_canvas().getWidth()*249/500)
			down_blocks_markX="C"; //center
		else if(x>=(IF_form.get_canvas().getWidth()*249/500)+4)
			down_blocks_markX="R"; //right side
		
		
		/*================================================== Left collision==================================*/
		
		if(x<=IF_form.get_canvas().getWidth()*83/200) {
			
			//if up left
			if(markY=="u") 
			{
				if(y>=IF_form.get_canvas().getHeight()*10/200) 
				{
					bag.set_card("VIP");
					bag.addComponants();
				}
				x=IF_form.get_canvas().getWidth()*83/200;
			}
			//if center left
			else if(markY=="c") { 
				//if center left top
				if(y<(IF_form.get_canvas().getHeight()*81/200)+4) 
					y=(IF_form.get_canvas().getHeight()*81/200)+4;
			    	
				//if center left bottom
			    if(x<=IF_form.get_canvas().getWidth()*69/200) 			    	
			    	if(y>IF_form.get_canvas().getHeight()*111/200-3) 
			    		y=IF_form.get_canvas().getHeight()*111/200-3;
			   }
		
		   //if down left
		   else 
			   if(x<=IF_form.get_canvas().getWidth()*70/200)
				  x=IF_form.get_canvas().getWidth()*70/200;
		} 
		/*================================================== Left collision==================================*/

		
		/*================================================== right collision==================================*/
		
		if(x>=IF_form.get_canvas().getWidth()*27/50) {
			
			//if up right
			if(markY=="u")
				  x=IF_form.get_canvas().getWidth()*27/50;
			  
			//if center right
			else if(markY=="c") { 
				  
			   //if center right top
				if(y<(IF_form.get_canvas().getHeight()*81/200)+4) 
					y=(IF_form.get_canvas().getHeight()*81/200)+4;
			    	
				//if center right bottom 
			    if(x>=IF_form.get_canvas().getWidth()*601/1000)
			    	if(y>IF_form.get_canvas().getHeight()*111/200-3) 
			    		y=IF_form.get_canvas().getHeight()*111/200-3;
			   }
			
			//if down
			else
			    if(x>=IF_form.get_canvas().getWidth()*601/1000)
					x=IF_form.get_canvas().getWidth()*601/1000;
			
		} 
		/*================================================== right collision==================================*/

		
		/*================================================== collision of down walk sides==================================*/
	
	//if center
	if(markY=="c") {
		
		//if the character collides with any of the 2 walk sides from the top 
		if(y>=IF_form.get_canvas().getHeight()*537/1000) {			
			if(x>=IF_form.get_canvas().getWidth()*393/1000 && x<=IF_form.get_canvas().getWidth()*57/125 || x>=IF_form.get_canvas().getWidth()*249/500 && x<=IF_form.get_canvas().getWidth()*279/500 )
				y=IF_form.get_canvas().getHeight()*537/1000;			
		}
	}
	
	//if down
	else if(markY=="d") {
		if(down_blocks_markX=="L") {
			//if the character collides with the left walk sides from the left
			if(x>=IF_form.get_canvas().getWidth()*393/1000)
				x=IF_form.get_canvas().getWidth()*393/1000;
		}
		else if(down_blocks_markX=="C") {
			//if the character collides with the left walk sides from the right
			if(x<=IF_form.get_canvas().getWidth()*57/125)
				x=IF_form.get_canvas().getWidth()*57/125;
			
			//if the character collides with the right walk sides from the left
			else if(x>=IF_form.get_canvas().getWidth()*249/500)
				x=IF_form.get_canvas().getWidth()*249/500;
		}
		else if(down_blocks_markX=="R") {
			
			//if the character collides with the left walk sides from the right
			if(x<IF_form.get_canvas().getWidth()*279/500)
				x=IF_form.get_canvas().getWidth()*279/500;
		}
	}
		
	/*================================================== collision of down walk sides==================================*/

			System.out.println(markY+" "+markX+" "+down_blocks_markX);//just for testing :)

			
	/*================================================== collision of Blocks==================================*/
			
			//down blocks collision
			if(markY=="d"&& (markX=="c" ||markX=="r" )) { 
				if(bag.get_cardNo()==100)
				{
					
				}
				else if(y>=IF_form.get_canvas().getHeight()*675/1000) //if down center X  
					y=IF_form.get_canvas().getHeight()*675/1000;
			}
			//left blocks collision
			else if(markY=="c" && markX=="l") {
				if(x<=IF_form.get_canvas().getWidth()*145/500) {//if center Y left
					x=IF_form.get_canvas().getWidth()*145/500;
				Assets.Messages[1]=true;	
				}
				else 		
					Assets.Messages[1]=false;
			}
			
			//right blocks collision
			else if(markY=="c" && markX=="r")
			{
				if(x>=IF_form.get_canvas().getWidth()*68/100) //if center Y right
			
				{
					x=IF_form.get_canvas().getWidth()*68/100;
					Assets.Messages[2]=true;
				}
				else 
					Assets.Messages[2]=false;
			}

			if(bag.isEmpty()) {
				//up blocks collision
				if(markY=="u"&& markX=="c") {
					
					if(y>=IF_form.get_canvas().getHeight()*22/100) //if up center X
					{
						Assets.Messages[0]=true;
						y=IF_form.get_canvas().getHeight()*22/100;
					}
					else 
						Assets.Messages[0]=false;
					
				}
			}
			else
				Assets.Messages[0]=false;
		/*================================================== collision of Blocks==================================*/
	
		
	/*================================================== collision of Blocks==================================*/

		
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
				y=IF_form.get_canvas().getHeight()-58;			
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
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y,IF_form.get_canvas().getWidth()*6/100,IF_form.get_canvas().getHeight()*19/400, null);
		
	}
	
	

}

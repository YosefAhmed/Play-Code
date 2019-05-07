package graphics;

import java.util.Random;

import Entities.bag;
import IF_Level.IF_form;
import javafx.util.Pair;

public class collision {
	
	public static boolean animationBlocks[] = new boolean[6];

	public static boolean IsFinished = false;
	private static boolean firstTime=true; //For not win at the first time
	Random rand = new Random();
	// Animation 
		public static Animation topBlock;
		public static Animation centerBlock;
		public static Animation rightDownBlock;
		public static Animation centerDownBlock;
		public static Animation leftDownBlock;
		public static bag bag =new bag();
	 /**mark :char to mark the Y position
	 * markX :char to mark the X position
	 * */
	private String markY,markX, down_blocks_markX;
	private float x, y; 

	Pair <Float, Float> cootdinates;
	public collision ( float  x, float y) {
		this.x=x;
		this.y=y;
		topBlock = new Animation(650,Assets.H_block,3);
		centerBlock = new Animation(650,Assets.V_block,3);
	}
	
	public void resetMarks() {		
		markX = "c";
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
		
		System.out.println(markX+"  "+markY);
	}
	
	
	public void leftCollision() {
		
		resetMarks();
		
		
		/*================================================== Left collision==================================*/
		
		if(x<=IF_form.get_canvas().getWidth()*83/200) {
			
			//if up left
			if(markY=="u") 
			{
				System.out.println("i'm U");

				if(y>=IF_form.get_canvas().getHeight()*10/200) 
				{
					
					if(bag.isEmpty())
					{
						// generate a random card VIP or Ordinary
						int index = rand.nextInt((1 - 0) + 1) + 0; 
						if (index ==0)
						{
							bag.set_card("VIP");
						}
						else 
							bag.set_card("Ordinary");
						
					}

						
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
			    	if(y>IF_form.get_canvas().getHeight()*111/210-3) 
			    	{
			    		y=IF_form.get_canvas().getHeight()*111/210-3;
			    		// collide with ID Shop 
			    		if(x<=IF_form.get_canvas().getWidth()*69/470)
			    		{
			    			int index = rand.nextInt((2 - 0) + 1) + 0;
			    			//For not win at the first time
			    			if(firstTime)
							{
			    				bag.set_cardNo(70);
							}
			    			// Generate a random ID
			    			else if(index==0)
			    			{
			    				bag.set_cardNo(70);
			    			}
			    			else if(index ==1)
			    			{
			    				bag.set_cardNo(100);
			    			}
			    			else if(index ==2)
			    			{
			    				bag.set_cardNo(150);
			    			}
			    		}
			    	}
			    		
			   }
		
		   //if down left
		   else 
			   if(x<=IF_form.get_canvas().getWidth()*70/200)
				   x=IF_form.get_canvas().getWidth()*70/200;
				  

		
		} 
		/*================================================== Left collision==================================*/
		//cootdinates = new Pair <Float, Float> (x,y);

	//	return cootdinates;

	}

	public void rightCollision() {
/*================================================== right collision==================================*/
		
		if(x>=IF_form.get_canvas().getWidth()*27/50) {
			
			//if up right
			if(markY=="u")
				  x=IF_form.get_canvas().getWidth()*27/50;
			  
			//if center right
			else if(markY=="c") { 
				  
			   //if center right top
				if(y<(IF_form.get_canvas().getHeight()*81/200)+4) 
				{
					y=(IF_form.get_canvas().getHeight()*81/200)+4;
					// Collide with ID Shop
				if(x>=IF_form.get_canvas().getWidth()*771/1000)
					{
						// Generate a random ID
						int index = rand.nextInt((2 - 0) + 1) + 0;
						// For not win at the first time
		    			if(firstTime)
						{
		    				bag.set_cardNo(150);
						}
						else if(index==0)
		    			{
		    				bag.set_cardNo(70);
		    			}
		    			else if(index ==1)
		    			{
		    				bag.set_cardNo(100);
		    			}
		    			else if(index ==2)
		    			{
		    				bag.set_cardNo(150);
		    			}
					}
				}
					
			    	
				//if center right bottom 
			    if(x>=IF_form.get_canvas().getWidth()*601/1000)
			    	if(y>IF_form.get_canvas().getHeight()*111/210-3) 
			    		y=IF_form.get_canvas().getHeight()*111/210-3;
			   }
			
			//if down
			else
			    if(x>=IF_form.get_canvas().getWidth()*601/1000)
					x=IF_form.get_canvas().getWidth()*601/1000;
			
		} 
		/*================================================== right collision==================================*/
	}
	
	public void downWalksidesCollision() {
		/*================================================== collision of down walk sides==================================*/
		
		//if center
		if(markY=="c") {
			
			//if the character collides with any of the 2 walk sides from the top 
			if(y>=IF_form.get_canvas().getHeight()*555/1100) {			
				if(x>=IF_form.get_canvas().getWidth()*393/1000 && x<=IF_form.get_canvas().getWidth()*57/125 || x>=IF_form.get_canvas().getWidth()*249/500 && x<=IF_form.get_canvas().getWidth()*279/500 )
					y=IF_form.get_canvas().getHeight()*555/1100;			
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
	}
	
	public void blocksCollision() {
		topBlock.tick();
		centerBlock.tick();
		/*================================================== collision of Blocks==================================*/
		
		//down blocks collision
		
		if(markY=="d"&& (markX=="c" ||markX=="r" )) 
		{
			if(bag.get_cardNo()!=0)
			{
				firstTime=false;
			}
						
			if(y>=IF_form.get_canvas().getHeight()*714/1100) //if down center X  
			{
				if(x<IF_form.get_canvas().getWidth()*395/1000)
				{
					if(bag.get_cardNo()==0)
					{
						Assets.Messages[3]=true;
						y=IF_form.get_canvas().getHeight()*714/1100;
					}
					else
					{
						if(bag.get_card()=="VIP")
						{
							if(bag.get_cardNo()==70)
							{
								//Animation 
								animationBlocks[5]=true;
							}
							else
							{
								Assets.Messages[4]=true;
								animationBlocks[5]=false;
								y=IF_form.get_canvas().getHeight()*714/1100;
							}
						}
						else 
						{
							animationBlocks[5]=false;
							y=IF_form.get_canvas().getHeight()*714/1100;
							Assets.Messages[4]=true;
						}
							
					}
					
				}
				// if down right
				else if(x>IF_form.get_canvas().getWidth()*275/500)
				{
					if(bag.get_cardNo()==0)
					{
						y=IF_form.get_canvas().getHeight()*714/1100;
						Assets.Messages[3]=true;
						
					}
					else
					{
						if(bag.get_card()=="Ordinary")
						{
							if(bag.get_cardNo()==150)
							{
								//Animation 
								animationBlocks[3]=true;
								
							}
							else
							{
								animationBlocks[3]=false;
								Assets.Messages[9]=true;
								y=IF_form.get_canvas().getHeight()*714/1100;
							}
						}
						else
						{
							animationBlocks[3]=false;
							Assets.Messages[9]=true;
							y=IF_form.get_canvas().getHeight()*714/1100;
						}
							
					}
				}
				else
				{
					if(bag.get_cardNo()==0)
					{
						Assets.Messages[3]=true;
						y=IF_form.get_canvas().getHeight()*714/1100;
					}
					else
					{
						if(bag.get_cardNo()==100)
						{
							//Animation
							animationBlocks[4]=true;
						}
						else
						{
							animationBlocks[4]=false;
							Assets.Messages[5]=true;
							y=IF_form.get_canvas().getHeight()*714/1100;

						}
					}
					
				}
					
			}
			else 
			{
				animationBlocks[3]=false;
				animationBlocks[4]=false;
				animationBlocks[5]=false;
				for(int i=3;i<10;i++)
					Assets.Messages[i]=false;
			}
				
		}
		
		//left blocks collision
		else if(markY=="c" && markX=="l")
		{
			if(x<=IF_form.get_canvas().getWidth()*145/500) {//if center Y left
				if(bag.get_card()=="Ordinary")
				{
					animationBlocks[1]=true;
				}
				if(bag.get_card()=="VIP")
				{
					x=IF_form.get_canvas().getWidth()*145/500;
					Assets.Messages[1]=true;
					animationBlocks[1]=false;
				}
			}
			else 		
			{
				animationBlocks[1]=false;
				Assets.Messages[1]=false;
			}
		}
		//right blocks collision
		else if(markY=="c" && markX=="r")
		{
			if(x>=IF_form.get_canvas().getWidth()*69/100 ) //if center Y right			
			{
				if(bag.get_card()=="VIP")
				{
					animationBlocks[2]=true;
				}
				if(bag.get_card()=="Ordinary")
				{
					x=IF_form.get_canvas().getWidth()*69/100;
					Assets.Messages[2]=true;
				}					
			}
			else 
			{
				animationBlocks[2]=false;
				Assets.Messages[2]=false;
			}
		}
		if(bag.isEmpty()) {
			//up blocks collision
			if(markY=="u"&& markX=="c") {
				
				if(y>=IF_form.get_canvas().getHeight()*22/115) //if up center X
				{
					Assets.Messages[0]=true;
					y=IF_form.get_canvas().getHeight()*22/115;
				}
				else 
				{
					Assets.Messages[0]=false;
				}
					
				
			}
		}
		else
		{
			if(markY=="u"&& markX=="c") {
			
			if(y>=IF_form.get_canvas().getHeight()*22/115) //if up center X
			{
				animationBlocks[0] =true;
			}
			else 
			{
				Assets.Messages[0]=false;
			}
			Assets.Messages[0]=false;
			}
		}
			
	/*================================================== collision of Blocks==================================*/
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}

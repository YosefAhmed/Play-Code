package graphics;

import IF_Level.IF_form;
import javafx.util.Pair;

public class collision {
 	
	 /**mark :char to mark the Y position
	 * markX :char to mark the X position
	 * */
	private String markY,markX, down_blocks_markX;
	private float x, y; 
	Pair <Float, Float> cootdinates;
	public collision ( float  x, float y) {
		this.x=x;
		this.y=y;

		
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
		
	}
	
	
	public Pair<Float,Float> leftCollision() {
		/*================================================== Left collision==================================*/
		
		if(x<=IF_form.get_canvas().getWidth()*83/200) {
			
			//if up left
			if(markY=="u") 
			{
/*				if(y>=IF_form.get_canvas().getHeight()*10/200) 
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

						
				}*/
				System.out.println("X "+x+" width "+IF_form.get_canvas().getWidth());
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
			 /*   		if(x<=IF_form.get_canvas().getWidth()*69/470)
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
			    		}*/
			    	}
			    		
			   }
		
		   //if down left
		   else 
			   if(x<=IF_form.get_canvas().getWidth()*70/200)
				   x=IF_form.get_canvas().getWidth()*70/200;
				  

		
		} 
		/*================================================== Left collision==================================*/
		cootdinates = new Pair <Float, Float> (x,y);

		return cootdinates;

	}
}

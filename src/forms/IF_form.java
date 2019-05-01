package forms;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import Entities.Player;
import Input.KeyManager;
import States.IF_state;
import States.state;
import graphics.Animation;
import graphics.Assets;

public class IF_form extends GameForm {

	
	//Input
	protected KeyManager keyManager;
	public IF_form(){
		keyManager = new KeyManager();
		
	}
	
	@Override
	protected void init(){
		initialize();
		Assets.init();  
		gamestate=new IF_state(this);
		state.setState(gamestate);
		frmGame.addKeyListener(keyManager);

		

	}
	
		@Override
	protected void tick() {
		keyManager.tick();		
		if(state.getState()!=null)
		state.getState().tick();		
	}

	@Override
	protected void render() {
		bs1 = canvas1.getBufferStrategy();
		if(bs1==null) {
			canvas1.createBufferStrategy(3);//number of buffers
			return;
		}
		
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		
		g=bs.getDrawGraphics();
		g1=bs1.getDrawGraphics();

		//clear screen
		g.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
		g1.clearRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
		//Draw Here
		
		//background
		g.drawImage(Assets.bg,0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
		//top blocks
		
		if(Player.bag.get_card()!=""&&Player.animationBlocks[0]==true )
		{
			
			g.drawImage(Player.topBlock.getCurrentFrame(),canvas.getWidth()*45/105, canvas.getHeight()*27/100,null);
		}
		else
		{
			g.drawImage(Assets.H_block[0],canvas.getWidth()*45/105, canvas.getHeight()*27/100,canvas.getWidth()*61/350,canvas.getHeight()*40/2600,null);
		}

		
		//down blocks
		if(Player.bag.get_card()=="VIP"&& Player.bag.get_cardNo()==70)
		{
			if(Player.animationBlocks[5])
			{
				g.drawImage(Player.topBlock.getCurrentFrame(),canvas.getWidth()*39/106, canvas.getHeight()*181/250,null);
			}
			else
				g.drawImage(Assets.H_block[0],canvas.getWidth()*39/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		else
		{
			
			g.drawImage(Assets.H_block[0],canvas.getWidth()*39/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		
		if((Player.bag.get_card()=="VIP"||Player.bag.get_card()=="Ordinary" )&& Player.bag.get_cardNo()==100)
		{
			if(Player.animationBlocks[4])
			{
				g.drawImage(Player.topBlock.getCurrentFrame(),canvas.getWidth()*50/106, canvas.getHeight()*181/250,null);
			}
			else
				g.drawImage(Assets.H_block[0],canvas.getWidth()*50/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		else
		{
			g.drawImage(Assets.H_block[0],canvas.getWidth()*50/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		if(Player.bag.get_card()=="Ordinary"&& Player.bag.get_cardNo()==150)
		{
			if(Player.animationBlocks[3])
			{
				g.drawImage(Player.topBlock.getCurrentFrame(),canvas.getWidth()*60/105, canvas.getHeight()*181/250,null);
			}
			else
				g.drawImage(Assets.H_block[0],canvas.getWidth()*60/105, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		else
		{
			
			g.drawImage(Assets.H_block[0],canvas.getWidth()*60/105, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		}
		//right blocks
		
		if(Player.bag.get_card()=="VIP")
		{
			if(Player.animationBlocks[2])
			{
				g.drawImage(Player.centerBlock.getCurrentFrame(),canvas.getWidth()*74/100, canvas.getHeight()*203/500,null);
			}
			else
			{
				g.drawImage(Assets.V_block[0],canvas.getWidth()*74/100, canvas.getHeight()*203/500,canvas.getWidth()*30/2600,canvas.getHeight()*68/350,null);
			}
		}
		else
		{
			g.drawImage(Assets.V_block[0],canvas.getWidth()*74/100, canvas.getHeight()*203/500,canvas.getWidth()*30/2600,canvas.getHeight()*68/350,null);
		}
		
		//left blocks
		if(Player.bag.get_card()=="Ordinary")
		{
			if(Player.animationBlocks[1])
			{
				g.drawImage(Player.centerBlock.getCurrentFrame(),canvas.getWidth()*145/500, canvas.getHeight()*203/500 ,null);
			}
			else
			{
				g.drawImage(Assets.V_block[0],canvas.getWidth()*145/500, canvas.getHeight()*203/500,canvas.getWidth()*30/2600,canvas.getHeight()*68/350 ,null);
			}
		}
		else
		{
			g.drawImage(Assets.V_block[0],canvas.getWidth()*145/500, canvas.getHeight()*203/500,canvas.getWidth()*30/2600,canvas.getHeight()*68/350 ,null);
		}
		
		
		//********************************************** Set Messages Position *****************************************//
		if(Assets.Messages[0])
			g.drawImage(Assets.msgs[0],canvas.getWidth()*49/120, canvas.getHeight()*67/220, canvas.getWidth()*2/10,canvas.getHeight()*2/10 ,null);
		if(Assets.Messages[1])
			g.drawImage(Assets.msgs[1],canvas.getWidth()*45/520, canvas.getHeight()*65/150, canvas.getWidth()*2/10,canvas.getHeight()*2/10 ,null);
		if(Assets.Messages[2])
			g.drawImage(Assets.msgs[2],canvas.getWidth()*320/420, canvas.getHeight()*61/150, canvas.getWidth()*2/10,canvas.getHeight()*2/10 ,null);
		for(int i=3;i<10;i++)
		{
			if(Assets.Messages[i])
			{
				g.drawImage(Assets.msgs[i],canvas.getWidth()*320/440, canvas.getHeight()*115/150, canvas.getWidth()*2/10,canvas.getHeight()*2/10 ,null);				
			}
		}
		
		//********************************************** Set Messages Position *****************************************//
		
		// show the cards in the right canvas
				if(Player.bag.get_card()=="VIP")
				{
					if(Player.bag.get_cardNo()==0)
					{
						g1.drawImage(Assets.card[0],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);
					}
					else if(Player.bag.get_cardNo()==70)
					{
						g1.drawImage(Assets.VIPID[0],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);
					}
					else if(Player.bag.get_cardNo()==100)
					{
						g1.drawImage(Assets.VIPID[1],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);	
					}
					else if(Player.bag.get_cardNo()==150)
					{
						g1.drawImage(Assets.VIPID[2],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);	
					}
					
				}
				else if(Player.bag.get_card()=="Ordinary")
				{
					if(Player.bag.get_cardNo()==0)
					{
						g1.drawImage(Assets.card[1],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);
					}
					else if(Player.bag.get_cardNo()==70)
					{
						g1.drawImage(Assets.OrdinaryID[0],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);
					}
					else if(Player.bag.get_cardNo()==100)
					{
						g1.drawImage(Assets.OrdinaryID[1],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);	
					}
					else if(Player.bag.get_cardNo()==150)
					{
						g1.drawImage(Assets.OrdinaryID[2],0,0,canvas1.getWidth(), frmGame.getHeight()/4, null);	
					}
				}
		
		if(state.getState()!=null)
			state.getState().render(g);

		
		//End Drawing
		bs.show();
		bs1.show();
		g.dispose(); 

		
	}

	public KeyManager getKeyManager() {
		return keyManager;
		}

	public static Canvas get_canvas() {
		return canvas;
	}






}

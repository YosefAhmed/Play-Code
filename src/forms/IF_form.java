package forms;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import Entities.Player;
import Input.KeyManager;
import States.IF_state;
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
		if(Player.bag.get_card()!="" )
		{
			
			g1.fillRect(5, 20, 100, 100);
				
			g.drawImage(Player.topBlock.getCurrentFrame(),canvas.getWidth()*45/105, canvas.getHeight()*27/100,null);
		}
		else
		{
			g.drawImage(Assets.H_block[0],canvas.getWidth()*45/105, canvas.getHeight()*27/100,null);
			//g.drawImage(Assets.H_block[0],canvas.getWidth()*45/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
			//g.drawImage(Assets.H_block[0],canvas.getWidth()*54/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		}

		
		//down blocks
		g.drawImage(Assets.H_block[0],canvas.getWidth()*39/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block[0],canvas.getWidth()*50/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block[0],canvas.getWidth()*60/105, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);

		//right blocks
		g.drawImage(Assets.V_block[0],canvas.getWidth()*74/100, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block[0],canvas.getWidth()*74/100, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		//left blocks
		g.drawImage(Assets.V_block[0],canvas.getWidth()*145/500, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block[0],canvas.getWidth()*145/500, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		for(int i=0;i<10;i++)
		{
			if(Assets.Messages[i])
			{
				g.drawImage(Assets.msgs[i],canvas.getWidth()*29/45, canvas.getHeight()*27/500, canvas.getWidth()*2/10,canvas.getHeight()*2/10 ,null);				
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

package forms;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import Input.KeyManager;
import States.GameState;
import States.state;
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
		gamestate=new GameState(this);
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
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		g=bs.getDrawGraphics();
		
		//clear screen
		g.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
		
		//Draw Here
		
		//background
		g.drawImage(Assets.bg,0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
		//top blocks
		g.drawImage(Assets.H_block,canvas.getWidth()*45/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block,canvas.getWidth()*54/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		
		//down blocks
		g.drawImage(Assets.H_block,canvas.getWidth()*39/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block,canvas.getWidth()*50/106, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block,canvas.getWidth()*60/105, canvas.getHeight()*181/250,canvas.getWidth()*12/130,canvas.getHeight()*1/70,null);

		//right blocks
		g.drawImage(Assets.V_block,canvas.getWidth()*74/100, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block,canvas.getWidth()*74/100, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		//left blocks
		g.drawImage(Assets.V_block,canvas.getWidth()*145/500, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block,canvas.getWidth()*145/500, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		
		if(state.getState()!=null)
			state.getState().render(g);

		
		//End Drawing
		bs.show();
		g.dispose(); 
		
	}

	public KeyManager getKeyManager() {
		return keyManager;
		}

	public static Canvas get_canvas() {
		return canvas;
	}

	public Panel get_panel() {
		return panel;
	}


}

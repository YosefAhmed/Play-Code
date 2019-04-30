package forms;

import Entities.Player;
//import States.GameState;
import States.state;
import graphics.Assets;

public class Var_form extends GameForm{

	@Override
	protected void init() {
		initialize();
		Assets.init();  
		//gamestate=new GameState(this);
		state.setState(gamestate);
		//frmGame.addKeyListener(keyManager);		
	}

	@Override
	protected void tick() {
	//	if(state.getState()!=null)
	//	state.getState().tick();		
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
		
		g.drawOval(0, 0, 100, 100);
		
		//End Drawing
		bs.show();
		bs1.show();
		g.dispose(); 		
	}

}

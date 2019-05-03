package forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import Entities.Player;
import Input.MouseManager;
//import States.GameState;
import States.state;
import graphics.Assets;
import graphics.Locations;

public class Var_form extends GameForm{

	MouseManager move;
	private int preX=0,preY=0,width=50,hight=50;
	private boolean inCell=false;
	
	Locations loc=new Locations();
	
	public  Var_form() {
		move=new MouseManager();
	}
	
	
	@Override
	protected void init() {
		initialize();
		Assets.init();  
		canvas.addMouseListener(move);
		canvas.addMouseMotionListener(move);
	}

	@Override
	protected void tick() {
		if(state.getState()!=null)
		state.getState().tick();
		move.tick();		
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
		
		g.drawImage(Assets.bg1, 0, 0,canvas.getWidth(),canvas.getHeight(), null);
		g.drawImage(Assets.variables[0],loc.relateToCanvas(28f, this, 'x'),loc.relateToCanvas(478, this, 'y'), null);
		g.drawImage(Assets.variables[1],loc.relateToCanvas(338f, this, 'x'),loc.relateToCanvas(423, this, 'y'), null);
		g.drawImage(Assets.variables[2],loc.relateToCanvas(100f, this, 'x'),loc.relateToCanvas(491f, this, 'y'), null);
		g.drawImage(Assets.variables[3],loc.relateToCanvas(196f, this, 'x'),loc.relateToCanvas(412f, this, 'y'), null);
		g.drawImage(Assets.variables[4],loc.relateToCanvas(373f, this, 'x'),loc.relateToCanvas(442f, this, 'y'), null);
		g.drawImage(Assets.variables[5],loc.relateToCanvas(417f, this, 'x'),loc.relateToCanvas(350f, this, 'y'), null);
		g.drawImage(Assets.variables[6],loc.relateToCanvas(108f, this, 'x'),loc.relateToCanvas(415f, this, 'y'), null);
		g.drawImage(Assets.variables[7],loc.relateToCanvas(400f, this, 'x'),loc.relateToCanvas(498f, this, 'y'), null);
		
		//if i clicked on the shape
		
		if(move.state==0 && ((move.x <= 50 && move.x !=0)&&(move.y<=50 && move.y !=0))) {
		  if(!inCell) {
			move.state=1;
			width=70;
			hight=70;
			move.pressDown=0;
		  }
		}
		//if i released on the right place
		else if(move.state==1 && (move.x >= 400 && move.y>= 300)) {
			inCell=true;
			move.state=0;
			preX=move.x;
			preY=move.y;
			width=50;
			hight=50;
		}
		//if i released on wrong place
		else if( move.pressed) {
			move.state=0;
			width=50;
			hight=50;
		}

		g.drawImage(Assets.player,preX,preY,width,hight,null);
		

		
	//	g.drawImage(Assets.variables[0], x, y, observer)
		//End Drawing
		bs.show();
		bs1.show();
		g.dispose(); 		
	}

}

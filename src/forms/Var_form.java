package forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

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
	
	Locations loc=new Locations(this);
	
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
		
		//drawing background
		g.drawImage(Assets.bg1, 0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
		//drawing numbers and strings
		g.drawImage(Assets.variables[0],loc.relateToCanvas(22, 'x'),loc.relateToCanvas(400, 'y'),
				loc.relateToCanvas(65, 'x'),loc.relateToCanvas(50, 'y'), null);
		
		g.drawImage(Assets.variables[1],loc.relateToCanvas(338, 'x'),loc.relateToCanvas(423, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[2],loc.relateToCanvas(100, 'x'),loc.relateToCanvas(491, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[3],loc.relateToCanvas(196, 'x'),loc.relateToCanvas(412, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[4],loc.relateToCanvas(20, 'x'),loc.relateToCanvas(450, 'y'),
				loc.relateToCanvas(70, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[5],loc.relateToCanvas(417, 'x'),loc.relateToCanvas(360, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[6],loc.relateToCanvas(108, 'x'),loc.relateToCanvas(415, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		g.drawImage(Assets.variables[7],loc.relateToCanvas(322, 'x'),loc.relateToCanvas(478, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
		
		//if i clicked on the shape
		if(loc.checkLocation(move.x, move.y)=='i') {
			JOptionPane.showMessageDialog(null, "integer");
		}
		else if(loc.checkLocation(move.x, move.y)=='f') {
			JOptionPane.showMessageDialog(null, "float");

		}
		else if(loc.checkLocation(move.x, move.y)=='s') {
			JOptionPane.showMessageDialog(null, "string");

		}
		
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
		move.x = move.y = 0;
		bs.show();
		bs1.show();
		g.dispose(); 		
	}

}

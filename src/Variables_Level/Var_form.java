package Variables_Level;

import javax.swing.JOptionPane;
import Input.MouseManager;
import States.state;
import forms.GameForm;
import graphics.Assets;
import graphics.Locations;

public class Var_form extends GameForm{

	MouseManager move;
	private int preX=0,preY=0,width=50,hight=50;
	
 // not to change the state of mouse after putting the object in the bookshelf  
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
		try {
		bs1 = canvas1.getBufferStrategy();
		if(bs1==null) {
			canvas1.createBufferStrategy(3);//number of buffers
			System.out.println("bs1 is created");
			return;
		}
		
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		//System.out.println(bs1);

		//System.out.println(bs);
		g=bs.getDrawGraphics();
		g1=bs1.getDrawGraphics();

		//clear screen
		g.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
	//	g1.clearRect(0, 0, canvas1.getWidth(), canvas1.getHeight());
		
		
		//Draw Here
		
		//drawing background
		g.drawImage(Assets.bg1, 0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
	//drawing numbers and strings
		
							   //---------------- "5" ------------------//	
		g.drawImage(Assets.variables[0],loc.relateToCanvas(22, 'x'),loc.relateToCanvas(400, 'y'),
				loc.relateToCanvas(65, 'x'),loc.relateToCanvas(50, 'y'), null);
						 //---------------- I love reading ------------------//
		g.drawImage(Assets.variables[1],loc.relateToCanvas(338, 'x'),loc.relateToCanvas(413, 'y'),
				loc.relateToCanvas(110, 'x'),loc.relateToCanvas(60, 'y'), null);
					     //--------------- What is your name ------------------//
		g.drawImage(Assets.variables[2],loc.relateToCanvas(150, 'x'),loc.relateToCanvas(481, 'y'),
				loc.relateToCanvas(100, 'x'),loc.relateToCanvas(50, 'y'), null);
							   //---------------- 0.8 ------------------//
		g.drawImage(Assets.variables[3],loc.relateToCanvas(196, 'x'),loc.relateToCanvas(412, 'y'),
				loc.relateToCanvas(100, 'x'),loc.relateToCanvas(70, 'y'), null);
							   //---------------- 0 ------------------//
		g.drawImage(Assets.variables[4],loc.relateToCanvas(20, 'x'),loc.relateToCanvas(460, 'y'),
				loc.relateToCanvas(60, 'x'),loc.relateToCanvas(75, 'y'), null);
								//---------------- 3.0  ------------------//
		g.drawImage(Assets.variables[5],loc.relateToCanvas(485, 'x'),loc.relateToCanvas(360, 'y'),
				loc.relateToCanvas(79, 'x'),loc.relateToCanvas(81, 'y'), null);
								//---------------- 5 ------------------//
		g.drawImage(Assets.variables[6],loc.relateToCanvas(108, 'x'),loc.relateToCanvas(400, 'y'),
				loc.relateToCanvas(60, 'x'),loc.relateToCanvas(75, 'y'), null);
								//---------------- 7.3 ------------------//
		g.drawImage(Assets.variables[7],loc.relateToCanvas(322, 'x'),loc.relateToCanvas(468, 'y'),
				loc.relateToCanvas(100, 'x'),loc.relateToCanvas(70, 'y'), null);
								//---------------- 9 ------------------//
		g.drawImage(Assets.variables[8],loc.relateToCanvas(390, 'x'),loc.relateToCanvas(355, 'y'),
				loc.relateToCanvas(60, 'x'),loc.relateToCanvas(75, 'y'), null);
		
		
		System.out.println(move.state);
		
	// if the return of loc.checkLocation is UpperCase then the click is on one of the objects	
		if(move.state==0 && Character.isUpperCase(loc.checkLocation(move.x, move.y))) {
		  
			move.state=1;
			move.pressDown=0;
			/*if(!inCell) {
			width=70;
			hight=70;
		  }*/
			JOptionPane.showMessageDialog(null, "Object Selected");

		 
		}
		else if(move.state==1 && Character.isUpperCase(loc.checkLocation(move.x, move.y))) {
			  
			move.state=0;
		}
		//if i released on the right place
		else if(move.state==1 && (loc.checkLocation(move.x, move.y) == 'i' ||
								  loc.checkLocation(move.x, move.y) == 'f' ||
								  loc.checkLocation(move.x, move.y) == 's')) {
			move.state=0;
			/*inCell=true;
			preX=move.x-25;
			preY=move.y-25;
			width=50;
			hight=50;*/
			JOptionPane.showMessageDialog(null, "Object Released");

		}
		//if i released on wrong place
		else if( move.pressed) {
			move.state=0;
		//	width=50;
		//	hight=50;
		}
		

		//End Drawing
		move.x = move.y = 0;
		
		bs.show();
		//bs1.show();
		g.dispose(); 		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
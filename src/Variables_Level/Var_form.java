package Variables_Level;

import javax.swing.JOptionPane;

import Input.MouseManager;
import States.state;
import forms.GameForm;
import graphics.Assets;
import graphics.Locations;

public class Var_form extends GameForm{
	
	private int pic =0;
	MouseManager move;
	boolean isFinished =false;
	int library[][] = new int[3][3]; 
	Locations loc=new Locations(this);
	private int newX=0,newY=0,width,hight;

	public  Var_form() {
		move=new MouseManager();
		for(int i=0 ;i<3;i++) {
			for(int j=0 ; j<3 ; j++) {
				library[i][j]=-1;
			}
		}
	}
	
	
	@Override
	protected void init() {
		initialize();
		width=loc.relateToCanvas(170, 'x');hight=loc.relateToCanvas(120, 'y');
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
			
			
		bs1=canvas1.getBufferStrategy();
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

		g=bs.getDrawGraphics();
		g1=bs1.getDrawGraphics();

		//clear screen
		g.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
		
		
		//Draw Here
		
			
		//drawing background
		g.drawImage(Assets.bg1, 0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
		if(move.isClicked)
		{
			
			if(move.state==0 && Character.isUpperCase(loc.checkObjectLocation(move.x, move.y, pic).charAt(0)))
			{
					move.state=1;
					width=loc.relateToCanvas(190, 'x');
					hight=loc.relateToCanvas(140, 'y');
				
			}
			else if(move.state == 1)
			{
				if(loc.CheckLocation(move.x, move.y).getKey() == "i"  )
				{
				  if(loc.lastObject == "I") {	
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						library[0][0]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						library[0][1]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						library[0][2]=pic;
					}
					pic++;
				  }
				  else
					  JOptionPane.showMessageDialog(null, "You must put integer in Integer cell", "Wrong Decleration", JOptionPane.ERROR_MESSAGE);
				  
				}
				else if(loc.CheckLocation(move.x, move.y).getKey() == "f" ) {
				  if( loc.lastObject == "F") {	
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						library[1][0]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						library[1][1]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						library[1][2]=pic;
					}
					
					pic++;
					}
				  else
					  JOptionPane.showMessageDialog(null, "You must put float in Float cell", "Wrong Decleration", JOptionPane.ERROR_MESSAGE);
				}
				else if(loc.CheckLocation(move.x, move.y).getKey() == "s" ) {
				  if(loc.lastObject == "S") {
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						library[2][0]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						library[2][1]=pic;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						library[2][2]=pic;
					}
					pic++;
				  }
				  else
					  JOptionPane.showMessageDialog(null, "You must put string in String cell", "Wrong Decleration", JOptionPane.ERROR_MESSAGE);
				}
				width=loc.relateToCanvas(170, 'x');
				hight=loc.relateToCanvas(120, 'y');
				move.state=0;
			}
			move.isClicked =false;
		}
		// al sora al bndos 3aleha
		g.drawImage(Assets.variables[pic],loc.relateToCanvas(280, 'x'),loc.relateToCanvas(380, 'y'),width,hight, null);
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(i==0 && j==0)
				{
					newX =loc.relateToCanvas(185, 'x');
					newY = loc.relateToCanvas(50, 'y');
				}
				else if(i==0 && j==1)
				{
					newX =loc.relateToCanvas(185, 'x');
					newY = loc.relateToCanvas(134, 'y');
				}
				else if(i==0 && j==2)
				{
					newX =loc.relateToCanvas(185, 'x');
					newY = loc.relateToCanvas(211, 'y');
				}
				else if(i==1 && j==0)
				{
					newX =loc.relateToCanvas(320, 'x');
					newY = loc.relateToCanvas(50, 'y');
				}
				else if(i==1 && j==1)
				{
					newX =loc.relateToCanvas(320, 'x');
					newY = loc.relateToCanvas(134, 'y');
				}
				else if(i==1 && j==2)
				{
					newX =loc.relateToCanvas(320, 'x');
					newY = loc.relateToCanvas(211, 'y');
				}
				else if(i==2 && j==0)
				{
					newX =loc.relateToCanvas(459, 'x');
					newY = loc.relateToCanvas(50, 'y');
				}
				else if(i==2 && j==1)
				{
					newX =loc.relateToCanvas(459, 'x');
					newY = loc.relateToCanvas(134, 'y');
				}
				else if(i==2 && j==2)
				{
					newX =loc.relateToCanvas(459, 'x');
					newY = loc.relateToCanvas(211, 'y');
				}
				if(library[i][j]==0)
				{
					g.drawImage(Assets.variables[0], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
				else if(library[i][j]==1)
				{
					g.drawImage(Assets.variables[1], newX,newY ,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
				else if(library[i][j]==2)
				{
					g.drawImage(Assets.variables[2], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==3)
				{
					g.drawImage(Assets.variables[3], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==4)
				{
					g.drawImage(Assets.variables[4], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==5)
				{
					g.drawImage(Assets.variables[5], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==6)
				{
					g.drawImage(Assets.variables[6], newX,newY ,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
				else if(library[i][j]==7)
				{
					g.drawImage(Assets.variables[7], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==8)
				{
					g.drawImage(Assets.variables[8], newX,newY ,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
				else if(library[i][j]==9)
				{
					g.drawImage(Assets.variables[9], newX,newY,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y')  , null);
				}
				else if(library[i][j]==10)
				{
					g.drawImage(Assets.variables[10], newX,newY ,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
				else if(library[i][j]==11)
				{
					g.drawImage(Assets.variables[11], newX,newY ,loc.relateToCanvas(100, 'x'),loc.relateToCanvas(60, 'y') , null);
				}
			}
		}
		//End Drawing
		
		bs.show();
		if(isFinished)
		{
			isFinished=false;
			Thread.sleep(1000);
			Var_form.frmGame.dispose();
			new Var_Level_Code();
			pic=0;		
		}
		if(pic==Assets.variables.length-1) {
			isFinished=true;
						
	}
		g.dispose(); 	
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
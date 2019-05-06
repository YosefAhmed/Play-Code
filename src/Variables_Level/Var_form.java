package Variables_Level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;
import Input.MouseManager;
import States.state;
import forms.GameForm;
import graphics.Assets;
import graphics.Locations;
import javafx.util.Pair;

public class Var_form extends GameForm{
	
	//boolean isSelected [] = new boolean [9];
	//int inLocation [] = new int [9];
	private int pic =0;
	MouseManager move;
	private int newX=0,newY=0,width=50,hight=50;
	
	private Stack<BufferedImage> imgStack = new Stack<BufferedImage>(); 
	
	
 // not to change the state of mouse after putting the object in the bookshelf  
	private boolean inCell=false;
	
	Locations loc=new Locations(this);
	
	public  Var_form() {
		move=new MouseManager();
		/*
		for(int i=0;i<9;i++)
		{
			isSelected[i]=false;
			inLocation[i]=0;
		}*/
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
		g.setColor(Color.BLUE);
		g.fillRect(loc.relateToCanvas(280, 'x'),loc.relateToCanvas(380, 'y'), loc.relateToCanvas(170, 'x'),loc.relateToCanvas(120, 'y'));

		/*	if(pic==0)
			
		if((pic==0||pic==1||pic==2)&&loc.CheckLocation(move.x, move.y).getKey()=="s")
		{
			if(loc.CheckLocation(move.x, move.y).getValue()=="1")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
			{
				
			}
		}
		else if((pic==3||pic==4||pic==5)&&loc.CheckLocation(move.x, move.y).getKey()=="f")
		{
			if(loc.CheckLocation(move.x, move.y).getValue()=="1")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
			{
				
			}
		}
		else if((pic==6||pic==7|pic==8)&&loc.CheckLocation(move.x, move.y).getKey()=="i")
		{
			if(loc.CheckLocation(move.x, move.y).getValue()=="1")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
			{
				
			}
			else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
			{
				
			}
		}
		else 
		{
			
		}
		*/
		g.setColor(Color.BLUE);
		g.fillRect(loc.relateToCanvas(280, 'x'),loc.relateToCanvas(380, 'y'), loc.relateToCanvas(170, 'x'),loc.relateToCanvas(120, 'y'));
		
		if(move.isClicked)
		{
			
			if(move.state==0 && Character.isUpperCase(loc.checkObjectLocation(move.x, move.y, pic).charAt(0)))
			{
				//System.out.println(loc.checkObjectLocation(move.x, move.y));
				
				//if(loc.checkObjectLocation(move.x, move.y)!="wrong")
					move.state=1;
					width=80;
					hight=130;
				
			}
			else if(move.state == 1)
			{
				
				if(loc.CheckLocation(move.x, move.y).getKey() == "i" && loc.lastObject == "I") {
					imgStack.push(Assets.variables[pic]);
					pic++;
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						newX = 192;
						newY = 55;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						newX = 192;
						newY = 124;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						newX = 192;
						newY = 229;
					}
				}
				else if(loc.CheckLocation(move.x, move.y).getKey() == "f" && loc.lastObject == "F") {
					imgStack.push(Assets.variables[pic]);
					pic++;
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						newX = 320;
						newY = 55;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						newX = 320;
						newY = 124;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						newX = 320;
						newY = 229;
					}
				}
				else if(loc.CheckLocation(move.x, move.y).getKey() == "s" && loc.lastObject == "S") {
					System.out.println("ana gowa el string");
					imgStack.push(Assets.variables[pic]);
					pic++;
					if(loc.CheckLocation(move.x, move.y).getValue()=="1")
					{
						newX = 454;
						newY = 55;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="2")
					{
						newX = 454;
						newY = 124;
					}
					else if(loc.CheckLocation(move.x, move.y).getValue()=="3")
					{
						newX = 454;
						newY = 229;
					}
				}
				
				width=50;
				hight=70;
				move.state=0;
			}
			move.isClicked =false;
			System.out.println(move.state+"  "+ imgStack.size()+"  "+loc.CheckLocation(move.x, move.y).getKey()+"  "+loc.checkObjectLocation(move.x, move.y, pic));
		}
		
		g.drawImage(Assets.variables[pic],loc.relateToCanvas(280, 'x'),loc.relateToCanvas(380, 'y'),width,hight, null);
		if(! imgStack.isEmpty())
			for(int i=0; i<imgStack.size(); i++) {
	    
				g.drawImage(imgStack.get(i), newX, newY, null);
			}
		
		//End Drawing
			//move.x = move.y = 0;
		
		bs.show();
		//bs1.show();
		g.dispose(); 		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
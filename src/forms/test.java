package forms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import States.IF_state;
import States.state;
import graphics.Assets;

public class test extends GameForm {

	Movement move;
	public test() {
		move=new Movement();
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
		
		//draw here
		g.drawImage(Assets.player,move.x-35,move.y-35,null);
		
			
			
			
		//End Drawing
		bs.show();
		bs1.show();
		g.dispose();
	}

	public static  Canvas get_canvas() {
		// TODO Auto-generated method stub
		return canvas;
	}
	
	/*	public test() {

		Canvas canvas=new Canvas();
		canvas.setSize(700,700);
		canvas.setBackground(Color.WHITE);
		GridBagConstraints gbc_canvas1 = new GridBagConstraints();
		gbc_canvas1.fill = GridBagConstraints.BOTH;
		gbc_canvas1.gridx = 0;
		gbc_canvas1.gridy = 0;
		canvas.setFocusable(true);
		
		BufferStrategy bs;
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		
		g=bs.getDrawGraphics();		
		
		g.fillOval(0, 0, 500, 500);
		//getContentPane().add(canvas, gbc_canvas1);
		
		
		JPanel back=new JPanel();
		back.setSize(getSize());
		back.setBackground(Color.WHITE);
		back.setLayout(null);
		back.setLocation(0,0);
		
			JPanel panel=new JPanel();
			panel.setBackground(new Color(10,5,10));
			panel.setSize(150,100);
			panel.setName("panel : "+(1));
			back.add(panel);
		
		Movement mv=new Movement(back.getComponents());
		add(canvas);
		setVisible(true);
		
	}*/
	
}

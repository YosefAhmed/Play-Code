package forms;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Input.KeyManager;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.Shape;

import States.GameState;
import States.state;
import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Button;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public abstract class GameForm implements Runnable{

	//????????
	private Thread thread;
	//to control the loop in run()
	private boolean running=false;
	
	public JFrame frmGame;
	protected static  Canvas canvas = new Canvas();
	protected static Panel panel = new Panel();

	//To allow drawing
	protected BufferStrategy bs;
	
	//g is like a paint brush
	public Graphics g;
	
	private SpriteSheet sheet;				
	//state
	protected state gamestate;
			

	
	
	
	/**
	 * Create the application.
	 */
	public GameForm() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		
		//form
		frmGame = new JFrame();
		frmGame.setTitle("Game");
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		frmGame.setSize(screenSize.width*3/4,screenSize.height*3/4);
		frmGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGame.setVisible(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {frmGame.getWidth()*1/4,screenSize.width*2/3, 0};
		gridBagLayout.rowHeights = new int[]{473, 0};
		gridBagLayout.columnWeights = new double[]{frmGame.getWidth()*4/5, screenSize.width*2/3, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frmGame.getContentPane().setLayout(gridBagLayout);
		frmGame.setResizable(false);
		
		//panel
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		
		//panel.setLayout(new GridLayout(0, 1, 1, 1));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setSize(frmGame.getWidth()*1/5, frmGame.getHeight());
		frmGame.getContentPane().add(panel, gbc_panel);
		
		
		
		//canvas
		canvas.setSize(frmGame.getWidth()*4/5, frmGame.getHeight());
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.gridx = 1;
		gbc_canvas.gridy = 0;
		canvas.setFocusable(false);
		frmGame.getContentPane().add(canvas, gbc_canvas);
		

	}
	
	protected abstract Panel get_panel();

	protected abstract void init();
	
	protected abstract void tick() ;

	protected abstract void render(); 
	
	public void run(){
		
		init();
		
		int fbs=80;
		double timePerTick=1000000000/fbs; 
		double delta=0;
		long now , lastTime=System.nanoTime();
		while(running) {
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			lastTime=now;
			if(delta >=1) {
			tick();
			render();
			delta--;
			}
		}
		
		stop();
	}
	public synchronized void start() {
		if(running)
			return;
		running=true;
		thread=new Thread(this);
		thread.start();
	} 
    public synchronized void stop() {
    	if(!running)
			return;
    	running=false;
    	try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

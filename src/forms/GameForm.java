package forms;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import Input.KeyManager;
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
import java.awt.Button;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GameForm implements Runnable{

	public JFrame frmGame;
	private Thread thread;//????????
	private boolean running=false;//to control the loop in run()
	
	public static Canvas canvas = new Canvas();
	private BufferStrategy bs;//To allow drawing
	public Graphics g;//g is like a paint brush
	
	private BufferedImage test;
	
	private SpriteSheet sheet;				
			//state
			private state gamestate;
			
			//Input
			private KeyManager keyManager;
	
	/**
	 * Create the application.
	 */
	public GameForm() {
		keyManager = new KeyManager();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		Panel panel = new Panel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmGame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 1, 1));
		panel.setBackground(Color.CYAN);
		panel.setSize(frmGame.getWidth()*1/5, frmGame.getHeight());
		

		// canvas.setBackground(Color.BLACK);
		canvas.setSize(frmGame.getWidth()*4/5, frmGame.getHeight());
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.gridx = 1;
		gbc_canvas.gridy = 0;
		canvas.setFocusable(false);
		frmGame.getContentPane().add(canvas, gbc_canvas);
		

	}
	
	private void init()
	{
		initialize();
		Assets.init();  
		gamestate=new GameState(this);
		state.setState(gamestate);
		frmGame.addKeyListener(keyManager);

	}
	
	private void tick() 
	{
		keyManager.tick();		
		if(state.getState()!=null)
		state.getState().tick();
		 
	}

	private void render() {
		bs = canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);//number of buffers
			return;
		}
		g=bs.getDrawGraphics();
		
		//clear screen
		g.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
		
		//Draw Here
		
		g.drawImage(Assets.bg,0, 0,canvas.getWidth(),canvas.getHeight(), null);
		
		g.drawImage(Assets.H_block,canvas.getWidth()*45/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block,canvas.getWidth()*54/105, canvas.getHeight()*27/100,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		
	
		g.drawImage(Assets.H_block,canvas.getWidth()*45/105, canvas.getHeight()*181/250,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);
		g.drawImage(Assets.H_block,canvas.getWidth()*54/105, canvas.getHeight()*181/250,canvas.getWidth()*11/125,canvas.getHeight()*1/70,null);

		
		g.drawImage(Assets.V_block,canvas.getWidth()*69/100, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block,canvas.getWidth()*69/100, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		
		g.drawImage(Assets.V_block,canvas.getWidth()*165/500, canvas.getHeight()*203/500, canvas.getWidth()*1/70,canvas.getHeight()*1/10 ,null);
		g.drawImage(Assets.V_block,canvas.getWidth()*165/500, canvas.getHeight()*63/125, canvas.getWidth()*1/70,canvas.getHeight()*1/10,null);

		
		if(state.getState()!=null)
			state.getState().render(g);

		
		//End Drawing
		bs.show();
		g.dispose(); 
		
	}
	public float[] blockDimension;
	
	public void run(){
		init();
		
		int fbs=60;
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
	public KeyManager getKeyManager() {
		return keyManager;
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

package forms;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Start.Launcher;
import States.state;
import graphics.Assets;
import graphics.SpriteSheet;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public abstract class GameForm implements Runnable {

	//????????
	private Thread thread;
	//to control the loop in run()
	private boolean running=false;
	
	//containers
	public static JFrame frmGame;
	protected static  Canvas canvas1 = new Canvas(); //the bag
	protected static  Canvas canvas = new Canvas(); //the game place
	protected static JPanel panel =new JPanel(); //the panel contains the bag


	//To allow drawing
	protected BufferStrategy bs;
	protected BufferStrategy bs1;
	//g is like a paint brush
	public Graphics g;
	public Graphics g1;
	
	//for assets
	private SpriteSheet sheet;				
	//state
	protected state gamestate;

	//Back Button
	protected JButton back_btn=new JButton("Back");
	
	
	
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
		frmGame.setIconImage(Assets.icon);
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
				panel.setLayout(new FlowLayout(FlowLayout.CENTER));
				canvas1.setSize(frmGame.getWidth()*1/5, frmGame.getHeight());
				frmGame.getContentPane().add(panel, gbc_panel);
				panel.setBackground(Color.white);
		
		//canvas1
				canvas1.setSize(frmGame.getWidth()*1/5, frmGame.getHeight()*2/3);
				GridBagConstraints gbc_canvas1 = new GridBagConstraints();
				gbc_canvas1.anchor = GridBagConstraints.LINE_START;
				gbc_canvas1.gridx = 0;
				gbc_canvas1.gridy = 0;
				canvas1.setFocusable(false);
				canvas1.setBackground(Color.white);
				panel.add(canvas1, gbc_canvas1);

		      //adding the Back button to the panel below canvas1
                back_btn.setPreferredSize(new Dimension(canvas1.getWidth()*2/3,canvas1.getHeight()*1/9));
				back_btn.setBackground(Color.BLUE);
				back_btn.setForeground(Color.WHITE);
				Font myFont = new Font ("Courier New", 1, 20);
				back_btn.setFont(myFont);
				back_btn.setFocusable(false);
	        	back_btn.setEnabled(true);
				panel.setFocusable(false);
				panel.add(back_btn);
			    panel.add(Box.createRigidArea(new Dimension(-10, 150)));
		
			    
	/*	//---------------------------------------------  test -------------------------------	    

*/
				//---------------------------------------Back button action------------------//
				 back_btn.addActionListener(new ActionListener()
				    {
				        public void actionPerformed(ActionEvent e){   
				   	//---------------------****write the Back button Action here****---------
				        	//JOptionPane.showInputDialog(canvas.requestFocusInWindow());
				        	Launcher.main(null); //new Main_Form();
				        	bs.dispose();
				        	bs1.dispose();
				        	panel.removeAll();
				        	//back_btn.getModel().setPressed(true);
				        	frmGame.dispose();
				        	back_btn.setEnabled(false);
				        	
				        }
				   });
			   //---------------------------------------Back button action------------------//

				 
		//---------------------------------------------  test -------------------------------
				 
		//canvas
		canvas.setSize(frmGame.getWidth()*4/5, frmGame.getHeight());
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.gridx = 1;
		gbc_canvas.gridy = 0;
		canvas.setFocusable(false);
		frmGame.getContentPane().add(canvas, gbc_canvas);
		

	}
	

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
			if(!back_btn.isEnabled()) {
				System.out.println("returned");	
				return;
			}
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

	public Canvas getcanvas() {
		// TODO Auto-generated method stub
		return canvas;
	}

}

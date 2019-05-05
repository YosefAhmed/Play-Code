package forms;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IF_Level.IF_form;
import graphics.Assets;

public abstract class Intro_Form extends JFrame {

	protected JLabel pic;
	private JButton NextBt, BackBt;
    private static int CurrentImage ;    
    public int NoOfImages ;
       
	public Intro_Form() {
		setNoOfImages();
		setIconImage(Assets.icon);
		CurrentImage = 1;
		pic = new JLabel();
        pic.setBounds(220,50,700,410);
        
		DisplayImg(0);
        
        //Next Button setUp
        NextBt = new JButton();
        NextBt.setBounds(900, 470, 84, 48);
        NextBt.setText("Start");
        NextBt.setBackground(Color.darkGray);
        NextBt.setForeground(Color.WHITE);       
        NextBt.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				if (NextBt.getText()=="Play")
				{
					IF_form game = new IF_form();
					game.start();
					setVisible(false);
				}
				else
				{
					NextBt.setText("Next");
			        BackBt.setVisible(true);
			        DisplayImg(CurrentImage);
					CurrentImage += 1;
	                
					if(CurrentImage == NoOfImages )
	                {
						NextBt.setText("Play");
	                }
					else 
						NextBt.setText("Next");
				}
			  }
			
		});
        
      //Back Button setUp
        BackBt = new JButton();
        BackBt.setBounds(800, 470, 84, 48);
        BackBt.setText("Back");
        BackBt.setBackground(Color.darkGray);
        BackBt.setForeground(Color.WHITE);       
        BackBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				NextBt.setText("Next");
				NextBt.setVisible(true);
				DisplayImg(CurrentImage--);
				if(CurrentImage == 0 )
                {
					BackBt.setVisible(false);
					NextBt.setText("Start");
              
                }

			}
		});
        
        //Form Elements setUp
        add(pic);
        add(NextBt);
        add(BackBt);
        BackBt.setVisible(false);
        setTitle("Introduction to the Game");
        setLayout(null);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width*3/4,screenSize.height*3/4);
        getContentPane().setBackground(Color.decode("#45a49a"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
	public abstract void setNoOfImages();

	public abstract void DisplayImg(int i);
	
	
}

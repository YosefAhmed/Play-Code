package Start;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Display extends JFrame 
{
	private JPanel content = new JPanel();
	private CardLayout card=new CardLayout(getWidth(),getHeight());
	private Canvas canvas;
	
	//private String title ;
	//private int width,height;
	
	public Display(String title)
	{
		setTitle(title);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width*2/3,screenSize.height*2/3);
		createDisplay();
	}
	
	private void createDisplay()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout()); 
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		//for the card layout of the panel
		Container c = getContentPane();
        c.setLayout(card);
        
        
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(getSize()));
		canvas.setMaximumSize(new Dimension(getWidth(),getHeight()));
		canvas.setMinimumSize(new Dimension(getWidth(),getHeight()));
		canvas.setBackground(Color.BLUE);
        
       content.add(canvas);
		content.setBackground(Color.BLACK);
		add(content);
		//pack();
		System.out.println(getSize()+"\n"+getWidth()+"\n"+getHeight());
	    
	}
	
}

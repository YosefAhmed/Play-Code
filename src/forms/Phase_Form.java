package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import graphics.Assets;

public abstract class Phase_Form extends JFrame
{

	protected JLabel pic;
	private JButton NextBt, BackBt;
    public static int CurrentImage = 1;
    protected int NoOfImages ;
           	
	public Phase_Form() {		
		setNoOfImages();
		setIconImage(Assets.icon);
		pic = new JLabel();
        pic.setBounds(220,50,560,410);
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
				if (NextBt.getText()=="Finish")
				{
					finish();
					dispose();
					CurrentImage=1;
				}
				else
				{
					NextBt.setText("Next");
			        BackBt.setVisible(true);

			        DisplayImg(CurrentImage++);

					if(CurrentImage == NoOfImages )
	                {
						
						CurrentImage--;
						NextBt.setText("Finish");
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
		System.out.println(CurrentImage);

        BackBt.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				NextBt.setText("Next");
				NextBt.setVisible(true);
				
					DisplayImg(--CurrentImage);

			    if(CurrentImage == 0 )
                {
					CurrentImage++;
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
        setLayout(null);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width*3/4,screenSize.height*3/4);
        getContentPane().setBackground(Color.decode("#45a49a"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    
	public abstract void setNoOfImages();

	public abstract void DisplayImg(int i);
	
	public abstract void finish(); 
}

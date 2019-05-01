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
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import graphics.Assets;

public class Code_Form extends JFrame {

	private JLabel pic;
	private JButton NextBt, BackBt;
    private static int CurrentImage = 1;    
           	
	public Code_Form() {
			
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
				NextBt.setText("Next");
		        BackBt.setVisible(true);
		        DisplayImg(CurrentImage);
				CurrentImage += 1;
                
				if(CurrentImage == Assets.CodePhaseData_lvl2.length )
                {
					NextBt.setVisible(false);
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
				NextBt.setVisible(true);
				DisplayImg(--CurrentImage);
				if(CurrentImage == 0 )
                {
					BackBt.setVisible(false);
                }


				
			}
		});
        
        //Form Elements setUp
        add(pic);
        add(NextBt);
        add(BackBt);
        BackBt.setVisible(false);
        setTitle("Coding Phase");
        setLayout(null);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width*3/4,screenSize.height*3/4);
        getContentPane().setBackground(Color.decode("#45a49a"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void DisplayImg(int i){
        ImageIcon icon = new ImageIcon(Assets.CodePhaseData_lvl2[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
	
}

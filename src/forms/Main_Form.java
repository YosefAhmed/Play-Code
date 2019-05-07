package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import IF_Level.IF_Level_Intro;
import Start.Launcher;
import Variables_Level.Var_Level_Intro;
import Variables_Level.Var_form;
import graphics.Assets;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Form extends JFrame {
	
	private JPanel contentPane;
	private JLabel image;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	
	public Main_Form()
	{
		
		Assets.init();
		setIconImage(Assets.icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		image = new JLabel(new ImageIcon(Assets.mainBacKground));

		
	// level 1 button 
		JButton lvl1Button = new JButton("");
		lvl1Button.setIcon(new ImageIcon(Assets.mainLevel1Button));
		lvl1Button.setBounds(screenSize.width/20, screenSize.height*1/2, 200, 80);
		image.add(lvl1Button);
		// Level 1 action
		
				lvl1Button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Var_Level_Intro intro = new Var_Level_Intro();
						Launcher.m.dispose();					
					}
				});
		
		
	// level 2 button 
		JButton lvl2Button = new JButton("");
		lvl2Button.setIcon(new ImageIcon(Assets.mainLevel2Button));
		lvl2Button.setBounds(screenSize.width/20, (screenSize.height*1/2)+100, 200, 80);
		image.add(lvl2Button);
		// Level 2 action
		lvl2Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				 IF_Level_Intro intro = new IF_Level_Intro();
				Launcher.m.setVisible(false);
			}
		});
				
	// level 3 button 
		JButton lvl3Button = new JButton("");
		lvl3Button.setIcon(new ImageIcon(Assets.mainLevel3Button));
		lvl3Button.setBounds(screenSize.width/20, (screenSize.height*1/2)+200, 200, 80);
		image.add(lvl3Button);
		// Level 3 action
		lvl2Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
				
				
				
		contentPane.add(image);
		setResizable(false);
		setVisible(true);
		pack();
		
	 }

}

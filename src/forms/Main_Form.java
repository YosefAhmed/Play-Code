package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IF_Level.IF_Level_Intro;
import IF_Level.IF_form;
import Loops_Level.Loops_Form;
import Start.Launcher;
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
		//setBounds(screenSize.width/4, screenSize.height/100, 450, 300);
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
						Var_form game = new Var_form();
						
						game.start();
						System.out.println("i'v been started");
						Launcher.m.dispose();
						System.out.println("i'v been hiden");

						//Launcher.m.dispose();
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
				new IF_Level_Intro();
				Launcher.m.setVisible(false);
				//Launcher.m.dispose();
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
				Loops_Form game = new Loops_Form();
				game.start();
				Launcher.m.setVisible(false);
				//Launcher.m.dispose();
			}
		});
				
				
				
		contentPane.add(image);
		setResizable(false);
		setVisible(true);
		pack();
		
	 }

}

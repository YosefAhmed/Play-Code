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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Form extends JFrame {

	private JPanel contentPane;
	private JLabel image;
	public Main_Form()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Form.class.getResource("/textures/Icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		try {
			 image  = new JLabel(new ImageIcon(ImageIO.read(Main_Form.class.getResource("/textures/background.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// level 1 button 
		JButton lvl1Button = new JButton("");
		lvl1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IF_form game = new IF_form();
				game.start();
				setVisible(false);
			}
		});
		lvl1Button.setIcon(new ImageIcon(Main_Form.class.getResource("/textures/level1.png")));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		lvl1Button.setBounds(screenSize.width/20, screenSize.height*1/2, 200, 80);
		image.add(lvl1Button);
		
		// level 2 button 
				JButton lvl2Button = new JButton("");
				lvl2Button.setIcon(new ImageIcon(Main_Form.class.getResource("/textures/level2.png")));
				lvl2Button.setBounds(screenSize.width/20, (screenSize.height*1/2)+100, 200, 80);
				image.add(lvl2Button);
				
		// level 1 button 
				JButton lvl3Button = new JButton("");
				lvl3Button.setIcon(new ImageIcon(Main_Form.class.getResource("/textures/leve3.png")));
				lvl3Button.setBounds(screenSize.width/20, (screenSize.height*1/2)+200, 200, 80);
				image.add(lvl3Button);
				
				
		contentPane.add(image);
		setResizable(false);
		setVisible(true);
		pack();
		
	 }

}

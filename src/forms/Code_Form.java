package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Code_Form extends JFrame {

	private JLabel pic;
	private JButton NextBt, BackBt;
    private static int CurrentImage = 1;    
    
    //Images Path In Array
    String[] list = {
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\Start.png",//0
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\1.png",//1
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\2.png",//2
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\3.png",//3
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\4.png",//4
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\5.png",//5
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\6.png",//6
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\7.png",//7
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\8.png",//8
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\9.png",//9
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\10.png",//10
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\11.png",//11
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\12.png",//12
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\13.png",//13
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\14.png",//14
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\15.png",//15
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\16.png",//16
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\17.png",//17
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\18.png",//18
                      "C:\\Users\\Mohammed\\eclipse-workspace\\PlayCodeGame\\res\\textures\\Level2_IF\\end.png"//19

                    };
	
	public Code_Form() {
			
		pic = new JLabel();
        pic.setBounds(220,50,560,410);
		
        DisplayImg(0); // Displaying Start Image
        
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
                
				if(CurrentImage == list.length )
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
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
	
}

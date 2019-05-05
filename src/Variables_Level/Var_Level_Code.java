package Variables_Level;

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
import forms.Code_Form;
import graphics.Assets;

public class Var_Level_Code extends Code_Form{

	@Override
	public void DisplayImg(int i) {
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon(Assets.CodePhaseData_lvl2[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);

	}

	@Override
	public void setNoOfImages() {
		NoOfImages = Assets.CodePhaseData_lvl2.length;
		
	}

}
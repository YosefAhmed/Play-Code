package Variables_Level;

import java.awt.Image;

import javax.swing.ImageIcon;

import forms.Phase_Form;
import graphics.Assets;

public class Var_Level_Intro extends Phase_Form {

	@Override
	public void setNoOfImages() {
		NoOfImages = Assets.IntroPhaseData_lvl1.length;
		
	}

	@Override
	public void DisplayImg(int i) 
	{
		ImageIcon icon = new ImageIcon(Assets.IntroPhaseData_lvl1[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
		
	}

	@Override
	public void finish() {
		Var_form g = new Var_form();
		g.start();		
	}

}


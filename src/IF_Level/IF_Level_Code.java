package IF_Level;

import java.awt.Image;

import javax.swing.ImageIcon;

import forms.Phase_Form;
import graphics.Assets;

public class IF_Level_Code extends Phase_Form{
	
	public IF_Level_Code()
	{
		setTitle("IF Code");
	}
	@Override
	public void DisplayImg(int i) {
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
	@Override
	public void finish() {
		System.exit(0);		
	}
	

}

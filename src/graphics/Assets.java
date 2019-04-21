package graphics;

import java.awt.image.BufferedImage;

import forms.GameForm;

public class Assets
{
	public static BufferedImage player,H_block,V_block,bg;
	public static void init()
	{
		SpriteSheet H_blockLoader,V_blockLoader,	sheet =new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));   //the sprite sheet picture 
		
		player=sheet.crop(250, 0,50, 50);
		 H_blockLoader=new SpriteSheet(ImageLoader.loadImage("/textures/el 7agz.png"));
		 H_block=H_blockLoader.crop(0, 0,73, 10);
		 
		 V_blockLoader=new SpriteSheet(ImageLoader.loadImage("/textures/el 7agz V.png"));
		 V_block=V_blockLoader.crop(0, 0, 10, 73);
		 
		 bg =ImageLoader.loadImage("/textures/IF_Design.png");		
		
	}

}

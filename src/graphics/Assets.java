package graphics;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import forms.GameForm;

public class Assets
{
	public static BufferedImage player,H_block[],V_block[],bg;
	// pictures of the pop up messages
	public static BufferedImage msgs [];
	// pictures of the cards in the bag
	public static BufferedImage card [];
	// pictures of the VIP cards with the IDs in the bag 
	public static BufferedImage VIPID [];
	// pictures of the Ordinary cards with the IDs in the bag
	public static BufferedImage OrdinaryID [];
	// array of boolean of the pop up messages (shown or not shown )
	static public  boolean Messages[];

	public static void init()
	{
		SpriteSheet H_blockLoader,V_blockLoader,messages,sheet,cards;
		messages=new SpriteSheet(ImageLoader.loadImage("/textures/msgs.png"));	
		sheet =new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));   //the sprite sheet picture 
		cards = new SpriteSheet(ImageLoader.loadImage("/textures/cards.png"));
		msgs  = new BufferedImage[10]; // 10 Different messages 
		card  = new BufferedImage[2]; // 2 cards VIP or Ordinary
		VIPID  = new BufferedImage[3]; // 3 VIP cards 70,100,150
		OrdinaryID  = new BufferedImage[3]; // 3 Ordinary cards 70,100,150
		Messages= new boolean[10];
		Arrays.fill(Messages, Boolean.FALSE);// all messages are not shown at start
		player=sheet.crop(250, 0,50, 50);
		 H_blockLoader=new SpriteSheet(ImageLoader.loadImage("/textures/el 7agz.png"));
		 H_block= new BufferedImage[3];
		 H_block[0]=H_blockLoader.crop(0, 0,170, 10);
		 H_block[1]=H_blockLoader.crop(0, 0,70, 10);
		 H_block[2]=H_blockLoader.crop(0, 0,10, 10);

		 
		 V_blockLoader=new SpriteSheet(ImageLoader.loadImage("/textures/el 7agz V.png"));
		 V_block= new BufferedImage[3];
		 V_block[0]=V_blockLoader.crop(0, 0,10, 130);
		 V_block[1]=V_blockLoader.crop(0, 0,10, 10);
		 V_block[2]=V_blockLoader.crop(0, 0,10, 10);
		 
		 
		 bg =ImageLoader.loadImage("/textures/IF_Design.png");
		 // loop to cut the 10 messages from the Spreadsheet
		 for(int i=0,x=0;i<10;i++)
		 {
			 msgs[i] =messages.crop(x, 0, 262, 182);
			 x+=262;
		 }
		 
		 for(int i=0,x=0;i<2;i++)
		 {
			 card[i] =cards.crop(x, 0, 262, 182);
			 x+=262;
		 }
		 for(int i=0,x=524;i<3;i++)
		 {
			 VIPID[i] =cards.crop(x, 0, 262, 182);
			 x+=262;
		 }
		 for(int i=0,x=1310;i<3;i++)
		 {
			 OrdinaryID[i] =cards.crop(x, 0, 262, 182);
			 x+=262;
		 }
	}

}

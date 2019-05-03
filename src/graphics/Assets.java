package graphics;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import com.sun.org.apache.xpath.internal.operations.Variable;

import forms.GameForm;

public class Assets
{
	
	public static BufferedImage player,H_block[],V_block[],bg2,bg1,variables[];
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
	public static BufferedImage CodePhaseData_lvl2[];

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
		 
		 bg1 =ImageLoader.loadImage("/textures/LEVEL 1/BackGround2.png");
		 bg2 =ImageLoader.loadImage("/textures/IF_Design.png");
		 
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
		 
		 CodePhaseData_lvl2 = new BufferedImage[20];
		 CodePhaseData_lvl2[0]= ImageLoader.loadImage("/textures/Level2_IF/start.png");
		 CodePhaseData_lvl2[1]= ImageLoader.loadImage("/textures/Level2_IF/1.png");
		 CodePhaseData_lvl2[2]= ImageLoader.loadImage("/textures/Level2_IF/2.png");
		 CodePhaseData_lvl2[3]= ImageLoader.loadImage("/textures/Level2_IF/3.png");
		 CodePhaseData_lvl2[4]= ImageLoader.loadImage("/textures/Level2_IF/4.png");
		 CodePhaseData_lvl2[5]= ImageLoader.loadImage("/textures/Level2_IF/5.png");
		 CodePhaseData_lvl2[6]= ImageLoader.loadImage("/textures/Level2_IF/6.png");
		 CodePhaseData_lvl2[7]= ImageLoader.loadImage("/textures/Level2_IF/7.png");
		 CodePhaseData_lvl2[8]= ImageLoader.loadImage("/textures/Level2_IF/8.png");
		 CodePhaseData_lvl2[9]= ImageLoader.loadImage("/textures/Level2_IF/9.png");
		 CodePhaseData_lvl2[10]= ImageLoader.loadImage("/textures/Level2_IF/10.png");
		 CodePhaseData_lvl2[11]= ImageLoader.loadImage("/textures/Level2_IF/11.png");
		 CodePhaseData_lvl2[12]= ImageLoader.loadImage("/textures/Level2_IF/12.png");
		 CodePhaseData_lvl2[13]= ImageLoader.loadImage("/textures/Level2_IF/13.png");
		 CodePhaseData_lvl2[14]= ImageLoader.loadImage("/textures/Level2_IF/14.png");
		 CodePhaseData_lvl2[15]= ImageLoader.loadImage("/textures/Level2_IF/15.png");
		 CodePhaseData_lvl2[16]= ImageLoader.loadImage("/textures/Level2_IF/16.png");
		 CodePhaseData_lvl2[17]= ImageLoader.loadImage("/textures/Level2_IF/17.png");
		 CodePhaseData_lvl2[18]= ImageLoader.loadImage("/textures/Level2_IF/18.png");
		 CodePhaseData_lvl2[19]= ImageLoader.loadImage("/textures/Level2_IF/end.png");
		 
		 
		 variables= new BufferedImage[9];
		 
		 variables[0]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/-5-.png");
		 variables[1]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/I love reading_.png");
		 variables[2]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/What is your name_.png");
		 variables[3]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/0.8.png");
		 variables[4]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/0.png");
		 variables[5]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/3.0.png");
		 variables[6]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/5.png");
		 variables[7]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/7.3.png");
		 variables[8]=ImageLoader.loadImage("/textures/LEVEL 1/Spirates2/9.png");

		 

	}

}

package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity {
	protected float x,y;
	
	public Entity(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	/*public Color getPixleColor(int x,int y, BufferedImage image) throws IOException {
		 
		  // Getting pixel color by position x and y 
		/*int clr=0;
		int rgp[]=new int[3];
		try {
	    	clr=  image.getRGB(x,y); 
		}catch (Exception e) {

		}
		  int  red   = (clr & 0x00ff0000) >> 16;
		  int  green = (clr & 0x0000ff00) >> 8;
		  int  blue  =  clr & 0x000000ff;
		  
		  rgp[0]= red;
		  rgp[1]=green;
		  rgp[2]=blue;
		  System.out.println(clr);
		int rgp[]=new int[3];
		Color clr =Color.BLACK;
		try {		
			if(x>0&&y>0) {
			 clr = new Color(image.getRGB(x*5/4, y*5/4));
			  rgp[0]= clr.getRed();
			  rgp[1]=clr.getGreen();
			  rgp[2]=clr.getBlue();
	//			image.setRGB(x*5/4, y*5/4,55);
			  }
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(rgp[0]+" "+rgp[1]+" "+rgp[2]);
		//System.out.println(x+" "+y);
			
		return clr;
	}*/
	
}

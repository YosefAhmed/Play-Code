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
	
}

package graphics;

import java.awt.image.BufferedImage;

public class Animation
{
	private int speed , index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	private int NoFrames;
	
	public Animation(int speed, BufferedImage[] frames, int NoFrames)
	{
		this.frames = frames;
		this.speed = speed;
		this.NoFrames= NoFrames-1;
		index=0;
		timer=0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick()
	{
		timer+=System.currentTimeMillis()-lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer>speed)
		{
			index++;
			timer =0;
			if(index>=frames.length)
				index= NoFrames;
		}
	}
	
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
}

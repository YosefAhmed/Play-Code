package States;

import java.awt.Graphics;

import forms.GameForm;

public abstract class state {
	
	 private static state currentstate=null;
	
	 public static void setState(state state)
	 {
		 currentstate=state;
	 }
	 
	 public static state getState() {
		 return currentstate;
	 }
	//Class
	 
	 protected GameForm game;
	
	 public state(GameForm game) {
		 this.game=game;
	 }
	 
	public abstract void tick();
	public abstract void render(Graphics g);
	
}

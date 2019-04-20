package States;

import java.awt.Graphics;

import Entities.Player;
import forms.GameForm;
import graphics.Assets;


public class GameState extends state{

	private Player player;
	public GameState(GameForm game) {
		super(game);
		player=new Player(game,game.canvas.getWidth()*48/100, 20);
	}
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}

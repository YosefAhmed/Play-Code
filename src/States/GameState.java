package States;

import java.awt.Graphics;

import Entities.Player;
import forms.GameForm;
import forms.IF_form;
import graphics.Assets;


public class GameState extends state{

	private Player player;
	public GameState(IF_form game) {
		super(game);
		player=new Player(game,IF_form.get_canvas().getWidth()*48/100, 20);
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

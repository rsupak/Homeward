package dev.rsupak.tilegamev1_7.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.statics.EntityId;
import dev.rsupak.tilegamev1_7.gfx.Animation;
import dev.rsupak.tilegamev1_7.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, EntityId.Player);	
		
		bounds_x = 7;
		bounds_y = 20;
		bounds_width = 17;
		bounds_height = 38;
		
		//Animations
		animUp = new Animation(300, Assets.player_up);
		animDown = new Animation(300, Assets.player_down);
		animLeft = new Animation(300, Assets.player_left);
		animRight = new Animation(300, Assets.player_right);
		
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)(x - handler.getGameCamera().getxOffset()), 
										   (int)(y - handler.getGameCamera().getyOffset()), width, height);
	}

	@Override
	public void tick() {
		//Animations
		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), 
										   (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.drawRect((int)(x + bounds_x - handler.getGameCamera().getxOffset()), 
//				(int)(y + bounds_y - handler.getGameCamera().getyOffset()), bounds_width, bounds_height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		else if(xMove > 0)
			return animRight.getCurrentFrame();
		else if(yMove < 0)
			return animUp.getCurrentFrame();
		else
			return animDown.getCurrentFrame();
	}

}

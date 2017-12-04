package dev.rsupak.tilegamev1_7.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.statics.EntityId;
import dev.rsupak.tilegamev1_7.gfx.Animation;
import dev.rsupak.tilegamev1_7.gfx.Assets;

public class Enemy extends Creature {
	
	//Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;
	private long lastTime = System.currentTimeMillis();
	private final ScheduledExecutorService movement = Executors.newScheduledThreadPool(1);
	
	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32, EntityId.Enemy);	
		
		bounds_x = 0;
		bounds_y = 0;
		bounds_width = 32;
		bounds_height = 32;
		
		//Animations
		animUp = new Animation(300, Assets.enemy_up);
		animDown = new Animation(300, Assets.enemy_down);
		animLeft = new Animation(300, Assets.enemy_left);
		animRight = new Animation(300, Assets.enemy_right);
		
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
		long now = System.currentTimeMillis();
		if(now - lastTime >= 3000) {
			moveEnemy();
			lastTime = System.currentTimeMillis();
		}
		move();
		if(now - lastTime >= 500) {
			e_xMove = 0;
			e_yMove = 0;
		}
		move();	
	}
	
	private void moveEnemy() {
		e_xMove = 0;
		e_yMove = 0;
				
		Random enemyMovement = new Random();
		int random = enemyMovement.nextInt(4);
		
		switch(random) {
			case 0: e_xMove = speed / 3;
				break;
			case 1: e_xMove = -speed / 3;
				break;
			case 2: e_yMove = speed / 3;
				break;
			case 3: e_yMove = -speed / 3;
				break;
		}
	}
	
	
	private void getInput() {
		e_xMove = 0;
		e_yMove = 0;
		
		
//		if(handler.getKeyManager().e_up)
//			e_yMove = -speed;
//		if(handler.getKeyManager().e_down)
//			e_yMove = speed;
//		if(handler.getKeyManager().e_left)
//			e_xMove = -speed;
//		if(handler.getKeyManager().e_right)
//			e_xMove = speed;
//		move();
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
		if(e_xMove < 0)
			return animLeft.getCurrentFrame();
		else if(e_xMove > 0)
			return animRight.getCurrentFrame();
		else if(e_yMove < 0)
			return animUp.getCurrentFrame();
		else
			return animDown.getCurrentFrame();
	}

}

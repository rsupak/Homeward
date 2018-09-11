package dev.rsupak.tilegamev1_7.entities.creatures;

import java.awt.Rectangle;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.Entity;
import dev.rsupak.tilegamev1_7.entities.EntityManager;
import dev.rsupak.tilegamev1_7.entities.statics.EntityId;
import dev.rsupak.tilegamev1_7.states.GameState;
import dev.rsupak.tilegamev1_7.states.State;
import dev.rsupak.tilegamev1_7.tiles.Tile;
import dev.rsupak.tilegamev1_7.utils.LevelSelect;
import dev.rsupak.tilegamev1_7.worlds.World;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 60;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove, e_xMove, e_yMove;
	private String level;
	private int levelCase;
	private LevelSelect ls = new LevelSelect();
	private GameState gs;
	private World world;
	private EntityManager entityManager;
	
	public Creature(Handler handler, float x, float y, int width, int height, EntityId id) {
		super(handler, x, y, width, height, id);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		e_xMove = 0;
		e_yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollision(xMove, 0f))
			moveX();
		if(!checkEntityCollision(0f, yMove))
			moveY();	
		
		if(!checkEntityCollision(xMove, 0f))
			e_moveX();
		if(!checkEntityCollision(0f, yMove))
			e_moveY();	
	}
	
	public void moveX() {
		if(xMove > 0) { //Moving Right
			int tx = (int)(x + xMove + bounds_x + bounds_width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds_y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int)(y + bounds_y + bounds_height) / Tile.TILEHEIGHT)) {
				if(x > handler.getWorld().getWidth() * Tile.TILEWIDTH)
					x = 0;
				x += xMove;
			}
			else 
				x = tx * Tile.TILEWIDTH - bounds_x - bounds_width - 1;
		} else if(xMove < 0) { //Moving Left
			int tx = (int)(x + xMove + bounds_x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int)(y + bounds_y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int)(y + bounds_y + bounds_height) / Tile.TILEHEIGHT)) {
				if(x < 0)
					x = handler.getWorld().getWidth() * Tile.TILEWIDTH; 
				x += xMove;
			} else 
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds_x;
		}
	}
	
	public void moveY() {
		if(yMove < 0) { //Moving Up
			int ty = (int)(y + yMove + bounds_y) / Tile.TILEHEIGHT;
			Rectangle tempRect = new Rectangle((int)x, (int)y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			if(!collisionWithTile((int)(x + bounds_x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int)(x + bounds_x + bounds_width) / Tile.TILEWIDTH, ty)) {
				if(y < 0) 
					y = handler.getWorld().getHeight() * Tile.TILEHEIGHT;
				y += yMove;
			} else 
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds_y;
		} else if(yMove > 0) { //Moving Down
			int ty = (int)(y + yMove + bounds_y + bounds_height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds_x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int)(x + bounds_x + bounds_width) / Tile.TILEWIDTH, ty)) {
				if(y > handler.getWorld().getHeight() * Tile.TILEHEIGHT)
					y = 0;
				y += yMove;
			} else 
				y = ty * Tile.TILEHEIGHT - bounds_y - bounds_height - 1;
		}
	}
	
	public void e_moveX() {
		if(e_xMove > 0) { //Moving Right
			int tex = (int)(x + e_xMove + bounds_x + bounds_width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tex, (int)(y + bounds_y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tex, (int)(y + bounds_y + bounds_height) / Tile.TILEHEIGHT)) {
				if(x > handler.getWorld().getWidth() * Tile.TILEWIDTH)
					x = 0;
				x += e_xMove;
			}
			else 
				x = tex * Tile.TILEWIDTH - bounds_x - bounds_width - 1;
		} else if(e_xMove < 0) { //Moving Left
			int tex = (int)(x + e_xMove + bounds_x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tex, (int)(y + bounds_y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tex, (int)(y + bounds_y + bounds_height) / Tile.TILEHEIGHT)) {
				if(x < 0)
					x = handler.getWorld().getWidth() * Tile.TILEWIDTH; 
				x += e_xMove;
			} else 
				x = tex * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds_x;
		}
	}
	
	public void e_moveY() {
		if(e_yMove < 0) { //Moving Up
			int tey = (int)(y + e_yMove + bounds_y) / Tile.TILEHEIGHT;
			Rectangle tempRect = new Rectangle((int)x, (int)y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			if(!collisionWithTile((int)(x + bounds_x) / Tile.TILEWIDTH, tey) &&
					!collisionWithTile((int)(x + bounds_x + bounds_width) / Tile.TILEWIDTH, tey)) {
				if(y < 0) 
					y = handler.getWorld().getHeight() * Tile.TILEHEIGHT;
				y += e_yMove;
			} else 
				y = tey * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds_y;
		} else if(e_yMove > 0) { //Moving Down
			int tey = (int)(y + e_yMove + bounds_y + bounds_height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + bounds_x) / Tile.TILEWIDTH, tey) &&
					!collisionWithTile((int)(x + bounds_x + bounds_width) / Tile.TILEWIDTH, tey)) {
				if(y > handler.getWorld().getHeight() * Tile.TILEHEIGHT)
					y = 0;
				y += e_yMove;
			} else 
				y = tey * Tile.TILEHEIGHT - bounds_y - bounds_height - 1;
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	protected boolean checkLevelSelect(int x, int y) {
		return handler.getWorld().getTile(x, y).isLevelSelect();
	}

	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}

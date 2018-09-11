package dev.rsupak.tilegamev1_7.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rsupak.tilegamev1_7.Game;
import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.statics.EntityId;
import dev.rsupak.tilegamev1_7.states.GameState;
import dev.rsupak.tilegamev1_7.states.State;
import dev.rsupak.tilegamev1_7.utils.LevelSelect;
import dev.rsupak.tilegamev1_7.worlds.World;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected EntityId id;
	protected int bounds_x, bounds_y, bounds_width, bounds_height;
	protected int levelId;
	private Game game;
	private GameState gameState;
	private World world;
	private String level;
	private int levelCase = 0;
	
	public Entity(Handler handler, float x, float y, int width, int height, EntityId id) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		bounds_x = 0;
		bounds_y = 0;
		bounds_width = width;
		bounds_height = height;
		levelId = levelCase;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollision(float xOffset, float yOffset) {
		for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				if(e.id == EntityId.LevelTrigger) {
					System.out.println(LevelSelect.teleport(e.levelId));
					handler.switchLevel(LevelSelect.teleport(e.levelId));
					return true;
				}
				else
					return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds_x + xOffset),
				(int)(y + bounds_y + yOffset), bounds_width, bounds_height);
	}
	
	public abstract Rectangle getBounds();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBounds_height() {
		return bounds_height;
	}

	public void setBounds_height(int bounds_height) {
		this.bounds_height = bounds_height;
	}

	public EntityId getId() {
		return id;
	}
	
	public int getLevelId() {
		return levelId;
	}
	
}

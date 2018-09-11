package dev.rsupak.tilegamev1_7.worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.EntityManager;
import dev.rsupak.tilegamev1_7.entities.creatures.Enemy;
import dev.rsupak.tilegamev1_7.entities.creatures.Player;
import dev.rsupak.tilegamev1_7.entities.statics.Dungeon1;
import dev.rsupak.tilegamev1_7.entities.statics.OutWorld;
import dev.rsupak.tilegamev1_7.entities.statics.TestWorld;
import dev.rsupak.tilegamev1_7.entities.statics.Town1;
import dev.rsupak.tilegamev1_7.gfx.ImageLoader;
import dev.rsupak.tilegamev1_7.tiles.Tile;
import dev.rsupak.tilegamev1_7.utils.ColorMap;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] worldTiles;
	private BufferedImage image;
	private ColorMap colormap = new ColorMap();
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		loadWorldImage(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int)(Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH));
		int xEnd = (int)(Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1));
		int yStart = (int)(Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT));
		int yEnd = (int)(Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1));
		
		for(int y = yStart; y < yEnd; y++) {
			for(int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
										(int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		Tile t = Tile.mapTiles[worldTiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	public void loadWorldImage(String path) {
		StringBuilder sb = new StringBuilder();
		image = ImageLoader.loadImage(path);
		width = image.getWidth();
		height = image.getHeight();
		
		worldTiles = new int[width][height];
		for(int y = 0; y < height; y++) 
			for(int x = 0; x < width; x++) {
				int pixel = image.getRGB(x, y);
				int red = (pixel >> 16) & 0xFF;
				int green = (pixel >> 8) & 0xFF;
				int blue = pixel & 0xFF;
				if (red == 210 && green == 210 && blue == 210){
					entityManager.addEntity(new TestWorld(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					worldTiles[x][y] = 255;
				} else if (red == 255 && green == 255 && blue == 255) {
					entityManager.addEntity(new OutWorld(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					worldTiles[x][y] = 255;
				} else if (red == 255 && green == 0 && blue == 0) {
					entityManager.addEntity(new Dungeon1(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					worldTiles[x][y] = 255;
				} else if (red == 255 && green == 137 && blue == 154) {
					entityManager.addEntity(new Town1(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					worldTiles[x][y] = 10;
				}  else if (red == 255 && green == 195 && blue == 0) {
					entityManager.addEntity(new Enemy(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					worldTiles[x][y] = 1;
				} else if(red == 255 && green == 0 && blue == 220) {
					worldTiles[x][y] = 1;
					spawnX = x * Tile.TILEWIDTH;
					spawnY = y * Tile.TILEHEIGHT;
				}
					
				else
					worldTiles[x][y] = colormap.getTileBycolor(red, green, blue);
			}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
}

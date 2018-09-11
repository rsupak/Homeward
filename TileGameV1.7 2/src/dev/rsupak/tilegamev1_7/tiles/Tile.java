package dev.rsupak.tilegamev1_7.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Statics
	
	public static Tile[] mapTiles = new Tile[501];
	public static Tile dirtTile = new DirtTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile treeTile_1 = new TreeTile_1(2);
	public static Tile mountainTile = new MountainTile(3);
	public static Tile dwaterTile = new DeepWaterTile(4);
	public static Tile swaterTile = new ShallowWaterTile(5);
	public static Tile desertTile = new DesertTile(6);
	public static Tile columnTile = new ColumnTile(7);
	public static Tile floorTile = new FloorTile(8);
	public static Tile townRoadTile = new TownRoadTile(9);
	public static Tile cityTile = new CityTile(10);
	public static Tile innTile = new InnTile(11);
	public static Tile houseWall = new HouseWall(12);
	public static Tile levelTile = new LevelTile(255);
	public static Tile emptyTile = new EmptyTile(500);
	
	
	
	
	//Class

	public static final int TILEWIDTH = 50, TILEHEIGHT = 50;
	protected BufferedImage texture;
	protected final int id;
	protected int teleportId = 0;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		mapTiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isLevelSelect() {
		return false;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId() {
		return id;
	}
	
	public void setTeleportId(int tId) {
		this.teleportId = tId;
	}
	
	public int getTeleportId() {
		return teleportId;
	}
	
}

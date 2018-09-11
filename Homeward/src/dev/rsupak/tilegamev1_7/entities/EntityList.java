package dev.rsupak.tilegamev1_7.entities;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.creatures.Player;
import dev.rsupak.tilegamev1_7.entities.statics.TestWorld;
import dev.rsupak.tilegamev1_7.tiles.Tile;

public class EntityList {

	private static EntityManager entityManager;
	private static Handler handler;
	private int gridW = Tile.TILEWIDTH, gridH = Tile.TILEHEIGHT;
	private static Entity teleport1;
	
	public static void init() {
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		teleport1 = new TestWorld(handler, 5 * Tile.TILEWIDTH, 4 * Tile.TILEHEIGHT);
		entityManager.addEntity(teleport1);
	}
	
}

package dev.rsupak.tilegamev1_7;

import dev.rsupak.tilegamev1_7.gfx.GameCamera;
import dev.rsupak.tilegamev1_7.input.KeyManager;
import dev.rsupak.tilegamev1_7.states.GameState;
import dev.rsupak.tilegamev1_7.states.State;
import dev.rsupak.tilegamev1_7.worlds.World;

public class Handler {

	private Game game;
	private World world;
	private GameState gameState;
	
	public Handler(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public void switchLevel(String path) {
		getGame().clearScreen();
		getWorld().getEntityManager().clearEntities();
		gameState = new GameState(this);
		gameState.setWorldPath(path);
		world = new World(this, gameState.getWorldPath());
		gameState.setWorld(world);
		State.setState(gameState);
	}
	
}

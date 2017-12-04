package dev.rsupak.tilegamev1_7.states;

import java.awt.Graphics;

import dev.rsupak.tilegamev1_7.Game;
import dev.rsupak.tilegamev1_7.Game;
import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.EntityManager;
import dev.rsupak.tilegamev1_7.entities.creatures.Player;
import dev.rsupak.tilegamev1_7.entities.statics.TestWorld;
import dev.rsupak.tilegamev1_7.utils.LevelSelect;
import dev.rsupak.tilegamev1_7.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	private Game game;
	private TestWorld testWorld;
	private EntityManager entityManager;
	private String worldPath = LevelSelect.teleport(1);
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, worldPath);
		handler.setWorld(world);	
		State.setState(this);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public String getWorldPath() {
		return worldPath;
	}

	public void setWorldPath(String path) {
		worldPath = path;
	}
	
	public void switchLevel(String path) {
		new GameState(handler);
		this.setWorldPath(path);
		world = new World(handler, getWorldPath());
		setWorld(world);
		State.setState(this);
	}
	
}

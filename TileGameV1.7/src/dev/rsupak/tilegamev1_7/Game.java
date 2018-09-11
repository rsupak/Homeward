package dev.rsupak.tilegamev1_7;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.rsupak.tilegamev1_7.display.Display;
import dev.rsupak.tilegamev1_7.gfx.Assets;
import dev.rsupak.tilegamev1_7.gfx.GameCamera;
import dev.rsupak.tilegamev1_7.gfx.SpriteSheet;
import dev.rsupak.tilegamev1_7.input.KeyManager;
import dev.rsupak.tilegamev1_7.states.GameState;
import dev.rsupak.tilegamev1_7.states.State;

public class Game implements Runnable{
	
	private Display display;
	private Thread thread;
	
	private String title;
	private int width, height;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Handler
	private Handler handler;
	
	//States
	private State gameState;
	
	//Inputs
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		gameState = new GameState(handler);
		State.setState(gameState);
		
	}
	
	public void tick() {
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear Screen
		clearScreen();
		
		//Draw Here
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing
		
		bs.show();
		g.dispose();
	}
	
	
	@Override
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1e9 / fps;
		double delta = 0; //Change in seconds
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1e9) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clearScreen() {
		g.clearRect(0, 0, width, height);
	}
	
	//Getters and Setters
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


}

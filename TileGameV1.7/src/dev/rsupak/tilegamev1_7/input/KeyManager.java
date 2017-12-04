package dev.rsupak.tilegamev1_7.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener, FocusListener{

	private boolean[] keys;
	public boolean up, down, left, right, e_up, e_down, e_left, e_right, quit;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		quit = keys[KeyEvent.VK_ESCAPE];
		
		e_up = keys[KeyEvent.VK_I];
		e_down = keys[KeyEvent.VK_K];
		e_left = keys[KeyEvent.VK_J];
		e_right = keys[KeyEvent.VK_L];
		if(quit)
			System.exit(1);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
	}

}


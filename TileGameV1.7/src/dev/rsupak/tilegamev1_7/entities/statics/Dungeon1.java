package dev.rsupak.tilegamev1_7.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.gfx.Assets;
import dev.rsupak.tilegamev1_7.tiles.Tile;

public class Dungeon1 extends StaticEntity{

	public Dungeon1(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT, EntityId.LevelTrigger);
		
		bounds_x = 23;
        bounds_y = (int) (height/2);
        bounds_width = 2;
        bounds_height = (int) (height - height / 1.5f) - 15;
        levelId = 1;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
//		g.setColor(Color.GREEN);
//		g.drawRect((int)(x + bounds_x - handler.getGameCamera().getxOffset()), 
//				(int)(y + bounds_y - handler.getGameCamera().getyOffset()), bounds_width, bounds_height);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)(x), (int)(y), width, height);
	}

}

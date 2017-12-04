package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class HouseWall extends Tile {
	
	public HouseWall(int id) {
		super(Assets.houseWall, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

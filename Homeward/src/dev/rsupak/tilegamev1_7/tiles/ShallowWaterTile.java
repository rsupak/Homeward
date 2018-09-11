package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class ShallowWaterTile extends Tile {

	public ShallowWaterTile(int id) {
		super(Assets.shallowWater, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}

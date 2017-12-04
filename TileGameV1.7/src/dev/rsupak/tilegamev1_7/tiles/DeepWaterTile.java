package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class DeepWaterTile extends Tile {

	public DeepWaterTile(int id) {
		super(Assets.deepWater, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}

package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class MountainTile extends Tile {

	public MountainTile(int id) {
		super(Assets.mountain, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}

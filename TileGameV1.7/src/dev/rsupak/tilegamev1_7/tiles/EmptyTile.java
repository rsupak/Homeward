package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class EmptyTile extends Tile {

	public EmptyTile(int id) {
		super(Assets.empty, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}

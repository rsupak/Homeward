package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class ColumnTile extends Tile {

	public ColumnTile(int id) {
		super(Assets.column, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}

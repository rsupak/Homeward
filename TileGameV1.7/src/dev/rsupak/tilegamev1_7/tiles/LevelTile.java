package dev.rsupak.tilegamev1_7.tiles;

import dev.rsupak.tilegamev1_7.gfx.Assets;

public class LevelTile extends Tile {
	
	public LevelTile(int id) {
		super(Assets.portal, id);
	}
	
	@Override
	public boolean isLevelSelect() {
		return true;
	}
	
}

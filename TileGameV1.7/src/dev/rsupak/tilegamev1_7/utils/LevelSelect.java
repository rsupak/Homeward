package dev.rsupak.tilegamev1_7.utils;

public class LevelSelect {
	
	public static String teleport(int worldCase) {
		switch(worldCase) {
			case 0: return "/worlds/OverWorldMap.png";
			case 1: return "/worlds/level.png";
			case 2: return "/worlds/opening_dungeon.png";
			case 3: return "/worlds/Town1.png";
			default: return "/worlds/OverWorldMap.png";
		}
	}
 }

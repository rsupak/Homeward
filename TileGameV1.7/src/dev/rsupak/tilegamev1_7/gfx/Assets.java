package dev.rsupak.tilegamev1_7.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int player_width = 32, player_height = 60;
	private static final int tile_width = 32, tile_height = 32;
	private static final int tw = 40, th = 40;
	private static final int ew = 32, eh = 32;
	
	public static BufferedImage empty, grass, dirt, tree1, mountain, deepWater, floor_1, column,
								shallowWater, desert, portal;
	//Town Tiles
	public static BufferedImage city, townRoad, inn, houseWall;
	public static BufferedImage player_up_idle, player_down_idle, player_left_idle, player_right_idle;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] enemy_down, enemy_up, enemy_left, enemy_right;

	public static void init() {
		
		SpriteSheet empty_tile = new SpriteSheet(ImageLoader.loadImage("/textures/empty.png"));
		SpriteSheet map_tiles = new SpriteSheet(ImageLoader.loadImage("/textures/landtiles.png"));
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet enemy = new SpriteSheet(ImageLoader.loadImage("/textures/enemySheet.png"));
		
		//Animated player
		
		// Player Down //
		player_down_idle = player.crop(0, 0, player_width, player_height);//idle
		player_down = new BufferedImage[6];
		player_down[0] = player.crop(2, 0, player_width, player_height);
		player_down[1] = player.crop(3, 0, player_width, player_height);
		player_down[2] = player.crop(1, 0, player_width, player_height);//between
		player_down[3] = player.crop(4, 0, player_width, player_height);
		player_down[4] = player.crop(5, 0, player_width, player_height);
		player_down[5] = player.crop(1, 0, player_width, player_height);//between
		
		// Player Up //
		player_up_idle = player.crop(0, 2, player_width, player_height);
		player_up = new BufferedImage[6];
		player_up[0] = player.crop(2, 2, player_width, player_height);
		player_up[1] = player.crop(3, 2, player_width, player_height);
		player_up[2] = player.crop(1, 2, player_width, player_height);
		player_up[3] = player.crop(4, 2, player_width, player_height);
		player_up[4] = player.crop(5, 2, player_width, player_height);
		player_up[5] = player.crop(1, 2, player_width, player_height);
		
		// Player Left //
		player_left_idle = player.crop(0, 1, player_width, player_height);
		player_left = new BufferedImage[6];
		player_left[0] = player.crop(2, 1, player_width, player_height);
		player_left[1] = player.crop(3, 1, player_width, player_height);
		player_left[2] = player.crop(1, 1, player_width, player_height);
		player_left[3] = player.crop(4, 1, player_width, player_height);
		player_left[4] = player.crop(5, 1, player_width, player_height);
		player_left[5] = player.crop(1, 1, player_width, player_height);
		
		// Player Right //
		player_right_idle = player.crop(0, 3, player_width, player_height);
		player_right = new BufferedImage[6];
		player_right[0] = player.crop(2, 3, player_width, player_height);
		player_right[1] = player.crop(3, 3, player_width, player_height);
		player_right[2] = player.crop(1, 3, player_width, player_height);
		player_right[3] = player.crop(4, 3, player_width, player_height);
		player_right[4] = player.crop(5, 3, player_width, player_height);
		player_right[5] = player.crop(1, 3, player_width, player_height);

		
		//Animated enemies
		
		// Enemy Down //
		enemy_down = new BufferedImage[3];
		enemy_down[0] = enemy.crop(0, 6, ew, eh);
		enemy_down[1] = enemy.crop(1, 6, ew, eh);
		enemy_down[2] = enemy.crop(2, 6, ew, eh);
		
		// Enemy Up //
		enemy_up = new BufferedImage[3];
		enemy_up[0] = enemy.crop(6, 6, ew, eh);
		enemy_up[1] = enemy.crop(7, 6, ew, eh);
		enemy_up[2] = enemy.crop(8, 6, ew, eh);
		
		// Enemy Left //
		enemy_left = new BufferedImage[3];
		enemy_left[0] = enemy.crop(9, 6, ew, eh);
		enemy_left[1] = enemy.crop(10, 6, ew, eh);
		enemy_left[2] = enemy.crop(11, 6, ew, eh);
		
		// Enemy Right //
		enemy_right = new BufferedImage[3];
		enemy_right[0] = enemy.crop(3, 6, ew, eh);
		enemy_right[1] = enemy.crop(4, 6, ew, eh);
		enemy_right[2] = enemy.crop(5, 6, ew, eh);
		
		//Map Tiles
		
		empty = ImageLoader.loadImage("/textures/empty.png");
		grass = map_tiles.crop(0,  0, tile_width, tile_height);
		dirt = map_tiles.crop(10, 10, tile_width, tile_height);
		tree1 = map_tiles.crop(5, 19, tile_width, tile_height);
		mountain = map_tiles.crop(6,  11, tile_width, tile_height);
		deepWater = map_tiles.crop(6, 10, tile_width, tile_height);
		shallowWater = map_tiles.crop(5, 10, tile_width, tile_height);
		desert = map_tiles.crop(9, 10, tile_width, tile_height);
		portal = map_tiles.crop(8, 1, tile_width, tile_height);
		floor_1 = map_tiles.crop(4, 1, tile_width, tile_height);
		column = map_tiles.crop(11, 14, tile_width, tile_height);
		
		//Town Tiles
		city = map_tiles.crop(6, 12, tile_width, tile_height);
		townRoad = map_tiles.crop(3, 1, tile_width, tile_height);
		inn = map_tiles.crop(8, 3, tile_width, tile_height);
		houseWall = map_tiles.crop(9, 0, tile_width, tile_height);

		
	}
	
}

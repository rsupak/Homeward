package dev.rsupak.tilegamev1_7.utils;

import java.awt.image.BufferedImage;

import dev.rsupak.tilegamev1_7.gfx.ImageLoader;

/*
 * The purpose of this file is to declutter the World.java file.
 * With the potential for a long list of map tiles being used
 * to implement the loadWorldImage() method, a separate file was
 * created to hold the number/color values being used.
 * May work better with an Enum file as the delimiter???
 */

public class ColorMap {
	
	public int getTileBycolor(int red, int green, int blue) {
		if(red == 0 && green == 255 && blue == 0) 
			return 1;
		else if(red == 83 && green == 147 && blue == 8) 
			return 2;
		else if(red == 0 && green == 0 && blue == 0) 
			return 3;
		else if(red == 34 && green == 12 && blue == 255) 
			return 4;
		else if(red == 0 && green == 255 && blue == 255) 
			return 5;
		else if(red == 249 && green == 226 && blue == 203) 
			return 6;
		else if(red == 111 && green == 109 && blue == 124) 
			return 7;
		else if(red == 147 && green == 147 && blue == 147) 
			return 8;
		else if(red == 0 && green == 0 && blue == 2)
			return 9;
		else if(red == 214 && green == 214 && blue == 239)
			return 11;
		else if(red == 207 && green == 177 && blue == 177)
			return 12;
		else if(red == 0 && green == 0 && blue == 255)
			return 255;
		else if(red == 255 && green == 0 && blue == 0)
			return 255;
		else if(red == 150 && green == 75 && blue == 0)
			return 225;
		else if(red == 1 && green == 1 && blue == 1)
			return 0;
		else 
			return 0;
	}
	
}

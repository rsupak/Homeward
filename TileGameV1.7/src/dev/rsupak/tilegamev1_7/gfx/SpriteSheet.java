package dev.rsupak.tilegamev1_7.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		BufferedImage image = sheet.getSubimage(((x + 1) * width) - width, ((y + 1) * height) - height, width, height);
		return image;
	}
}

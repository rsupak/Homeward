package dev.rsupak.tilegamev1_7.entities.statics;

import dev.rsupak.tilegamev1_7.Handler;
import dev.rsupak.tilegamev1_7.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height, EntityId id) {
		super(handler, x, y, width, height, id);
	}
	
	
}

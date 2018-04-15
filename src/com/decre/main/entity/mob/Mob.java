package com.decre.main.entity.mob;

import com.decre.main.entity.Entity;
import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir;
	protected boolean moving;

	public void move(int dx, int dy) {
		if(dx > 0) dir = 1;
		if(dy > 0) dir = 2;
		if(dx < 0) dir = 3;
		if(dy < 0) dir = 0;
		
		if (!collision()) {
			this.x += dx;
			this.y += dy;
		}
	}

	public void update() {

	}

	public void render(Screen screen) {

	}

	private boolean collision() {
		return false;
	}

}

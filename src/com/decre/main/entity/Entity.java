package com.decre.main.entity;

import java.util.Random;

import com.decre.main.graphics.Screen;
import com.decre.main.level.Level;

public abstract class Entity {

	public int x, y;
	private boolean removed;
	protected Level level;
	protected final Random random = new Random();

	public abstract void update();

	public abstract void render(Screen screen);

	public void remove() {
		// TODO Remove from level
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void init(Level level) {
		this.level = level;
	}

}

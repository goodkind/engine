package com.decre.main.entity.projectile;

import java.util.Random;

import com.decre.main.entity.Entity;
import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, rateOfFire, range, damage;

	protected final Random random = new Random();

	public Projectile(int x, int y, double dir) {
		this.xOrigin = x;
		this.yOrigin = y;
		this.angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getSpriteSize() {
		return sprite.SIZE;
	}

	protected void move() {

	}

	@Override
	public void render(Screen screen) {
		// TODO Auto-generated method stub

	}

}

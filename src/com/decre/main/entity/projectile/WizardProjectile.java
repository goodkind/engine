package com.decre.main.entity.projectile;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 15;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		damage = 20;
		speed = 4;
		rateOfFire = 15;
		sprite = Sprite.wizardProjectile;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision(x, y, nx, ny, 7)) remove();
		move();
	}

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this);
	}

}

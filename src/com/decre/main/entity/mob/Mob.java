package com.decre.main.entity.mob;

import com.decre.main.entity.Entity;
import com.decre.main.entity.projectile.Projectile;
import com.decre.main.entity.projectile.WizardProjectile;
import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir;
	protected boolean moving;

	public void move(int dx, int dy) {
		if (dx != 0 && dy != 0) {
			move(dx, 0);
			move(0, dy);
			return;
		}

		if (dx > 0) dir = 1;
		if (dy > 0) dir = 2;
		if (dx < 0) dir = 3;
		if (dy < 0) dir = 0;

		if (!collision(dx, dy)) {
			this.x += dx;
			this.y += dy;
		}

	}

	public void update() {

	}

	protected void shoot(int x, int y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		level.addProjectile(p);
	}

	public void render(Screen screen) {

	}

	private boolean collision(int dx, int dy) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + dx) + c % 2 * 14 - 8) / 16;
			int yt = ((y + dy) + c / 2 * 12 + 3) / 16;

			if (level.getTile(xt, yt).solid()) solid = true;
		}

		return solid;
	}

}

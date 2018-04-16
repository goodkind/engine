package com.decre.main.entity.mob;

import com.decre.main.Game;
import com.decre.main.entity.projectile.Projectile;
import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;
import com.decre.main.input.KeyBoard;
import com.decre.main.input.Mouse;

public class Player extends Mob {

	private KeyBoard input;
	private int anim = 0;
	private boolean walking;

	public Player(KeyBoard input) {
		this.input = input;
		sprite = Sprite.playerDown;
	}

	public Player(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerDown;
	}

	public void update() {
		int xDir = 0, yDir = 0;
		if (anim < 7500) anim++;
		else anim = 0;

		if (input.up) yDir--;
		if (input.down) yDir++;
		if (input.left) xDir--;
		if (input.right) xDir++;

		if (xDir != 0 || yDir != 0) {
			move(xDir, yDir);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	private void updateShooting() {
		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);

			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.playerUp;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerUp_1;
				} else {
					sprite = Sprite.playerUp_2;
				}
			}
		}
		if (dir == 1 || dir == 3) {
			sprite = Sprite.playerSide;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerSide_1;
				} else {
					sprite = Sprite.playerSide_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerDown;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerDown_1;
				} else {
					sprite = Sprite.playerDown_2;
				}
			}
		}
		if (dir == 3) flip = 1;
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}

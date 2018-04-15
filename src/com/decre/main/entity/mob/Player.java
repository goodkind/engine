package com.decre.main.entity.mob;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;
import com.decre.main.input.KeyBoard;

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
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		if (input.up)
			yDir--;
		if (input.down)
			yDir++;
		if (input.left)
			xDir--;
		if (input.right)
			xDir++;

		if (xDir != 0 || yDir != 0) {
			move(xDir, yDir);
			walking = true;
		} else {
			walking = false;
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
		if (dir == 3)
			flip = 1;
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}

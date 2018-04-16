package com.decre.main.level.tile;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;

public class FLowerTile extends Tile {

	public FLowerTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}

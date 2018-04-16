package com.decre.main.level.tile.spawnlevel;

import com.decre.main.graphics.Screen;
import com.decre.main.graphics.Sprite;
import com.decre.main.level.tile.Tile;

public class SpawnWaterTile extends Tile {

	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
